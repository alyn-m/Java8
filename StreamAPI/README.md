# Everything About Java Stream API
Steam API is a framework in Java,that allows us to process collection of data(like Lists, Sets, Arrays) in a functional style.
Purpose of Stream API:
- To simplify and speed up data processing
What exactly is a Stream?
- A Stream is a sequence of elements that can be processed (transformed, filtered, collected) in a pipeline.

What we can do with Stream API:
- We can performe operations such as filtering, mapping, reducing and Transforming on collection of data.

## Benefits of the Stream API
 1. Improved Readability: The declarative style of coding makes operations like filtering, mapping, and reduction easier to understand.
 2. Less Boilerplate Code: Stream API reduces the need for explicit loops and temporary data structures, resulting in concise and clean code.
 3. Enhanced Performance with Parallel Streams: By using parallel streams, you can process large datasets faster by leveraging multi-core processors.
 4. Composability: Multiple operations can be chained together, forming a pipeline for data processing.
 5. Ease of Transformation: Easily transform data into different formats or structures using mapping and flat-mapping techniques.

## Why Stream API:
### Before Stream API introduced:
 - Before Java 8 streams, processing collection invloved writing imperative loops, which could lead to verbose and error prone code
 - Common Problems are:
    1. Boilerplate Code: Writing iterative loops (for or while loops) to perform operations on collections resulted in verbose and boilerplate code.
    2. Lack of Parallelism:Achieving parallelism in traditional loop-based code requires explicit management of threads, leading to complexity and potential bugs.
    3. Lack of Composition: It was challenging to compose multiple operations (e.g., filter, map, and reduce) in a concise and readable manner.
### With the Streams in Java 8, many of these problems were addressed, offering several advantages:
 1. Declarative Syntax: Streams provide a declarative syntax for processing collections, enabling concise and readable code.
 2. Functional Style: Streams support functional-style programming paradigms, allowing operations to be composed and performed in a fluent and expressive manner.
 3. Immutable Data: Streams operate on immutable data, avoiding side effects and promoting thread safety, making them suitable for parallel processing.
 4. Lazy Evaluation: Streams use lazy evaluation, meaning intermediate operations are only executed when terminal operations are invoked, resulting in optimized performance.


## Stream Pipeline
- A Stream Pipeline is a sequence of stream operations that process data in a step-by-step flow — starting from a data source, through one or more intermediate operations, and ending with a terminal operation.
>[!TIP]
- --(1)-> Data Source (The data which needs to be processed)  <br>
      -(2)--> Intermediate Operations (Pass through several filters, transformers, or sorters)  <br>
         -(3)--> Terminal Operation (And finally produce a result) 
### Structure of a Stream Pipeline
>[!Note]
>[Source] → [Intermediate Operations] → [Terminal Operation]

### Basics of Stream Pipeline
 - Creating Stream: Steams can be created in multiple ways.
 - Intermediate Operations: Intermediate operations transform the elements of a stream. Common operations include filter, map, and sorted.
 - Terminal Operations: Terminal operations produce a result or a side-effect, such as forEach, collect, or count.

<img width="768" height="361" alt="image" src="https://github.com/user-attachments/assets/157c6c9a-21e2-41ad-b251-1e43a33a7096" />



|1️⃣ Source|2️⃣ Intermediate Operations|3️⃣ Terminal Operations|
|---------|--------------------------|----------------------|
|This is where the stream begins-data comes from|These are lazy operations that transform or filter the stream’s data|These are eager operations — once called, the entire pipeline executes|
|Collections(List, Set, etc)|filter(Predicate)|collect(Collector)|
|Arrays|map(Function)|forEach(Consumer)|
|I/O Channels (Files, etc.)|distinct()|reduce(...)|
|Generators|sorted()|count()|
|Other Streams|limit(n)|findFirst()|

## How Streams works internally
1. When you call .stream(), a Stream object is created (not data copied).
2. Intermediate operations are recorded (like steps in a plan).
3. Terminal operation executes the plan — applies intermediate operations one element at a time.
4. After a terminal operation, the Stream is closed (cannot be reused).    \
   
