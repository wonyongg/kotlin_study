## 코틀린에서의 배열(Arrays)

### 코틀린에서의 기본형, 객체형
```kotlin
val a: Int = 10
// a : int
// JVM에서는 int로 처리됨 (기본형)
// 컴파일러가 알아서 int로 변환

val b: Int? = 10
// b : class java.lang.Integer
// JVM에서는 Integer로 처리됨 (객체형 = boxing)
// nullable이니까 반드시 객체 (Integer)로 변환됨
```
- Kotlin 코드를 보면 그냥 Int 하나만 쓰고, int, Integer와 같은 구분이 안 보이지 않는다.
- 사실 Kotlin 내부적으로는 기본형과 객체형을 구분하고 있다.
- 컴파일 시 JVM에 맞춰서 알아서 int(primitive) 또는 Integer(object)로 변환되는 것이다.
- 내부적으로 객체처럼 메서드 호출이 가능하다.
  - 컴파일 시 a.compareTo(5)를 JVM의 정적 메서드로 바꿔준다 (Integer.compare(a, 5))

### 코틀린의 기본형 배열과 객체 배열
```kotlin
val intArray = IntArray(3)        // [0, 0, 0]
val objectArray = arrayOf(1, 2, null) // Array<Int>

println("intArray: $intArray") // [0, 0, 0] → 실제로 int 타입 값 저장
println("intArray values: ${intArray.contentToString()}")
println("objectArray: $objectArray") // [Integer(1), Integer(2), null] → 객체 저장
println("objectArray values: ${objectArray.contentToString()}")
```
- 기본형 배열은 숫자나 불린 같은 값 자체를 저장하며 null은 올 수 없다.
  - 자바의 `int[]`와 같다.
- 기본형 배열의 메모리 효율이 더 높으며 속도 역시 빠르다.
- 객체 배열은 객체에 대한 참조를 저장하며 null을 허용한다.
  - 자바의 `Integer[]`와 같다.

```kotlin
val list: List<Int> = listOf(1, 2, 3)
println("list[0].JavaClass: ${list[0].javaClass}") // list[0].JavaClass: class java.lang.Integer
```
- JVM에서는 제네릭에 기본형을 직접 쓸 수 없기 때문에 Kotlin의 `List<Int>`는 내부적으로 `List<Integer>`로 처리된다. 
- null을 허용해야 하기 때문이다.