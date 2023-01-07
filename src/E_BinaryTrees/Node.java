package E_BinaryTrees;

import java.util.Collection;
import java.util.Iterator;

public class Node<E> implements TreePrinter.PrintableNode {
    E data;
    Node<E> right;
    Node<E> left;

    public Node(E data){
        this.data = data;
        right = null;
        left = null;
    }
    public Node(){}

    @Override
    public String toString(){
        return String.valueOf(data);
    }
    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }
    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }
    @Override
    public String getText() {
        return toString();
    }
}
