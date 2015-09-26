package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("salutation")
public class Greeting {

    @JacksonXmlProperty(localName="gid", isAttribute=true)
    private final long id;

    @JsonProperty("message")
    private final String content;

    private GreeterPerson greeterPerson;

    @JacksonXmlElementWrapper(localName = "occasions")
    @JsonProperty("occasion")
    private List<GreetingOccasion> greetingOccasions = new ArrayList<>();

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

    public GreeterPerson getGreeterPerson() {
        return greeterPerson;
    }

    public void setGreeterPerson(GreeterPerson greeterPerson) {
        this.greeterPerson = greeterPerson;
    }

    public List<GreetingOccasion> getGreetingOccasions() {
        return greetingOccasions;
    }

    public void setGreetingOccasions(List<GreetingOccasion> greetingOccasions) {
        this.greetingOccasions = greetingOccasions;
    }
}
