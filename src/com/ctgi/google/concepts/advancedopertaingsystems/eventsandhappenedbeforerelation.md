Advanced Operating System - Events and Happened before relation
===============================================================
the happened-before relation (denoted: --> ) is a relation between the result of two events, such that if one event should happen before another event, the result must reflect that. Even if those events are in reality executed out of order (usually to optimize program flow). This involves ordering events based on the potential causal relationship of pairs of events in a concurrent system, especially asynchronous distributed systems. It was formulated by Leslie Lamport.In Java specifically, a happens-before relationship is a guarantee that memory written to by statement A is visible to statement B, that is, that statement A completes its write before statement B starts its read.


####When is it possible to order two events?
Three cases:
	1 Events executed on the same process:
		if e and f are events on the same process and e occurred before f , then e happened-before f
	2 Communication events of the same message:
		if e is the send event of a message and f is the receive event of the same message, then e happened-before f
	3 Events related by transitivity:
		if event e happened-before event g and event g happened-before event f , then e happened-before f
		
The happened-before relation is formally defined as the least strict partial order on events such that:

If events a and b occur on the same process, a --> b if the occurrence of event a  preceded the occurrence of event b.
If event a is the sending of a message and event b is the reception of the message sent in event a , a --> b.
If there are other causal relationships between events in a given system, such as between the creation of a process and its first event, these relationships are also added to the definition.

Like all strict partial orders, the happened-before relation is transitive, irreflexive and antisymmetric, i.e.:

```c
forall a, b, c, if a --> b and b --> c, then a --> c (transitivity)
forall a, a -/->  a (irreflexivity)
forall a, b, if a --> b and b --> a then a=b (antisymmetry).
Because the happened-before relation is both irreflexive and antisymmetric, it follows that: if a --> b then b -/-> a.
```

####Concurrent events
If events are not related by happened before relation then they are concurrent. Concurrency property does not hold transitivity.
```
P1 -------a------------c----------
P2 ------------b------------------
```
Events a , b, c from processes P1 and P2. a and b are concurrent ( a||b ) because there is no happened before relation between these two. An the same way b || c. But a is not concurrent with c because a happened before c.

####Abstract Clocks
Abstract clocks are used to order the events. 

Types,
```
	1. Logical clock
	2. Vector clock
	3. Matrix clock
	4. Direct Dependency Clock
```
###Referrences

* [wikipedia.com](http://en.wikipedia.org/wiki/Happened-before)
* [chibios.org](http://www.chibios.org/dokuwiki/doku.php?id=chibios:articles:semaphores_mutexes)

