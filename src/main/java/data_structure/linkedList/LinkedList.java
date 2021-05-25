package data_structure.linkedList;

public class LinkedList {
    public Node head;

    public static class Node {
        int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.next;

        }
    }

    public boolean isPresent(int data) {
        Node node = head;
        while (node != null) {
            if (node.data == data)
                return true;
            node = node.next;
        }
        return false;
    }

    public void delete(int data) {
        Node node = head;
        while (node != null) {
            if (head.data == data) {
                head = head.next;
                break;
            } else if (node.next.data == data) {
                node.next = node.next.next;
                break;
            }

            node = node.next;

        }
    }

    public void deleteIndex(int index) {
        Node node = head;
        int count = 0;
        while (node != null) {
            count++;
            if (index == 0) {
                head = head.next;
                break;
            }
            else if (count == index){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
    }

    public int size() {
        int count = 0;
        Node node = head;
        while (node!= null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public int getByIndex(int index) {
        Node node = head;
        int count = 0;
        while (node!= null) {
            if (count == index)
                return node.data;
            count++;
            node = node.next;
        }
        return -1;
    }

    public void insertAtStart(int data){
        Node newNode = new Node(5);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data){
        Node node = head;
        while(node.next!=null)
            node = node.next;
        Node newNode = new Node(data);
        node.next = newNode;
    }

    public void insertAtGivenIndex(int index,int data){
        Node node = head;
        int count = 0;
        while(node.next!=null){
            count++;
            if(index==0){
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
                break;
            }else if(count == index){
                Node newNode =  new Node(data);
                newNode.next = node.next;
                node.next = newNode;
                break;
            }
            node = node.next;
        }
    }

}
