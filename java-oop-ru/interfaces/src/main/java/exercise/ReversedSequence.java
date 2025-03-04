package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private String str;

    public ReversedSequence(String str) {
        this.str = str;
    }

    public String getReversedString() {
        return new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return getReversedString().charAt(index);
    }
    @Override
    public CharSequence subSequence(int start, int end) {
        return getReversedString().substring(start, end);
    }

    @Override
    public String toString() {
        return getReversedString();
    }
}

// END
