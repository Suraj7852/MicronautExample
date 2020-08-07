package hello.world;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;


@Controller
public class StudentController {

    @Inject
    StudentService studentService;

    @Get(uri="/students", produces = MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentService.getAllStudent();
    }

    @Post(uri = "/student", consumes = MediaType.APPLICATION_JSON)
    public Student addStudent(@Body Student student ) {
        studentService.addStudent(student);
        return student;
    }

    @Delete(uri = "/remove/{id}", consumes = MediaType.APPLICATION_JSON)
    public boolean removeStudent(int id ) {
        studentService.removeStudent(id);
        return true;
    }

    @Put(uri = "/update/{id}", consumes = MediaType.APPLICATION_JSON)
    public Student updateStudent(@Body Student student, int id) {
        return studentService.updateStudent(student, id);
    }
}