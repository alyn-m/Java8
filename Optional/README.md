# Optional
Def-1: Optional is a container which is used to store a value which might or might not be present.
Def-2: Optional is a container that either contains a non-null value or nothing(empty Optional)

Why Optional is created ?
- It is created to reduce the NullPointerExcpetion that occures in java code.

### Optional Methods
1. Optional.ofNullable(T)
2. Optional.of(T)
3. Optional.empty()


Example:
Without Optional:

```
public class Main {
    public static void main(String[] args) {

        Student Student = getStudentWithName("hamza");
        if(student != null){                        // This is how we check the nulls in code, we can replace this using Optional
             System.out.println(Student.getName());
        }else {
          System.out.println("no Student with the given name ");
        }

    }

   public  static Student  getStudentWithName(String name ){
        // lets suppose that our database contain only 2 students ahmed and hamza .
        if (name.equals("hamza") || name.equals("ahmed")) {
            return new Student(name , 22 , "Morocco");
        } else {
            return null ;
        }
    }

}




```

With Optional
