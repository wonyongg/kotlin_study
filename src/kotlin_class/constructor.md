# 자바와 코틀린의 주 생성자

# 들어가기 전(var & val 정리)
- Kotlin에서 `var`와 `val`은 변수 선언 키워드로, 각각 변수의 변경 가능 여부를 지정합니다.
- `var`: 값이 변경 가능한 변수를 선언할 때 사용합니다. 타입이 아닌 변수 선언용 키워드입니다.
- `val`: 값이 변경 불가능한 변수를 선언할 때 사용하며, 한 번 값이 할당되면 재할당이 불가능합니다.

--- 

## 자바의 기본 생성자(No-argument constructor)
```java
class Car {
    String brand;
    String model;
    int year;

    // 기본 생성자
    public Car() {
        // 기본값으로 필드를 초기화
        this.brand = "BMW";
        this.model = "X5";
        this.year = 2020;
    }
}
```
- 파라미터가 없는 생성자
- 명시적으로 정의하지 않으면 컴파일러가 자동으로 생성

## 코틀린의 기본 생성자(주 생성자, Primary Constructor)
```kotlin
class Car(val brand: String, val model: String, var year: Int) {
    init {
        print("초기화 블록 실행")
    }
}
```
- 주 생성자는 클래스 선언의 일부로 파라미터를 직접 선언한다.
- 이는 자동으로 프로퍼티가 되어 getter가 만들어진다.
- init 블록을 이용하여 초기화 시 실행 로직을 추가할 수 있다.

## 자바의 생성자 오버로딩
```java
class Car {
    String brand;
    String model;
    int year;


    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.year = 2021; // 기본값
    }
}
```
- 자바는 매개변수의 수에 따라 생성자를 여러 개 정의할 수 있다.
- 이를 생성자 오버로딩이라고 한다.

## 코틀린의 보조 생성자
```kotlin
class Car1(val brand: String, val model: String, var year: Int) {

    // 보조 생성자 1: year를 파라미터로 받음
    constructor(brand: String, model: String, year: Int, color: String) : this(brand, model, year) {
        println("Additional Info: Color is $color")
    }

    // 보조 생성자 2: year를 기본값으로 설정
    constructor(brand: String, model: String) : this(brand, model, 2021) {
        println("Default year set to 2021")
    }
}

class Car2(val brand: String, val model: String) {
    var year: Int

    // 첫 번째 보조 생성자
    constructor(brand: String, model: String, year: Int) : this(brand, model) {
        this.year = year
    }

    // 두 번째 보조 생성자 (기본값 사용)
    constructor(brand: String, model: String) : this(brand, model) {
        this.year = 2021  // 기본값 설정
    }
}
```
- 보조 생성자를 사용하여 다양한 초기화 방법을 제공하며, 주 생성자를 호출하는 방식으로 구현한다.