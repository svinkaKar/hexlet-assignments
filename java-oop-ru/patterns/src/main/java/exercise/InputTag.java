package exercise;

// BEGIN
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InputTag implements TagInterface {

    private String type;
    private String value;

    @Override
    public String render() {
        return String.format("<input type=\"%s\" value=\"%s\">", type, value);
    }
}

// END
