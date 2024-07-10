package sorting.sortingvisualizer;


import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Visualizer {

    private Canvas canvas;

    public Visualizer(Canvas canvas) {
        this.canvas = canvas;
    }

    public void drawArray(int[] array) {
        Platform.runLater(() -> {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            double width = canvas.getWidth() / array.length;
            for (int i = 0; i < array.length; i++) {
                double height = array[i] * 10;
                gc.setFill(Color.BLUE);
                gc.fillRect(i * width, canvas.getHeight() - height, width, height);
            }
        });
    }
}
