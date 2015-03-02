DHCP
====

Dynamic Host Configuration Protocol (DHCP) is a network protocol that enables a server to automatically assign an IP address to a computer from a defined range of numbers (i.e., a scope) configured for a given network.

DHCP assigns an IP address when a system is started, for example:

* A user turns on a computer with a DHCP client.
* The client computer sends a broadcast request (called a DISCOVER or DHCPDISCOVER), looking for a DHCP server to answer.
* The router directs the DISCOVER packet to the correct DHCP server.
* The server receives the DISCOVER packet. Based on availability and usage policies set on the server, the server determines an appropriate address (if any) to give to the client. The server then temporarily reserves that address for the client and sends back to the client an OFFER (or DHCPOFFER) packet, with that address information. The server also configures the client's DNS servers, WINS servers, NTP servers, and sometimes other services as well.
* The client sends a REQUEST (or DHCPREQUEST) packet, letting the server know that it intends to use the address.
* The server sends an ACK (or DHCPACK) packet, confirming that the client has a been given a lease on the address for a server-specified period of time.

####Introduction Video
<a href="http://www.youtube.com/watch?feature=player_embedded&v=RUZohsAxPxQ
" target="_blank"><img src="http://img.youtube.com/vi/RUZohsAxPxQ/0.jpg" 
alt="http://img.youtube.com/vi/RUZohsAxPxQ/15.jpg" width="540" height="380" border="10" /></a>

####Messages

1.DHCPDISCOVER
2.DHCPOFFER
3.DHCPREQUEST
4.DHCPACK

Protocol Used - UDP

###Referrences

* [javarevisited.blogspot.com](http://javarevisited.blogspot.com/2014/07/9-difference-between-tcp-and-udp-protocol.html)
* [chibios.org](http://www.chibios.org/dokuwiki/doku.php?id=chibios:articles:semaphores_mutexes)

