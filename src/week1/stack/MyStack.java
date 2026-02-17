package week1.stack;

import week1.arrayList.MyArrayList;

public class MyStack<E> {
    // Composition
    private MyArrayList<E> list = new MyArrayList<>();

    // 데이터 추가
    public void push(E item){
        list.add(item);
    }

    // 데이터 추출 (가장 위)
    public E pop(){
        if(isEmpty()){
            throw new RuntimeException("스택이 비어있습니다.");
        }
        return list.remove(list.size()-1);
    }

    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("스택이 비어있습니다.");
        }
        return list.get(list.size()-1);
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }
}
