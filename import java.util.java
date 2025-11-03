import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private final StringBuilder content = new StringBuilder();
    private TextFormatStrategy formatStrategy;
    private final List<EditorObserver> observers = new ArrayList<>();

    public void setFormatStrategy(TextFormatStrategy strategy) {
        this.formatStrategy = strategy;
        notifyObservers("formatChange",
                strategy == null ? "cleared" : strategy.getClass().getSimpleName());
    }

    public void addObserver(EditorObserver obs) { observers.add(obs); }
    public void removeObserver(EditorObserver obs) { observers.remove(obs); }

    private void notifyObservers(String event, String details) {
        for (EditorObserver o : observers) o.onEvent(event, details, this);
    }

    public void setText(String text) {
        content.setLength(0);
        content.append(text);
        notifyObservers("edit", "setText(" + text.length() + ")");
    }

    public void appendText(String text) {
        content.append(text);
        notifyObservers("edit", "append(" + text.length() + ")");
    }

    public void applyFormat(int startInclusive, int endExclusive) {
        if (formatStrategy == null) {
            notifyObservers("warn", "no strategy");
            return;
        }
        if (startInclusive < 0 || endExclusive > content.length() || startInclusive >= endExclusive) {
            notifyObservers("error", "bad range [" + startInclusive + "," + endExclusive + ")");
            return;
        }
        String before = content.substring(0, startInclusive);
        String target = content.substring(startInclusive, endExclusive);
        String after  = content.substring(endExclusive);

        String formatted = formatStrategy.format(target);
        content.setLength(0);
        content.append(before).append(formatted).append(after);

        notifyObservers("formatApplied", "[" + startInclusive + "," + endExclusive + ")");
    }

    public String getText() { return content.toString(); }
}
