## 코틀린의 함수

### 기본 내장 함수
```kotlin
fun main() {
    println("hello world")
}
```
- 코틀린에서 정의된 기본 내장 함수

### 직접 생성한 함수
```kotlin
fun main() {
    myFunction()
}

fun myFunction() {
    println("this is myFunction")
}
```

### 파라미터가 포함된 직접 생성한 함수
```kotlin
fun main() {
    myParameterFunction("john")
}

fun myParameterFunction(name: String) { 
    println("my name is $name")
}
```
- 사용자가 직접 생성한 함수, 여기서 name은 매개변수라고 함
- 매개변수로 전달된 john을 인수라고 함

### 복수의 파라미터가 포함된 직접 생성한 함수
```kotlin
fun main() {
    myParameterFunction2("jack", 25)
}

fun myParameterFunction2(name: String, age: Int) {
    println("my name is $name, my age is $age")
}
```

### 반환타입이 지정된 직접 생성한 함수
```kotlin
fun main() {
    println("a + b = ${myParameterReturnFunction(1,4)}")
}

fun myParameterReturnFunction(a: Int, b: Int): Int { // 반환타입 지정

    return a + b
}
```

### 간결한 함수 작성 방법
```kotlin
fun main() {
    println("c - d = ${shorterSyntaxReturnFunction(5,2)}")
}

fun shorterSyntaxReturnFunction(c: Int, d: Int) = c - d 
```
- 반환 타입은 `=` 이후에 나오는 값의 타입에 따라 자동 지정된다.
