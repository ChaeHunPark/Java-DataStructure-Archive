package week3.tree;

public class MyBinarySearchTree<E extends Comparable<E>>{

    private Node<E> root; // 트리의 시작점
    private int size; // 노드의 개수

    public MyBinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    // 앞으로 구현할 핵심 메서드들
    public void add(E data) {
        root = addRecursive(root, data);
        size++;
    }

    private Node<E> addRecursive(Node<E> current, E data) {
        // 1. 갈 곳이 비어있다면? 그 자리가 새 데이터의 주인
        if(current == null) {
            return new Node<>(data);
        }

        // 2. compareTo 사용해서 비교하기
        int compare = data.compareTo(current.data);

        if(compare < 0) {
            // 나보다 작으면 왼쪽 서브트리로 보내기
            current.left = addRecursive(current.left, data);
        }else if (compare > 0) {
            // 나보다 크면 오른쪽 서브트리로 보내기
            current.right = addRecursive(current.right, data);
        }
        // 값이 같다면? BST는 중복 허용 X, 아무것도 안함

        return current; // 현재 노드를 반환

    }

    public boolean contains(E data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node<E> current, E data) {
        // 1. 끝까지 갔는데 없으면 false;
        if(current == null) {
            return false;
        }

        // 2. 현재 노드 비교
        int compare = data.compareTo(current.data);

        if(compare == 0) {
            // 현재 노드와 일치
            return true;
        }

        // 찾지 못했다면, 왼쪽이 더크면 왼쪽, 오른쪽이 더크면 오른쪽으로 순회
        return (compare < 0)
                ? containsRecursive(current.left, data)
                : containsRecursive(current.right, data);
    }

    public void remove(E data) {
        root = removeRecursive(root, data);
    }

    private Node<E> removeRecursive(Node<E> current, E data) {
        if(current == null) return null;

        // 삭제시킬값, 현재 값 비교
        int compare = data.compareTo(current.data);


        // 삭제 시킬값 < 현재 값
        if(compare < 0) {
            current.left = removeRecursive(current.left, data);
        } else if (compare > 0) {
            // 삭제 시킬값 > 현재 값
            current.right = removeRecursive(current.right, data);
        } else {
            // 삭제 시킬값 == 현재 값

            // 자식이 없으면 null을 반환 부모와 연결을 끊기
            // 자식이 하나면 그 자식을 반환해서 부모와 연결 시키기

            // 왼쪽 자식이 null이면 오른쪽 자식을 반환, 오른쪽 자식이 null인 경우 오른쪽 자식 null을 반환
            if (current.left == null) return current.right;
            // 왼쪽 자식이 있네? 오른쪽 자식이 null이면 왼쪽 자식 반환
            if (current.right == null) return current.left;


            // 자식이 둘인경우
            // 오른쪽 서브트리에서 가장 작은 값을 찾아서 현재 노드에 덮어씀
            // 오른쪽 서브트리는 나보다 항상 크기 때문에 규칙이 망가지지 않음

            // 오른쪽 데이터 자식들 중 가장 작은 데이터를 찾아 현재 데이터에 덮어쓰고
            current.data = findSmallestValue(current.right);

            // 1. 현재 노드의 데이터를 후계자 값으로 바꿨으므로, 오른쪽 서브트리에서 원본 후계자 노드를 삭제하러 감.
            // 2. 후계자는 '오른쪽 동네의 최솟값'이므로, 재귀 내부에서 반드시 [왼쪽 자식이 null인 케이스]에 걸림.
            // 3. 따라서 그 노드의 오른쪽 자식(있으면 노드, 없으면 null)을 반환하며 원본 노드만 트리에서 탈락시킴.
            current.right = removeRecursive(current.right, current.data);
        }
        return current;
    }



    private E findSmallestValue(Node<E> root) {
        // 왼쪽 노드가 null 이면 현재를 반환, 아니면 왼쪽 노드에서 찾기
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    // 순회 메서드들 (Traversal)
    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node<E> node) {
        if(node != null) {
            System.out.println(node.data + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    public void inOrder() {
        inOrderRecursive(root);
        System.out.println(); // 줄바꿈

    }

    private void inOrderRecursive(Node<E> node) {
        if(node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.data + " ");
            inOrderRecursive(node.right);
        }
    }

    public void postOrder() {
        postOrderRecursive(root);
        System.out.println(); // 줄바꿈
    }

    private void postOrderRecursive(Node<E> node) {
        if(node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.println(node.data + " ");
        }
    }

    public int size() {
        return size;
    }

}
