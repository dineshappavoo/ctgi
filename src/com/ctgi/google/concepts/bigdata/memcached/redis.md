Redis
=====
Redis is a data structure server. It is open-source, networked, in-memory, and stores keys with optional durability. The development of Redis has been sponsored by Pivotal Software since May 2013 before that, it was sponsored by VMware.According to the monthly ranking by DB-Engines.com, Redis is the most popular key-value store. The name Redis means REmote DIctionary Server.

####Data types
Redis maps keys to many types of values. A key difference between Redis and other structured storage systems is that Redis supports not only strings, but also abstract data types:

* Lists of strings
* Sets of strings (collections of non-repeating unsorted elements)
* Sorted sets of strings (collections of non-repeating elements ordered by a floating-point number called score)
* Hash tables where keys and values are strings

The type of a value determines what operations (called commands) are available for the value itself. Redis supports high-level, atomic, server-side operations like intersection, union, and difference between sets and sorting of lists, sets and sorted sets.

####Common Web Use Cases Solved In Redis:
* Show latest items listings in your home page. This is a live in-memory cache and is very fast. LPUSH is used to insert a content ID at the head of the list stored at a key. LTRIM is used to limit the number of items in the list to 5000. If the user needs to page beyond this cache only then are they sent to the database.

* Deletion and filtering. If a cached article is deleted it can be removed from the cache using LREM.

* Leaderboards and related problems. A leader board is a set sorted by score. The ZADD commands implements this directly and the ZREVRANGE command can be used to get the top 100 users by score and ZRANK can be used to get a users rank. Very direct and easy.

* Order by user votes and time. This is a leaderboard like Reddit where the score is formula the changes over time. LPUSH + LTRIM are used to add an article to a list. A background task polls the list and recomputes the order of the list and ZADD is used to populate the list in the new order. This list can be retrieved very fast by even a heavily loaded site. This should be easier, the need for the polling code isn't elegant.

* Implement expires on items. To keep a sorted list by time then use unix time as the key. The difficult task of expiring items is implemented by indexing current_time+time_to_live. Another background worker is used to make queries using ZRANGE ... with SCORES and delete timed out entries.

* Counting stuff. Keeping stats of all kinds is common, say you want to know when to block an IP addresss. The INCRBY command makes it easy to atomically keep counters; GETSET to atomically clear the counter; the expire attribute can be used to tell when an key should be deleted.

* Unique N items in a given amount of time. This is the unique visitors problem and can be solved using SADD for each pageview. SADD won't add a member to a set if it already exists.

* Real time analysis of what is happening, for stats, anti spam, or whatever. Using Redis primitives it's much simpler to implement a spam filtering system or other real-time tracking system.

* Pub/Sub. Keeping a map of who is interested in updates to what data is a common task in systems. Redis has a pub/sub feature to make this easy using commands like SUBSCRIBE, UNSUBSCRIBE, and PUBLISH. 

* Queues. Queues are everywhere in programming. In addition to the push and pop type commands, Redis has blocking queue commands so a program can wait on work being added to the queue by another program. You can also do interesting things implement a rotating queue of RSS feeds to update.

* Caching. Redis can be used in the same manner as memcache.

####Commands:
Full set of commands can be found [here](http://redis.io/commands)

####Popular Commands
MGET : Returns the values of all specified keys. For every key that does not hold a string value or does not exist, the special value nil is returned. Because of this, the operation never fails.

Example :
```shell
redis> SET key1 "Hello"
OK
redis> SET key2 "World"
OK
redis> MGET key1 key2 nonexisting
1) "Hello"
2) "World"
3) (nil)
redis> 
```

###Referrences

* [cs.stanford.edu](http://cs.stanford.edu/people/eroberts/courses/soco/projects/risc/whatis/index.html)
* [engineersgarage.com](http://www.engineersgarage.com/articles/risc-and-cisc-architecture?page=5)

