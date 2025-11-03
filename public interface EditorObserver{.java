public interface EditorObserver{
    void onEvent(string eventType, String content);

}
class autosavemodule implements EditorObserver{
    @Override
    public void onEvent(String eventType, String content){
        if ("edit".equals(Eventtype)) || "FormatChange".equals(Eventtype){
            saveCount++;
            System.out.println("[Autosave] Saved version #" + saveCount);
        } 
    }
}

class specialCheker implements EditorObserver{
    @Override
    public void onEvent(String eventType, String content){
        if ("edit".equals(Eventtype)){
            if (editor.getText().contains("specialword"){
                System.out.println("[specialcheker] specialword detected in text!")
            }
            }
    }
 }
class UIComponent Implements EditorObserver{
    @Override
    public void onEvent(String eventType, String details, TextEditor editor){
        System.out.println("[UIComponent] Event: " + eventType + " Details: " + details);
        
    }
}
