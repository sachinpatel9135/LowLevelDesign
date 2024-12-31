package InMemoryKeyValueStore;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class InMemoryKeyValueStore<K, V> {
    private int capacity;
    private Map<K, ValueWrapper<V>> store;
    private Map<K, Long> ttlMap;
    private Lock lock = new ReentrantLock();
    private ScheduledExecutorService ttlScheduler = Executors.newScheduledThreadPool(1);
        
    private static class ValueWrapper<V> {
        V value;
        long lastAccessTime;
        ValueWrapper(V value) {
            this.value = value;
            this.lastAccessTime = System.currentTimeMillis();
        }
    }
        
    public InMemoryKeyValueStore(int capacity) {
        this.capacity = capacity;
        this.store = new LinkedHashMap<> (capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, ValueWrapper<V>> eldest) {
                return size() > InMemoryKeyValueStore.this.capacity;
            }
        };
        this.ttlMap = new ConcurrentHashMap<>();
        startTtlEvictionTask();
    }

    // Start a periodic TTL eviction task
    private void startTtlEvictionTask() {
        ttlScheduler.scheduleAtFixedRate(() -> {
            long currentTime = System.currentTimeMillis();
            lock.lock();
            try {
                Iterator<Map.Entry<K,Long>> iterator = ttlMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<K, Long> entry = iterator.next();
                    if(entry.getValue() <= currentTime) {
                        store.remove(entry.getKey());
                        iterator.remove();
                    }
                }
            } finally {
                lock.unlock();
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public V get(K key) {
        lock.lock();
        try {
            ValueWrapper<V> wrapper = store.get(key);
            if(wrapper == null) return null;
            wrapper.lastAccessTime = System.currentTimeMillis();
            return wrapper.value;
        } finally {
            lock.unlock();
        }
    }

    public void put(K key, V value, long ttlMillis) {
        lock.lock();
        try {
            store.put(key, new ValueWrapper<> (value));
            if(ttlMillis > 0) {
                ttlMap.put(key, System.currentTimeMillis() + ttlMillis);
            }
        } finally {
            lock.unlock();
        }
    }

    public void delete(K key) {
        lock.lock();
        try {
            store.remove(key);
            ttlMap.remove(key);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return store.size();
        } finally {
            lock.unlock();
        }
    }

    //Shutdown the ttl eviction scheduler
    public void shutdown() {
        ttlScheduler.shutdown();
    }

    public static void main(String[] args) {
        InMemoryKeyValueStore<String, String> kvStore = new InMemoryKeyValueStore<>(5);

        kvStore.put("key1", "value1", 5000); // Expires in 5 seconds
        kvStore.put("key2", "value2", 0);    // No expiry
        System.out.println(kvStore.get("key1")); // Outputs: value1

        try {
            Thread.sleep(6000); // Wait for TTL to expire
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(kvStore.get("key1")); // Outputs: null
        System.out.println(kvStore.size());     // Outputs: 1
        System.out.println(kvStore.get("key2"));  // Outputs: value2
        System.out.println(kvStore.get("key1"));  // Outputs: null
    }
}
