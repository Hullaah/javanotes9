import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * A PairOfDice object represents an ordinary pair of six-sided dice.
 */
public class PairOfDice {

    private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.
    private double dieSize;

    public PairOfDice() {
            // Constructor.  Rolls the dice, so that they initially
            // show some random values.
        roll();  // Call the roll() method to roll the dice.
    }

    public PairOfDice(int val1, int val2) {
        // Constructor.  Creates a pair of dice that
        // are initially showing the values val1 and val2.
        die1 = val1;  // Assign specified values
        die2 = val2;  //            to the instance variables.
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public void setDieSize(double dieSize) {
        this.dieSize = dieSize;
    }

    public void roll() {
            // Roll the dice by setting each of the dice to be
            // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }

    public String toString() {
        return String.format("PairOfDice{%d, %d}", die1, die2);
    }

    public int getTotal() {
        return  die1 + die2;
    }

    public void draw(Canvas canvas, double x, double y) {
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();
        draw(canvas, x, y, die1);
        draw(canvas, canvasWidth - x - dieSize, canvasHeight - y - dieSize, die2);
    }

    private void draw(Canvas canvas, double x, double y, int die) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        double dotSize = dieSize / 4;
        double dotX, dotY;
        g.setLineWidth(2);
        g.setStroke(Color.BLACK);
        g.strokeRect(x, y, dieSize, dieSize);
        g.setFill(Color.WHITE);
        g.fillRect(x, y, dieSize, dieSize);
        g.setFill(Color.BLACK);
        switch (die) {
            case 1 -> {
                dotX = dotY = x + dieSize / 2;
                g.fillOval(dotX - dotSize / 2, dotY - dotSize / 2, dotSize, dotSize);
            }
            case 2 -> {
                dotX = dotY = x + dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = dotY = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
            }
            case 3 -> {
                dotX = dotY = x + dieSize / 2;
                g.fillOval(dotX - dotSize / 2, dotY - dotSize / 2, dotSize, dotSize);
                dotX = dotY = x + dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = dotY = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
            }
            case 4 -> {
                dotX = dotY = x + dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = dotY = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotY = x + dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = dotY;
                dotY = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
            }
            case 5 -> {
                dotX = dotY = x + dieSize / 2;
                g.fillOval(dotX - dotSize / 2, dotY - dotSize / 2, dotSize, dotSize);
                dotX = dotY = x + dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = dotY = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotY = x + dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = dotY;
                dotY = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
            }
            case 6 -> {
                dotX = dotY = x + dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = dotY = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotY = x + dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = dotY;
                dotY = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotY = x + dieSize / 2.8;
                g.fillOval(dotX, dotY, dotSize, dotSize);
                dotX = x + dieSize - dotSize - dieSize / 16;
                g.fillOval(dotX, dotY, dotSize, dotSize);
            }
        }
    }
} // end class PairOfDice
