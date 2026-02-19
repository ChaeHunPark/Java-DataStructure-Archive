package week2.hashMap;



public class MyHashMap<K, V> {

    // 단방향 연결 리스트 형태
    private class Node<K, V> {
        final K key;
        V value;
        Node<K,V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    // 해시 함수: 키를 배열의 인덱스로 변환
    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {

        // 1. 데이터를 넣기 전이나 후에 현재 size를 체크
        if (size >= table.length * 0.75) {
            resize();
        }

        int index = hash(key); // 키를 idx로 만들기
        Node<K, V> newNode = new Node<>(key, value, null);

        if(table[index] == null) {
            // 1. 해당 인덱스가 비어 있으면 바로 저장
            table[index] = newNode;
            size++;

        }else {
            // 2. (충돌 발생시)
            Node<K, V> curr = table[index];


            while (true){
                if(curr.key.equals(key)) {
                    curr.value = value; // 새로운 값으로 업데이트
                    return; // size를 늘리지 않고 종료
                }

                // 다음 노드가 없으면 맨 끝에 연결
                if(curr.next == null) {
                    curr.next = newNode;
                    size++;
                    break;
                }

                curr = curr.next;
            }

        }
        size++;
    }

    public V get(K key){
        // 인덱스 계산
        int index = hash(key);

        // 해당 인덱스의 헤드 가져오기
        Node<K,V> curr = table[index]; // 해당 인덱스 첫  노드

        // 루프 돌아서 key와 일치하는 노드 찾기

        // 연결 리스트 키 비교
        while (curr != null) {
            if(curr.key.equals(key)) {
                return curr.value;
            }

            curr = curr.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);

        Node<K, V> curr = table[index];
        Node<K, V> prev = null; // 이전 노드 저장하기

        while(curr != null){
            if(curr.key.equals(key)) {

                V result = curr.value; // 반환할 값 임시 저장

                if(prev == null) {
                    // 첫 노드를 삭제하는 경우
                    table[index] = curr.next; // 시작점을 다음 노드로 변경

                }else {
                    // 2. 중간/끝 삭제 경우
                    prev.next = curr.next; // 이전 노드가 현재의 다음 노드를 가르키게 변경
                }

                size--;
                return result;
            }

            prev = curr;
            curr = curr.next;
        }

        return null;

    }

    public int size() {
        return this.size;
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        int newCapacity = oldTable.length * 2; // 2배로 확장
        table = new Node[newCapacity]; // 크기를 늘린 새로운 배열 생성
        size = 0;

        // 기존 데이터를 새롭게 옮기기

        for(int i=0; i < oldTable.length; i++) {
            Node<K, V> curr = oldTable[i];
            while (curr != null) {
                put(curr.key, curr.value);
                curr = curr.next;
            }
        }
    }

}
