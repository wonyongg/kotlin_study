package kotlin_class

class CarFunctions(var brand: String, var model: String, var year: Int) {

    // Class function
    fun drive() {
        println("brooooooooom!")
    }

    // Class function with params
    fun speed(maxSpeed: Int) {

        println("This car's speed is $maxSpeed km/h.")
    }
}

fun main() {
    var car = CarFunctions("Ford", "Mustang", 1969)

    car.drive()
    car.speed(120)
}