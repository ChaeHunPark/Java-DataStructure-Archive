package week2.hashSet;

public class MyHashSetTest {
    public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>();

        // 1. add: 데이터 추가 테스트
        System.out.println("--- 추가 테스트 ---");
        System.out.println("A 추가: " + set.add("A")); // Expected: true
        System.out.println("B 추가: " + set.add("B")); // Expected: true
        System.out.println("C 추가: " + set.add("C")); // Expected: true

        // 2. 중복 add: 중복 데이터 추가 방지 테스트
        System.out.println("\n--- 중복 테스트 ---");
        System.out.println("A 다시 추가: " + set.add("A")); // Expected: false
        System.out.println("현재 Size: " + set.size());   // Expected: 3

        // 3. contains: 존재 여부 확인
        System.out.println("\n--- 조회 테스트 ---");
        System.out.println("A가 들어있는가? " + set.contains("A")); // Expected: true
        System.out.println("D가 들어있는가? " + set.contains("D")); // Expected: false

        // 4. remove: 삭제 테스트
        System.out.println("\n--- 삭제 테스트 ---");
        System.out.println("B 삭제 성공? " + set.remove("B"));     // Expected: true
        System.out.println("B 삭제 후 contains: " + set.contains("B")); // Expected: false
        System.out.println("최종 Size: " + set.size());          // Expected: 2

        // 5. 대량 데이터 및 리사이징 간접 확인 (선택 사항)
        System.out.println("\n--- 대량 데이터 추가 ---");
        for(int i = 0; i < 20; i++) {
            set.add("Data" + i);
        }
        System.out.println("최종 데이터 개수(중복 제외): " + set.size());
    }
}
