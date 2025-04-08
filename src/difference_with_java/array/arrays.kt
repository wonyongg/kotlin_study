package difference_with_java.array

fun main() {

    val a: Int = 10
    val b: Int? = 10
    val c = arrayOfNulls<Int?>(3)
    println("a.javaClass : ${a.javaClass}") // int
    println("b.javaClass : ${b?.javaClass}") // class java.lang.Integer
    println("c.javaClass : ${c?.javaClass}") // class [Ljava.lang.Integer;
    println("c : ${c.contentToString()}") // [null, null, null]

    val intArray = IntArray(3)        // [0, 0, 0]
    val objectArray = arrayOf(1, 2, 3) // Array<Int>

    println("intArray: $intArray") // [0, 0, 0] → 실제로 int 타입 값 저장
    println("intArray values: ${intArray.contentToString()}")
    println("objectArray: $objectArray") // [Integer(1), Integer(2), Integer(3)] → 객체 저장
    println("objectArray values: ${objectArray.contentToString()}")

    val list: List<Int> = listOf(1, 2, 3)
    list[0] = null
    println("list[0].JavaClass: ${list[0].javaClass}") // list[0].JavaClass: class java.lang.Integer
}