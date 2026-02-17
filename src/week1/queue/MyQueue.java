package week1.queue;

import week1.linkedList.MyLinkedList;

public class MyQueue<E> {
    // Composition
    private MyLinkedList<E> list = new MyLinkedList<>();

    // 맨 뒤에 추가
    public void offer(E item) {
        list.add(item);
    }

    // 맨 앞을 삭제하고 반환
    public E poll() {
        if(isEmpty()) {
            throw new RuntimeException("큐가 비어있습니다.");
        }
        return  list.remove(0);
    }

    // 맨 앞 확인
    public E peek() {
        if(isEmpty()) {
            throw new RuntimeException("큐가 비어있습니다.");
        }
        return  list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }

}
