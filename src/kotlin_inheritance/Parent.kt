package kotlin_inheritance;

// SuperClass
open class Parent {

    val x = 5
}

// SubClass
class Child : Parent() {

    fun print() {
        print(x)
    }
}

fun main() {
    val child = Child()
    child.print()
}