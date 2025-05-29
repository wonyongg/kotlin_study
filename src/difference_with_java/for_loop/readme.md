# 코틀린의 for 문 / 범위 표현(Range)
- 코틀린에서의 for 문은 자바와 같이 전통적인 for 문 형태가 없습니다.
- 범위(range)와 컬렉션을 사용한 간결한 형태로 표현됩니다.

## 특수 연산자
### in 연산자, 범위연산자
```kotlin
for (i in 0..9) {...}
```
- `in` 연산자는 범위 내에 값이 있는지 확인할 수 있다.
- - `..` 연산자를 사용하여 범위를 지정할 수 있다.

## 순회
### 컬렉션 순회
```kotlin
val list = listOf("A", "B", "C")
for(item in list) {
    println(item)
}
```
### 인덱스 순회
```kotlin
val list = listOf("apple", "banana", "cherry")

for ((index, value) in list.withIndex()) {
    println("$index: $value")
}

// 출력
0: apple
1: banana
2: cherry
```
- `list.withIndex()` 
  - list의 각 요소에 인덱스를 붙여주는 함수이다. 
- 결과는 IndexedValue(index: Int, value: T) 형태의 객체들로 이루어진 iterable이 된다.
  - iterable은 for 루프를 사용할 수 있는 객체를 말한다.

## Break or Continue
- 자바와 동일하다.

## 함수 사용
```kotlin
val arr = arrayOf(1, 2, 3, 4, 5)
arr.forEach { item ->
    println(item)
}
```
- forEach와 같은 함수를 사용할 수 있습니다.

# Label
```kotlin
outer@ for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) break@outer  // 바깥쪽 i 루프까지 완전히 빠져나감
        println("i=$i, j=$j")
    }
}

// 출력
i=1, j=1
```
```kotlin
outer@ for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) continue@outer  // 바깥쪽 루프의 다음 반복으로 건너뜀
        println("i=$i, j=$j")
    }
}

// 출력
i=1, j=1
i=2, j=1
i=3, j=1

```
- `label@`와 같은 형태로 사용된다.
- `break`, `continue`, `return` 등에 붙여 특정 루프나 블록을 지정할 수 있다.
- 중첩 루프에서 특정 루프만 빠져나가거나 건너뛰고 싶을 때 사용한다.
  - 예를 들어, `continue@outer`는 `j == 2`일 때 바깥 루프(i)의 다음 반복으로 건너뜀
- 복잡한 조건문에서 흐름 제어가 명확해져서 코드 가독성 향상