import java.util.*;

public class TextEditor {
    private String text = "";
    private TextFormatStrategy formatStrategy;
    private List<EditorObserver> observers = new ArrayList<>();

    public void setFormatStrategy(TextFormatStrategy strategy) {
        this.formatStrategy = strategy;
        notifyObservers("format_changed", strategy.getClass().getSimpleName());
    }

    public void type(String newText) {
        text += newText;
        notifyObservers("text_typed", newText);
    }

    public void save() {
        notifyObservers("document_saved", "File saved");
    }

    public void registerObserver(EditorObserver o) {
        observers.add(o);
    }

    public void notifyObservers(String event, String details) {
        for (EditorObserver o : observers)
            o.update(event, details);
    }

    public void showFormatted() {
        if (formatStrategy != null)
            System.out.println(formatStrategy.format(text));
        else
            System.out.println(text);
    }
}
