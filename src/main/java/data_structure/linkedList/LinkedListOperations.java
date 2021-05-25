package data_structure.linkedList;

public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node headNode = new LinkedList.Node(10);
        LinkedList.Node secondNode = new LinkedList.Node(20);
        LinkedList.Node thirdNode = new LinkedList.Node(30);
        linkedList.head = headNode;
        headNode.next = secondNode;
        secondNode.next = thirdNode;

        linkedList.printList();
        System.out.println("Size> " + linkedList.size());
        boolean isPresent = linkedList.isPresent(20);
        System.out.println("Is 20 present in linkedList > " + isPresent);
        linkedList.delete(20);
        linkedList.deleteIndex(0);
        isPresent = linkedList.isPresent(20);
        linkedList.printList();
        System.out.println("Is 20 present in linkedList > " + isPresent);
        System.out.println("Element at 0th index > " + linkedList.getByIndex(0));
        System.out.println("----Insertion At Start-----");
        linkedList.insertAtStart(5);
        System.out.println("-------Insertion At End--------");
        linkedList.insertAtEnd(40);
        linkedList.printList();
        System.out.println("-------Inserting at given index------");
        linkedList.insertAtGivenIndex(2,15);
        linkedList.printList();

    }
}
