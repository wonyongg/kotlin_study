## 코틀린의 for 문 / 범위 표현(Range)

- 코틀린에서의 fot 문은 자바와 같이 전통적인 for 문 형태가 없습니다.
- 범위(range)와 컬렉션을 사용한 간결한 형태로 표현됩니다.

### 특수 연산자
#### in 연산자
```kotlin
for (i in 0..9) {...}
```
- 범위 내에 값이 있는지 확인할 수 있다.

#### 범위연산자
```kotlin
for (i in 0..9) {
    println(i) // 0 ~ 9 출력
}
```
```kotlin
val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
if ("Volvo" in cars) {
    println("It exists!")
}
```
- `..` 연산자를 사용하여 쉽게 정의도 가능합니다.

#### Break or Continue
- 자바와 동일하다.

### 함수 사용
```kotlin
val arr = arrayOf(1, 2, 3, 4, 5)
arr.forEach { item ->
    println(item)
}
```
- forEach와 같은 함수를 사용할 수 있습니다.