public class UppercaseDecorator extends FormatDecorator {
    public UppercaseDecorator(TextFormatStrategy inner) {
        super(inner);
    }
    public String format(String text) {
        return inner.format(text).toUpperCase();
    }
}
