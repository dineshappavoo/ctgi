Operating System - Semaphores
=============================
A semaphore is a variable or abstract data type that is used for controlling access, by multiple processes, to a common resource in a parallel programming or a multi user environment.

####Types
* Binary Semaphores
* Counting Semaphores

Invented by Dutch computer scientist Edsger Dijkstra in 1962 or 1963  

###Introduction Video

<a href="http://www.youtube.com/watch?feature=player_embedded&v=KZU4ANBoLTY
" target="_blank"><img src="http://img.youtube.com/vi/KZU4ANBoLTY/0.jpg" 
alt="http://img.youtube.com/vi/KZU4ANBoLTY/15.jpg" width="540" height="380" border="10" /></a>

<a href="http://www.youtube.com/watch?feature=player_embedded&v=cIkzOOcdh2Y
" target="_blank"><img src="http://img.youtube.com/vi/cIkzOOcdh2Y/0.jpg" 
alt="http://img.youtube.com/vi/cIkzOOcdh2Y/15.jpg" width="540" height="380" border="10" /></a>

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

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/bsem.png "binary semaphores")

###Counting Semaphores
A counting semaphore is a synchronization object that can have an arbitrarily large number of states. The internal state is defined by a signed integer variable, the counter.

Counting semaphores are equipped with two operations, historically denoted as V (also known as signal) and P (or wait). Operation V increments the semaphore S, and operation P decrements it.

The value of the semaphore S is the number of units of the resource that are currently available. The P operation wastes time or sleeps until a resource protected by the semaphore becomes available, at which time the resource is immediately claimed. The V operation is the inverse: it makes a resource available again after the process has finished using it. One important property of semaphore S is that its value cannot be changed except by using the V and P operations.

`A simple way to understand wait and signal operations is:`

**`wait:`** If the value of semaphore variable is not negative, decrements it by 1. Otherwise, the process executing wait is blocked (i.e., added to the semaphore's queue) until the value is greater or equal to 1.

**`signal:`** Increments the value of semaphore variable by 1. After the increment, if the pre-increment value was negative (meaning there are processes waiting for a resource), it transfers a blocked process from the semaphore's waiting queue to the ready queue.

```c
function V(semaphore S, integer I):
    [S <- S + I]

function P(semaphore S, integer I):
    repeat:
        [if S >= I:
            S <- S - I
            break]
```

The counter value (N) has a precise meaning:

* Negative, there are exactly -N threads queued on the semaphore.
* Zero, no waiting threads, a wait operation would put in queue the invoking thread.
* Positive, no waiting threads, a wait operation would not put in queue the invoking thread.

To avoid starvation, a semaphore has an associated queue of processes (usually with first-in, first out semantics). If a process performs a P operation on a semaphore that has the value zero, the process is added to the semaphore's queue and its execution is suspended. When another process increments the semaphore by performing a V operation, and there are processes on the queue, one of them is removed from the queue and resumes execution. When processes have different priorities the queue may be ordered by priority, so that the highest priority process is taken from the queue first.


###Example: Producer/consumer problem
In the producer-consumer problem, one process (the producer) generates data items and another process (the consumer) receives and uses them. They communicate using a queue of maximum size N and are subject to the following conditions:

The consumer must wait for the producer to produce something if the queue is empty.
The producer must wait for the consumer to consume something if the queue is full.
The semaphore solution to the producer-consumer problem tracks the state of the queue with two semaphores: emptyCount, the number of empty places in the queue, and fullCount, the number of elements in the queue. To maintain integrity, emptyCount may be lower (but never higher) than the actual number of empty places in the queue, and fullCount may be lower (but never higher) than the actual number of items in the queue. Empty places and items represent two kinds of resources, empty boxes and full boxes, and the semaphores emptyCount and fullCount maintain control over these resources.

The binary semaphore useQueue ensures that the integrity of the state of the queue itself is not compromised, for example by two producers attempting to add items to an empty queue simultaneously, thereby corrupting its internal state. Alternatively a mutex could be used in place of the binary semaphore.

The emptyCount is initially N, fullCount is initially 0, and useQueue is initially 1.

The producer does the following repeatedly:
```c
produce:
    P(emptyCount)
    P(useQueue)
    putItemIntoQueue(item)
    V(useQueue)
    V(fullCount)
```
The consumer does the following repeatedly

```c
consume:
    P(fullCount)
    P(useQueue)
    item <- getItemFromQueue()
    V(useQueue)
    V(emptyCount)
```
You can find the source code for producer consumer problem [here](https://github.com/dineshappavoo/ctgi/tree/master/src/com/ctgi/google/threads/producerconsumer) 

###Mutex    
A mutex is a synchronization object that can have only two states:

* Not owned.
* Owned.

Two operations are defined for mutexes:

**`Lock (chMtxLock() in ChibiOS/RT):`** This operation attempts to take ownership of a mutex, if the mutex is already owned by another thread then the invoking thread is queued.
**`Unlock (chMtxUnlock() in ChibiOS/RT):`** This operation relinquishes ownership of a mutex. If there are queued threads then a thread is removed from the queue and resumed, ownership is implicitly assigned to the thread.

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/mutex.png "Mutex")


Note that, unlike semaphores, mutexes do have owners. A mutex can be unlocked only by the thread that owns it, this precludes the use of mutexes from interrupt handles but enables the implementation of the Priority Inheritance protocol, most RTOSs implement this protocol in order to address the Priority Inversion problem. It must be said that few RTOSs implement this protocol fully (any number of threads and mutexes involved) and even less do that efficiently.

Mutexes have one single use, Mutual Exclusion, and are optimized for that. Semaphores can also handle mutual exclusion scenarios but are best used as a communication mechanism between threads or between ISRs and threads.

###Referrences

* [wikipedia.com](http://en.wikipedia.org/wiki/Semaphore_%28programming%29)
* [chibios.org](http://www.chibios.org/dokuwiki/doku.php?id=chibios:articles:semaphores_mutexes)

