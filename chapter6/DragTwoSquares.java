import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class DragTwoSquares extends Application {

    private Square currentDraggedSquare;
    private GraphicsContext g;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(720, 540);
        g = canvas.getGraphicsContext2D();
        repaintCanvas();
        canvas.setOnMousePressed(this::mousePressed);
        canvas.setOnMouseDragged(this::mouseDragged);
        canvas.setOnMouseReleased(this::mouseReleased);

        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-color: #444; -fx-border-width: 2px");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.setOnKeyPressed(this::keyPressed);
        stage.setResizable(false);
        stage.show();
    }

    private void mousePressed(MouseEvent evt) {
        double x = evt.getX(), y = evt.getY();
        if (Square.SMALL.mouseOnTop(x, y)) {
            currentDraggedSquare = Square.SMALL;
        } else if (Square.BIG.mouseOnTop(x, y)) {
            currentDraggedSquare = Square.BIG;
        }
    }

    private void mouseDragged(MouseEvent evt) {
        if (currentDraggedSquare != null) {
            currentDraggedSquare.x = evt.getX() - currentDraggedSquare.width / 2;
            currentDraggedSquare.y = evt.getY() - currentDraggedSquare.height / 2;
            repaintCanvas();
        }
    }

    private void mouseReleased(MouseEvent evt) {
        currentDraggedSquare = null;
    }

    private void keyPressed(KeyEvent evt) {
        KeyCode code = evt.getCode();
        if (code == KeyCode.ESCAPE) {
            Square.BIG.x = 360 - 128 / 2.0;
            Square.BIG.y = 270 - 96 / 2.0;
            Square.SMALL.x = 360 - 64 / 2.0;
            Square.SMALL.y = 270 - 48 / 2.0;
            repaintCanvas();
        }
    }

    private void repaintCanvas() {
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 720, 540);
        g.setFill(Square.BIG.color);
        g.fillRect(Square.BIG.x, Square.BIG.y, Square.BIG.width, Square.BIG.height);
        g.setFill(Square.SMALL.color);
        g.fillRect(Square.SMALL.x, Square.SMALL.y, Square.SMALL.width, Square.SMALL.height);
    }

    private enum Square {
        BIG(360 - 128 / 2.0, 270 - 96 / 2.0, 128, 96, Color.RED),
        SMALL(360 - 64 / 2.0, 270 - 48 / 2.0, 64, 48, Color.BLUE);

        private double x;
        private double y;
        private final Color color;
        private final double width;
        private  final double height;

        Square(double x, double y, double width, double height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        private boolean mouseOnTop(double x, double y) {
            double x2 = this.x + this.width;
            double y2 = this.y + this.height;
            if (x > x2 || x < this.x || y > y2 || y < this.y)
                return false;
            return  true;
        }
    }
}
