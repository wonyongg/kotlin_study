# 자바와 코틀린의 생성자

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
  - 이때는 매개변수가 없는 기본 생성자가 만들어진다.

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

    // 보조 생성자 1: color를 추가 파라미터로 받음
    constructor(brand: String, model: String, year: Int, color: String) : this(brand, model, year) {
        println("Additional Info: Color is $color")
    }

    // 보조 생성자 2: year를 2021로 기본 설정하여 주생성자를 호출
    constructor(brand: String, model: String) : this(brand, model, 2021) {
        println("Default year set to 2021")
    }
}

class Car2(val brand: String, val model: String) {
    var year: Int

    // 보조 생성자 1: brand, model을 주생성자를 통해 초기화하고, year은 보조 생성자 필드에서 직접 초기화
    constructor(brand: String, model: String, year: Int) : this(brand, model) {
        this.year = year
    }

    // 보조 생성자 2: 주생성자가 year을 받지 않기 때문에 보조 생성자에서 직접 기본갑 설정
    constructor(brand: String, model: String) : this(brand, model) {
        this.year = 2021  // 기본값 설정
    }
}
```
- `constructor` 키워드로 클래스 본문 안에 선언되는 생성자이다.
- 보통 주 생성자에 없는 추가적인 초기화 로직이 필요할 때 사용한다.
- 보조 생성자를 사용하여 다양한 초기화 방법을 제공하며 주 생성자 혹은 다른 보조 생성자를 호출하는 방식으로 구현한다.
  - this(...) 사용