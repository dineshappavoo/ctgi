DNS
===
The Domain Name System (DNS) is a central part of the Internet, providing a way to match names (a website you’re seeking) to numbers (the address for the website). Anything connected to the Internet - laptops, tablets, mobile phones, websites - has an Internet Protocol (IP) address made up of numbers. Your favorite website might have an IP address like 64.202.189.170, but this is obviously not easy to remember. However a domain name such as bestdomainnameever.com is something people can recognize and remember. DNS syncs up domain names with IP addresses enabling humans to use memorable domain names while computers on the Internet can use IP addresses.

Let’s explore what keeps billions of Internet users and 284 million domain names* connecting—and how Verisign helps to make it happen.

####Introduction Video
<a href="http://www.youtube.com/watch?feature=player_embedded&v=GlZC4Jwf3xQ
" target="_blank"><img src="http://img.youtube.com/vi/GlZC4Jwf3xQ/0.jpg" 
alt="http://img.youtube.com/vi/GlZC4Jwf3xQ/15.jpg" width="540" height="380" border="10" /></a>

####The Query
The process begins when you ask your computer to resolve a hostname, such as visiting http://dyn.com. The first place your computer looks is its local DNS cache, which stores information that your computer has recently retrieved.
If your computer doesn’t already know the answer, it needs to perform a DNS query to find out.

DNS client will make a query to the root server. The server gives another root server information which has .com domain

```DNS CLIENT ```  -->  ```ROOT SERVER``` 

The query look like the following one,

for example .com
```example.com 	IN 	A```
```example.com``` - the domain to look up
```IN``` - The DNS class (Internet)
```A``` - The record type (address) -  We are looking for the address of the top level domain server
	
```DNS CLIENT```  <--  ```ROOT SERVER```

**Authority Section:**

		com.	172800	IN	NS	m.gltd-servers.com		
		com.	172800	IN	NS	l.gltd-servers.com		
		com.	172800	IN	NS	k.gltd-servers.com		
		com.	172800	IN	NS	j.gltd-servers.com
	
```172800``` - Time to live (How long the information is valid)
```IN``` - DNS class(Internet)
```NS``` - Name server(Authoritative server for .com domain)
```m.gltd-servers.com``` - Domain Name for each name servers
	
But with domain name alone we cant reach this DNS servers because we need IP address. So the IP address info is available in the additional section.
	
**Additional Section:**

		m.gltd-servers.com	172800	IN	A	192.55.83.30		
		m.gltd-servers.com	172800	IN	A	192.55.83.30		
		m.gltd-servers.com	172800	IN	A	192.55.83.30		
		m.gltd-servers.com	172800	IN	A	192.55.83.30
	

####Ask the recursive DNS servers
If the information is not stored locally, your computer queries (contacts) your ISP’s recursive DNS servers. These specialized computers perform the legwork of a DNS query on your behalf. Recursive servers have their own caches, so the process usually ends here and the information is returned to the user.

####Ask the root nameservers
If the recursive servers don’t have the answer, they query the root nameservers. A nameserver is a computer that answers questions about domain names, such as IP addresses. The thirteen root nameservers act as a kind of telephone switchboard for DNS. They don’t know the answer, but they can direct our query to someone that knows where to find it.

####Ask the TLD nameservers
The root nameservers will look at the first part of our request, reading from right to left — www.dyn.com — and direct our query to the Top-Level Domain (TLD) nameservers for .com. Each TLD, such as .com, .org, and .us, have their own set of nameservers, which act like a receptionist for each TLD. These servers don’t have the information we need, but they can refer us directly to the servers that do have the information.

####Ask the authoritative DNS servers
The TLD nameservers review the next part of our request — www.dyn.com — and direct our query to the nameservers responsible for this specific domain. These authoritative nameservers are responsible for knowing all the information about a specific domain, which are stored in DNS records. There are many types of records, which each contain a different kind of information. In this example, we want to know the IP address for www.dyndns.com, so we ask the authoritative nameserver for the Address Record (A).


####Retrieve the record
The recursive server retrieves the A record for dyn.com from the authoritative nameservers and stores the record in its local cache. If anyone else requests the host record for dyn.com, the recursive servers will already have the answer and will not need to go through the lookup process again. All records have a time-to-live value, which is like an expiration date. After a while, the recursive server will need to ask for a new copy of the record to make sure the information doesn’t become out-of-date.

####Receive the answer
Armed with the answer, recursive server returns the A record back to your computer. Your computer stores the record in its cache, reads the IP address from the record, then passes this information to your browser. The browser then opens a connection to the webserver and receives the website.
This entire process, from start to finish, takes only milliseconds to complete.

####
###Referrences

* [dyn.com](http://dyn.com/blog/dns-why-its-important-how-it-works/)
* [microsoft.com](https://technet.microsoft.com/en-us/library/cc772774(v=ws.10).aspx)

