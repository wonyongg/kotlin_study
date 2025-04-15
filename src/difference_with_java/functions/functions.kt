package difference_with_java.functions

fun main() {
    println("hello world") // 코틀린에서 이미 정의된 함수(입력한 텍스트를 출력)
    myFunction() // 직접 생성한 함수 호출
    myParameterFunction("john") // 파라미터가 포함된 직접 생성한 함수, 매개변수로 전달된 john을 인수라고 함
    myParameterFunction2("jack", 25)
    println("a + b = ${myParameterReturnFunction(1,4)}")
    println("c - d = ${shorterSyntaxReturnFunction(5,2)}")
}

fun myFunction() { // 사용자가 직접 생성한 함수
    println("this is myFunction")
}

fun myParameterFunction(name: String) { // 사용자가 직접 생성한 함수, 여기에 있는 name은 매개변수라고 함
    println("my name is $name")
}

fun myParameterFunction2(name: String, age: Int) { // 복수의 파라미터
    println("my name is $name, my age is $age")
}

fun myParameterReturnFunction(a: Int, b: Int): Int { // 반환타입 지정

    return a + b
}

fun shorterSyntaxReturnFunction(c: Int, d: Int) = c - d // 간결한 함수 작성 방법