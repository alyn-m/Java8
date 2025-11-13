# Lambda Expressions
 - Lambda Expression is a function without a name, that can be passed around as variable.
 - It is created to enable fucntional programming in Java
>💡 In simple terms: A lambda is a short way of writing anonymous methods.

> [!NOTE]
- We need to create functional interface before creating a lamdba expression. if there is not functional interface then there is not lambda expression possible.
- Without a functional interface, you cannot create or use a lambda expression in Java.

**A Lambda Expression is a Shorthand way to implement single abstract method of a functional interface.**
### Lambda Expression Syntax
- The Lambda Expression composed of 3 elements seperated by arrow token(->):
    - Syntax:
        - (params) -> {body of expression}
        - (params): Input arguments required by the functional interface method, enclosed in parentheses ()
        - -> (arrow token): Separates the parameters from the body.
        - Body : The expression or block({}) of code that executes when the method is called.
    - Example:
      ```
        Runnable task = () -> System.out.println("Running thread...");
        new Thread(task).start();
      ```

    - Syntax Variations(Main four forms):
      1. Zero Parameter
      2. One Parameter
      3. Multiple Parameters
      4. Single Expression Body
     
    - Based on Return Type
      1. Void (no return)
          ```
           Consumer<String> show = msg -> System.out.println(msg);
           show.accept("Hello!");
          ```
      2. Value-returning
          ```
           Function<Integer, Integer> squre = x -> x * x;
           System.out.println(squre.apply(4));
          ```  
     
### Why we need a functional interface to create lambda expression
> A lambda expression has no type on its own. The Java compiler needs to know: “Which method’s implementation is this lambda providing?”
> we can use built-in functional interfaces to lambdas.

## Build-In Functional Interfaces
>[!IMPORTANT]
>Java does not have built-in Lambda Expressions, Java does have build-in functional interfaces and you provide the lambda expression that implement them

Build-In Functional interfaces are pre-defined interfaces provided by java in the package java.util.function, designed to work with lambda expressions and method refrences.
>[!Note]
>all built-in interfaces are provided in java.util.function pakage
**Categories of Built-In Functional Interfaces**

|Category|Interface|Method|Description|Example|
|--------|---------|------|-----------|-------|
|Consumer|Consumer < T >|accept(T t)|Takes input returns nothing|x->|
|Supplier|Supplier < T >| get() | Takes no input returns output|X->|
|Function|Function &lt T, R &gt| apply(T t)|Takes input returns output|x->|
|Predicate|Predicate &lt T &gt | test(T t) | Takes input returns boolean|x->|
|Operator|Operator &lt T &gt|apply(T t)|Input and Output are same type|x->|

# Use Cases of Lambda Expressions
