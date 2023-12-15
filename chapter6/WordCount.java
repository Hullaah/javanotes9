import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WordCount extends Application {

    private TextArea text;
    private Label lineLabel, wordLabel, charLabel;
    private Button processButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        text = new TextArea();
        text.setPrefRowCount(25);
        text.setPrefColumnCount(40);
        lineLabel = makeLabel(" Number Of lines: 0");
        wordLabel = makeLabel(" Number Of words: 0");
        charLabel = makeLabel(" Number Of chars: 0");
        processButton = new Button("Process the Text");
        processButton.setOnAction(e -> {
            int[] textCount = countText(text.getText());
            lineLabel.setText(" Number Of lines: " + textCount[0]);
            wordLabel.setText("Number of words: " + textCount[1]);
            charLabel.setText("Number of chars: " + textCount[2]);
        });
        VBox root = new VBox(4, text, new BorderPane(processButton), lineLabel, wordLabel, charLabel);
        root.setStyle("-fx-background-color: blue; -fx-border-color: blue; -fx-border-width: 2px");
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label makeLabel(String text) {
        Label label = new Label(text);
        label.setMaxSize(1000,1000);
        label.setStyle("-fx-background-color:white; " + "-fx-font-size: 20px;" +
                "-fx-font-family: serif; -fx-font-weight: bold");
        return label;
    }

    private int[] countText(String inputText) {
        int wordCount = 1, lineCount =  0, charCount = 0;
        if (inputText == null)
        {
            inputText = inputText.strip();
            for (char c: inputText.toCharArray()) {
                if (Character.isWhitespace(c)) {
                    wordCount++;
                }
                if (c == '\n') {
                    lineCount++;
                }
                charCount++;
            }
        }
        return new int[]{lineCount, wordCount, charCount};
    }
}
