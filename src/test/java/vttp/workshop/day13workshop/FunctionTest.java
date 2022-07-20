package vttp.workshop.day13workshop;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class FunctionTest {

    private Logger logger = Logger.getLogger(FunctionTest.class.getName());
    private Path workingDir;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void readContact() throws IOException{
        this.workingDir = Path.of("", "c:/data");
        Path file = this.workingDir.resolve("0933c170");
        String content = Files.readString(file);
        assertThat(content, is(notNullValue()));
        
    }

    @Test
    public void saveContact() throws Exception {

        MultiValueMap<String,String> payload = new LinkedMultiValueMap<String, String>();
        payload.add("name", "Darren");
        payload.add("email", "darren@gmail.com");
        payload.add("phone", "12345678");

        logger.log(Level.INFO,""+ objectMapper.writeValueAsString(payload));

    }
    
}
