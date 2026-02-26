# 📂 Java DataStructure Archive
> **"기본기를 다시 설계하고, 최적의 효율을 고민하다"** > 자바를 주 언어로 사용하여 자료구조의 내부 원리를 밑바닥부터 구현하고 기록하는 저장소입니다.

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Progress](https://img.shields.io/badge/Progress-50%25-blue?style=for-the-badge)](https://github.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

---

## 📅 Curriculum & Progress
| 주차 | 주제 | 핵심 자료구조 (Implementation & Docs) | 상태 |
| :-- | :--- | :--- | :---: |
| **Week 1** | **Linear Data** | [ArrayList](./src/week1/arrayList), [LinkedList](./src/week1/linkedList), [Stack](./src/week1/stack), [Queue](./src/week1/queue) | ✅ 완료 |
| **Week 2** | **Hash & Search** | [HashMap](./src/week2/hashMap), [HashSet](./src/week2/hashSet), [PriorityQueue](./src/week2/priorityQueue) | ✅ 완료 |
| **Week 3** | **Non-Linear** | Tree, Graph, DFS, BFS | 🏗️ 진행 |
| **Week 4** | **Optimization** | Trie, Sorting, 최적화 기법 | ⚪ 대기 |

---

## 🚀 Core Principles
- **No Libraries**: 자바 표준 라이브러리(Collections) 없이 순수 로직으로만 구현.
- **Deep Dive**: 단순히 코드 복사가 아닌, 시간 복잡도($O$)와 메모리 효율성 분석.
- **Unit Testing**: 각 자료구조별로 테스트 클래스를 작성하여 예외 케이스 검증.
- **Documentation**: 구현 과정에서의 트러블슈팅과 인사이트를 README에 기록.

---

## 📊 Summary Table

### [Week 1] Linear Data
| Data Structure | Implementation Key | Time Complexity | Logic |
| :--- | :--- | :---: | :--- |
| **ArrayList** | Dynamic Resizing | $O(1)$ | 연속된 메모리, 인덱스 기반 접근 |
| **LinkedList** | Node Reference | $O(n)$ | 노드 간 연결, 삽입/삭제 유연성 |
| **Stack** | LIFO Logic | $O(1)$ | ArrayList 위임(Delegation) 구현 |
| **Queue** | FIFO Logic | $O(1)$ | LinkedList 위임(Delegation) 구현 |

### [Week 2] Hash & Priority
| Data Structure | Implementation Key | Time Complexity | Logic |
| :--- | :--- | :---: | :--- |
| **HashMap** | Separate Chaining | $O(1)$ | 해시 함수 기반 인덱스 매핑 및 충돌 해결 |
| **HashSet** | Composition | $O(1)$ | HashMap의 Key 특징을 이용한 중복 제거 |
| **PriorityQueue**| Min-Heap | $O(\log n)$ | 이진 트리 구조 기반의 실시간 서열 정리 |

---

## 🔗 Quick Links
- [**WEEK 1: 선형 자료구조 전체 요약 리포트**](./src/week1/README.md)
- [**WEEK 2: 해시 & 우선순위 전체 요약 리포트**](./src/week2/README.md)
- [시간 복잡도($O$) 요약 가이드](./complexity_table.md)

---
© 2026 DataStructure Study. All rights reserved.