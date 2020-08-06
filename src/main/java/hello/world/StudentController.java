package hello.world;

        import io.micronaut.http.HttpResponse;
        import io.micronaut.http.MediaType;
        import io.micronaut.http.annotation.*;
        import org.apache.commons.io.FileUtils;

        import java.io.File;
        import java.io.IOException;
        import java.io.InputStream;
        import java.nio.charset.Charset;


@Controller("/student")
public class StudentController {

    @Get(uri="/", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Object> student() throws IOException {
        String path = "student.json";
        String fileToString = FileUtils.readFileToString(getFileByFileName(path), Charset.defaultCharset());
        return HttpResponse.ok(fileToString);
    }

    @Post(value = "/{name}", consumes = MediaType.TEXT_PLAIN)
    public HttpResponse<Object> addStudent(@Body String name) throws IOException {
        return HttpResponse.ok(name);
    }


    private static File getFileByFileName(String fileName) throws IOException {
        InputStream fileAsStream = StudentController.class.getResourceAsStream("/" + fileName);
        File file = new File("/tmp/" + fileName);
        FileUtils.copyInputStreamToFile(fileAsStream, file);
        return file;
    }
}