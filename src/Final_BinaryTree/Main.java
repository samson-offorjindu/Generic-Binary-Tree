package Final_BinaryTree;

public class Main {
    public static int rand(){
        return (int)(Math.random() * 100);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(0);

        for (int i = 0; i < 100; i++) {
            tree.insert(rand());
        }

        tree.display();
    }
}
