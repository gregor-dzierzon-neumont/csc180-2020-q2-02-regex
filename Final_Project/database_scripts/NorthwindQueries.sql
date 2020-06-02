

SELECT c.customerid
    , c.companyname
    , o.orderid
    , o.orderdate
    , cat.categoryname
    , p.productname
    , od.unitprice
    , od.quantity
FROM customers AS c
INNER JOIN orders AS o
	ON c.customerid = o.customerid
INNER JOIN orderdetails od
    ON o.orderid = od.orderid
INNER JOIN products p
    ON od.productid = p.productid
INNER JOIN categories cat
    ON p.categoryid = cat.categoryid
WHERE o.orderdate BETWEEN '2012-10-01' and '2012-10-31';



SELECT *
FROM customers
WHERE customerid = 1;


SELECT *
FROM orders
WHERE customerid = 1;


SELECT c.customerid
     , c.companyname
     , o.orderid
     , o.orderdate
FROM customers AS c
         INNER JOIN orders AS o
                        ON c.customerid = o.customerid
WHERE c.customerid = 1;

