public abstract class FormatDecorator implements TextFormatStrategy {
    protected final TextFormatStrategy inner;
    protected FormatDecorator(TextFormatStrategy inner) {
        this.inner = inner;
    }
}
