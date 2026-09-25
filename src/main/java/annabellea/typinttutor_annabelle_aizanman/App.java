package annabellea.typinttutor_annabelle_aizanman;

import java.util.HashMap;
import java.util.Map;
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
    private Map<KeyCode, Button> keyButtons = new HashMap<>();
    private boolean shiftPressed = false;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.TOP_CENTER);
        
        Label title = new Label("Typing Tutor");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        Label instructionLabel = new Label("Text to type:");
        Label input = new Label();
        HBox inputBox = new HBox(5, instructionLabel, input);
        
        Label responseLabel = new Label("Your text:");
        TextField response = new TextField();
        HBox responseBox = new HBox(5, responseLabel, response);
        
        Label keyLabel = new Label("Key Pressed:");
        HBox pressedKeyBox = new HBox(10, keyLabel, keyPressedLabel);
        
        Label correctKeysLabel = new Label("Correct: 0");
        Label incorrectKeysLabel = new Label("Incorrect: 0");
        HBox keysBox = new HBox(30, correctKeysLabel, incorrectKeysLabel);
        
        Label counterLabel = new Label("1 of 6");
        
        Label popUp = new Label();
        
        Button nextButton = new Button("Next");
        Button resetButton = new Button("Reset");
        HBox control = new HBox(10, nextButton, resetButton);
        control.setAlignment(Pos.CENTER);
        
        //TEXT TO TYPE
        String[] texts = {
            "Try typing this text. Do it as quickly and accurately as you can",
            "Next type another line of input data", 
            "The quick brown fox jumps over the lazy dog", 
            "Five big quacking zephyrs jolt my wax bed", 
            "Sympathizing would fix Quaker objectives", 
            "A large fawn jumped quickly over white zinc boxes"
        };

        //button actions
        counterLabel.setText(texts[0]);
        int[] idxCurrentText = {0};

        nextButton.setOnAction(event -> {
            if(idxCurrentText[0] < 5){
                idxCurrentText[0]++;
                input.setText(texts[idxCurrentText[0]]);
            }
            counterLabel.setText((idxCurrentText[0] + 1) + " of 6");
        });

        resetButton.setOnAction(event -> {
            idxCurrentText[0] = 0;
            input.setText(texts[0]);
            response.clear();
            counterLabel.setText("1 of 6");
        });

        //Keyboard
        VBox keyboardBox = new VBox(5);
        keyboardBox.setAlignment(Pos.CENTER);

        //row 1 buttons
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
        
        row2.setAlignment(Pos.CENTER);
        
        //row2 buttons
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
        
        //row3 buttons
        HBox row3 = new HBox(5);
        row3.setAlignment(Pos.CENTER);
        
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
        
        //space button
        HBox row4 = new HBox();
        row4.setAlignment(Pos.CENTER);
        Button spaceButton = new Button("SPACE");
        row4.getChildren().add(spaceButton);
        
        keyboardBox.getChildren().addAll(row1, row2, row3, row4);

        //add buttons and keycodes to keycode hash map
        root.getChildren().addAll(title, inputBox, responseBox, pressedKeyBox,
                keysBox, counterLabel, control, keyboardBox);
        
        //add buttons and keycodes to keycode hash map
        
          //row1
        keyButtons.put(KeyCode.Q, qButton);
        keyButtons.put(KeyCode.W, wButton);
        keyButtons.put(KeyCode.E, eButton);
        keyButtons.put(KeyCode.R, rButton);
        keyButtons.put(KeyCode.T, tButton);
        keyButtons.put(KeyCode.Y, yButton);
        keyButtons.put(KeyCode.U, uButton);
        keyButtons.put(KeyCode.I, iButton);
        keyButtons.put(KeyCode.O, oButton);
        keyButtons.put(KeyCode.P, pButton);
        
          //row2
        keyButtons.put(KeyCode.A, aButton);
        keyButtons.put(KeyCode.S, sButton);
        keyButtons.put(KeyCode.D, dButton);
        keyButtons.put(KeyCode.F, fButton);
        keyButtons.put(KeyCode.G, gButton);
        keyButtons.put(KeyCode.H, hButton);
        keyButtons.put(KeyCode.J, jButton);
        keyButtons.put(KeyCode.K, kButton);
        keyButtons.put(KeyCode.L, lButton);
        
          //row3
        keyButtons.put(KeyCode.SHIFT, shiftButton);  
        keyButtons.put(KeyCode.Z, zButton);
        keyButtons.put(KeyCode.X, xButton);
        keyButtons.put(KeyCode.C, cButton);
        keyButtons.put(KeyCode.V, vButton);
        keyButtons.put(KeyCode.B, bButton);
        keyButtons.put(KeyCode.N, nButton);
        keyButtons.put(KeyCode.M, mButton);
        
          //row4
        keyButtons.put(KeyCode.SPACE, spaceButton);
        
        var scene = new Scene(root, 640, 480);
        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            System.out.println("Key pressed: " + event.getCode());
            
            highlightKey(event);
            displayKeyPressed(event);
            
            if(event.getCode() == KeyCode.SHIFT){
                    shiftPressed = true;
            }
            
            if (event.getText().length() > 0) {
                String keyText = event.getText();
                
                if(shiftPressed){
                    keyText = keyText.toUpperCase();
                }
                
                response.appendText(keyText);
            }
            
            if (event.getCode() == KeyCode.BACK_SPACE){
                String current = response.getText();
                
                if(!current.isEmpty()) {
                    response.deleteText(current.length() - 1, current.length());
                }
            }
            
            if (event.getCode() == KeyCode.SPACE){
                String current = response.getText();
                
                if(!current.isEmpty()) {
                    current = (current + " ");
                }
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            stopHighlightKey(event);
            
            if (event.getText().length() > 0) {
                String keyText = event.getText();
                
                if(!shiftPressed){
                    response.appendText(keyText);
                }
            }
        });
 
        stage.setScene(scene);
        stage.setOnShown(event -> root.requestFocus());
        stage.show();
    }
   
    //key pressed
    Label keyPressedLabel = new Label("None");
    
    private void displayKeyPressed(KeyEvent event){
        keyPressedLabel.setText(event.getCode().toString());
    }
    
    //highlighting key when touched
    /**
     * highlights key when pressed
     * @param event key is pressed
     */
    private void highlightKey(KeyEvent event){
        Button button = keyButtons.get(event.getCode());
            
        if(button != null) {
            button.setStyle("-fx-background-color: lightblue");
        }
    }
    
    /**
     * return key to original color when key is released
     * @param event key is released
     */
    private void stopHighlightKey(KeyEvent event){
        Button button = keyButtons.get(event.getCode());
        
        if(button != null) {
            button.setStyle("");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
