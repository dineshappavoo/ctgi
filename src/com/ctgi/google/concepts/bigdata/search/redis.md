Elastic Search
==============
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

To show the examples through go client we are creating connection here,
```go
func main() {
    conn, err := redis.Dial("tcp", ":6379")
    if err != nil {
        log.Fatal(err)
    }
    defer conn.Close()
```
All the go code should be under this function main

**Commands**
**SET:**
```
SET key value [EX seconds] [PX milliseconds] [NX|XX]
```
Set key to hold the string value. If key already holds a value, it is overwritten, regardless of its type. Any previous time to live associated with the key is discarded on successful SET operation.
Options

Starting with Redis 2.6.12 SET supports a set of options that modify its behavior:
* EX seconds -- Set the specified expire time, in seconds.
* PX milliseconds -- Set the specified expire time, in milliseconds.
* NX -- Only set the key if it does not already exist.
* XX -- Only set the key if it already exist.

**Return value**
Simple string reply: OK if SET was executed correctly. Null reply: a Null Bulk Reply is returned if the SET operation was not performed because the user specified the NX or XX option but the condition was not met.

**Examples:**

```shell
redis> SET mykey "Hello"
OK
redis> GET mykey
"Hello"
redis> 
```
GO Example:
```go
// add some keys
    if _, err = conn.Do("SET", "k1", "a"); err != nil {
        log.Fatal(err)
    }
    if _, err = conn.Do("SET", "k2", "b"); err != nil {
        log.Fatal(err)
    }
```
MGET :
Returns the values of all specified keys. For every key that does not hold a string value or does not exist, the special value nil is returned. Because of this, the operation never fails.

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

In golang client through redigo api
```go
// get many keys in a single MGET, ask redigo for []string result
    strs, err := redis.Strings(conn.Do("MGET", "k1", "k2", "k3"))
    if err != nil {
        log.Fatal(err)
    }
    //prints [a b ]
    fmt.Println(strs)
```

**DEL key [key ...]:**
Time complexity: O(N) where N is the number of keys that will be removed. When a key to remove holds a value other than a string, the individual complexity for this key is O(M) where M is the number of elements in the list, set, sorted set or hash. Removing a single key that holds a string value is O(1).

Removes the specified keys. A key is ignored if it does not exist.

**Return value**
Integer reply: The number of keys that were removed.

Examples
redis> SET key1 "Hello"
OK
redis> SET key2 "World"
OK
redis> DEL key1 key2 key3
(integer) 2
redis> 

###Referrences

* [redis.io](http://redis.io/commands)
* [coderwall.com](https://coderwall.com/p/unklzq/redis-go-building-a-simple-swear-word-filter)
* []()
* [engineersgarage.com](http://www.engineersgarage.com/articles/risc-and-cisc-architecture?page=5)

