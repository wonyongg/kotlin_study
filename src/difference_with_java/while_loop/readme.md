# while & do-while
## while
```kotlin
var i = 0
while (i < 3) {
    println("i = $i")
    i++
}

// 출력
i = 0
i = 1
i = 2
```
- 조건을 먼저 검사한 뒤, 참이면 블록을 실행한다.
- 조건이 거짓이면 한 번도 실행되지 않을 수 있다.

## do-while
```kotlin
var j = 0
do {
    println("j = $j")
    j++
} while (j < 3)

// 출력
j = 0
j = 1
j = 2
```
- 블록을 먼저 실행하고 나서 조건을 검사한다. 
- 조건이 거짓이더라도 최소 한 번은 무조건 실행된다.