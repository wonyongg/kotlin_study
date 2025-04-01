# 코틀린에서의 if...else

## 표현식(Expression) vs. 문(Statement)
### 표현식 (Expression)
- 값을 반환하는 코드 조각
- 다른 코드에서 값으로 사용할 수 있음
- 예시: `5 + 3`, `"Hello".length`, `if (x > 0) "Positive" else "Negative"`

### 문 (Statement)
- 어떤 동작을 수행하지만 값을 반환하지 않는 코드 조각
- 단독으로 실행되지만, 다른 코드에서 값으로 사용할 수 없음
- 예시: `if (x > 0) { println("Positive") }`, `while (true) { ... }`

---
## 자바와 코틀린에서의 차이
```kotlin
val time = 20
val greeting = if (time < 18) {
    "Good day!"
} else {
    "Good evening!"
}

println(greeting) // Good evening!
```
- 코틀린에서는 if 문이 표현식(expression)이기 때문에 값을 반환할 수 있다.
- 자바에서는 문(statement)이기 때문에 값을 반환할 수 없다.

---

## 한 줄로 표현
```kotlin
val time2 = 10
val greeting2 = if (time2 < 18) "Good day!" else "Good evening!"
println(greeting2) // Good day!
```
- 코틀린에서는 if문은 표현식이기 때문에 값으로 반환이 가능하여 한 줄로 작성이 가능하다.

```java
int time2 = 10;
String greeting = (time2 < 18) ? "Good day!" : "Good evening!";
System.out.println(greeting);
```
- 자바에서 한 줄로 표현하기 위해서는 삼항 연산자를 사용할 수 있다.