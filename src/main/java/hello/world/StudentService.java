package hello.world;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
        Student student = new Student();
        student.setName("suraj");
        student.setAge(22);
        student.setRoll(413);
        students.add(student);
    }

    public List<Student> getAllStudent() {
        return students;
    }

    public boolean addStudent(Student student) {
        students.add(student);
        return true;
    }
}
