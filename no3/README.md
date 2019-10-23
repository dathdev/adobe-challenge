# Execute Spring Boot project
## Requirements
- Maven 3.6.1
- Java 1.8.0
## Run Spring Boot app
From the `lru-rest-service` folder in the command line, run `mvn spring-boot:run`. The app should be exposed on `localhost:8080`.
# API endpoints
For the simplicity of the demo app, I implemented everything with the GET method.
- `/getImagesUrl?Lat=<Lat value>&Long=<Long value>`: to get an "image URL" with the provided coordinates. It should also return the hit counter for the image, if the cache is full when this request was received.
- `/getCache`: to get all the cached image URLs and hit counters.
- `/clearCache`: to clear all the cached values.
- `/clearHitCounter`: to reset the hit counters while keeping the cached values.
# Implementation
I used a HashMap to keep all the cached value and a Linked List as a queue to manage the last hit cached value. Everytime the cache hits, the HashMap would be able to look for the cached value with an O(1) complexity given how HashMap works. Java's CircularFifoQueue would take care of clearing the last value in the queue if it exceeds the capacity automatically but I still had to remove the HashMap entry manually because Java does not allow the use of pointers.

*NOTES: change the CACHE_SIZE inside lru-rest-service/src/main/java/lru/LruCache.java for testing purpose*