|Stage|Operation|Description|
|-----|---------|-----------|
|1️⃣|names.stream()|Creates stream source|
|2️⃣|filter()|Keeps only “A” starting names|
|3️⃣|map()|Converts to uppercase|
|4️⃣|sorted()|Alphabetically sorts|
|5️⃣|collect()|Executes pipeline and collects results|


## Examples of Stream API Usage
 1.  Filter names starting with "J" and collect them into a new list
 2.  Convert names to uppercase
 3.  Calculate the sum of all numbers
 4.  Print numbers in parallel
 5.  Group items by name and count their occurrences
 6.  Convert database rows into DTOs
 7.  Group audit logs by user
 8.  Identify slow endpoints in API monitoring
 9.  Generate report summaries
 10.  Process REST API responses in bulk
 11.  Chunk data for batch processing
 12.  Combine configs from multiple YAML files (flatten)
 13.  Extract logs of specific microservices
 14.  Aggregate CPU usage for autoscaling decisions
 15.  Filter EC2 instances by state
 16.  Mask sensitive fields in logs
 17.  Remove whitelisted IPs from firewall logs
 18.  Extract failed login attempts from logs
 19.  Identify potential brute-force attack patterns
 20.  Convert raw text to tokens (NLP preprocessing)
 21.  Remove empty/invalid training samples
 22.  Transform insurance claims into payer-specific formats
 23.  Extract patients with abnormal clinical results
 24.  Identify duplicate medical prescriptions
 25.  Filter out invalid or missing patient records
 26.  Convert raw ISO8583 message fields into a business DTO
 27.  Classify transactions based on risk score (AML system)
 28.  Aggregate customer’s daily transaction limit usage
 29.  Filter failed or reversed payment transactions
 30.  RTP
 31.  Filter out duplicate messages using Streams
 32.  Validate TTL (message time expiry)
 33.  Validate creditor agent availability
 34.  Transform inbound XML → ISO20022 DTO using Stream map()
 35.  Apply multiple validations in a pipeline
 36.  ACH
 37.  Read ACH file lines into DTOs
 38.  Check duplicate file
 39.  Validate file structure using Streams
 40.  Group by transaction type using groupingBy
 41.  Convert each ACH record → ISO message
 42.  Validate all job configurations before launching
 43.  Extract ECR image URIs
 44.  Build ECS task definitions using map()
 45.  Aggregate execution time for monitoring
 46.  Filter failed tasks for retries
 47.  Launch multiple Fargate tasks in parallel


## Use Cases:
1. Filtering          : Get all employees with salary > 100k
2. Transformation     : Convert all names to uppercase
3. Aggregation        : Sum all transactions or find average
4. Parallel Streams : Analyze logs or large datasets concurrently
5. Searching          : Find first user from a specific country
6. Grouping           : Group products by category

# Fundamentals
## Everything about Streams
What is Stream?
 - It is a sequence of elements.  

How to create streams?
 - We not only can create streams using collection, we can also create manually using factory methods, generators, builders or even I/O Sources.
### Basic Syntax
 1️⃣ Using Stream.of()
   ```
     Stream<String> stream = Stream.of("Alpha", "Beta", "Gamma");
     stream.forEach(System.out::println);
   ```
 2️⃣ Using Stream.builder()
  ```
   Stream<String> stream = Stream.<String>builder()
                              .add("One")
                              .add("Two")
                              .add("Three")
                              .build();
   stream.forEach(System.out::println);
 ```
 3️⃣ Using Stream.generate()
  ```
   Stream<Double> randomStream = Stream.generate(Math::random);
   randomStream.limit(5).forEach(System.out::println);
  ```
 4️⃣ Using Stream.iterate()
  ```
   Stream<Integer> numbers = Stream.iterate(1, n -> n + 1);
   numbers.limit(5).forEach(System.out::println);
  ```
 5️⃣ Using IntStream, LongStream, DoubleStream
  ```
   IntStream intStream = IntStream.range(1, 6);
   intStream.forEach(System.out::println);

  ```
 6. Using stream() method : This method will consider the collection as the data source and generate a sequential stream.
 7. Using parallelStream() method - Instead of generating a sequential stream, this method will generate a parallel stream.

