package annabellea.typinttutor_annabelle_aizanman;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        
        root.getChildren().addAll(title, inputBox, responseBox, pressedKeyBox,
                keysBox, counterLabel, control);
        
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}