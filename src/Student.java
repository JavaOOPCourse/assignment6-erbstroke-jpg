import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    // TODO: Task 1 — Создай конструктор, который принимает имя, GPA и возраст
    public Student(String name, double gpa, int age) {
        // заглушка
        this.name=name;
        this.gpa=gpa;
        this.age=age;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    // TODO: Task 1 — Добавь возможность изменить GPA
    public void setGpa(double newGpa) {
        // заглушка
        if(newGpa>=0 && newGpa<=4){
            this.gpa=newGpa;
        }
    }

    // TODO: Task 1 (Sorting) — Реализуй Comparable по GPA (по возрастанию)
    @Override
    public int compareTo(Student other) {
        // заглушка — верни правильное значение сравнения
        return Double.compare(this.gpa,other.gpa);
    }

    @Override
    public String toString() {
        // TODO: Сделай красивый вывод
        return "Name : "+this.name
                +" , Age : "+this.age
                +" , GPA : "+this.gpa;
    }
}

class NameCompare implements Comparator<Student>{
    public int compare(Student s1 , Student s2){
        return s1.getName().compareTo(s2.getName());
    }
}

class GpaNameCompare implements Comparator<Student>{
    public int compare(Student s1 , Student s2){
        int result = Double.compare(s2.getGpa(),s1.getGpa());
        if(result==0){
            return s1.getName().compareTo(s2.getName());
        }return result ;
    }

}