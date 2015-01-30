Operating System - Microprocessor [x86 Vs ARM] AND [RISC Vs CISC]
========================================================
###RISC
RISC, or Reduced Instruction Set Computer. is a type of microprocessor architecture that utilizes a small, highly-optimized set of instructions, rather than a more specialized set of instructions often found in other types of architectures.

It is also called ad LOAD/STORE architecture

###Details
The first RISC projects came from IBM, Stanford, and UC-Berkeley in the late 70s and early 80s. The IBM 801, Stanford MIPS, and Berkeley RISC 1 and 2 were all designed with a similar philosophy which has become known as RISC. Certain design features have been characteristic of most RISC processors:

**one cycle execution time:** RISC processors have a CPI (clock per instruction) of one cycle. This is due to the optimization of each instruction on the CPU and a technique called ;
**pipelining:** a techique that allows for simultaneous execution of parts, or stages, of instructions to more efficiently process instructions;
**large number of registers:** the RISC design philosophy generally incorporates a larger number of registers to prevent in large amounts of interactions with memory

###CISC
The primary goal of CISC architecture is to complete a task in as few lines of assembly as possible. This is achieved by building processor hardware that is capable of understanding and executing a series of operations. For this particular task, a CISC processor would come prepared with a specific instruction (we'll call it "MULT"). When executed, this instruction loads the two values into separate registers, multiplies the operands in the execution unit, and then stores the product in the appropriate register. Thus, the entire task of multiplying two numbers can be completed with one instruction:

```c
MULT 2:3, 5:2
```

CISC	|	RISC
----------------|-----------------
Emphasis on hardware	|	Emphasis on software
Includes multi-clock complex instructions	|	Single-clock,reduced instruction only
Memory-to-memory:"LOAD" and "STORE" incorporated in instructions	|	Register to register: "LOAD" and "STORE" are independent instructions
Small code sizes, high cycles per second	|	Low cycles per second, large code sizes
Transistors used for storing complex instructions	|	Spends more transistors on memory registers


###EXAMPLE

		![RISC_VS_CISC](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/cisc_risc.JPG "cisc_risc")

####CISC Approach
CISC design would try to finish the task in the minimum possible instructions by implementing hardware which could understand and execute series of operations. Thus the processor would come with a specific instruction ÔMULÕ in its instruction set. ÔMULÕ will loads the two values from the memory into separate registers, multiplies the operands in the execution unit, and then stores the product in the appropriate location. So, the entire task of multiplying two numbers can be completed with one instruction:
```c
MUL 1:3, 4:2
```
MUL is referred to as a "complex instruction" as it operates directly on the computer's memory banks and does not require the programmer to explicitly call any loading or  storing functions.
 
####RISC Approach
RISC processors use simple instructions that can be executed within a clock cycle. Thus, ÔMULÕ instruction will be divided into three instructions.

i)"LOAD," which moves data from the memory bank to a register,
ii)"PROD," which finds the product of two operands located within the registers, and
iii)"STORE," which moves data from a register to the memory banks.
 
In order to perform the task, a programmer would need to code four lines of assembly:
```
LOAD A, 1:3
LOAD B, 4:2
PROD A, B
STORE 1:3, A
```

###Referrences

* [cs.stanford.edu](http://cs.stanford.edu/people/eroberts/courses/soco/projects/risc/whatis/index.html)
* [engineersgarage.com](http://www.engineersgarage.com/articles/risc-and-cisc-architecture?page=5)

