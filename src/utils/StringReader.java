package utils;

public class StringReader {
    private String[] texts;
    private int index = 0;

    public StringReader(String[] texts) {
        this.texts = texts;
    }

    public String next() {
        if (index < texts.length) return texts[index++];
        return null;
    }

    public boolean isFirstLine() {
        return index == 1;
    }
}