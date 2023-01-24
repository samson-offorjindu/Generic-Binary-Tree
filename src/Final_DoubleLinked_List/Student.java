package Final_DoubleLinked_List;

public class Student implements Comparable<Student>{
    String name;
    String id;
    int gpa;

    public Student(String name, String id, int gpa){
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return "[" + name + ", " + id + ", " + gpa + "]";
    }

    @Override
    public int compareTo(Student o) {
        if (this.gpa == o.gpa) {
            return 0;

        } else if (this.gpa <= o.gpa) {
            return -1;
        }
        return 1;
    }
}
