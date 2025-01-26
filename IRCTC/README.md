IRCTC

- User should be able to search trains between two stations on a date
- User should be able to select a train and book a ticket
- There can be different type of seats available
- Make payment, get ticket and seat is confirmed, get notification of confirmed ticket
- Multiple seats can be booked and we will try to find nearest seating arrangement

Out of scope: train status

Actor - Account
        - User - search train between station, book tickets, make payment, past trips, upcoming trips
        - admin - add/remove train,station,
- System -  confirm ticket, send notification on confirmed tickets

Train - name, id, List of stations(route, time), fair, list of seats, 
Station - name, city
Ticket - source, destination station, fair, train number, startTime