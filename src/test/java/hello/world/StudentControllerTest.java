package hello.world;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import io.micronaut.http.client.annotation.*;
import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class StudentControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void getStudents() {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange(HttpRequest.GET("/students")).status());
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setName("rahul");
        student.setRoll(12);
        student.setAge(15);
        assertEquals(HttpStatus.OK, client.toBlocking().exchange(HttpRequest.POST("/student",student)).status());
    }
}
