public class ItalicFormat implements TextFormatStrategy {
    public String format(String text) {
        return "*" + text + "*";
    }
}
