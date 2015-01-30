Operating - System
=====================
A semaphore is a variable or abstract data type that is used for controlling access, by multiple processes, to a common resource in a parallel programming or a multi user environment.

####Types
	* Binary Semaphores
	* Counting Semaphores

Invented by Dutch computer scientist Edsger Dijkstra in 1962 or 1963  

###Protocols
When used for a pool of resources, a semaphore tracks only how many resources are free; it does not keep track of which of the resources are free. Some other mechanism (possibly involving more semaphores) may be required to select a particular free resource.

Processes are trusted to follow the protocol. Fairness and safety are likely to be compromised (which practically means a program may behave slowly, act erratically, hang or crash) if even a single process acts incorrectly. This includes:

	* requesting a resource and forgetting to release it
	* releasing a resource that was never requested
	* holding a resource for a long time without needing it
	* using a resource without requesting it first (or after releasing it)

Even if all processes follow these rules, multi-resource deadlock may still occur when there are different resources managed by different semaphores and when processes need to use more than one resource at a time, as illustrated by the dining philosophers problem.

###Binary Semaphores
A binary semaphore is a synchronization object that can have only two states:

	* Not taken.
	* Taken.

Two operations are defined:

`Take (chBSemWait() in ChibiOS/RT):` Taking a binary semaphore brings it in the “taken” state, trying to take a semaphore that is already taken enters the invoking thread into a waiting queue.

`Release (chBSemSignal() in ChibiOS/RT):` Releasing a binary semaphore brings it in the “not taken” state if there are not queued threads. If there are queued threads then a thread is removed from the queue and resumed, the binary semaphore remains in the “taken” state. Releasing a semaphore that is already in its “not taken” state has no effect.

###Referrences

* [wikipedia.com](http://en.wikipedia.org/wiki/Semaphore_%28programming%29)
* []()

