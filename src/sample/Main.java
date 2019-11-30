package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application  {

    Stage window;                   //główne okienko
    Scene scene1, scene2, scene3;   //trzy opcje do wejścia z menu

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setResizable(false);

        Label label1 = new Label("Menu glowne");
        Button button1 = new Button("Nowa gra");
        Button button2 = new Button("Ranking");
        Button button3 = new Button("Exit");


        VBox layout1 = new VBox(30);        //vbox na przyciski zeby były na sroko
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(label1, button1, button2, button3);

        Canvas canvas = new Canvas(800,495);    //canvas do rysowania
        var context = canvas.getGraphicsContext2D();
        context.setLineWidth(5);
        context.setStroke(Color.WHITE);
        context.strokeLine(220, 429, 348,69);   //
        context.strokeLine(505, 429, 348,69);   //rysowanie literki A na poczatku
        context.strokeLine(268, 265, 437,265);  //



        VBox layout2 = new VBox(5);             //vbox na canvas i dolne menu w oknie do rozgrywki
        layout2.getChildren().add(getHBox1(canvas));
        layout2.getChildren().add(getHBox2(canvas));
        layout2.setStyle("-fx-background-color: green");


        scene1 = new Scene(layout1, 800, 530);
        scene2 = new Scene(layout2, 800, 530);

        button1.setOnAction(e -> {window.setScene(scene2); /*context.clearRect(0, 0, 800, 495);*/});
        //button2.setOnAction(e -> window.setScene(scene3));
        button3.setOnAction(e -> window.close());


        window.setScene(scene1);
        window.setTitle("Draw that thing");
        window.show();

    }
    public HBox getHBox1(Canvas canvas){        //tutej cały algorytm do rysowania na canvasie
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(20);
        gc.setStroke(Color.BLACK);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e->{
            gc.beginPath();
            gc.lineTo(e.getSceneX(), e.getSceneY());
            gc.stroke();
        } );
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e->{
            gc.lineTo(e.getSceneX(), e.getSceneY());
            gc.stroke();
        } );

        HBox hBox = new HBox();
        hBox.getChildren().add(canvas);
        hBox.setStyle("-fx-background-color: #5fa9ff");

        //SnapshotParameters params = new SnapshotParameters();        //
        //params.setFill(Color.TRANSPARENT);                           //tu jest ta konwersja (nie działa) canvasa do img
        //Image snapshot = canvas.snapshot(params, null);              //
        //snapshot.getPixelReader().getArgb();                         //
        return hBox;
    }
    public HBox getHBox2(Canvas canvas){                //a to jest se menu dolne w okienku rozgrywki
        var context = canvas.getGraphicsContext2D();
        Button button4 = new Button("Menu");

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        button4.setOnAction(e-> {window.setScene(scene1); context.clearRect(0, 0, 800, 495);});
        //hBox.setSpacing(10);
        hBox.getChildren().add(button4);
        return hBox;
    }

// no i plan prezentacji
}
