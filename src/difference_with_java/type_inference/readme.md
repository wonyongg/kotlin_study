## 코틀린의 타입 추론
- 코틀린에서는 변수 선언 시 타입을 명시하거나, 초기값을 통해 타입을 추론하도록 해야 한다. 
- 타입을 전혀 지정하지 않으면 코틀린은 변수의 타입을 알 수 없어서 오류가 발생한다.

```kotlin
fun main() {
//    var name -> Error
//    출력: error: this variable must either have a type annotation or be initialized
    var name: String
    name = "John"
    println(name)
}

fun main() {
//    var num -> Error
    var num: Int
    num = 2
    println(num)
}
```