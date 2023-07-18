## Dukan

A single seller - multi customer application. Functionalities related to User, Product and Order.<br />
Functionality to generate **Relevant Products Feed Page for Customer**. <br />
Functionality to generate **Trending Products Page**.<br />
**Ranking Produts** based on total sales and impressions.

![image](https://github.com/sacihn173/dukaanSpringBoot/assets/73626851/cc5631c1-9f37-4d6a-b4a2-7f8b769611dc)

## Relevant User Feed Generation (Recommendation System) :

Tag based System is used. (Each product is assigned with some tags)   

The User Feed is combination of two sections : 
1. Trending Products : <br />
   Products having highest impressions and sales at that instance of time.
   
2. Product based on User's history : <br />
   User's order history is used to generate related products.<br />

**How are products related to User's History generated**<br/>

Two issues are solved :

1. **Getting products having tags similar to user's history products**<br />
   
   Search is performed to filter out products having tags similar to products the user bought.

2. **Ordering these products on make recommedation as relevant as possible**<br />

   Relations are build between products. A product which is more related to user bought product in given higher ranking.<br/>
   
   **How are products related** ? <br />

   For each pair of products, the count of common users who bought both the products is stored.<br/>
   Higher the number, more related the products are.
   
   For example, <br/>
   User Y bought a product X in past, and products similar to X are to be generated.<br/>
   First the products with tags similar to product X are filtered (gives us product A and B).<br/>
   Now, the products A and B are to be ranked.<br/>
   Let T be the count of users who bought both products X and A.<br/>
   Let S be the count of users who bought both products X and B.<br/>
   If T > S, then A is more relevant product than B for the user.<br/>
   Else, B is more relevant product than A.<br/>

   ![image](https://github.com/sacihn173/dukaanSpringBoot/assets/73626851/edca9147-67d1-4a0c-8adb-80362e3d029e)



   
   Similarily, ranking is done based on impresssions also (Sales is given more preference).<br/>

   
Trending Products :
-
Products with highest count of impressions in last 24 hours are presented as trending products.<br />

Product Ranking :
-
Products are sorted based on 'total_sales' and then on 'total_impressions' and ranked.<br />


Schema :

![image](https://github.com/sacihn173/dukaanSpringBoot/assets/73626851/2064b4ec-6fd8-4f90-9d06-ad2f47c974a7)



![image](https://github.com/sacihn173/dukaanSpringBoot/assets/73626851/38dcb938-60eb-4649-a687-2643e9528df6)

