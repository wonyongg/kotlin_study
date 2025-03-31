## 문자열 인덱스

### 자바
```java
public class Main {
    public static void main(String[] args) {
        String str = "Java";

        System.out.println(str.charAt(0)); // 'J'
        System.out.println(str.charAt(1)); // 'a'
        System.out.println(str.charAt(2)); // 'v'
        System.out.println(str.charAt(3)); // 'a'

        // 예외 발생 (인덱스 초과)
        // System.out.println(str.charAt(4)); // StringIndexOutOfBoundsException 발생
    }
}
```
- charAt(int index)은 Java의 String 클래스에서 제공하는 메서드로, 문자열에서 특정 위치(인덱스)에 있는 문자(char)를 반환한다.

### 코틀린
```kotlin
fun main() {
    val str = "Kotlin"
    
    println(str[0]) // 'K'
    println(str[1]) // 'o'
    println(str[5]) // 'n'

    println(str.get(0)) // 'K'
    println(str.get(1)) // 'o'

    // 예외 발생 (범위를 벗어난 인덱스)
    // println(str[6]) // StringIndexOutOfBoundsException 발생
}
```
- get(index)는 사실 str[index]와 동일하지만, 대괄호([])가 더 일반적으로 사용된다.

---

## 문자열 길이 구하기
### 자바
```java
String str = "Hello";
System.out.println(str.length()); // 5
```

### 코틀린
```kotlin
val str = "Hello"
println(str.length) // 5
```

--- 

## 문자열 템플릿
### 자바
```java
String firstName = "John";
String lastName = "Doe";
System.out.println(String.format("My name is %s %s", firstName, lastName));
```
```java
int a = 5;
int b = 10;

// String.format()을 사용한 문자열 포맷팅
String result = String.format("Sum: %d", a + b); // Sum: 15
```

### 코틀린
```kotlin
val firstName = "John"
val lastName = "Doe"
println("My name is $firstName $lastName")
```
```kotlin

val a = 5
val b = 10

// String Templates을 사용한 문자열 포맷팅
val result = "Sum: ${a + b}"

println(result) // Sum: 15

```
