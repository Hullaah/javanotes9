import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
public class Checkerboard extends Application {
    private Canvas canvas;

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(400, 400);
        GraphicsContext g = canvas.getGraphicsContext2D();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == j % 2)
                    g.setFill(Color.RED);
                else
                    g.setFill(Color.BLACK);
                g.fillRect(i * 50, j * 50, 50, 50);
            }
        }
        canvas.setOnMouseClicked(this::mouseClicked);

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void mouseClicked(MouseEvent evt) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setStroke(Color.CYAN);
        g.setLineWidth(4);

        double x = evt.getX(), y = evt.getY();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == j % 2)
                    g.setFill(Color.RED);
                else
                    g.setFill(Color.BLACK);
                g.fillRect(i * 50, j * 50, 50, 50);
                if ((x >= i * 50) && (x < (i * 50 + 50)) && (y >= j * 50) && (y < (j * 50 + 50)))
                    g.strokeRect(i * 50 + 2, j * 50 + 2, 50 - 4, 50 - 4);
            }
        }
    }
}
