# 자바의 final 키워드, 코틀린에서는?

## final 키워드란?
- Java에서 불변과 안전성을 보장하는 키워드이다.

```java
final class Car { }
class SportsCar extends Car { } // ❌ 에러: final 클래스는 상속 불가

```
- 클래스에 사용하면 상속을 막을 수 있다.

```java
class Car {
    final void drive() { }
}
class Truck extends Car {
    void drive() { } // ❌ 에러
}
```
- 메서드에 사용하면 오버라이딩을 막을 수 있다.
- 변수에 사용하면 값의 재할당을 막을 수 있다.

**사용이유**?
- 불변의 의미를 부여해 의도를 명확하게 한다.
- 상속이나 오버라이딩을 막음으로서 보안 및 안정성을 높인다.
- 값을 재할당할 수 없기 때문에 thread-safe하다.

## 코틀린에서는 어떻게 할까?
```kotlin
class A // 기본 final
fun foo() // 기본 final
val x = 1 
```
- 코틀린은 명시적으로 final을 쓸 일이 거의 없다.
- 기본적으로 모든 클래스와 함수는 final로 간주되기 때문이다.

### 코틀린 클래스
```kotlin
class Car // 기본이 final
class SportsCar : Car() // ❌ 에러: 'Car' is final

open class Vehicle
class Truck : Vehicle() // ✅ OK
```
- 상속을 원하는 경우 open 키워드를 붙인다.

### 코틀린 메서드
```kotlin
open class Car {
    fun start() { }         // 오버라이드 불가 (기본 final)
    open fun drive() { }    // 오버라이드 허용
}

class Truck : Car() {
    override fun drive() { } // ✅ OK
}
```
- 클래스와 마찬가지로 오버라이딩을 허용하고 싶은 경우 open 키워드를 붙인다.

### 코틀린 변수
- `var`: 값이 변경 가능한 일반 변수를 선언할 때 사용합니다. 타입이 아닌 변수 선언용 키워드입니다.
- `val`: 값이 변경 불가능한 변수를 선언할 때 사용하며, 한 번 값이 할당되면 재할당이 불가능합니다.
