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


![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/quad-core-cpu-with-hyper-threading-in-windows-8s-task-manager.png "Task Manager")

Most computers now have multi-core CPUs, which is the most efficient option here. However, Intel CPUs also have hyper-threading as a bonus. Some computers that need a large amount of CPU power may have multiple CPUs, but it’s much less efficient than it sounds. Multi-core CPUs are also found on smartphones and tablets, and they’re useful for the same reason.

The more CPUs or cores a computer has, the more things it can do at once. This helps improve performance across everything you do — even if you’re just doing one thing at a time, the computer needs to perform background tasks. With a multi-core CPU, it can use other cores for such background tasks to avoid slowing your programs down. The advent of dual-core CPUs offered a dramatically better desktop experience to PC users.

###Yale university - With Example
####Hyper-Threading and Multi-Core

####Threads

Consider the problem of cooking for a big dinner party. Each dish has its own recipe. You could follow the instructions in one recipe until that one dish is done, then set it aside and start the next dish. Unfortunately, it would take several days to cook the dinner, and everything would come out cold. Fortunately, there are long periods of time when something sits in the oven, and while it is cooking you can prepare one or two other things.

A sequence of instructions to do one thing is called a recipe in the kitchen, and a thread in computer programming. A computer user intuitively understands the behavior of threads when running several programs on the screen, or when listening to an MP3 file in the background while typing a letter into the word processor. Even a single program can make use of threads. The Browsers has separate threads for every file or image you are downloading, and it may assign a separate thread to decode each image or banner ad that appears on the screen when you visit the New York Times web site.

Some short operations have a very high priority. For example, a pot of rice you just started has to be checked every 30 seconds of so to see if it has come to a full boil. At that point the heat can be turned down, the pot can be covered, and now you can forget it for 15 minutes. However, if you dont check it regularly at first, it will boil over, make a mess on the stove, and you have to start over.

Computer programs also assign a priority to their threads. As with cooking, high priority can only be assigned to trivial tasks that can be accomplished in almost no time at all. Just as a kitchen has to have timers, and a beep when the microwave is done, so the operating system has to have support for program threads and the ability to connect them to timers and to events signaled when data arrives from the network or another device.

In the kitchen, each task you perform has its own set of tools. To chop carrots, you need a knife and a cutting board. To take something from the oven, you need oven mittens. It takes some small amount of time to set down what you are doing and change. If you dont change, you will find it is very difficult to cut carrots while wearing oven mittens.

Each thread in the computer stores its status and data in the CPU chip. To switch threads, the operating system has to take this data out of the CPU, store it away, and load up data for the other thread. Switching from one thread to another takes a few hundred instructions, but this is not a problem when the CPU can execute billions of instructions a second while a hard drive or network performs only about 30 operations per second. The overhead of thread switching for I/O is trivial.

If it is a big complicated dinner that one person can simply not get done in time, you need some help. Specific tasks can be assigned to different people. The threads dont change. The bread is still cooked the same way whether there is one person in the kitchen or two. With two people, however, one can chop carrots while the other peels potatoes.

Modern operating systems support computers with more than one CPU chip. The system assigns one thread to run one one CPU, and another thread to run on the next CPU. The two threads run concurrently. However, such systems are expensive and are typically found only in big servers or engineering workstations. Desktop and laptop computers have come with only one CPU.

####Hyper-Threading

As has already been noted, memory delay has become an important problem for computer performance. When an instruction requires data that is in second level cache, it may have to wait a cycle or two. During this time, the CPU will look for other instructions that do not depend on the result of the blocked instruction and execute them out of order. However, out of order execution is at best good for a dozen instructions. When an instruction needs data from DDR DRAM, it will be blocked for a length of time during which the CPU could have run hundreds of instructions.

In 2004, Intel tried to address this memory delay problem with a trick called Hyper-Threading. Rather than duplicate the entire circuitry of a CPU, a Hyperthreading processor simply duplicates the registers that hold all the data that the OS would have to remove from the CPU in order to run a different thread. The OS thinks that there are two CPUs and it assigns two different threads to them. All the registers and data needed to run each thread are loaded into the same CPU chip at the same time.

When both threads are able to run at full speed, the CPU spends half its time running instructions for each thread. Unlike the OS, the CPU doesn't have a view of "priority" and cannot favor one thread because it is more important. However, if one thread becomes blocked because it is waiting for data from the very slow main memory, then the CPU can apply all of its resources to executing instructions for the other thread. Only when both threads are simultaneously blocked waiting for data from memory does the CPU become idle.

####Multi-Core

Moore's Law says that every 18 months the number of circuits on a chip can double. About one Moore Generation after Intel introduced Hyperthreading both Intel and AMD decided to spend the extra transistors to take the next step and create two real CPUs in the same chip.

It has always been possible to do this in any 18 month cycle. However, vendors previously decided to use the transistors to make the single CPU run faster, by supporting out of order execution and register renaming.

