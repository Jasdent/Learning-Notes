package Other;

import java.util.*;
public class sorting_understand {

    public static void main(String[] args) {


        List<Student> studentList = Arrays.asList(
                new Student("12113419", "A", 3.52),
                new Student("12018674", "B", 3.88),
                new Student("12113419", "C", 3.11)
        );

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Student i:studentList){
            System.out.print(i.getName()+" | ");
        }


    }
}


class Student{
    private String studentid;
    private String name;
    private double GPA;

    Student(String id,String name,double GPA){
        this.studentid=id;
        this.name=name;
        this.GPA=GPA;
    }

    public String getStudentid(){
        return this.studentid;
    }
    public String getName(){
        return this.name;
    }

}