package week2.hashMap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println("=== 1. 기본 삽입 및 조회 테스트 ===");
        map.put("Apple", 1000);
        map.put("Banana", 2000);
        System.out.println("Apple: " + map.get("Apple")); // 예상: 1000
        System.out.println("Banana: " + map.get("Banana")); // 예상: 2000

        System.out.println("\n=== 2. 값 업데이트 테스트 ===");
        map.put("Apple", 1500);
        System.out.println("Updated Apple: " + map.get("Apple")); // 예상: 1500

        System.out.println("\n=== 3. 해시 충돌 및 삭제 테스트 ===");
        // 의도적으로 충돌이 날 만한 상황을 가정하거나,
        // 여러 데이터를 넣어 연결 리스트 구조를 만듭니다.
        map.put("Cherry", 3000);
        map.put("Date", 4000);

        System.out.println("삭제 전 size: " + map.size()); // size 변수 확인
        System.out.println("Removed Banana: " + map.remove("Banana")); // 삭제 수행
        System.out.println("Banana 조회: " + map.get("Banana")); // 예상: null
        System.out.println("삭제 후 size: " + map.size());

        System.out.println("\n=== 4. 존재하지 않는 키 조회 ===");
        System.out.println("Unknown: " + map.get("Mango")); // 예상: null
    }
}