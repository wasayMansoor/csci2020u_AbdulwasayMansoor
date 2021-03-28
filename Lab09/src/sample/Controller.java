package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;;

public class Controller {

    private ArrayList<String> date = new ArrayList<String>();
    private ArrayList<String> open = new ArrayList<String>();
    private ArrayList<String> high = new ArrayList<String>();
    private ArrayList<String> low = new ArrayList<String>();
    private ArrayList<String> close = new ArrayList<String>();
    private ArrayList<String> adjClose = new ArrayList<String>();
    private ArrayList<String> volume = new ArrayList<String>();

    @FXML
    Canvas canvas;

    public void initialize() throws IOException{
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawLinePlot(gc, Color.BLACK);
    }

    //Reads Data
    public void data(String sURL) throws IOException {
        URL netURL = new URL(sURL);

        URLConnection conn = netURL.openConnection();
        conn.setDoOutput(false);
        conn.setDoInput(true);

        InputStream inStream = conn.getInputStream();
        Scanner s = new Scanner(inStream).useDelimiter("\\A");
        while (s.hasNextLine()){
            StringTokenizer info = new StringTokenizer(s.nextLine(),",");
            while (info.hasMoreElements()){
                date.add(info.nextToken());
                open.add(info.nextToken());
                high.add(info.nextToken());
                low.add(info.nextToken());
                close.add(info.nextToken());
                adjClose.add(info.nextToken());
                volume.add(info.nextToken());
            }
        }
    }

    //Function That Clears All Current Data
    public void clearData(){
        date.clear();
        open.clear();
        high.clear();
        low.clear();
        close.clear();
        adjClose.clear();
        volume.clear();
    }

    //Function That Initializes The Plot Then Calls PlotLine Function
    private void drawLinePlot(GraphicsContext gc, Color colour) throws IOException {
        gc.setStroke(colour);
        //Y Axis
        gc.strokeLine(50,850, 50,  50);
        //X Axis
        gc.strokeLine(50,850, 950,  850);

        //Data For Google Then Plotting Line For Google
        data("https://query1.finance.yahoo.com/v7/finance/download/GOOG?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
        plotLine(gc, close, Color.RED);

        //Clear All Data
        clearData();

        //Data For Apple Then Plotting Line For Apple
        data("https://query1.finance.yahoo.com/v7/finance/download/AAPL?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
        plotLine(gc, close, Color.BLUE);

    }

    //Function that Plot Lines
    public void plotLine(GraphicsContext gc, ArrayList<String> data, Color colour){
        gc.setStroke(colour);
        for(int i = 1; i < data.size()-1; i++){
            //double val: data
            System.out.println(data.get(i));
            gc.strokeLine(40+(i*10),850 - Double.parseDouble(data.get(i)),40+((i+1)*10),850 - Double.parseDouble(data.get(i+1)));

        }
    }

}
