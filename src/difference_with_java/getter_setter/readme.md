# 코틀린의 Getter / Setter

## 자바
```java
public class User {
    private String name;         // 필드

    public String getName() {    // getter
        return name;
    }

    public void setName(String name) {  // setter
        this.name = name;
    }
}
```
- 자바에서는 필드를 만들고 이를 접근하기 위한 getter, setter를 따로 정의한다.
- 물론 java 17 이후 레코드가 있긴하다.

## 코틀린
```kotlin
class User {
    var name: String = "default"
}
```
```java
// 위 코드를 자바 코드로 변환했을 경우
public final class User {
   private String name = "default";

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final void setName(@NotNull String name) {
      this.name = name;
   }
}
```
- 코틀린은 안전하고 직관적인 문법을 만들기 위해 기존 자바 스타일의 `필드 + getter/setter`를 프로퍼티 하나로 추상화했다.
- 코틀린은 `var name: String` 한 줄로 자동으로 getter, setter를 만들어준다.
  - var name이 프로퍼티이다.
  - 자동으로 get(), set() 함수가 생긴다.
  - 내부에 field라고 하는 저장 공간이 자동으로 생긴다.
  - 위의 에시에서 진짜 필드 name은 private로 제공되며 kotlin에서는 이 필드를 getter/setter로 접근하는 것이다.

### field
- field는 프로퍼티의 진짜 값이 저장되는 공간이다.
- 커스텀 `getter`/`setter` 안에서 자기 자신이 참조할 수 있게 해주는 예약어이다.
- 만약 `get() = name`이라고 하면 무한루프가 발생하므로 `get() = field`를 통해 진짜 값을 가져오는 것이다.

### val
```kotlin
class User {
    val id: Int = 10
        get() = field + 100
}
```
- val는 읽기 전용으로 기본적으로 getter만 생성되고 setter는 없다.