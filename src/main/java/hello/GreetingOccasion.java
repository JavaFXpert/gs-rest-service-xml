package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("occasion")
public class GreetingOccasion {

    private final String purpose;

    public GreetingOccasion(String purpose) {
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }
}
