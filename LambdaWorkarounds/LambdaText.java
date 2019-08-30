package LambdaWorkarounds;

import javafx.scene.text.Text;

public class LambdaText{
    private Text text;
    
    public LambdaText(){
        text = new Text(0, 0, "");
    }
    
    public void setText(Text textToBeSet){
        text = textToBeSet;
    }
    
    public Text getText(){
        return text;
    }
}