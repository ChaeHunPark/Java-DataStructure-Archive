package week1.arrayList;
/*
* 리스트 자료구조의 기본 규격의 정의한다.
* */

public interface MyList<E> {
    void add(E element); // 맨 뒤에 추가
    void add(int index, E element); // 특정 인덱스에 추가
    E get(int index); // 조회
    E remove(int index); // 삭제 및 반환
    int size(); // 현재 크기
    boolean isEmpty(); // 비어있는지 확인
    void clear(); // 전체 초기화
}
