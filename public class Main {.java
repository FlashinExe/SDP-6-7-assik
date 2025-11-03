public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        DocumentSaver saver = new CloudSaverAdapter(new LegacyCloudService());
        TextEditorFacade facade = new TextEditorFacade(editor, saver);
        facade.initDefaultObservers();

        facade.loadText("Text Editor Demo\nThis is a small demo.");
        facade.addLine("We can switch formatting at runtime.");
        facade.addLine("Try specialword and   triple spaces.");

        facade.setFormat(TextEditorFacade.Format.BOLD);
        facade.formatRange(0, "Text Editor Demo".length());

        facade.setFormat(TextEditorFacade.Format.ITALIC);
        int s = facade.view().indexOf("small");
        int e = s + "small".length();
        facade.formatRange(s, e);

        facade.setFormat(TextEditorFacade.Format.UNDERLINE);
        int u1 = facade.view().indexOf("switch formatting");
        int u2 = u1 + "switch formatting".length();
        facade.formatRange(u1, u2);

        facade.quickSave();

        System.out.println("\n=== Final Document ===");
        System.out.println(facade.view());
    }
}
