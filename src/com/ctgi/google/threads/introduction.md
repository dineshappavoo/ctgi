Architecture - GPU Vs CPU
=========================
###GPU
What Are Threads?

All programmers are familiar with writing sequential programs. You've probably written a program that displays "Hello World!", or sorts a list of names, or computes a list of prime numbers. These are sequential programs: each has a beginning, an end, a sequence, and at any given time during the runtime of the program there is a single point of execution.

A thread is similar to the sequential programs described above: a single thread also has a beginning, an end, a sequence, and at any given time during the runtime of the thread there is a single point of execution. However, a thread itself is not a program--it cannot run on its own--but runs within a program.

**Definition: A thread is a single sequential flow of control within a program.**

There is nothing new in the concept of a single thread. The real hoopla surrounding threads is not about a single sequential thread, but rather about the use of multiple threads in a single program all running at the same time and performing different tasks.

The HotJava browser is an example of a multithreaded application; within the HotJava browser you can scroll a page while it's downloading an applet or image, play animation and sound concurrently, print a page in the background while you download a new page, or watch three sorting algorithms race to the finish. You are used to life operating in a concurrent fashion...so why not your browser?

Some texts use either the name lightweight process instead of thread. A thread is similar to a real process in that a thread and a running program are both a single sequential flow of control. However, a thread is considered lightweight because it runs within the context of a full-blown program and takes advantage of the resources allocated for that program and the program's environment.

As a sequential flow of control, a thread must carve out some of its own resources within a running program (it must have its own execution stack and program counter for example). The code running within the thread only works within that context. Thus, other texts use execution context as a synonym for thread.

Process schedulers of many modern operating systems directly support both time-sliced and multiprocessor threading. The operating system kernel allows programmers to manipulate threads by exposing required functionality through the system call interface. Some threading implementations are called kernel threads, whereas lightweight processes (LWP) are a specific type of kernel threads that shares the same state and information.



###Referrences

* [nvidia.com](http://www.nvidia.com/object/what-is-gpu-computing.html)
* [wikipedia.org](http://en.wikipedia.org/wiki/Graphics_processing_unit)
* [allegroviva.com](http://allegroviva.com/gpu-computing/difference-between-gpu-and-cpu/)

