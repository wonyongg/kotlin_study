# 특별한 클래스
## data class
```kotlin
data class User(val name: String, val age: Int)

val user1 = User("Alice", 25)
val user2 = user1.copy(age = 30)

println(user1) // User(name=Alice, age=25)
println(user2) // User(name=Alice, age=30)
```
- `equals()`, `hashCode()`, `toString()`, `copy()`, `componentN()`을 자동으로 생성한다.
  - `equals()`
    - 두 객체가 같은지 비교하는 메서드
    - 기본 클래스에서는 참조값을 비교하지만, `data class`에서는 필드 값이 같으면 같다고 본다.
  - `hashCode()`
    - 객체를 해시 기반 컬렉션(`HashSet`, `HashMap` 등)에 넣을 때 사용하는 값이다.
    - `equals()`가 같다면 `hashCode()`도 같아야 하므로 `data class`는 필드 기반으로 자동 생성해준다.
  - `toString()`
    - 객체 정보를 문자열로 출력할 때 사용한다.
    - 기본 클래스의 겨우 `User@xxxxxx`처럼 출력되지만 `data class`의 경우 필드 정보를 보기 좋게 출력한다.
  - `copy()`
    - 기존 객체에서 일부 값만 바꾸어 새 객체를 만들 수 있는 메서드이다.
    - `val`로 정의한 필드도 복사해서 새로 만들 수 있다.
      - 이는 불변성을 유지하면서도 수정 유연성을 제공한다고 볼 수 있다.
  - `componentN()`
    - ```kotlin
      val u = User("Alice", 20)
      val (name, age) = u
    
      println(name) // Alice
      println(age)  // 20
      ``` 
    - `data class`는 내부 필드마다 `component1()`, `component2()` 같은 메서드를 만들어서 값을 구조 분해할 수 있게 한다.
    - 위의 예시에서 `component1()`은 `name`, `component2()`는 `age`를 의미한다.
- 불변 객체를 만들 때 유용하다.
- 최소한 하나 이상의 val 또는 var 프로퍼티를 가진 주 생성자가 있어야 한다.

## sealed class
```kotlin
sealed class Result
data class Success(val data: String) : Result()
data class Error(val exception: Throwable) : Result()
object Loading : Result()

fun handle(result: Result) {
    when (result) {
        is Success -> println("Success: ${result.data}")
        is Error -> println("Error: ${result.exception}")
        Loading -> println("Loading...")
    }
}
```
- `sealed class`는 상속 가능한 클래스의 범위를 제한할 수 있는 클래스이다.
  - 같은 파일 안에서만 상속이 가능하다.
- 주로 `when` 표현식과 함께 패턴 매칭할 때 사용된다.
- 같은 파일 내에서만 상속이 가능하다.
- 컴파일러가 하위 클래스들을 모두 알 수 있어 `when`에서 `else`가 필요하다.

## abstract 
```kotlin
abstract class Animal(val name: String) {
    abstract fun makeSound()
    
    fun introduce() {
        println("I am $name")
    }
}

class Dog : Animal("Dog") {
    override fun makeSound() {
        println("Woof!")
    }
}
```
- `abstract` 클래스는 인스턴스화 할 수 없으며 공통 기능의 틀을 정의할 수 있다.
- 공통으로 사용하는 일부 메서드나 프로퍼티만 구현하고, 나머지는 자식 클래스에서 개별적으로 구현하는 방식으로 사용된다.
-  `open` 없이도 상속이 가능하다.

## object
```kotlin
interface CliAppConfigckable {
    fun printInfo()
}

object AppConfig : CliAppConfigckable {
    val appName = "MyApp"
    val version = "1.0.0"

    override fun printInfo() {
        println("$appName v$version")
    }
}

AppConfig.printInfo() // MyApp v1.0.0
```
- `object`는 코틀린에서 클래스를 단 하나의 인스턴스로 정의할 때 사용한다.
  - 싱글톤 객체를 생성하는 것이므로 자바의 싱글톤 패턴을 간단히 구현할 수 있게 한다.
- `init` 블록으로 초기화가 가능하다.
- 인터페이스 구현이 가능하다.

## companion object
```kotlin
class User private constructor(val name: String) {
    companion object {
        // 상수 선언(대문자여야 함)
        const val TYPE = "normal"
        fun create(name: String): User {
            return User(name)
        }
    }
}

val user = User.create("Alice")
```
- companion object는 클래스 내부에 선언되는 싱글턴 객체이다. 
- 따라서 정적 멤버처럼 사용할 수 있다. 
  - Java의 static 키워드와 비슷한 역할을 한다.
  - 클래스의 인스턴스를 만들지 않아도 접근 가능하다.
- 팩토리 메서드나 상수 선언에 자주 사용된다.
- 인터페이스 구현이 가능하다.