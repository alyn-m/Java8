 ┌──────────────────────────────────────────────────────────────┐
 │                      Java Source Code                        │
 │   Function<Integer,Integer> f = x -> x + 1;                  │
 └──────────────────────────────────────────────────────────────┘
                                │
                                ▼
 ┌──────────────────────────────────────────────────────────────┐
 │                        Java Compiler (javac)                 │
 │ 1. Parses lambda syntax                                      │
 │ 2. Creates private synthetic method (lambda$0)               │
 │ 3. Inserts invokedynamic instruction                         │
 └──────────────────────────────────────────────────────────────┘
                                │
                                ▼
 ┌──────────────────────────────────────────────────────────────┐
 │               Bytecode with invokedynamic                    │
 │   invokedynamic #...]                                         │
 └──────────────────────────────────────────────────────────────┘
                                │
                                ▼
 ┌──────────────────────────────────────────────────────────────┐
 │                        JVM Runtime                           │
 │            (During class loading & linking)                  │
 └──────────────────────────────────────────────────────────────┘
                                │
                                ▼
 ┌──────────────────────────────────────────────────────────────┐
 │   Bootstrap Method: java.lang.invoke.LambdaMetafactory       │
 │   - Creates CallSite                                          │
 │   - Binds functional interface method to lambda$0             │
 │   - Uses MethodHandles to link lambda                         │
 └──────────────────────────────────────────────────────────────┘
                                │
                                ▼
 ┌──────────────────────────────────────────────────────────────┐
 │             JVM Generates Synthetic Lambda Class             │
 │          (In memory only, not .class on disk)                │
 │     Example: MyClass$$Lambda$1/0x0000000800b04400            │
 └──────────────────────────────────────────────────────────────┘
                                │
                                ▼
 ┌──────────────────────────────────────────────────────────────┐
 │                 Lambda Object Instantiated                    │
 │   new Function<Integer,Integer>() { apply() → lambda$0 }      │
 │   (Optimized form using MethodHandles, not real class)        │
 └──────────────────────────────────────────────────────────────┘
                                │
                                ▼
 ┌──────────────────────────────────────────────────────────────┐
 │                     Lambda Execution                         │
 │     f.apply(5)  →  invokes lambda$0(5) → return 6             │
 └──────────────────────────────────────────────────────────────┘
