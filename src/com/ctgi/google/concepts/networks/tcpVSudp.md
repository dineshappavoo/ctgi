TCP Vs UDP
==========
TCP and UDP are two transport layer protocols, which are extensively used in internet for transmitting data between one host to another.

By the way, use of TCP and UDP is not limited to one area, its at the heart of internet. The protocol which is core of internet, HTTP is based on TCP. One more reason, why Java developer should understand these two protocol in detail is that Java is extensively used to write multi-threaded, concurrent and scalable servers. Java also provides rich Socket programming API for both TCP and UDP based communication. In this article, we will learn key differences between TCP and UDP protocol, which is useful to every Java programmers. To start with, TCP stands for Transmission Control Protocol and UDP stands for User Datagram Protocol, and both are used extensively to build Internet applications.

####1) Connection oriented vs Connection less
First and foremost difference between them is TCP is a connection oriented protocol, and UDP is connection less protocol. This means  a connection is established between client and server, before they can send data. Connection establishment process is also known as TCP hand shaking where control messages are interchanged between client and server. Attached image describe the process of TCP handshake, for example which control messages are exchanged between client and server. 

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/TCP-Handshake-Message-Diagram.jpg "TCp connection")

Client, which is initiator of TCP connection, sends SYN message to server, which is listening on a TCP port. Server receives and sends a SYN-ACK message, which is received by client again and responded using ACK. Once server receive this ACK message,  TCP connection is established and ready for data transmission. On the other hand, UDP is a connection less protocol, and point to point connection is not established before sending messages. That's the reason, UDP is more suitable for multicast distribution of message, one to many distribution of data in single transmission.

####2) Reliability
TCP provides delivery guarantee, which means a message sent using TCP protocol is guaranteed to be delivered to client. If message is lost in transits then its recovered using resending, which is handled by TCP protocol itself. On the other hand, UDP is unreliable, it doesn't provide any delivery guarantee. A datagram package may be lost in transits. That's why UDP is not suitable for programs which requires guaranteed delivery.

####3) Ordering
Apart from delivery guarantee, TCP also guarantees order of message. Message will be delivered to client in the same order, server has sent, though its possible they may reach out of order to the other end of the network. TCP protocol will do all sequencing and ordering for you. UDP doesn't provide any ordering or sequencing guarantee. Datagram packets may arrive in any order. That's why TCP is suitable for application which need delivery in sequenced manner, though there are UDP based protocol as well which provides ordering and reliability by using sequence number and redelivery e.g. TIBCO Rendezvous, which is actually a UDP based application

####4) Data Boundary
TCP does not preserve data boundary, UDP does. In Transmission control protocol, data is sent as a byte stream, and no distinguishing indications are transmitted to signal message (segment) boundaries. On UDP, Packets are sent individually and are checked for integrity only if they arrived. Packets have definite boundaries which are honoured upon receipt, meaning a read operation at the receiver socket will yield an entire message as it was originally sent. Though TCP will also deliver complete message after assembling all bytes. Messages are stored on TCP buffers before sending to make optimum use of network bandwidth.

####5) Speed
In one word, TCP is slow and UDP is fast. Since TCP does has to create connection, ensure guaranteed and ordered delivery, it does lot more than UDP. This cost TCP in terms of speed, that's why UDP is more suitable where speed is a concern, for example online video streaming, telecast or online multi player games.

####6) Heavy weight vs Light weight
Because of the overhead mentioned above, Transmission control protocol is considered as heavy weight as compared to light weight UDP protocol. Simple mantra of UDP to deliver message without bearing any overhead of creating connection and guaranteeing delivery or order guarantee keeps it light weight. This is also reflected in their header sizes, which is used to carry meta data.

####7) Header size
TCP has bigger header than UDP. Usual header size of a TCP packet is 20 bytes which is more than double of 8 bytes, header size of UDP datagram packet. TCP header contains Sequence Number, Ack number, Data offset, Reserved, Control bit, Window, Urgent Pointer, Options, Padding, Check Sum, Source port, and Destination port. While UDP header only contains Length, Source port, Destination port, and Check Sum. Here is how TCP and UDP header looks like :

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/TCP-Packet-Format-Diagram.gif "TCp connection")

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/UDP-Packet-format.jpg "TCp connection")

####8) Congestion or Flow control
TCP does Flow Control. TCP requires three packets to set up a socket connection, before any user data can be sent. TCP handles reliability and congestion control. On the other hand, UDP does not have an option for flow control.


####9) Usage and application
Where does TCP and UDP are used in internet? After knowing key differences between TCP and UDP, we can easily conclude, which situation suits them. Since TCP provides delivery and sequencing guaranty, it is best suited for applications that require high reliability, and transmission time is relatively less critical. While UDP is more suitable for applications that need fast, efficient transmission, such as games. UDP's stateless nature is also useful for servers that answer small queries from huge numbers of clients. In practice, TCP is used in finance domain e.g. FIX protocol is a TCP based protocol, UDP is used heavily in gaming and entertainment sites.


####10) TCP and UDP based Protocols
One of the best example of TCP based higher end protocol is HTTP and HTTPS, which is every where on internet. In fact most of the common protocol you are familiar of e.g. Telnet, FTP and SMTP all are based over Transmission Control Protocol. UDP don't have any thing as popular as HTTP but UDP is used in protocol like DHCP (Dynamic Host Configuration Protocol) and DNS (Domain Name System). Some of the other protocol, which is based over User Datagram protocol is Simple Network Management Protocol (SNMP), TFTP, BOOTP and NFS (early versions).


That's all about difference between TCP and UDP protocol. Always remember to mention that TCP is connection oriented, reliable, slow, provides guaranteed delivery and preservers order of messages, while UDP is connection less, unreliable, no ordering guarantee, but fast protocol. TCP overhead is also much higher than UDP, as it transmits more meta data per packet than UDP. It's worth mentioning that header size of Transmission control protocol is 20 bytes, compared to 8 bytes header of User Datagram protocol. Use TCP, if you can't afford to lose any message, while UDP is better for high speed data transmission, where loss of single packet is acceptable e.g. video streaming or online multi player games. While working in TCP/UDP based application on Linux, it's also good to remember basic networking commands e.g. telnet and netstat, they help tremendously to debug or troubleshoot any connection issue.

###Referrences

* [wikipedia.com](http://en.wikipedia.org/wiki/Semaphore_%28programming%29)
* [chibios.org](http://www.chibios.org/dokuwiki/doku.php?id=chibios:articles:semaphores_mutexes)

