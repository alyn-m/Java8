# Lambda Expressions
 - Lambda Expression is a function without a name, that can be passed around as variable.
 - It is created to enable fucntional programming in Java
>💡 In simple terms: A lambda is a short way of writing anonymous methods.

>[!NOTE]
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
|Consumer|Consumer < T>|accept(T t)|Takes input returns nothing. Consumer only consumes somthing returns nothing|```x->System.out.println(x);```|
|Supplier|Supplier < T>| get() | Takes no input returns output. Supplier supplies/return something but will not take anything|```()->"Hello";```|
|Function|Function <T, R>| apply(T t)|Takes input returns output. |```x-> x*2```|
|Predicate|Predicate < T> | test(T t) | Takes input returns boolean. Predicate predicts something based on input and return true or false|```x -> x >10```|
|Operator|Operator < T>|apply(T t)|Input and Output are same type. |```x -> x.toUpperCase()```|

# Use Cases of Lambda Expressions

## 💻 Example: Using All Core Functional Interfaces
```
import java.util.function.*;

public class BuiltInFunctionalExample {
    public static void main(String[] args) {
        // Consumer
        Consumer<String> printer = msg -> System.out.println("Message: " + msg);
        printer.accept("Hello Lambda!");

        // Supplier
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random: " + randomValue.get());

        // Function
        Function<Integer, String> converter = n -> "Value: " + n;
        System.out.println(converter.apply(10));

        // Predicate
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 8 even? " + isEven.test(8));

        // UnaryOperator
        UnaryOperator<String> upper = str -> str.toUpperCase();
        System.out.println(upper.apply("java8"));

        // BinaryOperator
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(5, 3));
    }
}

```
