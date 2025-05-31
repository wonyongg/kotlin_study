# 프로퍼티(Property)
- 필드(field) + getter/setter 기능이 포함된 변수이다. 
- 코틀린에서 클래스 안에 선언된 변수는 단순한 변수(variable)가 아니라 프로퍼티(property)로 간주한다.

## 예제
```kotlin
class Person {
    var name: String = "우리흥"
}
```
- 여기서 `name`은 그냥 변수가 아닌 프로퍼티이다.

```kotlin
fun getName(): String
fun setName(value: String)
```
- 코틀린은 자동으로 다음과 같은 getter/setter 메서드를 생성해준다.

```kotlin
val p = Person()
println(p.name) // -> getName() "우리흥" 호출
p.name = "해리 케인"  // -> setName("해리케인") 호출
```
- 위와 같이 `p.name`을 호출할 때 자동으로 getName()이 자동으로 호출되며,
- `p.name`에 값을 재할당하는 것으로 setName()이 자동으로 호출된다.
- getter/setter의 자세한 내용은 getter_setter 디렉터리에 있다.

# 위임 프로퍼티(Delegated Property)
- 프로퍼티의 getter/setter 구현을 다른 객체에 위임하는 기능이다.
- 즉, 프로퍼티의 실제 동작(값 저장, Logging, lazy 처리 등)을 개발자가 직접 구현하지 않고 위임 객체(delegate)에게 맡길 수 있다.

## 예제
```kotlin
// 예시
val/var 프로퍼티 이름: 타입 by 위임 객체

val name: String by delegate
```

## 대표적인 위임 객체
### Lazy
```kotlin
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

// 출력 예시
println(lazyValue)  // computed! → Hello
println(lazyValue)  // Hello (이미 계산되어 재실행 안 됨)
```
- 초기화를 지연하고, 최초 접근 시 단 한 번만 실행된다.
  - thread safe하다.
  - lazy mode 기본값(SYNCHRONIZED)으로 인해 멀티스레드 환경에서도 한 번만 초기화가 보장된다.
- 불변 키워드인 val만 가능하다.

#### lazy mode 선택
- 기본적으로 `LazyThreadSafetyMode.SYNCHRONIZED` 모드로 동작한다.

**LazyThreadSafetyMode.PUBLICATION**
```kotlin
val config: Config by lazy(LazyThreadSafetyMode.PUBLICATION) {
println("초기화 호출")
loadConfigFromServer()
}
```
- 여러 스레드가 개별적으로 최초 접근 시점에 초기화 블록을 실행할 수 있다.
- 초기화 블록이 여러 번 실행되더라도 최종적으로 가장 먼저 완료된 값 하나만 내부에 저장되고 나머지는 무시된다.
  - 어떤 스래드의 초기화 값이 채택될지는 정해져 있지 않고 가장 먼저 초기화를 끝낸 값이 채택된다.
  - 이는 타이밍, 스케줄링, 스레드 우선순위 등 여러 요인에 따라 달라진다.
- 장점
  - 동시성 제어를 위한 락(lock)을 사용하지 않아 성능이 좋다.
  - 초기화를 여러 번 시도해도 무관한 경우 유용하다.
    - 멱등성을 보장하는 경우여야 안전하다.
- 단점
  - 반대로 초기화 시도가 여러 번 일어나면 안되는 코드에서는 위험하다.
    - 데이터베이스 쓰기, 로그, 파일 생성 등
  - 최종적으로 어떤 스레드의 값이 될지 모르기 때문에 테스트, 디버깅 등이 어렵다.
    - 비결정적이다.


**LazyThreadSafetyMode.NONE**
****
```kotlin
val cache: Cache by lazy(LazyThreadSafetyMode.NONE) {
println("초기화 호출")
Cache()
}
```
- thread safe를 보장하지 않는다.
- 내부에 락이나 동기화 비용이 발생하지 않아 싱글 스레드 환경에서는 가장 빠르게 초기화 된다.
  - 초기화 블록이 가볍고 단순한 경우에 적합하다.
- 장점
  - 성능 자체는 가장 높다.
- 단점
  - thread safe 하지 않다.
  - 여러 스레드가 접근할 경우 초기화 순서가 보장되지 않는다.
    - 어떤 값이 채택될지 전혀 알 수가 없다.

### observable
```kotlin
import kotlin.properties.Delegates

var name: String by Delegates.observable("default") { prop, old, new ->
    println("${prop.name} changed from $old to $new")
}
```
- 값이 변경될 때마다 콜백이 호출된다.
- `"default"`는 name의 초기값이다.
- `prop`는 name 프로퍼티를 뜻한다.

### vetoable
```kotlin
var age: Int by Delegates.vetoable(0) { _, _, new ->
    new >= 0 // 음수면 거부
}
```
- 값을 할당하기 전에 검증이 가능하다.
  - false인 경우 할당이 거부된다.
- `_`의 경우 prop, old인데 사용하지 않는 매개변수 자리에 사용하는 코틀린 문법이다.