package week3.tree;

// 크기 비교를 위해 Comparable 인터페이스 확장
public class Node<E extends Comparable<E>> {
    E data;
    Node<E> left; // 나보다 작은 자식
    Node<E> right; // 나보다 큰 자식

    public Node(E data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
