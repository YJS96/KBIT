package afternoon.collection.list;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("linkedList = " + linkedList);

        linkedList.addFirst(0);
        linkedList.addLast(6);
        System.out.println("linkedList = " + linkedList);

        linkedList.add(3, 22);
        System.out.println("linkedList = " + linkedList);

        int firstElement = linkedList.getFirst();
        int lastElement = linkedList.getLast();
        int elementAtIndex = linkedList.get(3);

        System.out.println("firstElement = " + firstElement);
        System.out.println("lastElement = " + lastElement);
        System.out.println("elementAtIndex = " + elementAtIndex);
    }
}
