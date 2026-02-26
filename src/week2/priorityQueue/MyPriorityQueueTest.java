package week2.priorityQueue;

public class MyPriorityQueueTest {
    public static void main(String[] args) {
// 1. 숫자 테스트: 우리가 시뮬레이션한 시나리오
        System.out.println("--- [Integer Test] ---");
        MyPriorityQueue<Integer> intPq = new MyPriorityQueue<>();
        int[] nums = {17, 12, 15, 11, 13, 16, 14};

        for (int n : nums) intPq.add(n);

        System.out.println("모두 꺼내기:");
        while (!intPq.isEmpty()) {
            System.out.print(intPq.poll() + " "); // 11 12 13 14 15 16 17 순서로 나와야 함!
        }
        System.out.println("\n");

        // 2. 문자열 테스트: 사전순 정렬 확인 (compareTo의 힘)
        System.out.println("--- [String Test] ---");
        MyPriorityQueue<String> strPq = new MyPriorityQueue<>();
        strPq.add("banana");
        strPq.add("apple");
        strPq.add("cherry");
        strPq.add("dragonfruit");

        System.out.println("사전순으로 꺼내기:");
        while (!strPq.isEmpty()) {
            System.out.print(strPq.poll() + " "); // apple banana cherry dragonfruit 순서!
        }
    }
}
