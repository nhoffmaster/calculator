import LambdaWorkarounds.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        
        Pane root = new Pane();
        
        Text input = new Text(20, 30, "");
        LambdaText result = new LambdaText();
        
        input.setStroke(Color.BLACK);
        
        Rectangle box = new Rectangle(10, 10, 280, 150);
        box.setFill(Color.TRANSPARENT);
        box.setStroke(Color.BLACK);
        box.setStrokeWidth(5);
        
        EvaluateCheck evaluated = new EvaluateCheck();
        
        Buttons buttons = new Buttons("+", "-", "*", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "=", "Delete", "Clear");
        
        BreakCount breakCount = new BreakCount();
        
        for(int i = 0; i < buttons.buttons.length; i++){
            String text = buttons.buttons[i].getText();
            buttons.buttons[i].setOnAction(e -> {
                if(evaluated.getEvaluated()){
                    evaluated.setEvaluated(false);
                    input.setText("");
                    root.getChildren().remove(result.getText());
                }
                if((input.getText().length() - breakCount.getBreakCount()) % 30 == 0 && input.getText().length() != 0){
                    input.setText(input.getText() + "\n");
                    breakCount.setBreakCount(breakCount.getBreakCount() + 1);
                }
                input.setText(input.getText() + text);
            });
        }
        
        buttons.buttons[0].setLayoutX(10);
        buttons.buttons[0].setLayoutY(170);
        
        buttons.buttons[1].setLayoutX(87);
        buttons.buttons[1].setLayoutY(170);
        
        buttons.buttons[2].setLayoutX(164);
        buttons.buttons[2].setLayoutY(170);
        
        buttons.buttons[3].setLayoutX(241);
        buttons.buttons[3].setLayoutY(170);
        
        
        buttons.buttons[4].setLayoutX(10);
        buttons.buttons[4].setLayoutY(378);
        
        
        buttons.buttons[5].setLayoutX(10);
        buttons.buttons[5].setLayoutY(326);
        
        buttons.buttons[6].setLayoutX(87);
        buttons.buttons[6].setLayoutY(326);
        
        buttons.buttons[7].setLayoutX(164);
        buttons.buttons[7].setLayoutY(326);
        
        
        buttons.buttons[8].setLayoutX(10);
        buttons.buttons[8].setLayoutY(274);
        
        buttons.buttons[9].setLayoutX(87);
        buttons.buttons[9].setLayoutY(274);
        
        buttons.buttons[10].setLayoutX(164);
        buttons.buttons[10].setLayoutY(274);
        
        
        buttons.buttons[11].setLayoutX(10);
        buttons.buttons[11].setLayoutY(222);
        
        buttons.buttons[12].setLayoutX(87);
        buttons.buttons[12].setLayoutY(222);
        
        buttons.buttons[13].setLayoutX(164);
        buttons.buttons[13].setLayoutY(222);
        
        
        buttons.buttons[14].setLayoutX(10);
        buttons.buttons[14].setLayoutY(430);
        buttons.buttons[14].setOnAction(e -> {
            if(!evaluated.getEvaluated()){
                String breaks = "";
                for(int i = 0; i < breakCount.getBreakCount(); i++){
                    breaks += "\n";
                }
                result.setText(new Text(20, 50, breaks + Parser.parse(input.getText()).toString()));
                result.getText().setStroke(Color.BLACK);
                root.getChildren().add(result.getText());
            }
            evaluated.setEvaluated(true);
        });
        
        buttons.buttons[15].setLayoutX(87);
        buttons.buttons[15].setLayoutY(430);
        buttons.buttons[15].setFont(new Font(10));
        buttons.buttons[15].setOnAction(e -> {
            input.setText(input.getText().substring(0, input.getText().length() - 1));
        });
        
        buttons.buttons[16].setLayoutX(164);
        buttons.buttons[16].setLayoutY(430);
        buttons.buttons[16].setFont(new Font(10));
        buttons.buttons[16].setOnAction(e -> {
            input.setText("");
        });
        
        
        root.getChildren().addAll(box, input, result.getText());
        buttons.addToLayout(root);
        
        Scene scene = new Scene(root, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}