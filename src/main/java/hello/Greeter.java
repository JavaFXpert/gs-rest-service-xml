package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("salutation")
public class Greeter {

    @JsonProperty("sender-name")
    private final String name;

    @JsonProperty("year-sent")
    private final int year;

    public Greeter(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
