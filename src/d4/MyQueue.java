package d4;

// 큐의 형태로 데이터를 관리하는 클래스
public class MyQueue {
    // 데이터를 담기위한 배열
    private int[] arr = new int[16];
    // 제일 앞의 데이터가 어딘지 front (데이터를 뺄때 어디의 데이터를 뺄지를 결정하는)
    private int front = -1;
    // 제일 뒤의 데이터가 어딘지 rear (데이터를 넣을때 어디에 데이터를 넣을지를 결정하는)
    private int rear = -1;

    // 데이터를 큐에 담기위한 enQueue
    public void enQueue(int x) {
        // 넣어줄 공간을 설정하고,
        rear++;
        // 해당 위치에 넣어준다.
        arr[rear] = x;
    }

    // 데이터를 큐에서 꺼기 위한 deQueue
    public int deQueue() {
        // 데이터를 가져올 공간을 설정하고,
        front++;
        // 해당 위치에서 가져온다.
        return arr[front];
    }

    // 큐가 비어있는지 확인하기 위한 isEmpty()
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    // 잘못된 포화 상태 인식
    // 큐가 채워져있는지 확인하기 위한 isFull()
    public boolean isFull() {
        // front가 이동한 상황은 고려가 되지 않는다.
        return this.rear == arr.length - 1;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(10);
        myQueue.enQueue(11);
        myQueue.enQueue(12);
        System.out.println(myQueue.isEmpty());

        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        // 들어있는 데이터는 0개
        System.out.println(myQueue.isEmpty());

        for (int i = 0; i < 13; i++) {
            myQueue.enQueue(i);
        }
        // 들어있는 데이터는 12개
        System.out.println(myQueue.deQueue());
        // 남은 공간이 4칸이어도 가득찼다고 인식한다.
        System.out.println(myQueue.isFull());
        // myQueue.enQueue(10);  // 오류
    }
}










