public class TextEditorFacade {
    private final TextEditor editor;
    private final DocumentSaver saver;

    public enum Format { BOLD, ITALIC, UNDERLINE, NONE }

    public TextEditorFacade(TextEditor editor, DocumentSaver saver) {
        this.editor = editor;
        this.saver = saver;
    }

    public void initDefaultObservers() {
        editor.addObserver(new UiComponent());
        editor.addObserver(new AutoSaveModule());
        editor.addObserver(new SpellChecker());
    }

    public void loadText(String text) { editor.setText(text); }
    public void addLine(String line) { editor.appendText("\n" + line); }
    public String view() { return editor.getText(); }

    public void setFormat(Format f) {
        switch (f) {
            case BOLD -> editor.setFormatStrategy(new BoldFormatStrategy());
            case ITALIC -> editor.setFormatStrategy(new ItalicFormatStrategy());
            case UNDERLINE -> editor.setFormatStrategy(new UnderlineFormatStrategy());
            case NONE -> editor.setFormatStrategy(null);
        }
    }

    public void formatRange(int start, int end) { editor.applyFormat(start, end); }

    public void quickSave() { saver.save(editor.getText()); }
}
