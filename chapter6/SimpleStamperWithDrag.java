import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class SimpleStamperWithDrag extends Application {

    private double prevX, prevY;
    private GraphicsContext g;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(720, 540);
        g = canvas.getGraphicsContext2D();
        paintCanvas();
        canvas.setOnMousePressed(this::mousePressed);
        canvas.setOnMouseDragged(this::mouseDragged);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-color: #444; -fx-border-width: 2px");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void mousePressed(MouseEvent evt) {
        double x = evt.getX();
        double y = evt.getY();
        if (evt.isSecondaryButtonDown()) {
            paintCanvas();
        } else {
            g.setStroke(Color.BLACK);
            if (evt.isShiftDown()) {
                g.setFill(Color.BLUE);
                g.fillOval(x - 30, y - 15, 60, 30);
                g.strokeOval(x - 30, y -15, 60, 30);
            } else {
                g.setFill(Color.RED);
                g.fillRect(x -30, y - 15, 60, 30);
                g.strokeRect(x - 30, y -15, 60, 30);
            }
        }
        prevX = x;
        prevY = y;
    }

    private void mouseDragged(MouseEvent evt) {
        double x = evt.getX();
        double y = evt.getY();
        if (Math.abs(x - prevX) < 5 && Math.abs(y - prevY) < 5)
                return;
        if (evt.isSecondaryButtonDown()) {
            paintCanvas();
        } else {
            g.setStroke(Color.BLACK);
            if (evt.isShiftDown()) {
                g.setFill(Color.BLUE);
                g.fillOval(x - 30, y - 15, 60, 30);
                g.strokeOval(x - 30, y -15, 60, 30);
            } else {
                g.setFill(Color.RED);
                g.fillRect(x -30, y - 15, 60, 30);
                g.strokeRect(x - 30, y -15, 60, 30);
            }
        }
        prevX = x;
        prevY = y;
    }

    private void paintCanvas() {
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 720, 540);
    }
}