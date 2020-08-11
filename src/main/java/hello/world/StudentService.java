package hello.world;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
        Student student = new Student();
        student.setId(1);
        student.setName("suraj");
        student.setAge(22);
        student.setRoll(413);
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(int id) {
        return getSingleStudent(id);
    }

    public boolean addStudent(Student student) {
        student.setId(students.size()+1);
        students.add(student);
        return true;
    }

    public boolean removeStudent(int id) {
        students.remove(getSingleStudent(id));
        return true;
    }

    public Student updateStudent(Student student, int id) {
        Student student1 = getSingleStudent(id);
        student.setId(id);
        if (student.getName().equals(""))
            student.setName(student1.getName());
        if (student.getAge()==0)
            student.setAge(student1.getAge());
        if (student.getRoll() == 0)
            student.setRoll(student1.getRoll());
        students.set(getIndexOfStudent(id),student);
        return student;
    }

    private int getIndexOfStudent(int id) {
        return students.indexOf(getSingleStudent(id));
    }

    private Student getSingleStudent(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().get();
    }
}
