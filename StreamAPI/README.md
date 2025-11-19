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
