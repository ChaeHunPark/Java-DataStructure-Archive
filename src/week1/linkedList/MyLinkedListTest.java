package week1.linkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        System.out.println("=== 1. 추가 테스트 ===");
        list.add("A");
        list.add("B");
        list.add("C");
        // 현재 상태: [A, B, C], size: 3
        printList(list);

        System.out.println("\n=== 2. 특정 인덱스 삭제 (중간 - B) ===");
        String removed = list.remove(1);
        System.out.println("삭제된 값: " + removed); // B
        printList(list); // [A, C], size: 2

        System.out.println("\n=== 3. 맨 앞 삭제 (A) ===");
        list.remove(0);
        printList(list); // [C], size: 1

        System.out.println("\n=== 4. 마지막 남은 요소 삭제 (C) ===");
        list.remove(0);
        printList(list); // Empty, size: 0

        System.out.println("\n=== 5. 다시 추가 후 맨 뒤 삭제 테스트 ===");
        list.add("First");
        list.add("Last");
        printList(list); // [First, Last]

        list.remove(1); // "Last" 삭제
        printList(list); // [First], size: 1
    }

    private static void printList(MyLinkedList<String> list) {
        System.out.print("현재 리스트: [");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + (i == list.size() - 1 ? "" : ", "));
        }
        System.out.println("] | Size: " + list.size());
    }
}
