public class UnderlineFormat implements TextFormatStrategy {
    public String format(String text) {
        return "__" + text + "__";
    }
}
