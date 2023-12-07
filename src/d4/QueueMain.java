package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // Java의 기본 Queue는 LinkedList를 활용한다.
        Queue<Integer> queue = new LinkedList<>();
        // enQueue 메서드 - add, offer
        // 넣기를 시도하고, 실패할 경우 예외를 발생시킨다.
        queue.add(10);
        queue.add(20);
        queue.add(30);
        // 넣기를 시도하고, 실패할 경우 false를 반환한다.
        queue.offer(15);
        queue.offer(25);
        queue.offer(35);

        // deQueue 메서드 - remove, poll
        // 빼기를 시도하고, 실패할 경우 예외를 발생시킨다.
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        // 빼기를 시도하고, 실패할 경우 null을 반환한다.
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        // 예외가 발생하지 않고 null을 출력
        System.out.println(queue.poll());
        // 예외가 발생, 프로그램 종료
        // System.out.println(queue.remove());

        // 다음에 등장할 아이템을 확인하는 메서드 - element, peek
        // 비어있을 경우 예외 발생
        // System.out.println(queue.element());
        // 비어있을 경우 null 반환
        System.out.println(queue.peek());

        // 비어있는지 확인
        System.out.println(queue.isEmpty());
        // 몇개 있는지 확인
        System.out.println(queue.size());
    }
}
