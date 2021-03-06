package hello.world;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class StudentServiceTest {

    @Inject
    StudentService studentService;

    @Test
    public void getAllStudent() {
        List<Student> allStudent = studentService.getStudents();
        assertEquals(allStudent.get(0).getName(),"suraj");
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        boolean addStudent = studentService.addStudent(student);
        assertEquals(addStudent,true);
    }

    @Test
    public void removeStudent() {
        boolean removeStudent = studentService.removeStudent("");
        assertEquals(removeStudent,true);
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setName("kumar");
        Student student1 = studentService.updateStudent(student, "");
        assertEquals(student1.getName(),"kumar");
    }

    @Test
    public void getSingleStudent() {
        Student student = studentService.getStudent("1");
        assertEquals(student.getName(), "suraj");
    }

}