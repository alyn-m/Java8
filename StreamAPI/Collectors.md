# Collectors in Java
 - Collector is a terminal/final operation is stream pipeline, collector takes the elements processed by the stream and puts them back into a data structure (like List, Set or Map) or combines them into a single summary result (like count, sum or average).
 - In Java, the Stream API provides a modern way to process data. But after filtering, mapping, and transforming, we usually need to gather results into a collection, a map, or even a single value.
 - That’s where Collectors come in.
 - A Collector is an object that defines how to accumulate elements of a stream into a final result.
 - The Collectors utility class provides ready-to-use static methods, so you rarely need to write your own collectors.
 - They are terminal operations used with collect() to:
    1. Aggregate
    2. Transform
    3. Group
    4. Partition
    5. Reduce
    6. Convert
    7. Summarize
    8. Build maps, sets, lists
    9. Create custom collectors
  
### Examples of Collectors:
1. Group jobs by schedule interval
2. 
