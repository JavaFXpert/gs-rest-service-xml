package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonRootName("salutation")
public class Greeting {

    @JacksonXmlProperty(localName="gid", isAttribute=true)
    private final long id;

    @JsonProperty("message")
    private final String content;

    private Greeter greeter;

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

    public Greeter getGreeter() {
        return greeter;
    }

    public void setGreeter(Greeter greeter) {
        this.greeter = greeter;
    }
}
