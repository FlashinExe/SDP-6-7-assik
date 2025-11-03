public class BoldFormat implements TextFormatStrategy {
    public String format(String text) {
        return "**" + text + "**";
    }
}
