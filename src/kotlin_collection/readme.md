## 읽기 전용 컬렉션 vs 가변 컬렉션
```kotlin
// 읽기 전용 List
val names: List<String> = listOf("Alice", "Bob")
// names.add("Charlie") // ❌ 컴파일 에러 (add 없음)
println(names[0]) // ✅ 읽기는 가능

// 가변 List
val mutableNames: MutableList<String> = mutableListOf("Alice", "Bob")
mutableNames.add("Charlie") // ✅ 가능
mutableNames.removeAt(0)
println(mutableNames)
```
### 주의할 점
```kotlin
val list: List<String> = mutableListOf("A", "B")
(list as MutableList).add("C") // ⚠️ 가능은 하지만 위험
```
- 읽기 전용이라고 해서 진짜 불변(immutable)은 아님 
- 내부 구현체가 MutableList일 수 있어서 cast로 수정 가능 
- 진짜 불변 컬렉션을 원하면 Java의 `Collections.unmodifiableList()`나, Kotlin의 `experimental immutable collections` 사용 필요