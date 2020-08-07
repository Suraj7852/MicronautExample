package hello.world;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.apache.commons.io.FileUtils;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
}