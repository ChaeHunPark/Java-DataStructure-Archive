package week1.linkedList;

public class MyLinkedList<E> {

    private Node<E> first; // 첫 번째 노드(Head)
    private Node<E> last; // 마지막 노드(Tail)
    private int size = 0;

    public void add(E element) {
        // 데이터를 담은 새 노드 만들기
        Node<E> l = last;
        Node<E> newNode = new Node<>(element, null);
        last = newNode; // 끝 노드를 지정,

        if(l == null) { // 리스트가 비어있었다면 첫 번째 노드도 새 노드가 됨
            first = newNode;
        }else { // 기존 마지막 노드의 next를 새 노드에 연결
            l.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        // 인덱스 검사
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
        }

        //node 메서드로 노드 및 값 가져오기
        E element = node(index).item;

        //리턴
        return element;
    }

    public E remove(int index) {
        // 1. 인덱스 유효성 검사
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
        }

        // 2. 맨 앞을 지우는 경우
        if(index == 0){
            Node<E> target = first;
            E element =  target.item; // 반환할 데이터
            first = target.next;

            // 데이터가 하나뿐이어서 비어버린 경우
            if(first == null) {
                last = null;
            }

            //GC를 위한 배려
            target.item = null;
            target.next = null;

            size--;
            return element;

        }

        // 3. index 0보다 큰경우

        // 삭제할 노드의 바로 앞 노드 찾기
        Node<E> prev = node(index -1);
        // 삭제할 노드
        Node<E> target = prev.next;
        // 앞 노드랑 연결할 노드
        Node<E> nextNode = target.next;

        // 연결 하기
        prev.next = nextNode;

        // 마지막 노드를 지운거면
        if(nextNode == null) {
            last = prev;
        }

        //GC를 위한 배려
        target.item = null;
        target.next = null;

        size--;

        return target.item;

    }

    public int size() {
        return this.size;
    }

    private Node<E> node(int index) {
        Node<E> x = first;

        for (int i=0; i<index; i++) {
            x = x.next;
        }

        return x;
    }


    //  리스트의 최소 단위인 '노드'
    private static class Node<E> {
        E item; //데이터
        Node<E> next; // 다음 노드를 가리키는 화살표

        Node(E element, Node<E> next) {
            this.item = element;
            this.next =  next;
        }
    }
}
