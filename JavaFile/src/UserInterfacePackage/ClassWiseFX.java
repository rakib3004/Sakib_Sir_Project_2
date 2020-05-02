package UserInterfacePackage;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ClassWiseFX extends Application {
    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    @Override
    public void start(Stage primaryStage) throws Exception{



        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);


        Button back = new Button("Back");
        Button exit = new Button("Exit");


        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);



        back.setOnAction(actionEvent -> {
            ChooseType chooseType = new ChooseType();

            try {
                chooseType.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);

        });
        setStyle(exit);
        setStyle(back);

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);




        MenuItem uponnash = new MenuItem("Uponnash");


        uponnash.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("");


            } });


        MenuItem kobita = new MenuItem("Kobita");

        kobita.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                System.out.println(""); }
        });

        MenuItem rochonaboli = new MenuItem("Rochonaboli");
        rochonaboli.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); }
        });
        MenuItem religion = new MenuItem("Religion");
        religion.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); }
        });


        MenuItem biggan = new MenuItem("Biggan");
        biggan.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); } });

        MenuItem sciFi = new MenuItem("Sci Fi");
        sciFi.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); }
        });

        MenuItem shishuShahitto = new MenuItem("Shishu Shahitto");
        shishuShahitto.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); }
        });
        


        MenuItem kisoreUponnash = new MenuItem("Kisore Uponnash");
        kisoreUponnash.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); } });
        MenuItem biography = new MenuItem("Biography");
        biography.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); }
        });

        MenuItem gobesona = new MenuItem("Gobesona");
        gobesona.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); }
        });
        MenuItem onubad = new MenuItem("Onubad");

        onubad.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); }
        });
        MenuItem others = new MenuItem("Others");
        others.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(""); }
        });
        MenuButton bsse = new MenuButton("Select");
        bsse.getItems().addAll( uponnash, kobita, rochonaboli, religion,
                biggan, sciFi, shishuShahitto, kisoreUponnash,biography,
                gobesona, onubad,others);


bsse.setTranslateX(500);
bsse.setTranslateY(350);
bsse.setPrefSize(200, 50);


        Image image = new Image("libraryBackground6.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,bsse);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }


    public void showInfo(Stage secondaryStage){
        

    }






    public Button setStyle( Button button)
    {
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  button;
    }
}