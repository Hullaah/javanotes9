public class RandomBrighten {
    static final int ROWS = 80;
    static final int COLUMNS = 80;
    static final int SQUARE_SIZE = 5;
    static int currentRow;
    static  int currentColumn;

    public static void main(String[] args) {
        Mosaic.open(ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE);
        Mosaic.setUse3DEffect(false);
        currentColumn = COLUMNS / 2;
        currentRow = ROWS / 2;
        while (true) {
            changeColorToGreen(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(5);
        }
    }

    static  void changeColorToGreen(int currentRow, int currentColumn) {
        int currentAmountOfGreen = Mosaic.getGreen(currentRow, currentColumn);
        int newAmountOfGreen = Math.min(currentAmountOfGreen + 25, 255);
        Mosaic.setColor(currentRow, currentColumn, 0, newAmountOfGreen, 0);;
    }

    static void randomMove() {
        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = (int) (4 * Math.random());
        switch (directionNum) {
            case 0 -> { // move up
                currentRow--;
                if (currentRow < 0)   // CurrentRow is outside the mosaic;
                    currentRow = ROWS - 1;   // move it to the opposite edge.
            }
            case 1 -> {  // move right
                currentColumn++;
                if (currentColumn >= COLUMNS)
                    currentColumn = 0;
            }
            case 2 -> {  // move down
                currentRow++;
                if (currentRow >= ROWS)
                    currentRow = 0;
            }
            case 3 -> {  // move left
                currentColumn--;
                if (currentColumn < 0)
                    currentColumn = COLUMNS - 1;
            }
        }
    }
}
