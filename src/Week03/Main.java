package Week03;


import Structures.Node;

import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.setNext(new Node<>(2));
        head.getNext().setPrev(head);

        head.getNext().setNext(new Node<>(3));
        head.getNext().getNext().setPrev(head.getNext());

        head.getNext().getNext().setNext(new Node<>(4, null, head.getNext().getNext()));


        Node<Integer> ch1 = new Node<>(1);
        Node<Integer> ch2 = new Node<>(2);
        Node<Integer> ch3 = new Node<>(3);
        Node<Integer> ch4 = new Node<>(4);

        ch1.setNext(ch2);
        ch2.setPrev(ch1);
        ch2.setNext(ch3);
        ch3.setPrev(ch2);
        ch3.setNext(ch4);
        ch4.setPrev(ch3);
        print(ch1);
//        System.out.println(ch1);

        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);


        MyLinkedList<Object> llo = new MyLinkedList<>();
        llo.add(null);

        MyLinkedList<Integer> lln = new MyLinkedList<>();
//        lln.add(0, 1);


        System.out.println("------------------ lle ----------------------------------");
        LinkedList<Integer> lle = new LinkedList<>();
        System.out.println(lle);

        lle.add(1);
        lle.add(2);
        lle.add(4);
        lle.add(5);
        System.out.println(lle);
        // lle.add(4,3); == lle.add(3);
        lle.add(0, 0);
        System.out.println(lle);
        System.out.println(lle.set(3, 3));
        System.out.println(lle);

        Node<Integer> chain = new Node<>(1, new Node<>(2, new Node<>(3)));
        chain = remove(chain, 3);


        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.size());       // 3
        System.out.println(list.get(0));       // 10
        System.out.println(list.get(2));       // 30

        list.add(1, 15);
        System.out.println(list.get(1));       // 15
        System.out.println(list.size());       // 4

        list.set(1, 20);
        System.out.println(list.get(1));       // 20

        System.out.println(list.indexOf(20));     // 1
        System.out.println(list.lastIndexOf(20)); // 2

        list.remove(0);
        System.out.println(list.get(0));       // 20
        System.out.println(list.size());       // 3

        list.remove(Integer.valueOf(20));
        System.out.println(list.size());       // 2

        list.clear();
        System.out.println(list.size());       // 0
        System.out.println(list.isEmpty());    // true
    }

    private static Node<Integer> remove(Node<Integer> chain, int i) {
        return null;
    }

    private static void print(Node<Integer> ch) {
        if (ch == null)
            return;

        while (ch != null) {

            System.out.print(ch.getValue() + "-> ");
            ch = ch.getNext();
        }

        System.out.println("null");

    }

}


