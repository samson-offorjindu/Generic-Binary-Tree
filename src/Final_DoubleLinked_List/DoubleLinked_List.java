package Final_DoubleLinked_List;

import java.util.NoSuchElementException;

public class DoubleLinked_List<E> {
    Node<E> head;
    Node<E> tail;
    int length;

    boolean isValidIndex(int index){
        return index >= 0 && index <= length;
    }

    boolean isEmpty(){
        return length == 0;
    }

    int getLength () {
        return length;
    }

    public E get(int index) {
        if (index == 0)
            return head.data;

        if (index >= length)
            throw new NoSuchElementException();

        Node<E> current = head;
        int counter = 0;

        while (counter < index && current.next != null){
            counter++;
            current = current.next;
        }

        return current.data;
    }

    public Node<E> getNode(int index) {
        if (index == 0)
            return head;

        if (index >= length)
            throw new NoSuchElementException();

        Node<E> current = head;
        int counter = 0;

        while (counter < index && current.next != null){
            counter++;
            current = current.next;
        }

        return current;
    }

    public E get(E key){
        Node<E> current = head;

        for (int i = 0; i < length && current.next != null; i++){
            if (key.equals(current.data)) {
                return current.data;
            }
        }

        return current.data;
    }

    public void show(){
        Node<E> node = head;

        while(node!=null){
            System.out.print(node.data + "<=>");
            node = node.next;
        }
        System.out.println(" null");
    }

    public void showBack(){
        Node<E> node = tail;

        if(tail == null)
            return;

        while(node!=null){
            System.out.print(node.data + " ->");
            node = node.previous;
        }

        System.out.println(" null ");
    }

    public void insert_end(E data){

        Node<E> node = new Node<>(data);

        if(isEmpty())
            head = node;
        else
            tail.next = node;

        node.previous = tail;
        tail = node;
        length++;
    }
    public void insert_start(E data){

        Node<E> node = new Node<>(data);

        node.next = head;
        node.previous = null;

        if(head != null)
            head.previous = node;

        head = node;
    }

    public Node<E> remove_last(){

        if(isEmpty())
            throw new NoSuchElementException();

        Node<E> node = tail;

        if(head == tail)
            head = null;
        else
            tail.previous.next = null;

        tail = tail.previous;
        node.previous = null;
        length--;

        return tail;
    }

    public Node<E> remove_first() {
        if(isEmpty())
            throw new NoSuchElementException();

        Node<E> node = head;

        if(head == tail)
            tail = null;
        else
            head.next.previous = null;

        head = head.next;
        node.next = null;
        length--;

        return head;
    }

    public void insert_at_index(E data, int index){
        Node<E> newNode = new Node<>(data);
        Node<E> current = head;

        if(index == 0)
            insert_start(data);

        else if (index == length)
            insert_end(data);

        else {
            for(int i = 0; i < index && current.next != null; i++){
                current = current.next;
            }

            newNode.next = current;
            current.previous.next = newNode;
            newNode.previous = current.previous;
            current.previous = newNode;
        }
    }

    public Node<E> remove_at_index(int index){
        Node<E> current = head;

        if(index == 0)
            return remove_first();

        else if(index == length)
            return remove_last();

        else {
            for(int i = 0; i < index && current.next != null; i++){
                current = current.next;
            }

            current.previous.next = current.next;
            current.next.previous = current.previous;
            length--;

        }

        return current;
    }

    public void swapNode(int pos_a, int pos_b){
        if (pos_a - pos_b == 1)
            switchNode(pos_a, pos_a);

        else if (pos_a - pos_b == -1)
            switchNode(pos_b, pos_a);

        else throw new RuntimeException("Swap Operation not Possible");
    }

    public void switchNode(int pos_a, int pos_b){
        // Search and assignment for the nodes
        Node<E> nodeA = getNode(pos_a), nodeB = getNode(pos_b);

        Node<E> tempNode = nodeA.previous;
        nodeA.previous = nodeB.previous;
        nodeB.previous = tempNode;

        // swapping process
        tempNode = nodeA.next;
        nodeA.next = nodeB.next;
        nodeB.next = tempNode;

        // update the next and previous pointers of the adjacent nodes
        if (nodeA.previous != null)
            nodeA.previous.next = nodeA;

        if (nodeA.next != null)
            nodeA.next.previous = nodeA;

        if (nodeB.previous != null)
            nodeB.previous.next = nodeB;

        if (nodeB.next != null)
            nodeB.next.previous = nodeB;
    }

    private void switchNode(Node<E> nodeA, Node<E> nodeB){

        Node<E> tempNode = nodeA.previous;
        nodeA.previous = nodeB.previous;
        nodeB.previous = tempNode;

        // swapping process
        tempNode = nodeA.next;
        nodeA.next = nodeB.next;
        nodeB.next = tempNode;

        // update the next and previous pointers of the adjacent nodes
        if (nodeA.previous != null)
            nodeA.previous.next = nodeA;

        if (nodeA.next != null)
            nodeA.next.previous = nodeA;

        if (nodeB.previous != null)
            nodeB.previous.next = nodeB;

        if (nodeB.next != null)
            nodeB.next.previous = nodeB;
    }

    private Node<E> insertSorted(Node<E> head, Node<E> newNode) {
        // Special case for the head node
        if (head == null || ((Comparable)head.data).compareTo(newNode.data) >= 0) {
            newNode.next = head;
            newNode.previous = null;

            if (head != null) {
                head.previous = newNode;
            }
            return newNode;
        }

        // Locate the node before the point of insertion
        Node<E> current = head;
        while (current.next != null && ((Comparable)head.data).compareTo(newNode.data) < 0) {
            current = current.next;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
        newNode.previous = current;

        if (newNode.next != null) {
            newNode.next.previous = newNode;
        }

        return head;
    }

    public void sort() {
        Node<E> sorted = null;
        Node<E> current = head;

        while (current != null) {
            Node<E> next = current.next;
            sorted = insertSorted(sorted, current);

            current = next;
        }

        head = sorted;
    }
}
