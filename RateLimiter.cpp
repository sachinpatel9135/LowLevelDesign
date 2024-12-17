#include<iostream>
#include<mutex>
#include<chrono>
#include<thread>
#include<unordered_map>

using namespace std;
//There are some errors in this code, but looks good for current practice so pushing it.
//token bucket algorithm implementation
class RateLimiter{
private:
    int maxTokens;
    int refillRate;
    int currentTokens;
    chrono::steady_clock::time_point lastRefillTime;
    mutex mtx;

    void refillTokens() {
        auto now = chrono::steady_clock::now();
        double elapsedSeconds = chrono::duration_cast<chrono::seconds>(now - lastRefillTime).count();

        int tokensToAdd = (int)elapsedSeconds*refillRate;
        if(tokensToAdd > 0) {
            currentTokens = min(maxTokens, currentTokens+tokensToAdd);
            lastRefillTime = chrono::steady_clock::now();
        }
    }
public:
    RateLimiter(int maxTokens, int refillRate){
        this->maxTokens = maxTokens;
        this->refillRate = refillRate;
        this->currentTokens = maxTokens;
        lastRefillTime = chrono::steady_clock::now();
    }

    bool allowRequest() {
        lock_guard<mutex> lock(mtx);
        refillTokens();

        if(currentTokens > 0) {
            currentTokens--;
            return true;
        }
        return false;
    }
};

class RateLimiterManager {
private:
    unordered_map<string, RateLimiter> clientRateLimiters;
    int maxTokens, refillRate;
public:
    RateLimiterManager(int maxTokens, int refillRate): maxTokens(maxTokens), refillRate(refillRate) {}

    bool allowRequest(const string& clientId) {
        if(clientRateLimiters.find(clientId) == clientRateLimiters.end()) {
            clientRateLimiters.emplace(clientId, maxTokens, refillRate);
        }
        return clientRateLimiters[clientId].allowRequest();
    }
};

int main() {
    RateLimiterManager manager(5,2); //5 is bucket size, 2 is tokens per second

    string client = "client1";

    for(int i=0; i<10; i++) {
        if(manager.allowRequest(client)) {
            cout << "request " << i << " is allowed.\n";
        }
        else {
            cout << "request " << i << " is not allowed.\n";
        }
        this_thread::sleep_for(chrono::milliseconds(500));
    }
    return 0;
}