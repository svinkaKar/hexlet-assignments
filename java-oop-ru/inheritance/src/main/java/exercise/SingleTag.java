package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String nameTag, Map<String, String> atributesTag) {
        super(nameTag, atributesTag);
    }

    public String toString() {
        return super.getAtributes(super.getNameTag(), super.getAtributesTag());
    }
}

// END
