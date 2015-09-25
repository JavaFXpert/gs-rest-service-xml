package hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class GreetingControllerTest {

    private MockMvc mockMvc;

    @Before
    public void prepare() {
        mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController())
                .setMessageConverters(new MappingJackson2HttpMessageConverter(),
                        new MappingJackson2XmlHttpMessageConverter()).build();
    }

    @Test
    public void greetingJson() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "James").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, James!"));

    }

    @Test
    public void greetingXml() throws Exception {
        mockMvc.perform(get("/greeting").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(xpath("/salutation/message").string("Hello, World!"));

    }

    @Test
    public void greetingXmlPathExtension() throws Exception {
        mockMvc.perform(get("/greeting.xml").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(xpath("/salutation/message").string("Hello, World!"));

    }

}
