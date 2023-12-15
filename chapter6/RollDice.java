import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;

public class RollDice extends Application {
    private final static int CANVAS_SIZE = 200;
    private Canvas canvas;
    private PairOfDice dice;

    private Button rollButton;

    private long startTime;

    private final AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            dice.roll();
            dice.draw(canvas, CANVAS_SIZE / 8.0, CANVAS_SIZE / 8.0);
            if ( time - startTime >= 1_000_000_000 ) {
                stop();
                rollButton.setDisable(false);
            }
        }
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(200,200,255));
        g.fillRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
        dice = new PairOfDice();
        dice.setDieSize(CANVAS_SIZE * 5 / 16.0);
        dice.draw(canvas, CANVAS_SIZE  / 8.0, CANVAS_SIZE / 8.0);

        rollButton = new Button("Roll!");
        rollButton.setMaxWidth(1000);
        rollButton.setOnAction(this::buttonClicked);

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(rollButton);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dice!");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void buttonClicked(ActionEvent evt) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(200,200,255));
        g.fillRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
        g.setLineWidth(2);
        g.setStroke(Color.BLUE);
        g.strokeRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
        startTime = System.nanoTime();
        rollButton.setDisable(true);
        timer.start();
    }
}
