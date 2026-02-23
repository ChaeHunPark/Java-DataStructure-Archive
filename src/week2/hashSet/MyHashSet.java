package week2.hashSet;

import week2.hashMap.MyHashMap;

public class MyHashSet<E> {
    private MyHashMap<E, Object> map = new MyHashMap<>();
    private static final Object PRESENT = new Object();

    public boolean add(E e) {
        // map.put이 null 이면 -> 이전에 이 Key가 없었다는 뜻 -> 추가 성공
        // map.put이 PRESENT를 반환한다면 -> 중복된 Key가 있었다는 뜻 -> 추가 실패
        return map.put(e, PRESENT) == null;
    }

    public boolean contains(Object o) {
        // 이미 맵에 get 로직이 있으니 활용 (혹은 containsKey 구현 후 활용)
        return map.get((E)o) != null;
    }

    public boolean remove(Object o) {
        return map.remove((E)o) != null;
    }

    public int size() {
        return map.size();
    }
}
