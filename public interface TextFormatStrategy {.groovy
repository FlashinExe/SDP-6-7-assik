public interface TextFormatStrategy {
    String format(String text);
}

class BoldFormatStrategy implements TextFormatStrategy {
    @Override
    public String format(String text) {
        return "<b>" + text + "</b>";
    }
}

class ItalicFormatStrategy implements TextFormatStrategy {
    @Override
    public String format(String text) {
        return "<i>" + text + "</i>";
    }
}

class UnderlineFormatStrategy implements TextFormatStrategy {
    @Override
    public String format(String text) {
        return "<u>" + text + "</u>";
    }
}
