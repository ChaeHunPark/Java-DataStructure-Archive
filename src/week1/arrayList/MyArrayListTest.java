package week1.arrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();

        // 1. 추가 및 확장 테스트
        for (int i = 0; i < 15; i++) {
            list.add("Data " + i);
        }
        System.out.println("Size after 15 adds: " + list.size()); // 15 출력 예상

        // 2. 중간 삽입 테스트
        list.add(5, "INSERTED");
        System.out.println("Index 5: " + list.get(5)); // INSERTED 출력 예상

        // 3. 삭제 테스트
        String removed = list.remove(5);
        System.out.println("Removed: " + removed);
        System.out.println("New Index 5: " + list.get(5)); // Data 5 출력 예상
    }
}
