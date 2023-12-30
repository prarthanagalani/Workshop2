package Linkedlist;

public class Main {

    public static void main(String[] args) {
        LL<Integer> l = new LL<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(9);
        l.add(5);

        l.display();

        System.out.println("*************************");

        l.reverseLL();

    }
}

class LL<T> {

    Node<T> head;

    LL() {
        head = null;
    }

    public void add(T x) {
        Node<T> newnode = new Node<>(x);

        if (head == null) {
            head = newnode;
        } else {
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newnode;

        }
    }

    public void display() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.println(temp.data);

            temp = temp.next;
        }
    }

    public void reverseLL() {
        Node<T> cur = head;
        Node<T> prev = null;
        Node<T> next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        Node<T> temp = prev;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}
