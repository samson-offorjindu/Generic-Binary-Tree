package Final_BinaryTree;

public class Student {
    String name;
    String surname;
    String faculty;
    String id;
    double GPA;

    public Student(String name, String surname, String faculty, double GPA) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.GPA = GPA;
    }



    @Override
    public String toString() {
        for (int i = 0; i < name.length() + 10; i++) {
            System.out.print("_");
        }

        System.out.println();

        System.out.println("| Name: " + name);
        System.out.println("| Surname: " + surname);
        System.out.println("| Faculty: " + faculty);
        System.out.println("| Index: " + id);
        System.out.println("| CGPA: " + GPA);

        for (int i = 0; i < name.length() + 10; i++) {
            System.out.print("_");
        }

        return "";
    }
}
