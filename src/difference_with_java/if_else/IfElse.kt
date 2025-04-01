package difference_with_java.if_else

fun main() {
    val time = 20
    val greeting = if (time < 18) {
        "Good day!"
    } else {
        "Good evening!"
    }

    println(greeting)

    val time2 = 10
    val greeting2 = if (time2 < 18) "Good day!" else "Good evening!"
    println(greeting2)
}