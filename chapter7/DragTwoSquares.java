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

import  java.util.ArrayList;

public class DragTwoSquares extends Application {

    private final static int SIZE = 64, CANVAS_WIDTH = 720, CANVAS_HEIGHT = 540;
    private final ArrayList<Square> squares = new ArrayList<>();
    private Square currentDraggedSquare;
    private GraphicsContext g;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
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
        if (evt.isShiftDown() || evt.isSecondaryButtonDown()) {
            for (var square: squares) {
                if (square.mouseOnTop(x, y)) {
                    currentDraggedSquare = square;
                    break;
                }
            }
        } else {
            int r = (int) (Math.random() * 0xff) + 1;
            int g = (int) (Math.random() * 0xff) + 1;
            int b = (int) (Math.random() * 0xff) + 1;
            double alpha = Math.random();
            if (alpha < 0.5)
                alpha += 0.5;
            squares.add(new Square(x - SIZE/ 2.0, y - SIZE / 2.0, SIZE, Color.rgb(r, g, b, alpha)));
            repaintCanvas();
        }
    }

    private void mouseDragged(MouseEvent evt) {
        if (currentDraggedSquare != null) {
            currentDraggedSquare.x = evt.getX() - currentDraggedSquare.size / 2;
            currentDraggedSquare.y = evt.getY() - currentDraggedSquare.size / 2;
            repaintCanvas();
        }
    }

    private void mouseReleased(MouseEvent evt) {
        currentDraggedSquare = null;
    }

    private void keyPressed(KeyEvent evt) {
        KeyCode code = evt.getCode();
        if (code == KeyCode.ESCAPE) {
            int index = 0;
            for (var square: squares) {
                index++;
                if ((square.x > CANVAS_WIDTH && square.y > CANVAS_HEIGHT) || (square.x < 0 && square.y < 0)) {
                    squares.remove(index);
                    break;
                }
            }
            repaintCanvas();
        }
    }

    private void repaintCanvas() {
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 720, 540);
        for (var square: squares) {
            g.setFill(square.color);
            g.fillRect(square.x, square.y, square.size, square.size);
        }
    }

    private static class Square {
        private double x;
        private double y;
        private final Color color;
        private final double size;

        public Square(double x, double y, double size, Color color) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
        }

        /**
         * Checks if the mouse is currently on top of either of the
         * two square.
         * @param x current mouse x co-ordinate
         * @param y current mouse y co-ordinate
         * @return true if mouse is on top of the square otherwise false
         */
        private boolean mouseOnTop(double x, double y) {
            // if the x or y co-ordinate is greater than the square's width or height or
            // less than the square's width or height then the mouse is not on top of any
            // square. if not, then it is on top of either of the two square
            if (x > this.x + this.size || x < this.x || y > this.y + this.size || y < this.y)
                return false;
            return  true;
        }
    }
}
