Spring Boot Rest APIs

1.Users can register using Mobile Number.

2.Users may have multiple roles (ADMINS,CUSTOMERS).

3.Admin can create, delete, update and read products (Any product) under (Any Category). 

4.Customers can only have the list of products.

5.Admin route cannot be accessed by Customers 

6.Used of JWT Token.


1. /authenticate
2. /register
3. /create
4. /read/{id}
5. /read/{category}
6. /delete/{id}
7. /update
