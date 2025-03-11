package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {

    private String bodyTag;
    private List<Tag> children;

    public PairedTag(String nameTag, Map<String, String> atributesTag, String bodyTag, List<Tag> children) {
        super(nameTag, atributesTag);
        this.bodyTag = bodyTag;
        this.children = children;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.getAtributes(super.getNameTag(), super.getAtributesTag()));
        if (!bodyTag.isEmpty()) {
            sb.append(bodyTag);
        }
        if (!children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                sb.append(children.get(i).toString());
            }
        }
        sb.append(String.format("</%s>", super.getNameTag()));
        return sb.toString();
    }
}

// END
