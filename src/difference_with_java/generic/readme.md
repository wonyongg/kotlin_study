# 제네릭(Generic)
## 제네릭이란?
- 타입을 파라미터화하는 것으로 재사용성과 타입 안전성을 높일 수 있다.
- `List<Int>`와 같이 리스트의 타입을 지정할 수 있다.
  - 타입을 몰라도 코드를 돌게 하고 에러는 컴파일 단계에서 잡는 것이 핵심 목적이다.
  - 자바 1.4 이전 버전에서는 `List`에 뭐든 넣을 수 있었고 꺼낼 때마다 `Object`로 받아서 형변환을 해야했다.
  - 제네릭이 도입된 이후에는 컴파일러가 `이 리스트에는 int만 들어갈 수 있다`고 타입 체크를 해주는 것이다.

## 무공변성(Invariant)
```kotlin
class Box<T>
val intBox: Box<Int> = Box<Int>()
val numBox: Box<Number> = intBox // ❌ 안 됨!
```
- `Box<Int>`와 `Box<Number>`는 전혀 관련 없는 타입으로 취급된다.
- 즉, 같은 구조라도 타입 파라미터가 다르면 서로 연관이 없다고 판단하는 것이다.
  - 이걸 무공변성이라고 한다.

## 공변성(Covariant) - `OUT T` (읽기 전용)
```kotlin
open class Fruit
class Apple : Fruit()
class Banana : Fruit()

class JuiceMaker<out T>(private val juice: T) {
  fun getJuice(): T {
    return juice
  }
}

val appleMaker: JuiceMaker<Apple> = JuiceMaker(Apple())
val fruitMaker: JuiceMaker<Fruit> = appleMaker // ✅ 공변성 덕분에 가능!

val juice: Fruit = fruitMaker.getJuice() // Apple이지만 Fruit로 꺼낼 수 있음
```
- `JuiceMaker<out Fruit>` Fruit 또는 그 자식인 Apple, Banana 주스만 꺼낼 수 있다.
- 안에 뭐가 들어있는지는 모르나 꺼내면 항상 Fruit이다.
- `out`은 읽기 전용으로 안전하게 꺼내만 쓸 수 있다.
- 그래서 `Apple`을 만드는 기계를 `Fruit를 만드는 기계처럼 사용할 수 있다.

## 반공변성(Contravariant) - `in T`(쓰기 전용)
```kotlin
class FruitProcessor<in T> {
  fun process(fruit: T) {
    println("Processing $fruit")
  }
}

val fruitProcessor: FruitProcessor<Fruit> = FruitProcessor()
val appleProcessor: FruitProcessor<Apple> = fruitProcessor // ✅ 반공변성 덕분에 가능!

appleProcessor.process(Apple()) // Apple을 받아서 처리
```
- `FruitProcessor<in Apple>` Apple 또는 Apple의 부모인 Fruit를 넣을 수 있다.
- `in`은 쓰기 전용으로 타입을 받아서 내부에서 쓰기만 한다.
- FruitProcessor<Fruit>는 Apple도 받을 수 있으니까 FruitProcessor<Apple>로도 쓸 수 있다.

## 제약조건
### 자바
```java
public <T extends Number> void printDouble(T value) {
  System.out.println(value.doubleValue());
}
```

### 코틀린
```kotlin
fun <T : Number> printDouble(value: T) {
  println(value.toDouble())
}
```
- `T : Number`는 `T`는 반드시 `Number` 또는 그 하위 타입이어야 한다는 뜻이다.
  - 즉 `int`, `float`, `double`은 가능하지만 `String`은 안 된다.

## 스타 프로젝션
### 자바
```java
class Box<T> {
    public T value;
}

void printBox(Box<?> box) {
    System.out.println(box.value); // 타입을 모르니까 읽기만 가능
}
```
- 자바에서 <?> = `Unbounded wildcard`

```kotlin
class Box<T>(val value: T)

fun printBox(box: Box<*>) {
    println(box.value) // ⚠️ 타입이 정확히 뭔지 모르니까 읽기만 가능, 쓰기는 ❌
}
```
- `Box<*>`은 아무 타입의 Box라도 받을 수 있다는 뜻이다.
  - `Box<Int>`, `Box<String>` 등
- 단, value의 타입이 정확하지 않아서 Any?로 추론된다.
  - 따라서 값을 읽는 건 가능하지만 값을 설정하거나 수정할 수는 없다.