A Server tends to assign a thread to each incoming user request. Generally all network users are of equal priority, so threading is an obvious choice for Server software. However, desktop users tend to do one primary thing at a time. If you are running a low intensity job like Word or Web Browsing, CPU doesn't matter. However, playing video games, retouching photographs, compressing TV programs, and a few other consumer programs will use a lot of one CPU, and making the one CPU run faster seemed more important.

Engineers ran out of ideas for using transistors to make a single program run faster. So starting last year they started building "dual core" chips with two CPUs. That forced some of the software vendors, particularly the video game makers, to redesign their software to make better use of the second processor.

Two CPUs can do twice as much work as one CPU if you can keep both processors busy all the time. Unfortunately, that is not realistic. Even on a server, the value of each subsequent processor goes down, and on a desktop there just isn't enough work to distribute it uniformly. So while Intel is beginning to show of a Core 2 Quadro chip with four CPUs, it makes little sense to go farther than that.

####Heat and Power

Computers are idle a lot of the time. When they are running, there is often only work to keep one core busy. The easy thing to do would be to design a dual core machine where both processors run all the time. Such a system will generate twice as much heat and use twice as much energy. Intel and AMD rushed their first generation of dual core processors out the door, so this is how they operate.

Given more time to do the engineering, you can design multi-core systems to shut down parts of the chip that are not being used. This is critical in a laptop system running on battery, but in today's heat and power conscious environment it is useful for even desktop machines.

####Co(re)ordination

Two programs are running on your computer. While they mostly do different things, they may both store data on the same disk and they both display output on the same screen. Internally, the operating system must coordinate their concurrent access to shared resources. At the hardware level, each CPU core must coordinate access to memory and to the I/O devices.

In the old days when Intel had one CPU per chip, coordination between the processors was done by the Northbridge chip on the mainboard. That was a perfectly sensible design. However, when Intel moved to Core Duo, and started to put two CPUs in the same chip, it was no left with the unfortunate consequence that the two CPUs could not talk directly to each other or coordinate activity, but instead they had to go out to the Northbridge chip for every such request.

When AMD came up with the Athlon 64/Opteron design they moved memory management into the CPU. That eliminated the need for a Northbridge chip. Processors where connected to the Southbridge (and thus all I/O devices) and to other processors using HyperTransport links. Each AMD CPU has one CPU, a memory manager, and 1 to 3 HyperTransport managers. AMD connected these five components to each other with a general purpose switch called the crossbar or "XBar" for short. At the time, they may not have given much thought to multiple CPU cores, but this turned out to be an ideal design.

Inside the AMD chip, a CPU that needs data from memory, an I/O device, or another CPU makes a request to the XBar. The XBar determines if the requested data is local (another CPU on the same chip, memory controlled by this chip) or remote (another chip connected by a HyperTransport link).

The use of the XBar to connect devices in the same chip, and the HyperTransport link to connect to external devices, creates a design that is efficient, scalable, and flexible. Recently AMD purchased ATI, a leading maker of the Graphics Processing Unit on a video card. This architecture will let them explore hybrid chips that contain a CPU to run programs and a GPU to handle video, both part of the same chip. Alternate designs combine CPU and some of the Southbridge function to produce ultra cheap or ultra small boards.

This is such a good idea that Intel will be copying it, but probably not until 2008.


###Definition from Intel
A Hyper-Threading Technology (HT Technology) enabled system appears to have more processors than it actually has. With this technology, one physical processor with a single-core is seen as two logical processors. The term logical is used here purposely as these two logical processors are not the same as a dual physical processor. Windows* will report to have two CPUs instead of one. This can be a big problem for licensing software especially when implementing per-processor models, since a two-logical processor system doesn’t perform equally to the real dual-physical processor system. Now, with the introduction of multi-core, the licensing problem is getting worse.

A core is different from a logical processor. The core has its own set of execution units. Also, a core can have more than one logical processor associated with it. In a multi-core HT Technology enabled system, one physical processor can have a minimum of two cores (dual-core) and four logical processors. This is good for multi-threading applications. Cores have their own set of execution units. Therefore, unlike running on logical processors, two threads, each running on a separate core of the same physical processor, do not compete for execution units. Additionally, in multi-core systems you can retrieve the number of threads that can be served by any cache level. This information is generally important for cache blocking applications. For load balancing, it is important that you know which logical processor is associated with which physical processor.

###Referrences

* [howtogeek.com](http://www.howtogeek.com/194756/cpu-basics-multiple-cpus-cores-and-hyper-threading-explained/)
* [yale.edu](http://www.yale.edu/pclt/PCHW/Hyperthreading.htm)
* [intel.com](https://software.intel.com/en-us/articles/hyper-threading-technology-multi-core-and-mobile-intel-pentium-processor-m-toolbox)

