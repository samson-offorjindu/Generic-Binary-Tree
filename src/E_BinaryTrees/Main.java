package E_BinaryTrees;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        BinaryTree<ArrayList<String>> binary_matrix = new BinaryTree<>();
        ArrayList<String> students = new ArrayList<>();
        students.add("Niklaus");
        students.add("Elijah");
        students.add("Jeremiah");

        ArrayList<Double> grades = new ArrayList<>();
        grades.add(384.3);
        grades.add(300.56);
        grades.add(45.3);

        ArrayList<Integer> index = new ArrayList<>();
        index.add(3);
        index.add(9);
        index.add(13);

        binary_matrix.insert_node(students);
        binary_matrix.display(binary_matrix.root);

    }
}
