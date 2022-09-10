Spring Boot Rest APIs

Users can register using Mobile Number.
Users may have multiple roles (ADMINS,CUSTOMERS).
Admin can create, delete, update and read products (Any product) under (Any Category). 
Customers can only have the list of products.
Admin route cannot be accessed by Customers 
Used of JWT Token.


1. /authenticate
2. /register
3. /create
4. /read/{id}
5. /read/{category}
6. /delete/{id}
7. /update
