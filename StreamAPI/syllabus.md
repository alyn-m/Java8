# Java Stream API – Complete Developer Syllabus
## 1. Foundations of Stream API
 1. Basics
     - What is a Stream (definition, characteristics)
     - Difference between Stream, Iterator, Collection
     - Stream pipeline structure: Source → Intermediate ops → Terminal ops
 2. Stream Types (Important!)
     - Stream<T>
     - IntStream, LongStream, DoubleStream
     - Primitive vs boxed streams
     - Stream of Optional
## 2. Stream Creation Techniques
 1. From Collections
     - list.stream(), parallelStream()
 3. From Arrays
     - Arrays.stream()
 5. From Static Methods
     - Stream.of(), Stream.generate(), Stream.iterate()
 7. From Files / I/O
     - Files.lines()
     - BufferedReader.lines()
     - Files.walk(), Files.find()
 9. From Builders
     - Stream.Builder<T>
 11. From Spliterators (Advanced, must learn)

## 3. Core Intermediate Operations (Must Master)
 1. Transformations
     - map(), flatMap(), mapToInt(), etc.
 3. Filtering
     - filter(), distinct(), dropWhile(), takeWhile()
 5. Ordering
     - sorted(), custom comparator
     - stability of stream sorting
 7. Peeking
     - peek() — use cases and pitfalls (important!)
 9. Limiting
     - limit(), skip()
 11. State-based ops
     - OR, AND conditions with filters
     - Why Streams must NOT have mutable state inside lambdas
## 4. Terminal Operations (Full List)
 1. Reduction Operations
     - reduce() (all overloads!)
     - Identity + accumulator + combiner
     - Difference between reduce() vs collect()
 2. Matching
     - anyMatch(), allMatch(), noneMatch()
 3. Searching
     - findAny(), findFirst()
 4. Collectors
     - See section 5.
 5. Iteration
     - forEach(), forEachOrdered()
 6. Numeric summary
     - sum(), average(), min(), max(), summaryStatistics()
   
## 5. Collector Framework (Most Important Part)
 1. Built-in Collectors
     - toList(), toSet(), toCollection()
     - joining()
     - counting(), summingInt(), etc.
     - groupingBy() (very important!)
     - partitioningBy()
     - mapping(), flatMapping()
     - collectingAndThen()
     - toMap() pitfalls (duplicate keys!)
 2. Multi-Level Collectors
     - groupingBy() + downstream collector
     - Nested grouping (Hierarchical grouping)
 3. Immutable Collectors
     - Collectors.toUnmodifiableList()
 4. Custom Collector Implementation
     - Implementing Collector<T, A, R>
     - Characteristics:
       - UNORDERED
       - CONCURRENT
       - IDENTITY_FINISH
     - When to write custom collectors
## Advanced Stream Internals (Senior Level)
 1. Lazy Evaluation
     - When pipeline turns into execution
     - Fusion of operations
     - Rewriting of operations by optimizer
 3. Stream Execution Model
     - Spliterator
     - Characteristics:
        - ORDERED, DISTINCT, SIZED, SORTED, CONCURRENT, IMMUTABLE, NONNULL
     - Parallel execution behavior
 5. How Terminal Ops Trigger the Pipeline
     - Short-circuit operations:
        - findFirst(), anyMatch(), limit()
 7. Stream Consumption Rules
     - Why a Stream cannot be reused
     - Supplier-based solutions to reuse streams
   
## Spliterators (Very Important for 10+ Years Dev)
 1. What is a Spliterator
     - Replacement for Iterators
     - How Streams internally split workload
 2. Characteristics
     - SIZED
     - ORDERED
     - DISTINCT
     - SORTED
     - NONNULL
     - IMMUTABLE
     - CONCURRENT
 3. Implementing Custom Spliterators
     - trySplit()
     - characteristics()
     - estimateSize()
 5. When to use custom spliterators (real use cases)
## Parallel Streams — MUST KNOW INTERNALLY
 1. ForkJoinPool
     - CommonPool behavior
     - Custom thread pools
     - How tasks get split
     - Work stealing algorithm
   
 2. When to use parallel streams
     - CPU-bound operations
     - Large data sizes
     - Associative and stateless functions only
   
 3. When NOT to use them
     - IO operations
     - Stateful lambdas
     - Shared mutable data
     - Small datasets
   
 4. Performance Tuning
     - Benchmarking with JMH
     - Overheads of splitting
     - False sharing issues
     - Avoiding boxing/unboxing
   
## Stream Performance + Memory Model
 1. Boxing & Unboxing Costs
     - Avoid Stream<Integer> for heavy numeric ops
     - Use primitive streams
   
 2. Cost of sorted()
     - Parallel sorting behavior
     - Comparison costs
   
 3. Avoiding unnecessary collectors
     - Prefer mapToInt().sum() over collect(summingInt())
   
 4. Pipeline Fusion
     - How JVM optimizes pipelines
     - Combining map/filter operations
   
 5. Avoiding Overuse of Streams
     - Not everything should be a stream
     - Complexity overhead
   
## Error Handling in Streams (Deep Understanding)
 1. Checked exceptions in lambdas
    - Wrapper techniques
    - Custom functional interfaces
   
 2. Handling nulls
     - Optional + streams
     - flatMap(Optional::stream)
   
 3. Collectors error scenarios
     - duplicate keys
     - downstream type mismatches
   
## Streams + Optional Combinations
 1. optional.stream()
 2. Avoiding nested optionals
 3. flatMap with Optional

### Real Project Use Cases
 1. Data aggregation
 2. Log processing
 3. ETL transformations
 4. Grouping hierarchical data
 5. Building response DTOs cleanly
 6. File processing with NIO + streams
 7. Parallel processing of large datasets
 
