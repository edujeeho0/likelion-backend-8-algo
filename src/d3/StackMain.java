package d3;

public class StackMain {
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
