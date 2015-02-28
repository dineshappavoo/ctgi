CPU Single core Vs Multi core Vs Hyper Threading 
================================================
####CPU Basics: Multiple CPUs, Cores, and Hyper-Threading Explained
cpu-on-motherboard

The central processing unit (CPU) in your computer does the computational work — running programs, basically. But one single-core CPU can only perform one task at a time, which is where multiple CPUs, hyper-threading, and multi-core CPUs come into play.

Having more than a single CPU allows multiple programs to run at the same time, ensuring your computer stays responsive — especially while multitasking or performing computationally-demanding tasks like video encoding.

####Multiple CPUs
Most computers only have a single CPU. That single CPU may have multiple cores or hyper-threading technology, which we’ll cover later — but it’s still only one physical CPU unit inserted into a single CPU socket on the motherboard.

Before hyper-threading and multi-core CPUs came around, people attempted to add additional processing power to computers by adding additional CPUs. This requires a motherboard with more than one CPU socket — multiple CPUs are inserted into different sockets. The motherboard also needs additional hardware to connect those CPU sockets to the RAM and other resources. There’s a lot of overhead here — there’s additional latency if the CPUs need to communicate with each other, systems with multiple CPU will consume more power,  and the motherboard needs more sockets and hardware.

This isn’t very common among home-user PCs today. Even a high-powered gaming desktop with multiple graphics cards will generally only have a single CPU. You’ll find multi-CPU systems among supercomputers, servers, and similar high-end systems that need as much number-crunching power as they can get.


####Hyper-Threading Technology
Hyper-threading was Intel’s first attempt to bring parallel computation to consumer PCs. It debuted on desktop CPUs with the Pentium 4 HT back in 2002. The original Pentium 4 had just a single CPU core, so it could only do one thing at a time — but hyper-threading attempted to make up for that.

A single physical CPU core with hyper-threading appears as two logical CPUs to an operating system. The CPU is still a single CPU, so it’s “cheating” a bit — while the operating system sees two CPUs for each core, the actual CPU hardware only has a single set of execution resources for each core. The CPU pretends it has more cores than it does, and it uses its own logic to speed up program execution. Hyper-threading allows the two logical CPU cores to share physical execution resources. This can speed things up somewhat — if one virtual CPU is stalled and waiting, the other virtual CPU can borrow its execution resources. Hyper-threading can help speed your system up, but it’s nowhere near as good as having additional cores.

Thankfully, hyper-threading is now a “bonus.” While the original consumer processors with hyper-threading only had a single core that masqueraded as multiple cores, modern Intel CPUs now have both multiple cores and hyper-threading technology. Your dual-core CPU with hyper-threading appears as four cores to your operating system, while your quad-core CPU with hyper-threading appears as eight cores. Hyper-threading is no substitute for additional cores, but a dual-core CPU with hyper-threading should perform better than a dual-core CPU without hyper-threading.

####Multi-Core CPUs
Originally, CPUs had a single core. That meant the physical CPU had a single central processing unit on it. To increase performance, manufacturers add additional “cores,” or central processing units. A dual-core CPU has two central processing units, so it appears to the operating system as two CPUs. A different process can be using each core at the same time. This speeds up your system, because your computer can do multiple things at once.

Unlike hyper-threading, there are no tricks here — a dual-core CPU literally has two central processing units on the CPU chip. A quad-core CPU has four central processing units, an octa-core CPU has eight central processing units, and so on.

This helps dramatically improve performance while keeping the physical CPU unit small so it fits in a single socket. There only needs to be a single CPU socket with a single CPU unit inserted into it — not four different CPU sockets with four different CPUs, each needing their own power, cooling, and other hardware. There’s less latency because the cores can communicate more quickly, as they’re all on the same chip.

Windows 8’s task manager shows this fairly well — here we have a single processor with four cores and hyper-threading, so it appears to have eight logical CPUs.


![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/quad-core-cpu-with-hyper-threading-in-windows-8's-task-manager.png "Task Manager")

Most computers now have multi-core CPUs, which is the most efficient option here. However, Intel CPUs also have hyper-threading as a bonus. Some computers that need a large amount of CPU power may have multiple CPUs, but it’s much less efficient than it sounds. Multi-core CPUs are also found on smartphones and tablets, and they’re useful for the same reason.

The more CPUs or cores a computer has, the more things it can do at once. This helps improve performance across everything you do — even if you’re just doing one thing at a time, the computer needs to perform background tasks. With a multi-core CPU, it can use other cores for such background tasks to avoid slowing your programs down. The advent of dual-core CPUs offered a dramatically better desktop experience to PC users.


###Referrences

* [nvidia.com](http://www.nvidia.com/object/what-is-gpu-computing.html)
* [wikipedia.org](http://en.wikipedia.org/wiki/Graphics_processing_unit)
* [allegroviva.com](http://allegroviva.com/gpu-computing/difference-between-gpu-and-cpu/)

