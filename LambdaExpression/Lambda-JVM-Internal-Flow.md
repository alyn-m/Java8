           ┌──────────────────────────────────┐
           │         Java Developer           │
           │   Writes: x -> x + 1             │
           └──────────────────────────────────┘
                            │
                            ▼
           ┌──────────────────────────────────┐
           │            javac                 │
           ├──────────────────────────────────┤
           │ - Parses lambda                  │
           │ - Creates synthetic method       │
           │     lambda$0(int x)              │
           │ - Emits invokedynamic instruction│
           └──────────────────────────────────┘
                            │
                            ▼
           ┌──────────────────────────────────┐
           │         ClassFile (Bytecode)     │
           ├──────────────────────────────────┤
           │   Constant Pool entry:           │
           │   Bootstrap Method:              │
           │   LambdaMetafactory.metafactory  │
           │   invokedynamic #13              │
           └──────────────────────────────────┘
                            │
                            ▼
           ┌──────────────────────────────────┐
           │      JVM's ClassLoader           │
           ├──────────────────────────────────┤
           │ Loads class                      │
           │ Resolves invokedynamic           │
           └──────────────────────────────────┘
                            │
                            ▼ (Bootstrap call)
           ┌───────────────────────────────────────────┐
           │   java.lang.invoke.LambdaMetafactory      │
           ├───────────────────────────────────────────┤
           │ - Receives target type (Function)         │
           │ - Receives method handle to lambda$0      │
           │ - Creates CallSite with MH + FI           │
           │ - Prepares to generate synthetic class     │
           └───────────────────────────────────────────┘
                            │
                            ▼
           ┌───────────────────────────────────────────┐
           │         JVM Lambda Internal Class          │
           ├───────────────────────────────────────────┤
           │  MyClass$$Lambda$1                        │
           │  - Lives in memory only                   │
           │  - Points to lambda$0 via MethodHandle    │
           │  - Implements Function::apply             │
           └───────────────────────────────────────────┘
                            │
                            ▼
           ┌───────────────────────────────────────────┐
           │        Runtime Lambda Instance             │
           ├───────────────────────────────────────────┤
           │  f = new MyClass$$Lambda$1()               │
           │  f.apply(5) → calls lambda$0(5)            │
           └───────────────────────────────────────────┘
                            │
                            ▼
           ┌───────────────────────────────────────────┐
           │         Execution of lambda$0              │
           ├───────────────────────────────────────────┤
           │  Executes method body: x + 1               │
           └───────────────────────────────────────────┘
