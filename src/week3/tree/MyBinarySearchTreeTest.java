package week3.tree;

public class MyBinarySearchTreeTest {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();

        // 1. 트리 구축
        bst.add(50);
        bst.add(30); bst.add(70);
        bst.add(20); bst.add(40);
        bst.add(10); bst.add(45);

        bst.add(99);

        System.out.print("삭제 전 (중위 순회): ");
        bst.inOrder(); // 출력: 10 20 30 40 45 50 70

        // 2. 자식이 둘인 30 삭제 시도
        System.out.println("30 삭제 중...");
        bst.remove(30);

        System.out.print("삭제 후 (중위 순회): ");
        bst.inOrder(); // 출력: 10 20 40 45 50 70
    }
}
