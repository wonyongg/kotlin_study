# null safety
- `String` : null 불가능
- `String?` : null 가능
- `?.` : null이 아닐때만 호출할 수 있다.
  - null인 경우에는 null을 반환한다.
  - 예시 `val len: Int? = str?.lengh`
- `?:` : null인 경우 이후에 나오는 값을 사용한다.
  - `name?: "Unknown"`인 경우 `name`이 null이면 `"Unknown"`을 사용한다. null이 아니면 `name 값`을 사용한다.
- `!!` : null이 아님을 단언하며 null일 경우 `NullPointerException`이 발생한다.
  - `val thisIsNotNull = str!!.length`
- `as?` : 안전한 타입 변환을 위해 사용하며, 캐스팅이 불가능하면 예외대신 null을 반환한다.
  - ```kotlin
    val obj: Any = "hello"
    val str: String? = obj as? String  // "hello"
    
    val num: Int? = obj as? Int  // null (예외 안 남)
    ```
    