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


###Referrences

* [stackoverflow.com](http://stackoverflow.com/questions/2092527/what-happens-when-you-type-in-a-url-in-browser)
* [chibios.org](http://www.chibios.org/dokuwiki/doku.php?id=chibios:articles:semaphores_mutexes)