## Intermediate Stream Operations in Java
### Category-1: Filtering
### Category-2: Mapping
### Category-3: FlatMapping
### Category-4: Sorting
### Category-5: Peeking
 1. filter()
     - Keep only elements that satisfy a condition.
     - Example:
        - ```List<Integer> nums = List.of(1, 2, 3, 4);
             nums.stream()
                 .filter(n -> n % 2 == 0)      // keep even numbers
                 .toList();```
 3. map()
     - Transform each element.
     - Example:
        - ```List<String> names = List.of("ali", "bob");
             names.stream()
                  .map(String::toUpperCase)   // ali → ALI
                  .toList();```
 5. limit()
     - Take first n elements.
     - Example:
        - ```List<String> list = List.of("A", "B", "C", "D");
             list.stream()
                 .limit(2)     // A, B
                 .toList();```
 7. min()
 8. max()
 9. collect()
      - Gather elements into a collection.
      - Example:
         - ```List<String> names = List.of("A", "B");
              List<String> result = names.stream()
                                         .collect(Collectors.toList());```
 11. count()
      - Count elements.
      - Example:
         - ```List<String> list = List.of("A", "B", "C");
              long total = list.stream().count();   // 3```
 13. distinct()
      - Remove duplicates.
      - Example:
         - ```List<Integer> nums = List.of(1, 2, 2, 3);
              nums.stream()
                  .distinct()     // 1, 2, 3
                  .toList();```
 15. reduce()
      - Combine all elements to a single value.
      - Example:
         - ```List<Integer> nums = List.of(1, 2, 3);
              int sum = nums.stream()
                            .reduce(0, Integer::sum);   // 6```
 17. takeWhile()
      - Take elements until condition becomes false.
      - Example:
         - ```List<Integer> nums = List.of(1, 2, 3, 0, 4);
              nums.stream()
                  .takeWhile(n -> n > 0)   // stops at 0 → 1,2,3
                  .toList();```
 19. allMatch()
      - Check if all elements match a condition.
      - Example:
         - ```List<Integer> nums = List.of(2, 4, 6);
              boolean allEven = nums.stream()
                                    .allMatch(n -> n % 2 == 0);   // true```
 21. anyMatch()
      - Check if at least one element matches.
      - retuns: boolean
      - Example:
         - ```boolean hasEven = List.of(1, 3, 4).stream()
                                     .anyMatch(n -> n % 2 == 0);   // true```
 23. findAny()
      - Get any element (non-deterministic in parallel).
      - Example:
         - ```List<String> names = List.of("A", "B", "C");
              names.stream().findAny().get();   // returns any one```
 25. findFirst()
 26. skip()
      - Skip first n elements.
      - Example:
         - ```List<String> list = List.of("A", "B", "C");
              list.stream()
                  .skip(1)    // B, C
                  .toList();
           ```
 28. peek()
      - Debug values during stream operations.
      - Example:
         - ```List.of(1, 2, 3).stream()
                              .peek(n -> System.out.println("Processing: " + n))
                              .toList();
           ```
 30. sorted()
 32. average()
      - (Available in IntStream, DoubleStream, LongStream)
 34. range()
      - Create a sequence from start (inclusive) to end (exclusive).
 36. rangeClosed()
 37. boxed()
      - Convert primitive stream → Stream<Integer>, Stream<Double>, etc.

## Terminal Stream Operations in Java
### Category-1: Reduction
### Category-2: Collecting
### Category-3: Iteration
### Category-4: Matching
### Category-5: Finding
### Category-6: Stats       
### Category-7: Arrays
 1. collect()
 2. forEach()
 3. forEachOrder()
 4. reduce()

>[!warning]
>How to Identify Whether a Stream Operation is Terminal or Intermediate <br>
>If the method returns a Stream → Intermediate Operation <br>
>If the method does NOT return a Stream → Terminal Operation 
