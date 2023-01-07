package E_BinaryTrees;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        BinaryTree<ArrayList<String>> binary_matrix = new BinaryTree<>();
        ArrayList<String> students = new ArrayList<>();
        students.add("Niklaus");
        students.add("Elijah");
        students.add("Jeremiah");

        ArrayList<String> professors = new ArrayList<>();
        students.add("Jovan");
        students.add("Dragan");
        students.add("Calic");

        ArrayList<String> ex_professors = new ArrayList<>();
        students.add("Djon");
        students.add("Dragana");
        students.add("Kozik");


        binary_matrix.insert_node(students);
        binary_matrix.insert_node(professors);
        binary_matrix.insert_node(ex_professors);

        binary_matrix.display();
    }
}
