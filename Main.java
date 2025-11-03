public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.registerObserver(new AutoSaveModule());
        editor.registerObserver(new SpellChecker());

        editor.type("Hello, world!");

        editor.setFormatStrategy(new BoldFormat());
        editor.showFormatted();

        TextFormatStrategy stacked =
            new WordCountDecorator(
                new BracketsDecorator(
                    new UppercaseDecorator(
                        new BoldFormat()
                    )
                )
            );

        editor.setFormatStrategy(stacked);
        editor.showFormatted();

        TextFormatStrategy italicWithCount =
            new WordCountDecorator(new ItalicFormat());
        editor.setFormatStrategy(italicWithCount);
        editor.showFormatted();

        editor.save();
    }
}
