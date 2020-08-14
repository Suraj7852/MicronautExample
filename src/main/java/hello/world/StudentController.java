package hello.world;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;


@Controller("/students")
public class StudentController {

    @Inject
    StudentService studentService;

    @Get(uri="/", produces = MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @Get(uri="/{id}", produces = MediaType.APPLICATION_JSON)
    public Student getStudent(String id) {
        System.out.println(id);
        return studentService.getStudent(id);
    }

    @Post(uri = "/", consumes = MediaType.APPLICATION_JSON)
    public Student addStudent(@Body Student student ) {
        studentService.addStudent(student);
        return student;
    }

    @Delete(uri = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public boolean removeStudent(String id ) {
        studentService.removeStudent(id);
        return true;
    }

    @Put(uri = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public Student updateStudent(String id, @Body Student student) {
        return studentService.updateStudent(student, id);
    }
}