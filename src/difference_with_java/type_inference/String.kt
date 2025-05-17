package difference_with_java.type_inference

fun main() {
//    var name -> Error
    var name: String
    name = "John"

    var name2 = "David" // 초기화로 타입 추론
    println(name)
    println(name2)
}

