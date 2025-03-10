package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private String tagText;
    private TagInterface tagInf;

    public LabelTag(String tagText, TagInterface tagInf) {
        this.tagText = tagText;
        this.tagInf = tagInf;
    }

    @Override
    public String render() {
        return String.format("<label>%s=%s</label>", tagText, tagInf.render());
    }
}

// END
