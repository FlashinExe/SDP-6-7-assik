public class BracketsDecorator extends FormatDecorator {
    public BracketsDecorator(TextFormatStrategy inner) {
        super(inner);
    }
    public String format(String text) {
        return "[" + inner.format(text) + "]";
    }
}
