package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application  {

    Stage window;
    Scene scene1, scene2, scene3;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Button button1 = new Button("Nowa gra");
        Button button2 = new Button("Ranking");
        Button button3 = new Button("Exit");

        button1.setOnAction(e -> window.setScene(scene2));
        button2.setOnAction(e -> window.setScene(scene3));
        button3.setOnAction(e -> window.close());


        Label label1 = new Label("Menu glowne");
        //layout1 - children are laid out in vert column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button2, button3);

        VBox layout2 = new VBox();

        scene1 = new Scene(layout1, 900, 500);
        scene2 = new Scene(layout2, 900, 500);

        window.setScene(scene1);
        window.setTitle("Titlwe");
        window.show();


    }


}
