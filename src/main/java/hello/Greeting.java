package hello;

import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "greeting_root")
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
