Operating System - Critical Section
=============================
In concurrent programming, a critical section is a piece of code that accesses a shared resource (data structure or device) that must not be concurrently accessed by more than one thread of execution. A critical section will usually terminate in fixed time, and a thread, task, or process will have to wait for a fixed time to enter it (aka bounded waiting). Some synchronization mechanism is required at the entry and exit of the critical section to ensure exclusive use, for example a [semaphore](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/google/concepts/operatingsystem/semaphores.md).

###Referrences

* [wikipedia.com](http://en.wikipedia.org/wiki/Semaphore_%28programming%29)
* [chibios.org](http://www.chibios.org/dokuwiki/doku.php?id=chibios:articles:semaphores_mutexes)

