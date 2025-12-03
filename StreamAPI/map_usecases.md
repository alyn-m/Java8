# Java Stream `map()` – Real-World Use Cases

The `map()` operation transforms each element of a stream into another value.  
It is not limited to DTO → BO conversion — it is a powerful general transformation tool.

## 1. Convert String → Length
```
names.stream().map(String::length)
```

## 2. Convert File Path → File Size
```
paths.stream().map(Files::size)
```

## 3. Extract Only One Field (User → Email)
```
users.stream().map(User::getEmail)
```

## 4. Convert JSON String → Java Object
```
jsonList.stream()
        .map(json -> mapper.readValue(json, User.class))
```

## 5. Convert Image → Thumbnail
```
images.stream().map(img -> resize(img, 100, 100))
```

## 6. Payment Status Code → Enum
```
transactions.stream()
            .map(t -> t.getStatusCode().equals("00") 
                      ? Status.SUCCESS 
                      : Status.FAILED)
```

## 7. URL → HTTP Response Code
```
urls.stream()
    .map(u -> ((HttpURLConnection)new URL(u).openConnection()).getResponseCode())
```

## 8. Order Amount → Price After GST
```
orders.stream().map(o -> o.getPrice() * 1.18)
```

## 9. Number → Binary Representation
```
nums.stream().map(Integer::toBinaryString)
```

## 10. Sentence → Word Count
```
sentences.stream()
         .map(s -> s.split("\s+").length)
```

## 11. Throwable → Error Message
```
exceptions.stream().map(Throwable::getMessage)
```

## 12. File Path → File Content
```
paths.stream().map(Files::readString)
```

## 13. LocalDate → Day Name
```
dates.stream().map(LocalDate::getDayOfWeek)
```

## 14. Employee → Salary With Bonus
```
employees.stream()
         .map(e -> e.getSalary() + 5000)
```

## 15. Record → Kafka Message
```
records.stream()
        .map(r -> new ProducerRecord<>("payments", r.toJson()))
```

## 16. Convert IDs → Entities (Spring JPA)
```
ids.stream().map(repo::findById)
```
