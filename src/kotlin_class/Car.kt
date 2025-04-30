package kotlin_class

// 일반 클래스 선언
class Car {
    var brand = ""
    var model = ""
    var year = 0
}

// 생성자
class CarWithConstructors(var brand: String, var model: String, var year: Int)

fun main() {

    // Car의 객체 생성
    var car = Car()

    // Car 내에 존재하는 변수에 값 할당
    car.brand = "Ford"
    car.model = "Mustang"
    car.year = 1969

    println(car.brand)
    println(car.model)
    println(car.year)

    var car2 = Car()

    car2.brand = "BMW"
    car2.model = "X5"
    car2.year = 1999

    println(car2.brand)
    println(car2.model)
    println(car2.year)

    val carWithConstructors = CarWithConstructors("HYUNDAI", "SONATA", 2025)

    println(carWithConstructors.brand)
    println(carWithConstructors.model)
    println(carWithConstructors.year)
}