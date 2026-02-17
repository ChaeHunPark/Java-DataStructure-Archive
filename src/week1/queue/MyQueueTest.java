package week1.queue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        // 1. offer: A, B, C 추가
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        // 2. peek: 맨 앞이 "A"인지 확인
        System.out.println("Peek: " + queue.peek()); // Expected: A

        // 3. poll: 순서대로 A, B, C가 나오는지 확인
        System.out.println("Poll: " + queue.poll()); // Expected: A
        System.out.println("Poll: " + queue.poll()); // Expected: B
        System.out.println("Poll: " + queue.poll()); // Expected: C

        // 4. isEmpty: true 확인
        System.out.println("Is Empty: " + queue.isEmpty()); // Expected: true
    }
}
