package d4;

// 원형 큐
public class MyCyQueue {
    // 크기를 4로 먼저 만들어보자.
    private int size = 4;
    // 실제로 만들 배열의 크기는 size + 1
    // 한칸을 비워둬야 정확하게 비어있고 가득찬 상태를 파악할 수 있다.
    private int offset = size + 1;
    // 데이터를 담기위한 배열
    private int[] arr = new int[offset];
    // 앞쪽과 뒤쪽 데이터를 구분하기 위한 front와 rear
    private int front = 0;
    private int rear = 0;

    // 데이터를 넣기 위한 enqueue
    public void enQueue(int x) {
        // 큐가 가득 차있을 경우 예외 발생
        arr[rear] = x;
        // 위치 재설정
        rear = (rear + 1) % offset;
    }

    // 데이터를 빼기 위한 deQueue
    public int deQueue() {
        // 큐가 비어있을 경우 예외 발생
        // 현재 위치의 값을 회수
        int value = arr[front];
        // 위치 재설정
        front = (front + 1) % offset;
        return value;
    }

    // 큐가 비어있는지 확인하기 위한 isEmpty()
    public boolean isEmpty() {
        return rear == front;
    }

    // 큐가 가득 차있는지 확인하기 위한 isFull()
    public boolean isFull() {
        // 다음번에 넣을곳이 front라면 가득 차있는 상태이다.
        return (rear + 1) % offset == front;
    }

    public static void main(String[] args) {
        MyCyQueue myQueue = new MyCyQueue();
        // 처음의 비어있고 가득 차있는 상태를 확인
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.isFull());
        myQueue.enQueue(0);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        // 4개 넣고 비어있고 가득 차있는 상태를 확인
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.isFull());
        // 4개 제거
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        // 4개 제거 후 상태 확인
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.isFull());
        System.out.println("-------------");
        myQueue.enQueue(0);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
    }
}

















