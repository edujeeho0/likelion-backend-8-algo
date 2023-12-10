package d4;

public class MyLinkedList {
    private Node start;

    private static class Node {
        private final int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }


    public void add(int data) {
        if (start == null) start = new Node(data);
        else {
            Node head = start;
            while (head.link != null) {
                head = head.link;
            }

            head.link = new Node(data);
        }
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
        }
        else {
            Node prev = start;
            Node head = start;
            int i = 0;
            while (i < idx) {
                prev = head;
                head = head.link;
                i++;
            }
            prev.link = new Node(data, head);
        }
    }

    public void addFirst(int data) {
        start = new Node(data, start);
    }

    public int remove(int idx) {
        if (idx == 0) {
            int value = start.data;
            start = start.link;
            return value;
        }
        else {
            int i = 0;
            Node prev = start;
            Node head = start;
            while (i < idx) {
                prev = head;
                head = head.link;
                i++;
            }
            int value = head.data;
            prev.link = head.link;
            return value;
        }
    }

    public int removeLast() {
        Node head = start;
        Node prev = start;
        while (head.link != null) {
            prev = head;
            head = head.link;
        }
        int value = head.data;
        prev.link = null;
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node head = start;
        while (head != null) {
            builder.append(head.data);
            if (head.link != null) {
                builder.append(", ");
            }
            head = head.link;
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);

        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);
        System.out.println(linkedList.remove(1));
        System.out.println(linkedList);
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        System.out.println(linkedList);

        linkedList.add(0, 4);
        linkedList.add(3, 5);
        System.out.println(linkedList);
    }
}
