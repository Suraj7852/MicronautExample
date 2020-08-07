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
    public void test() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange(HttpRequest.GET("/student")).status());
    }

    @Test
    public void testName() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange(HttpRequest.POST("/student/name","name")).status());
    }
}
