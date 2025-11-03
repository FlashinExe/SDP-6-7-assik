public class SpellChecker implements EditorObserver {
    public void update(String eventType, String details) {
        System.out.println("[SpellChecker] Checked after " + eventType);
    }
}
