package Final_BinaryTree;


public class Main {
    public static int rand(){
        return (int)(Math.random() * 100);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> s_tree = new BinaryTree<>();

        for (int i = 0; i < 64; i++) {
            s_tree.insert(rand());
        }

        s_tree.display();

    }
}
