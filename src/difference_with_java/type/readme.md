# 코틀린의 타입 추론
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

# 코틀린의 최상위 타입
## `Any`
- 코틀린의 모든 클래스의 슈퍼타입 최상위 타입이다.
- 자바의 `Object`와 비슷하지만 null을 포함하지 않는다.
  - `Any?`를 사용하면 null도 받을 수 있다.
- 모든 타입은 `Any`를 상속한다.
- 메서드의 경우 `equals()`, `hashcode()`, `toString()`만 정의되어 있다.

## `Unit`
- ```kotlin
    fun logMessage(msg: String): Unit {
        println(msg)
    
        return Unit
    }
  
    // 반환 타입 Unit 생략 가능
    fun logMessage(msg: String) {
        println(msg)
    }
  ```
- 반환값이 없는 함수가 반환하는 타입이다.
- 자바의 `void`와 유사하지만, `Unit`의 경우 실제 객체이다.
- Unit 타입의 함수는 반환 타입인 `Unit`과 `return` 문을 명시하지 않아도 된다.
- 즉 아무것도 반환하지 않는 `void`와 비교하여 `Unit`이나는 빈 상자 하나를 반환한다.
  - 이걸 쓴느 이유는 코틀린에서는 모든 것이 값이기 때문에 통일감을 주기 위해서이다. 

## `Nothing`
- ```kotlin
    fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
    }
  
    val name: String = getName() ?: throw IllegalArgumentException("No name")
    // throw는 Nothing을 반환하므로 컴파일러는 문제 없음!
  ```
- `Nothing`은 절대 리턴하지 않는다는 걸 타입 시스템에 명시하기 위해 존재한다.
  - throw는 그 자체로 Nothing 타입을 가진다.
- 즉, 이 함수는 정상적으로 종료되지 않고 반드시 예외를 던진다는 것을 컴파일러에게 알려주어 Smart Cast나 Null 안전성 검사에 도움을 준다.
- `?:`은 엘비스 연산자로 `a ?: b`인 경우 `a`가 null이 아니면 `a`의 값 그대로를 사용하고, null인 경우 기본값인 `b`를 사용한다는 뜻이다.
- `Nothing`은 모든 타입의 하위 타입이다.
