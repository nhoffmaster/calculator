import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Buttons{
    Button[] buttons;
    
    public Buttons(String... values){
        buttons = new Button[values.length];
        
        for(int i = 0; i < values.length; i++){
            buttons[i] = new Button(values[i]);
            buttons[i].setPrefWidth(50);
            buttons[i].setPrefHeight(25);
        }
    }
    
    public void addToLayout(Pane layout){
        for(int i = 0; i < buttons.length; i++){
            layout.getChildren().add(buttons[i]);
        }
    }
}