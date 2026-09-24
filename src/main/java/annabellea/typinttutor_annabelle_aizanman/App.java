package annabellea.typinttutor_annabelle_aizanman;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.TOP_CENTER);
        
        Label title = new Label("Typing Tutor");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        Label instructionLabel = new Label("Text to type:");
        TextField input = new TextField();
        HBox inputBox = new HBox(5, instructionLabel, input);
        
        Label responseLabel = new Label("Your text:");
        TextField response = new TextField();
        HBox responseBox = new HBox(5, responseLabel, response);
        
        Label keyLabel = new Label("Key Pressed:");
        Label keyPressedLabel = new Label("None");
        HBox pressedKeyBox = new HBox(10, keyLabel, keyPressedLabel);
        
        Label correctKeysLabel = new Label("Correct: 0");
        Label incorrectKeysLabel = new Label("Incorrect: 0");
        HBox keysBox = new HBox(30, correctKeysLabel, incorrectKeysLabel);
        
        Label counterLabel = new Label("1 of 6");
        
        Button nextButton = new Button("Next");
        Button resetButton = new Button("Reset");
        HBox control = new HBox(10, nextButton, resetButton);
        control.setAlignment(Pos.CENTER);
        
        //KeyBoard
        VBox keyboardBox = new VBox(5);
        keyboardBox.setAlignment(Pos.CENTER);
        
        HBox row1 = new HBox(5);
        row1.setAlignment(Pos.CENTER);
        
        Button qButton = new Button("Q");
        Button wButton = new Button("W");
        Button eButton = new Button("E");
        Button rButton = new Button("R");
        Button tButton = new Button("T");
        Button yButton = new Button("Y");
        Button uButton = new Button("U");
        Button iButton = new Button("I");
        Button oButton = new Button("O");
        Button pButton = new Button("P");
        
        row1.getChildren().addAll(qButton, wButton, eButton, rButton, tButton,
                yButton, uButton, iButton, oButton, pButton);
        
        HBox row2 = new HBox(5);
        row1.setAlignment(Pos.CENTER);
        
        Button aButton = new Button("A");
        Button sButton = new Button("S");
        Button dButton = new Button("D");
        Button fButton = new Button("F");
        Button gButton = new Button("G");
        Button hButton = new Button("H");
        Button jButton = new Button("J");
        Button kButton = new Button("K");
        Button lButton = new Button("L");
        
        row2.getChildren().addAll(aButton, sButton, dButton, fButton, gButton,
                hButton, jButton, kButton, lButton);
        
        HBox row3 = new HBox(5);
        row1.setAlignment(Pos.CENTER);
        
        Button shiftButton = new Button("SHIFT");
        Button zButton = new Button("Z");
        Button xButton = new Button("X");
        Button cButton = new Button("C");
        Button vButton = new Button("V");
        Button bButton = new Button("B");
        Button nButton = new Button("N");
        Button mButton = new Button("M");
        
        row3.getChildren().addAll(shiftButton, zButton, xButton, cButton,
                vButton, bButton, nButton, mButton);
        
        HBox row4 = new HBox();
        row4.setAlignment(Pos.CENTER);
        Button spaceButton = new Button("SPACE");
        row4.getChildren().add(spaceButton);
        
        keyboardBox.getChildren().addAll(row1, row2, row3, row4);

        root.getChildren().addAll(title, inputBox, responseBox, pressedKeyBox,
                keysBox, counterLabel, control, keyboardBox);
        
        var scene = new Scene(root, 640, 480);
        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            System.out.println("Key pressed: " + event.getCode());
            
            if(event.getCode() == KeyCode.A) {
                aButton.setStyle("-fx-background-color: lightblue");
            }
            
            if (event.getText().length() > 0) {
                response.appendText(event.getText());
            }
            
            if (event.getCode() == KeyCode.BACK_SPACE){
                String current = response.getText();
                
                if(!current.isEmpty()) {
                    response.deleteText(current.length() - 1, current.length());
                }
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            if(event.getCode() == KeyCode.A) {
                aButton.setStyle("");
            }
        });
        
//        private void highlightKey(Keycode keycode){
//            
//        }
        
        stage.setScene(scene);
        stage.setOnShown(event -> root.requestFocus());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}