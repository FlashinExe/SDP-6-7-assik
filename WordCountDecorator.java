public class WordCountDecorator extends FormatDecorator {
    public WordCountDecorator(TextFormatStrategy inner) {
        super(inner);
    }
    public String format(String text) {
        String base = inner.format(text);
        int words = base.trim().isEmpty() ? 0 : base.trim().split("\s+").length;
        return base + " (words: " + words + ")";
    }
}
