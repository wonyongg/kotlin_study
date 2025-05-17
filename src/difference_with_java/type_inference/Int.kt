package difference_with_java.type_inference

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