Spring Boot Rest APIs

1.Users can register using Mobile Number.

2.Users may have multiple roles (ADMINS,CUSTOMERS).

3.Admin can create, delete, update and read products (Any product) under (Any Category). 

4.Customers can only have the list of products.

5.Admin route cannot be accessed by Customers.

6.Used of JWT Token.


1. /authenticate

--> Recieve username and password and authenticate it and generate a Jwt for it.
--> When calling other APIs this Jwt Token is sent in the header and based on it Authorization is given to customer(ADMIN OR USER).

2. /register
3. /create
4. /read/{id}
5. /read/{category}
6. /delete/{id}
7. /update

--> All passwords are stored and consumed with Base64 encoding.

Authentication : 

<img width="600" alt="image" src="https://user-images.githubusercontent.com/73626851/189494961-ad3504cf-5161-4777-a4c1-62ccf762a385.png">

Deletion based on Jwt Authentication : 

<img width="618" alt="image" src="https://user-images.githubusercontent.com/73626851/189495010-b168fe71-5a6e-465f-b0e9-6d7f1a9bf079.png">


