package exercise;

// BEGIN
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LabelTag implements TagInterface {

    private String tagText;
    private TagInterface tagInf;

    @Override
    public String render() {
        return String.format("<label>%s=%s", tagText, tagInf.render());
    }
}

// END
