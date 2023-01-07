package BinaryTreesJava;

public class Main {
    public static void main(String[] args){
        BinaryTree cursed_tree = new BinaryTree();

        for (int i = 0; i < 400; i++) {
            cursed_tree.insert_node((int) (Math.random() * 100));
        }

        cursed_tree.display(cursed_tree.root); // has to be fixed
    }
}
