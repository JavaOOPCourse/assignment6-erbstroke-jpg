import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        students.put("111",new Student("Nurs",2.7,17));
        students.put("222",new Student("Azamat",1.0,20));
        students.put("333",new Student("Bekbolot",2.3,22));
        students.put("444",new Student("Erbol",4.0,19));
        students.put("555",new Student("Abylaı",3.2,23));


        // TODO: Напечатай всех студентов (ID + объект)
        for(HashMap.Entry<String,Student> student : students.entrySet()){
            System.out.println("ID : "+student.getKey()
                    +" , "+student.getValue());
        }

        // TODO: Найди студента по ID и выведи его
        String findID="222";
        System.out.println("\nFound Student :");
        System.out.println(students.get(findID));


        // TODO: Удали одного студента по ID
        String findRemoveID="333";
        System.out.println("\nRemoved Student :");
        System.out.println(students.remove(findRemoveID));


        // TODO: Обнови GPA у одного студента
        System.out.println("\nUpdated GPA Student :");
        Student s = students.get(findID);
        s.setGpa(4.0);
        System.out.println(s);


        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        ArrayList<Student> studentsList = new ArrayList<>(students.values());
        System.out.println("\nStudents :");
        for(Student student : studentsList){
            System.out.println(student);
        }

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        System.out.println("\nSorted by GPA :");
        Collections.sort(studentsList);
        System.out.println(studentsList);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        System.out.println("\nSorted by Name :");
        studentsList.sort(new NameCompare());
        System.out.println(studentsList);


        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        ArrayList<Student> top = new ArrayList<>(students.values());
        Collections.sort(top);
        for(int i = 0;i<Math.min(3,top.size());i++){
            System.out.println(top.get(i));
        }


        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<Student>> gpaMap = new HashMap<>();

        for (Student student : students.values()) {
            gpaMap.putIfAbsent(student.getGpa(), new ArrayList<>());// if no key add
            gpaMap.get(student.getGpa()).add(student);
        }

        for (HashMap.Entry<Double, List<Student>> entry : gpaMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA: " + entry.getKey());
                entry.getValue().forEach(System.out::println);
            }
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course c1 = new Course("Java");
        Course c2 = new Course("Python");

        courseMap.put(c1,new ArrayList<>(Arrays.asList(students.get("111"),students.get("222"))));
        courseMap.put(c2,new ArrayList<>(Arrays.asList(students.get("555"),students.get("444"))));

        for(HashMap.Entry<Course,List<Student>> course : courseMap.entrySet()){
            System.out.println(course.getKey()+" : "+course.getValue());
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        studentsList.sort(new GpaNameCompare());
        System.out.println(studentsList);
    }
}