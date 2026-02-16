# 🚩 Week 1: Linear Data Structure (Part 1)
> 배열의 물리적 한계를 이해하고, 동적 배열(ArrayList)을 직접 설계 및 구현합니다.

## 📅 Day 1: ArrayList의 설계와 최적화

### 1. 핵심 개념 리마인드
* **물리적 연속성**: 데이터가 메모리 상에 빈틈없이 붙어 있어 **Random Access ($O(1)$)**가 가능함.
* **추상화(Interface)**: `MyList` 인터페이스를 통해 사용자에게 일관된 사용법 제공.
* **제네릭(Generic)**: 다양한 객체 타입을 안전하게 수용할 수 있는 구조 설계.

### 2. 주요 로직 구현 포인트
* **Dynamic Resizing**:
    * 배열이 꽉 차면 기존 크기의 2배로 확장 (`Arrays.copyOf` 활용).
    * 빈번한 확장은 성능 저하를 야기하므로 적절한 초기 용량(`DEFAULT_CAPACITY = 10`) 설정이 중요함.
* **Data Shifting (System.arraycopy)**:
    * **삽입**: `index`부터 끝까지 데이터를 한 칸씩 뒤로 복사 ($O(n)$).
    * **삭제**: `index+1`부터 끝까지 데이터를 한 칸씩 앞으로 복사 ($O(n)$).
    * **성능**: 네이티브 메서드인 `System.arraycopy`를 사용하여 OS 레벨에서 메모리 블록을 통째로 복사.
* **Memory Management**:
    * 삭제된 마지막 칸을 `null`로 명시적 처리하여 **Garbage Collection(GC)**이 정상 동작하도록 구현.

### 3. 시간 복잡도 분석 ($O$)
| 연산 | 복잡도 | 이유 |
| :--- | :---: | :--- |
| **조회 (get)** | $O(1)$ | 인덱스 기반의 주소 산술 연산 (Offset) |
| **맨 뒤 추가 (add)** | $O(1)$ | 추가 시 공간이 있다면 즉시 삽입 (평균적) |
| **중간 삽입/삭제** | $O(n)$ | 데이터 시프팅(Shifting) 오버헤드 발생 |



---

## 🛠️ 구현 결과물
- [x] `MyList.java`: 리스트 인터페이스 규격
- [x] `MyArrayList.java`: 동적 배열 로직 완성
- [x] `MyArrayListTest.java`: 기능 및 예외 케이스 검증 테스트 완료

### 💡 Insight
"이미 아는 개념이었지만, `System.arraycopy`의 파라미터 하나하나를 고민하며 구현해 보니 자바 컬렉션 프레임워크가 얼마나 효율적으로 설계되었는지 다시금 느낄 수 있었다. 특히 메모리 누수 방지를 위한 `null` 처리의 중요성을 재확인했다."