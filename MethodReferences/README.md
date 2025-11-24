# Method References
>Method references are simply shortcuts to call existing methods using the ```::``` operator.

What are Method references ?
- Method references is a way to refer to existing methods without writing a lambda expressions.
- Method references are a special type of lambda expression. They’re often used to create simple lambda expressions by referring to existing methods. 

>[!Warning]
>A method reference must always be assigned to a functional interface.

## Syntax:
>[!Important]
>object::methodName

## Use Cases:
>[!Note]
>Rather then writing a lambda expression we can write Method References.

- When to use: 
Most of the time, we do some operations inside the lambda expression. Sometimes, however, a lambda expression does nothing but call an existing method. In those cases, it’s often clearer to refer to the existing method by name. 

## Types of Method References
1. Static Method Reference
2. Instance Method Reference
3. Reference to a constructor
4. 
