package week2.priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class MyPriorityQueue<E extends Comparable<E>> {
    private List<E> heap;

    public MyPriorityQueue() {
        this.heap = new ArrayList<>();
    }

    public void add(E e) {
        heap.add(e); // 1. 맨 뒤에 추가
        siftUp(heap.size() -1);
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void siftUp(int index) {
        // add -> idx 0번에 도달하기 전까지 반복
        while(index > 0) {
            int parentIndex = (index - 1) / 2; // 부모를 찾는 공식

            // 부모님 보다 크기가 작으면 자리를 바꾼다.
            if(heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                // 아니면 현재 idx가 내 자리
                break;
            }
        }
    }

    public E poll() {
        if (heap.isEmpty()) return null;

        E root = heap.get(0); // 꺼낼 값 따로 저장
        E lastNode = heap.remove(heap.size() - 1); // 마지막 값

        if(!heap.isEmpty()) {
            heap.set(0, lastNode);
            siftDown(0); // 루트 값에서 우선 순위를 맞추기 위한 메서드
        }
        return root;
    }

    private void siftDown(int index) {
        int size = heap.size();

        // 이진 트리에서 왼쪽 자식 부터 오른쪽 자식 비교하면서 점점 내려가기
        while(index * 2 + 1 < size) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;

            int smallerChild = leftChild; // 왼쪽 부터 비교

            // 오른쪽 자식이 존재 하면서 왼쪽 자식 보다 더 작다면
            if(rightChild < size && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) {
                smallerChild = rightChild; // 오른쪽 자식이 더 작은 자식
            }

            // 현재 나와 더 작은 자식을 비교해서 자리 바꾸기
            if(heap.get(index).compareTo(heap.get(smallerChild)) > 0) {
                swap(index, smallerChild); // 내가 더 크면 자리 바꾸기
                index = smallerChild; // 내위치 바꾸기
            }else {
                break;
            }
        }
    }

    public int size() { return heap.size(); }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
