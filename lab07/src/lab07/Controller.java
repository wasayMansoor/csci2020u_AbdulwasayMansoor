package lab07;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.io.*;
import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {
    //PieChart
    private static Color[] pieColours =
            { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};

    //map
    private Map<String, Integer> map;


    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawPieChart(gc, map);
    }

    private void loadData(String filename) {
        try {
            Scanner scanner = new Scanner(new FileReader(new File(filename)));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String columns[] = line.split(",");
                if (columns.length >= 6) {
                    String field = columns[5].trim();
                    if (map.containsKey(field)) {
                        int count = map.get(field);
                        count += 1;
                        map.put(field, count);
                    } else {
                        map.put(field, 1);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    

    private void drawPieChart(GraphicsContext gc, Map<String, Integer> map) {
        map = new HashMap<>();
        loadData("weatherwarnings-2015.csv");
        int numOfAgeGroups = 0;
        for (int i = 0; i < map.size(); i++) {
            numOfAgeGroups += 1;
        }
        System.out.println("debug");

        double startAngle = 0.0;
        for (int i = 0; i < map.size(); i++) {
            double slicePercentage = (double) map.get(i) / (double) numOfAgeGroups;
            double sweepAngle = slicePercentage * 360.0;

            gc.setFill(pieColours[i]);
            gc.fillArc(500, 150, 300, 300, startAngle, sweepAngle, ArcType.ROUND);

            startAngle += sweepAngle;
        }
    }


}
