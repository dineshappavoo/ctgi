Website Flow
============
In an extremely rough and simplified sketch, assuming the simplest possible HTTP request, no proxies and IPv4 (this would work similarly for IPv6-only client, but I have yet to see such workstation):

* browser checks cache; if requested object is in cache and is fresh, skip to #9
* browser asks OS for server's IP address
* OS makes a DNS lookup and replies the IP address to the browser
* browser opens a TCP connection to server (this step is much more complex with HTTPS)
* browser sends the HTTP request through TCP connection
* browser receives HTTP response and may close the TCP connection, or reuse it for another request
* browser checks if the response is a redirect (3xx result status codes), authorization request (401), error (4xx and 5xx), etc.; these are handled differently from normal responses (2xx)
* if cacheable, response is stored in cache
* browser decodes response (e.g. if it's gzipped)
* browser determines what to do with response (e.g. is it a HTML page, is it an image, is it a sound clip?)
* browser renders response, or offers a download dialog for unrecognized types
* Again, discussion of each of these points have filled countless pages; take this as a starting point. Also, there are many other things happening in parallel to this (processing typed-in address, adding page to browser history, displaying progress to user, notifying plugins and extensions, rendering the page while it's downloading, pipelining, connection tracking for keep-alive, etc.).



####Introduction Video
<a href="http://www.youtube.com/watch?feature=player_embedded&v=DuSURHrZG6I
" target="_blank"><img src="http://img.youtube.com/vi/DuSURHrZG6I/0.jpg" 
alt="http://img.youtube.com/vi/DuSURHrZG6I/15.jpg" width="540" height="380" border="10" /></a>

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

###Difference Chart
|Property|TCP|UDP|
|--------|---|---|
|Acronym for	|	Transmission Control Protocol	|User Datagram Protocol or Universal Datagram Protocol|
Connection|	TCP is a connection-oriented protocol.	|UDP is a connectionless protocol.|
|Function	|As a message makes its way across the internet from one computer to another. This is connection based.	|	UDP is also a protocol used in message transport or transfer. This is not connection based which means that one program can send a load of packets to another and that would be the end of the relationship.|
|Usage	|TCP is suited for applications that require high reliability, and transmission time is relatively less critical.	|	UDP is suitable for applications that need fast, efficient transmission, such as games. UDP's stateless nature is also useful for servers that answer small queries from huge numbers of clients.|
|Use by other protocols	|	HTTP, HTTPs, FTP, SMTP, Telnet	|	DNS, DHCP, TFTP, SNMP, RIP, VOIP.|
|Ordering of data packets	|	TCP rearranges data packets in the order specified.	|	UDP has no inherent order as all packets are independent of each other. If ordering is required, it has to be managed by the application layer.|
|Speed of transfer	|	The speed for TCP is slower than UDP.	|	UDP is faster because there is no error-checking for packets.|
|Reliability	|	There is absolute guarantee that the data transferred remains intact and arrives in the same order in which it was sent.	|	There is no guarantee that the messages or packets sent would reach at all.|
|Header Size	|	TCP header size is 20 bytes	|	UDP Header size is 8 bytes.|
|Common Header Fields	|Source port, Destination port, Check Sum	|	Source port, Destination port, Check Sum|
|Streaming of data	|	Data is read as a byte stream, no distinguishing indications are transmitted to signal message (segment) boundaries.	|	Packets are sent individually and are checked for integrity only if they arrive. 	Packets have definite boundaries which are honored upon receipt, meaning a read operation at the receiver socket will yield an entire message as it was originally sent.|
|Weight	|TCP is heavy-weight. TCP requires three packets to set up a socket connection, before any user data can be sent. TCP handles reliability and congestion control.	|	UDP is lightweight. There is no ordering of messages, no tracking connections, etc. It is a small transport layer designed on top of IP.|
|Data Flow Control	|TCP does Flow Control. TCP requires three packets to set up a socket connection, before any user data can be sent. TCP handles reliability and congestion control.	|UDP does not have an option for flow control|
|Error Checking	|	TCP does error checking	|	UDP does error checking, but no recovery options.|
|Fields	|1. Sequence Number, 2. AcK number, 3. Data offset, 4. Reserved, 5. Control bit, 6. Window, 7. Urgent Pointer 8. Options, 9. Padding, 10. Check Sum, 11. Source port, 12. Destination port	|	1. Length, 2. Source port, 3. Destination port, 4. Check Sum|
|Acknowledgement	|	Acknowledgement segments	|	No Acknowledgment|
|Handshake	|	SYN, SYN-ACK, ACK	|	No handshake (connectionless protocol)|
|Checksum	|	checksum	|	to detect errors|
###Referrences

* [javarevisited.blogspot.com](http://javarevisited.blogspot.com/2014/07/9-difference-between-tcp-and-udp-protocol.html)
* [chibios.org](http://www.chibios.org/dokuwiki/doku.php?id=chibios:articles:semaphores_mutexes)

