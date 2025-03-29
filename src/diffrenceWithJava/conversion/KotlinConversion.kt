package diffrenceWithJava.conversion

fun main() {

    // 타입 추론 Int
    val a = 10

    println("a의 타입 : " + a.javaClass.typeName)

    // 명시적 타입 지정
    val b: Long = 20

    var c: Int
    c = b.toInt()
    // Type mismatch d = c

    println("b의 타입 : " + b.javaClass.typeName)
    println("c의 타입 : " + c.javaClass.typeName)
}

/*
코틀린의 경우 자동으로 형변환이 되지 않으며 to자료형()과 같은 함수를 사용한다.
 */