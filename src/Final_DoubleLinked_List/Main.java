package Final_DoubleLinked_List;

import Final_BinaryTree.BinaryTree;

public class Main {
    public static void main(String[] args){
        BinaryTree<String> tree = new BinaryTree<>();

        tree.insert("Val-El");
        tree.insert("Tel-El");
        tree.insert("Seg-El");
        tree.insert("Nyssa-Vex");
        tree.insert("Jor-El");
        tree.insert("Lara Lor-Van");
        tree.insert("Dru-Zod");
        tree.insert("Zor-El");
        tree.insert("Alura In-Ze");
        tree.insert("H'El");
        tree.insert("Kal-El");
        tree.insert("Kara Zor-El");

        tree.display();
    }
}
