package d3;

// int 데이터를 스택의 형태로 관리할 수 있는 클래스
public class MyStack {
    // 배열로 실제 데이터 보관
    private final int[] arr = new int[16];
    // 데이터를 얼마나 채워넣었는지
    private int top = -1;

    // 데이터 넣기
    // x를 스택의 제일 위에 넣는다.
    public void push(int x) {
        if (top == arr.length - 1) {
            throw new RuntimeException("stack is full");
        }
        this.top++;
        arr[this.top] = x;
    }

    // 데이터 회수
    // 스택의 제일 위의 데이터를 꺼낸다.
    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        // 제일 위에 있는 데이터
        int value = arr[this.top];
        // 스택의 제일 위칸을 줄여준다.
        this.top--;
        return value;
    }

    // 비어있는지 확인
    public boolean isEmpty() {
        return this.top == -1;
    }

    public static void main(String[] args) {
        MyStack intStack = new MyStack();
        intStack.push(10);
        intStack.push(15);
        intStack.push(20);
        System.out.println(intStack.isEmpty());

        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.isEmpty());
    }
}
