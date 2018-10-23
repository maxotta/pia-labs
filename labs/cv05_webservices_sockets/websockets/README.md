WebSocket Lab
==========

Lab demonstrating simple use of WebSockets using Spring implementation.


This example has been created for a Internet Application Programming (KIV/PIA) labs at the Department of Computer Science,
University of West Bohemia in Pilsen, Czech Republic.

## Tasks

In this lab, you are given a working application which represents a very simple chat.

* Explore server implementation: *org.danekja.edu.pia.core.chat.ChatHandler*
* Explore client application: *webapp/websocket-test.html*

Run the server as usual, then open the websocket-test.html in two browser tabs and
try to send a few messages.

### Task 1: "User (dis)connected" messages

Extend server functionality so that all connected users are notified when a user (dis)connects.

### Task 2: List of connected users

Extend client functionality so that it displays list of connected users somewhere on the screen.


## Some Reading

* [Principles](http://enterprisewebbook.com/ch8_websockets.html)

* [Some ranting with useful description how it works](http://lucumr.pocoo.org/2012/9/24/websockets-101/)

* [Spring Docs](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/websocket.html)

## License

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.
