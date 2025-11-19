# Java Stream API – Flashcards (GitHub-Friendly)

Below are collapsible flashcards using `<details>` tags so answers stay hidden until expanded.

---

## Flashcard 0 — What is a Stream?
<details>
  <summary>Show Answer</summary>
In simple terms, A Stream is a Sequence of elements/data. <br>
other words, A stream is a sequence of Data flowing through a pipeline where you transform, filter or reduce it - without midifying the original source.
</details>

---
## Flashcard 1 — What is a Stream API?
<details>
  <summary>Show Answer</summary>
    Stream API is a collection of methods used to process the objects present in the collection. 
</details>

---

## Flashcard 2 — Stream vs Collection?
<details>
  <summary>Show Answer</summary>

Collection stores data; Stream processes data. Streams do not modify or store data.
</details>

---

---

## Flashcard 2.1 — Why Stream API is desinged or developed?
<details>
  <summary>Show Answer</summary>

Collection stores data; Stream processes data. Streams do not modify or store data.
</details>

---

## Flashcard 3 — How many parts of a Stream pipeline?
<details>
  <summary>Show Answer</summary>
Stream Piple line consist of 3 steps as mentioned below: <br>
**Source → Intermediate Operations → Terminal Operation**
</details>

---

## Flashcard 4 — Create a Stream from a Collection?
<details>
  <summary>Show Answer</summary>

Use `collection.stream()` or `collection.parallelStream()`.
</details>

---

## Flashcard 5 — What is a Spliterator?
<details>
  <summary>Show Answer</summary>

A special iterator that supports splitting and parallel processing.
</details>

---

## Flashcard 6 — Create an infinite Stream?
<details>
  <summary>Show Answer</summary>

Using `Stream.generate()` or `Stream.iterate()`.
</details>

---

## Flashcard 7 — map() vs flatMap()?
<details>
  <summary>Show Answer</summary>

- `map()` transforms elements  
- `flatMap()` flattens nested structures  
</details>

---

## Flashcard 8 — Is filter() lazy?
<details>
  <summary>Show Answer</summary>

Yes. All intermediate operations are lazy.
</details>

---

## Flashcard 9 — Purpose of peek()?
<details>
  <summary>Show Answer</summary>

Used for debugging; should not be used for side effects.
</details>

---

## Flashcard 10 — Stateful intermediate operations?
<details>
  <summary>Show Answer</summary>

`sorted()`, `distinct()`, and partially `limit()`, `skip()`.
</details>

---

## Flashcard 11 — What triggers pipeline execution?
<details>
  <summary>Show Answer</summary>

Terminal operations like `collect()`, `reduce()`, `forEach()`.
</details>

---

## Flashcard 12 — forEach() vs forEachOrdered()?
<details>
  <summary>Show Answer</summary>

`forEachOrdered()` preserves encounter order; `forEach()` may not, especially in parallel streams.
</details>

---

## Flashcard 13 — What is a reduction?
<details>
  <summary>Show Answer</summary>

Combining elements into a single result (e.g., `sum`, `reduce()`).
</details>

---

## Flashcard 14 — Collector for grouping?
<details>
  <summary>Show Answer</summary>

`Collectors.groupingBy()`.
</details>

---

## Flashcard 15 — What is a downstream collector?
<details>
  <summary>Show Answer</summary>

A collector applied inside another collector, e.g., `groupingBy(key, counting())`.
</details>

---

## Flashcard 16 — toMap() duplicate keys issue?
<details>
  <summary>Show Answer</summary>

Throws `IllegalStateException` unless a merge function is provided.
</details>

---

## Flashcard 17 — Purpose of collectingAndThen()?
<details>
  <summary>Show Answer</summary>

To apply a finishing transformation after collecting.
</details>

---

## Flashcard 18 — Convert Optional to Stream?
<details>
  <summary>Show Answer</summary>

Use `optional.stream()`.
</details>

---

## Flashcard 19 — Why combine Optional + flatMap?
<details>
  <summary>Show Answer</summary>

Enables null-safe transformations without nested Optionals.
</details>

---

## Flashcard 20 — Which thread pool do parallel streams use?
<details>
  <summary>Show Answer</summary>

The **ForkJoinPool.commonPool()**.
</details>

---

## Flashcard 21 — When NOT to use parallel streams?
<details>
  <summary>Show Answer</summary>

- IO-heavy tasks  
- Small datasets  
- Shared mutable state  
- Synchronized operations  
</details>

---

## Flashcard 22 — Why must reduce ops be associative?
<details>
  <summary>Show Answer</summary>

Parallel streams reorder execution; non-associative operations break results.
</details>

---

## Flashcard 23 — What is Work Stealing?
<details>
  <summary>Show Answer</summary>

ForkJoin algorithm where idle threads steal tasks from busy threads.
</details>

---

## Flashcard 24 — Purpose of trySplit() in Spliterator?
<details>
  <summary>Show Answer</summary>

Divides data to allow parallel processing.
</details>

---

## Flashcard 25 — Meaning of SIZED and ORDERED?
<details>
  <summary>Show Answer</summary>

- **SIZED:** Exact size is known  
- **ORDERED:** Data has encounter order  
</details>

---

## Flashcard 26 — Why prefer primitive streams?
<details>
  <summary>Show Answer</summary>

Avoids boxing/unboxing overhead, improving performance.
</details>

---

## Flashcard 27 — Why avoid using forEach in business logic?
<details>
  <summary>Show Answer</summary>

It hides control flow and encourages side effects.
</details>

---

## Flashcard 28 — When do streams cause performance issues?
<details>
  <summary>Show Answer</summary>

- Very deep pipelines  
- Expensive mapping  
- Misuse of parallel streams  
</details>

---

## Flashcard 29 — What is pipeline fusion?
<details>
  <summary>Show Answer</summary>

JVM optimizes by merging intermediate operations to reduce passes.
</details>

---

## Flashcard 30 — Why can't streams be reused?
<details>
  <summary>Show Answer</summary>

They are single-use; terminal ops consume and close the stream.
</details>

---

## Flashcard 31 — Why avoid mutating external state inside lambdas?
<details>
  <summary>Show Answer</summary>

Causes race conditions and violates functional programming principles.
</details>

---

## Flashcard 32 — Why is exception handling hard in streams?
<details>
  <summary>Show Answer</summary>

Checked exceptions aren't supported in lambdas; require wrapping.
</details>

---
