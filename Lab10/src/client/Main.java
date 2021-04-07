package client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        Socket socket = new Socket("127.0.0.1 ", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        primaryStage.setTitle("SimpleBBS Client v1.0");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);

        Label userNameL = new Label("Username:");
        grid.add(userNameL, 0, 0);

        TextField userTF = new TextField();
        grid.add(userTF, 1, 0);

        Label messageL = new Label("Message:");
        grid.add(messageL, 0, 1);

        TextField messageF = new TextField();
        grid.add(messageF, 1, 1);

        Button sendB = new Button("Send");
        grid.add(sendB, 0, 2);
        sendB.setOnAction(event -> {

            String message = userTF.getText() + ": " + messageF.getText();
            System.out.println("Send: " + message);

            out.println(message);
            out.flush();

        });

        Button exitB = new Button("Exit");
        grid.add(exitB, 0, 3);

        exitB.setOnAction(event -> {
            System.exit(0);
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
