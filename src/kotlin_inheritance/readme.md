# 상속과 인터페이스 구현

## 자바에서의 클래스 상속
```java
class Child extends Parent {}

```

## 코틀린에서의 클래스 상속
```kotlin
class Child : Parent()

```

## 자바에서의 인터페이스 구현
```java
class MyClass implements MyInterface {}
```

## 코틀린에서의 인터페이스 구현
```kotlin
class MyClass : MyInterface
```

## 자바에서 둘 다 있는 경우
```java
class MyClass extends Parent implements MyInterface, AnotherInterface {}
```

## 코틀린에서 둘 다 있는 경우
```kotlin
class MyClass : Parent(), MyInterface, AnotherInterface
```
