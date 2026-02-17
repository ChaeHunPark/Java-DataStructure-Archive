package week1.stack;

public class MyStackTest {
    public static void main(String[] args) {

        MyStack<Character> stack = new MyStack<>();

        // A, B, C 순서대로 푸쉬
        stack.push('A');
        stack.push('B');
        stack.push('C');

        // peek 실행시 C가 나오는 지 확인
        System.out.println(stack.peek());

        // pop 실행시 순서대로 C B A가 나오는지 확인

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // isEmpty가 true인지 확인
        System.out.println(stack.isEmpty());

    }
}
