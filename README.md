## Dukan

A single seller - multi customer application. Functionalities related to User, Product and Order.<br />
Functionality to generate **Relevant Products Feed Page for Customer**. 
Functionality to generate **Trending Products Page**.<br />
**Ranking Produts** based on total sales and impressions.

![image](https://github.com/sacihn173/dukaanSpringBoot/assets/73626851/cc5631c1-9f37-4d6a-b4a2-7f8b769611dc)

Dynamic Customer Feed of products generation :
-
Combination of two sections : 
1. Trending Produts : <br />
   Customer's history searches and orders tags are used to filter products from trending products.
   
3. Most Sold products : <br />
   Customer's history is stored in form of product tags (ordered and searched).<br />
   For Feed generation request, these tags are used to get list of products.<br />
   Products are then ranked based on 'total_sales', 'total_impressions' and 'product_rank'.<br />
   The products are then randomly ordered (to avoid presenting same products everytime) and are served.<br />

Improvement Needed : Some better algorithm to generate different products on every request, instead of just randomly ordering.

Trending Products :
-
Products with highest count of impressions in last 24 hours are presented as trending products.<br />
A cron runs every 12 hours and updates the list.

Product Ranking :
-
Products are sorted based on 'total_sales' and then on 'total_impressions' and ranked.<br />
A cron runs every 24 hours and updates the ranks.


Improvements : Instead of dynamically generating feed for every request, develop a method to generate and store a small part of the feed for actively visiting users.

Schema :

![image](https://github.com/sacihn173/dukaanSpringBoot/assets/73626851/38dcb938-60eb-4649-a687-2643e9528df6)

