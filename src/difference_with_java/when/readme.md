## When Expression

- 코틀린에서 When은 If/Else와 마찬가지로 표현식이기 때문에 값을 할당할 수 있다.

```kotlin
val day = 4
val result = when (day) {
    1 -> "Monday"
    2 -> "Tuesday"
    3 -> "Wednesday"
    4 -> "Thursday"
    5 -> "Friday"
    6 -> "Saturday"
    7 -> "Sunday"
    else -> "Invalid day."
}
println(result) // Thursday
```
- 자바의 `switch`와 비슷하다. 
- 각 분기는 `->`로 표시한다.
  - `1, 2 ->`, `in 3..10 ->`와 같은 묶음 표현도 가능하다. 
- 일치하는 값이 있으면 해당 코드 블록이 실행된다.
- else는 일치는 값이 없을 때 실행할 코드이다.
