# 자바와 코틀린의 타입 변환

## 자바 타입 변환(자동)

- 자바에서는 기본형 타입 간에 자동으로 변환이 가능하다. 
- 예를 들어, `int`에서 `long`으로, `long`에서 `int`로 변환이 자유롭게 이루어진다.

### 예시
```java
public class JavaConversion {

    public static void main(String[] args) {

        int a = 10;
        long b = 20L;

        long c = a;  // int에서 long으로 자동 변환

        System.out.println(c);
    }
}
```

- 자바에서는 int를 long으로 변환할 때 자동으로 형변환이 이루어진다.
- a(타입: int)는 c(타입: long)에 아무런 문제 없이 할당된다.

--- 

## 코틀린 타입 변환(명시적)
- 코틀린에서는 자동으로 형변환이 되지 않는다. 
- 타입 간에 변환이 필요할 때는 toInt(), toLong() 같은 함수를 사용해야 한다. 
- 이는 언어의 타입 안전성을 더 강화시킨다.

### 예시
```kotlin
fun main() {

    // 타입 추론으로 Int 타입
    val a = 10

    println("a의 타입: " + a.javaClass.typeName)

    // 명시적 타입 선언
    val b: Long = 20

    var c: Int
    c = b.toInt()  // Long에서 Int로 명시적 변환

    println("b의 타입: " + b.javaClass.typeName)
    println("c의 타입: " + c.javaClass.typeName)

    // 자동 형변환이 되지 않기 때문에 직접 변환하지 않으면 타입 불일치 오류 발생
    var d: Int
    d = b // 컴파일 오류(Type mismatch)가 발생함
}
```

- `명시적 변환`: b(Long)를 c(Int)로 변환하려면 toInt() 함수를 사용해야 한다.
- `타입 불일치`: `b = d`와 같이 변환 없이 호환되지 않는 타입을 할당하려고 하면 컴파일 오류가 발생한다.
