public class AutoSaveModule implements EditorObserver {
    public void update(String eventType, String details) {
        System.out.println("[AutoSave] " + eventType + " - " + details);
    }
}
