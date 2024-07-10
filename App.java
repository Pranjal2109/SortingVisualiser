package sorting.sortingvisualizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Visualizer visualizer;

    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        inputField.setPromptText("Enter numbers separated by commas");

        Button sortButton = new Button("Sort");
        Canvas canvas = new Canvas(400, 300);

        visualizer = new Visualizer(canvas);

        VBox root = new VBox(10, inputField, sortButton, canvas);
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Sorting Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();

        sortButton.setOnAction(e -> {
            String input = inputField.getText();
            String[] numberStrings = input.split(",");
            int[] array = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                array[i] = Integer.parseInt(numberStrings[i].trim());
            }
            int[] sortedArray = mergeSort(array);
            visualizer.drawArray(sortedArray);
        });
    }

    private int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        return merge(array, left, right);
    }

    private int[] merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
