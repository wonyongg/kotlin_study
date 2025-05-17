## 코틀린의 타입 추론
- 코틀린에서는 변수 선언 시 타입을 명시하거나, 초기값을 통해 타입을 추론하도록 해야 한다. 
- 타입을 전혀 지정하지 않으면 코틀린은 변수의 타입을 알 수 없어서 오류가 발생한다.

```kotlin
fun main() {
//    var name -> Error
//    출력: error: this variable must either have a type annotation or be initialized
    var name: String
    name = "John"
    var name2 = "David" // 초기화로 타입 추론 
    println(name) // John
    println(name2) // David
}

fun main() {
//    var num -> Error
    var num: Int
    num = 2
    var num2 = 1
    
    println(num)
    println(num2)

    println(num2::class) // 코틀린 리플랙션 기능 중 하나, ::는 참조 연산자이며, 코틀린의 클래스 정보 출력
    println(num2.javaClass.name) // 런타임 시점에서 num2의 실제 자바 클래스 이름 출력
}
```