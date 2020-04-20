# Spring-Boot-Redis-Cache-DB-Operation-using-Jedis-Java-Client
In this Demo, I have shown with the help of Jedis client and Spring Redis data how we can put data in Redis DataBase (SpringBoot App)

#Spring Boot Application with Redis as Database and Cache ( Also used Spring Data Redis )
Redis is an open source powerful and high performance in-memory data structure store, used as a database, cache and message broker
It supports data structures such as strings, hashes, lists, sets, sorted sets, etc.
It's Key-Value Pair NoSql Data base

# YouTube Link for this Code :  

What is caching?
Caching is a mechanism to enhance the performance of a system. It is a temporary memory that lies between the application and the persistent database. Cache memory stores recently used data items in order to reduce the number of database hits as much as possible.

Why we need caching?
Caching of frequently used data in application is a very popular technique to increase performance of application. With caching, we store such frequently accessed data in memory to avoid hitting the costly backends every time when user requests the data. Data access from memory is always faster in comparison to fetching from storage like database, file system or other service calls.

What data should be cached?
This is mostly opinionated decision about the type of data which should reside in cache and go through cache lifecycle. It varies in different scenario and requirement on how much time we can tolerate stale data.
So caching candidates will vary on each project, still those are few examples of caching –
List of products available in an eCommerce store
Any Master data which is not frequently changed
Any frequently used database read query, where result does not change in each call at least for a specific period.

Prerequisites
Install Redis and Start Redis Server(https://redis.io/download)
or else you can check my videos :
# 1. Introduction of Redis DataBase (Caching)| Installation, insert and retrieve Data from Redis DB
https://youtu.be/K2JEcGD0HW0

# 2. Redis Data Types and Command for Insert, Retrieve, Expire Key-value | ttl, Set, exists, NX, XX, ex
https://youtu.be/q1OyHtl6Pp4

# 3. Create Redis DataBase by RedisLabs Cloud Service & Access DB using Redis Desktop Manager GUI Client
https://youtu.be/swkK_IgPr8E

Download Link : https://github.com/MicrosoftArchive/redis/releases ( in windows)
Download Link : https://redis.io/download ( in Linux)

Follow me on FaceBook: https://www.facebook.com/TechTalkDebu
Instagram: techtalk_debu
LinkedIn : https://www.linkedin.com/in/debu-paul

# URL SPecification for this code
 
Get a Pincode : http://localhost:8092/redis/pincode/{id of the pincode}
Get All Pincode : http://localhost:8092/redis/pincode
Add a Pincode : http://localhost:8092/redis/pincode   Request Body :  
{
"id":2,
"pincodeVal":"700125",
"stateName":"WB"
}
Delete a Pincode : http://localhost:8092/redis/pincode/{ id of the pincode, which want to delete }

Redis Database
For the Database, this example uses HashOperations. It is a redis construct, which can be used for reds hash operations. 
If you would like to see what are the different operations provided by spring data redis, 
please a look at the spring data redis documentation
Redis Cache
@EnableCaching - It enables Spring’s annotation-driven cache management capability. In spring boot project, we need to add it to the boot application class annotated with @SpringBootApplication. Spring provides one concurrent hashmap as default cache, but we can override CacheManager to register external cache providers as well easily.

@Cacheable - It is used on the method level to let spring know that the response of the method are cacheable. Spring manages the request/response of this method to the cache specified in annotation attribute. For example, @Cacheable ("cache-name1", “cache-name2”).. Used with @GetMapping

@CachePut - Update the Cache.Sometimes we need to manipulate the cacheing manually to put (update) cache before method call. This will allow us to update the cache and will also allow the method to be executed. The method will always be executed and its result placed into the cache (according to the @CachePut options). Used with @PutMapping

@CacheEvict - It is used when we need to evict (remove) the cache previously loaded of master data. When CacheEvict annotated methods will be executed, it will clear the cache.
We can specify key here to remove cache, if we need to remove all the entries of the cache then we need to use allEntries=true. This option comes in handy when an entire cache region needs to be cleared out – rather then evicting each entry (which would take a long time since it is inefficient), all the entries are removed in one operation.Delete the Cache. Used with @DeleteMapping

@Caching This annotation is required when we need both CachePut and CacheEvict at the same time.
