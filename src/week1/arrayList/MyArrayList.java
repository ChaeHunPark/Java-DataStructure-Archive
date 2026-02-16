package week1.arrayList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    // 리와인드: 자바 ArrayList와 같게 Object 배열을 사용
    private Object[] elementData;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    // 배열 확장 메서드

    private void ensureCapacity() {
        // 1.5배 또는 2배 확장 전략으로 선택, 자주 배열을 확장하면 성능 저하.
        int newCapacity = elementData.length * 2;
        // copyOf로 새 배열 생성 및 데이터 복사를 한번에.
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public void add(E element) {

        // 배열이 꽉찼는지 확인
        if(elementData.length == size){

            /* ***for문을 사용한 방법***

                // 확장할 배열 만들어 놓기
                Object[] data = new Object[elementData.length + DEFAULT_CAPACITY];
                // 데이터 복사
                for (int i = 0; i < elementData.length; i++) {
                    data[i] = elementData[i];
                }
                // 크기를 늘린 오브젝트로 변경
                elementData = data;
            * */
            ensureCapacity();
        }

        elementData[size++] = element;
    }

    @Override
    public void add(int index, E element) {

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }


        if(elementData.length == size){
            ensureCapacity();
        }

        /*
        * System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
        * src : 복사할 원본 배열
        * srcPos : 원본 배열에서 복사를 시작할 위치(인덱스)
        * dest : 복사본이 저장될 대상 배열
        * destPos: 대상 배열에서 데이터가 저장되기 시작할 위치
        * length : 복사할 데이터 수
        *
        * for 문을 돌려 데이터를 하나씩 옮기면 Java레벨에서 동작, 이메서드는 C/C++ 수준으로 메모리 블록을
        * 통째로 복사하기 때문에 성능이 압도적
        *
        * */

        System.arraycopy(elementData, index+1, elementData, index+1, size - index);

        elementData[index] = element;
        size++;




    }

    @Override
    public E get(int index) {
        // 찾고자하는 인덱스가 0보다 작거나, 리스트 크기보다 오류를 내어준다.
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return (E) elementData[index];
    }

    @Override
    public E remove(int index) {

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // 삭제할 값 반환용
        E oldValue = (E) elementData[index];

        System.arraycopy(elementData, index+1, elementData, index, size-index-1);

        // 마지막 칸 비우기
        elementData[--size] = null;

        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
