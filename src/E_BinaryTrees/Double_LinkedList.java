package E_BinaryTrees;

import java.util.NoSuchElementException;
class Nodes<E> {
    E data;
    Nodes<E> previous;
    Nodes<E> next;

    public Nodes(E data){
        this.data = data;
    }
    public Nodes(){}
}

class Double_LinkedList<E> extends Nodes<E>{
    int size;
    Nodes<E> head;
    Nodes<E> tail;

    public Double_LinkedList() {
        super();
    }
    public Double_LinkedList(E data) {
        super(data);
    }
    boolean is_validIndex(int index){
        return index >= 0 && index <= size;
    }
    boolean is_empty() {
        return size == 0;
    }
    public int getSize(){
        return size;
    }
//  returns the head node-> first student
    public Nodes<E> first_node(Double_LinkedList<E> list){
        return list.head;
    }

    public void printListBackwards(){
        //initialises and checks if the tail is null
        Nodes<E> node = tail;

        if (tail == null) {
            return;
        }

        //else start iterating through the tail
        while (node != null) {
            System.out.print(node.data + " <<=>> ");
            node = node.previous;
        }
        System.out.println(" null ");
    }

    public void insertAtEnd(E data) {
        Nodes<E> node = new Nodes<>(data);

        if (is_empty()) {
            head = node;
        }
        else {
            tail.next = node;
        }
        node.previous = tail;
        tail = node;
        size++;
    }

    public void insertAtStart(E data) {
        Nodes<E> node = new Nodes<>(data);
        node.next = head;
        node.previous = null;

        if (head != null) {
            head.previous = node;
        }
        head = node;
    }

    public Nodes<E> remove_last(){

        if(is_empty())
            throw new NoSuchElementException();

        Nodes<E> node = tail;

        if(head == tail)
            head = null;
        else {
            tail.previous.next = null;
        }

        tail = tail.previous;
        node.previous = null;
        size--;

        return  tail;
    }

    public Nodes<E> remove_first(){
        if(is_empty())
            throw new NoSuchElementException();

        Nodes<E> node = head;

        if(head == tail)
            tail = null;
        else
            head.next.previous = null;

        head = head.next;
        node.next = null;
        size--;

        return head;
    }

    public Nodes<E> remove_at_index(int index){
        Nodes<E> current = head;

        if(index == 0)
            return remove_first();

        else if(index == size)
            return remove_last();

        else  {
            for(int i = 0; i < index && current.next != null; i++){
                current = current.next;
            }

            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
        return current;
    }
}
