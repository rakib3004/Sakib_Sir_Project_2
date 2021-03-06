package ProjectDescription;

import FilePackage.DateTimeWriter;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Phase1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Button back = new Button("Back");
        Button next = new Button("Next");
        back.setTranslateX(0);
        back.setTranslateY(650);
        next.setTranslateX(1100);
        next.setTranslateY(650);

         back.setOnAction(actionEvent -> {
            StaticStage staticStage = new StaticStage();
            try {
                staticStage.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        next.setOnAction(actionEvent -> {
            Phase1 phase1 = new Phase1();
            try {
                phase1.start2(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });




        setStyle(next);
        setStyle(back);


        back.setPrefSize(200, 80);
        next.setPrefSize(200, 80);


        Image image = new Image("Slide3.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,next,back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    public void start2(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button next = new Button("Next");
        back.setTranslateX(0);
        back.setTranslateY(650);
        next.setTranslateX(1100);
        next.setTranslateY(650);



        back.setOnAction(actionEvent -> {
            About about = new About();

            try {
                about.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        next.setOnAction(actionEvent -> {
            Phase1 phase1 = new Phase1();
            try {
                phase1.start3(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });




        setStyle(next);
        setStyle(back);


        back.setPrefSize(200, 80);
        next.setPrefSize(200, 80);


        Image image = new Image("Slide4.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,next,back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
    public void start3(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button next = new Button("Next");
        back.setTranslateX(0);
        back.setTranslateY(650);
        next.setTranslateX(1100);
        next.setTranslateY(650);



        back.setOnAction(actionEvent -> {
            Phase1 phase1 = new Phase1();
            try {
                phase1.start2(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        next.setOnAction(actionEvent -> {
            Phase1 phase1 = new Phase1();
            try {
                phase1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });




        setStyle(next);
        setStyle(back);


        back.setPrefSize(200, 80);
        next.setPrefSize(200, 80);


        Image image = new Image("Slide5.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,next,back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }


    public Button setStyle(Button button)
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
