package VisualRepresentation;

import BookDataBaseFX.*;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.PriorityData;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoPieChart extends Application  {


    PriorityData[] priorityData;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    @Override
    public void start(Stage primaryStage) {

    }


    public void startTypeBook(Stage primaryStage) throws IOException {



        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            TypesOfBookFX typesOfBookFX = new TypesOfBookFX();
            try {
                typesOfBookFX.start(primaryStage);
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






        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();


        String uponnashType,kobitaType,rochonaBoliType,
                religionType,bigganType,sciFicType,shisuSahittoType,kisoreUponnashType,onubadType,othersType;


        int uponnashTypeNO,kobitaTypeNO,rochonaBoliTypeNO,
                religionTypeNO,bigganTypeNO,sciFicTypeNO,shisuSahittoTypeNO,kisoreUponnashTypeNO,onubadTypeNO,othersTypeNO;

        uponnashTypeNO=0;kobitaTypeNO=0;rochonaBoliTypeNO=0;
        religionTypeNO=0;bigganTypeNO=0;sciFicTypeNO=0;
        shisuSahittoTypeNO=0; kisoreUponnashTypeNO=0;
        onubadTypeNO=0;othersTypeNO=0;

        uponnashType="Uponnash";
        kobitaType = "Kobita";
        rochonaBoliType = "Rochhona Boli";
        religionType= "Religion";
        bigganType = "Biggan";
        sciFicType = "Science Fiction";
        shisuSahittoType = "SHishu Sahitto";
        kisoreUponnashType = "Kisore";
        onubadType = "Onubad";
        othersType= "Others";


        int [] typeCounter = new int[6];

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0,2).equals("01")) {
                uponnashTypeNO++;

            } else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("05")) {
                rochonaBoliTypeNO++;

            } else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("02")) {
                kobitaTypeNO++;

            }else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("13")) {
                bigganTypeNO++;

            }else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("14")) {
                bigganTypeNO++;

            }else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("06")) {
                sciFicTypeNO++;

            } else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("10")) {
                kisoreUponnashTypeNO++;

            }  else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("11")) {
                shisuSahittoTypeNO++;

            }else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("04")) {
                religionTypeNO++;

            }  else {
                othersTypeNO++;

            }
        }






        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data(uponnashType,uponnashTypeNO);
        PieChart.Data slice2 = new PieChart.Data(kobitaType,kobitaTypeNO);
        PieChart.Data slice3 = new PieChart.Data(rochonaBoliType,rochonaBoliTypeNO);
        PieChart.Data slice4 = new PieChart.Data(religionType,religionTypeNO);
        PieChart.Data slice5= new PieChart.Data(bigganType,bigganTypeNO);
        PieChart.Data slice6 = new PieChart.Data(sciFicType,sciFicTypeNO);
        PieChart.Data slice7 = new PieChart.Data(shisuSahittoType,shisuSahittoTypeNO);
        PieChart.Data slice8 = new PieChart.Data(kisoreUponnashType,kisoreUponnashTypeNO);
        PieChart.Data slice9 = new PieChart.Data(onubadType,onubadTypeNO);
        PieChart.Data slice10 = new PieChart.Data(othersType,othersTypeNO);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
        pieChart.getData().add(slice6);
        pieChart.getData().add(slice7);
        pieChart.getData().add(slice8);
        pieChart.getData().add(slice9);
        pieChart.getData().add(slice10);


        pieChart.setTranslateX(55);
        pieChart.setTranslateY(55);
        pieChart.setPrefSize(590,590);

        HBox hBox1 = new HBox(pieChart,back,exit);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground14.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startDemandBook(Stage primaryStage) throws IOException {


        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            DemandsOfBookFX demandsOfBookFX = new DemandsOfBookFX();

            try {
                demandsOfBookFX.start(primaryStage);
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



        String below4,over4,over7,over10,over15,over20,over25,over30;
        int  below4Count,over4Count,over7Count,over10Count,over15Count,
                over20Count,over25Count,over30Count;


        below4Count=0;over4Count=0;over7Count=0;over10Count=0;
        over15Count=0;over20Count=0;over25Count=0;over30Count=0;

        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();

        for(iterator=0;iterator<numberOfBooks;iterator++){



            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=30.0){
                over30Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=25.0){
                over25Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=20.0){
                over20Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=15.0){
                over15Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=10.0){
                over10Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=7.0){
                over7Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=4.0){
                over4Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>4.0){
                below4Count++;
            }


        }



        below4 =  "0-3" ;
        over4 =  "4-6" ; over7 =  "7-9" ; over10 =  "10-14" ;
        over15=   "15-19" ;over20 =  "20-24" ; over25 =  "25-29" ;
        over30 =  "30+" ;




        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data(below4,below4Count);
        PieChart.Data slice2 = new PieChart.Data(over4,over4Count);
        PieChart.Data slice3 = new PieChart.Data(over7,over7Count);
        PieChart.Data slice4 = new PieChart.Data(over10,over10Count);
        PieChart.Data slice5 = new PieChart.Data(over15,over15Count);
        PieChart.Data slice6 = new PieChart.Data(over20,over20Count);
        PieChart.Data slice7 = new PieChart.Data(over25,over25Count);
        PieChart.Data slice8 = new PieChart.Data(over30,over30Count);


        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
        pieChart.getData().add(slice6);
        pieChart.getData().add(slice7);
        pieChart.getData().add(slice8);


        pieChart.setTranslateX(55);
        pieChart.setTranslateY(55);
        pieChart.setPrefSize(590,590);

        HBox hBox1 = new HBox(pieChart,back,exit);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();


    }

    public void startGenericBook(Stage primaryStage) throws IOException {


        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            GenericsOfBookFX genericsOfBookFX = new GenericsOfBookFX();
            try {
                genericsOfBookFX.start(primaryStage);
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


        String year2008,year2009,year2010,year2011,year2012,year2013,year2014,year2015,year2016,year2017;
        int  year2008Books,year2009Books,year2010Books,year2011Books,year2012Books,
                year2013Books,year2014Books,year2015Books,year2016Books,year2017Books;
year2008Books=0;year2009Books=0;year2010Books=0;year2011Books=0;
year2012Books=0;year2013Books=0;year2014Books=0;year2015Books=0;
year2016Books=0;year2017Books=0;

        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();

        for(iterator=0;iterator<numberOfBooks;iterator++){
            
if(priorityData[iterator].bookData.bookId.contains("17")){
    year2017Books++;
}
else if(priorityData[iterator].bookData.bookId.contains("16")){
    year2016Books++;
}else if(priorityData[iterator].bookData.bookId.contains("15")){
    year2015Books++;
}else if(priorityData[iterator].bookData.bookId.contains("14")){
    year2014Books++;
}else if(priorityData[iterator].bookData.bookId.contains("13")){
    year2013Books++;
}else if(priorityData[iterator].bookData.bookId.contains("0812")){
    year2012Books++;
}else if(priorityData[iterator].bookData.bookId.contains("0212")){
    year2012Books++;
}else if(priorityData[iterator].bookData.bookId.contains("1211")){
    year2011Books++;
}else if(priorityData[iterator].bookData.bookId.contains("0311")){
    year2011Books++;
}else if(priorityData[iterator].bookData.bookId.contains("1210")){
    year2010Books++;
}else if(priorityData[iterator].bookData.bookId.contains("0810")){
    year2010Books++;
}else if(priorityData[iterator].bookData.bookId.contains("0410")){
    year2010Books++;
}else if(priorityData[iterator].bookData.bookId.contains("1009")){
    year2009Books++;
}else if(priorityData[iterator].bookData.bookId.contains("0409")){
    year2009Books++;
}else if(priorityData[iterator].bookData.bookId.contains("1208")){
    year2008Books++;
}else if(priorityData[iterator].bookData.bookId.contains("0608")){
    year2008Books++;
}
        }



        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;





        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data(year2008,year2008Books);
        PieChart.Data slice2 = new PieChart.Data(year2009,year2009Books);
        PieChart.Data slice3 = new PieChart.Data(year2010,year2010Books);
        PieChart.Data slice4 = new PieChart.Data(year2011,year2011Books);
        PieChart.Data slice5 = new PieChart.Data(year2012,year2012Books);
        PieChart.Data slice6 = new PieChart.Data(year2013,year2013Books);
        PieChart.Data slice7 = new PieChart.Data(year2014,year2014Books);
        PieChart.Data slice8 = new PieChart.Data(year2015,year2015Books);
        PieChart.Data slice9 = new PieChart.Data(year2016,year2016Books);
        PieChart.Data slice10 = new PieChart.Data(year2017,year2017Books);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
        pieChart.getData().add(slice6);
        pieChart.getData().add(slice7);
        pieChart.getData().add(slice8);
        pieChart.getData().add(slice9);
        pieChart.getData().add(slice10);


        pieChart.setTranslateX(55);
        pieChart.setTranslateY(55);
        pieChart.setPrefSize(500,500);

        HBox hBox1 = new HBox(pieChart,back,exit);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();



    }

    public void startClassBook(Stage primaryStage) throws IOException {


        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            ClassesOfBookFX classesOfBookFX = new ClassesOfBookFX();
            try {
                classesOfBookFX.start(primaryStage);
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


        String year2008,year2009,year2010,year2011,year2012,year2013,year2014,year2015,year2016,year2017;
        int  year2008Books,year2009Books,year2010Books,year2011Books,year2012Books,
                year2013Books,year2014Books,year2015Books,year2016Books,year2017Books;
        year2008Books=0;year2009Books=0;year2010Books=0;year2011Books=0;
        year2012Books=0;year2013Books=0;year2014Books=0;year2015Books=0;
        year2016Books=0;year2017Books=0;

        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();

        for(iterator=0;iterator<numberOfBooks;iterator++){

            if(priorityData[iterator].bookData.bookId.contains("17")){
                year2017Books++;
            }
            else if(priorityData[iterator].bookData.bookId.contains("16")){
                year2016Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("15")){
                year2015Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("14")){
                year2014Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("13")){
                year2013Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0812")){
                year2012Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0212")){
                year2012Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1211")){
                year2011Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0311")){
                year2011Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1210")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0810")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0410")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1009")){
                year2009Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0409")){
                year2009Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1208")){
                year2008Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0608")){
                year2008Books++;
            }
        }



        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;





        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data(year2008,year2008Books);
        PieChart.Data slice2 = new PieChart.Data(year2009,year2009Books);
        PieChart.Data slice3 = new PieChart.Data(year2010,year2010Books);
        PieChart.Data slice4 = new PieChart.Data(year2011,year2011Books);
        PieChart.Data slice5 = new PieChart.Data(year2012,year2012Books);
        PieChart.Data slice6 = new PieChart.Data(year2013,year2013Books);
        PieChart.Data slice7 = new PieChart.Data(year2014,year2014Books);
        PieChart.Data slice8 = new PieChart.Data(year2015,year2015Books);
        PieChart.Data slice9 = new PieChart.Data(year2016,year2016Books);
        PieChart.Data slice10 = new PieChart.Data(year2017,year2017Books);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
        pieChart.getData().add(slice6);
        pieChart.getData().add(slice7);
        pieChart.getData().add(slice8);
        pieChart.getData().add(slice9);
        pieChart.getData().add(slice10);


        pieChart.setTranslateX(55);
        pieChart.setTranslateY(55);
        pieChart.setPrefSize(500,500);

        HBox hBox1 = new HBox(pieChart,back,exit);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();


    }

    public void startBorrowCount(Stage primaryStage) throws IOException {


        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            BorrrowCountOfBookFX borrrowCountOfBookFX = new BorrrowCountOfBookFX();
            try {
                borrrowCountOfBookFX.start(primaryStage);
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


        String year2008,year2009,year2010,year2011,year2012,year2013,year2014,year2015,year2016,year2017;
        int  year2008Books,year2009Books,year2010Books,year2011Books,year2012Books,
                year2013Books,year2014Books,year2015Books,year2016Books,year2017Books;
        year2008Books=0;year2009Books=0;year2010Books=0;year2011Books=0;
        year2012Books=0;year2013Books=0;year2014Books=0;year2015Books=0;
        year2016Books=0;year2017Books=0;

        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();

        for(iterator=0;iterator<numberOfBooks;iterator++){

            if(priorityData[iterator].bookData.bookId.contains("17")){
                year2017Books++;
            }
            else if(priorityData[iterator].bookData.bookId.contains("16")){
                year2016Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("15")){
                year2015Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("14")){
                year2014Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("13")){
                year2013Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0812")){
                year2012Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0212")){
                year2012Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1211")){
                year2011Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0311")){
                year2011Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1210")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0810")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0410")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1009")){
                year2009Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0409")){
                year2009Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1208")){
                year2008Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0608")){
                year2008Books++;
            }
        }



        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;





        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data(year2008,year2008Books);
        PieChart.Data slice2 = new PieChart.Data(year2009,year2009Books);
        PieChart.Data slice3 = new PieChart.Data(year2010,year2010Books);
        PieChart.Data slice4 = new PieChart.Data(year2011,year2011Books);
        PieChart.Data slice5 = new PieChart.Data(year2012,year2012Books);
        PieChart.Data slice6 = new PieChart.Data(year2013,year2013Books);
        PieChart.Data slice7 = new PieChart.Data(year2014,year2014Books);
        PieChart.Data slice8 = new PieChart.Data(year2015,year2015Books);
        PieChart.Data slice9 = new PieChart.Data(year2016,year2016Books);
        PieChart.Data slice10 = new PieChart.Data(year2017,year2017Books);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
        pieChart.getData().add(slice6);
        pieChart.getData().add(slice7);
        pieChart.getData().add(slice8);
        pieChart.getData().add(slice9);
        pieChart.getData().add(slice10);


        pieChart.setTranslateX(55);
        pieChart.setTranslateY(55);
        pieChart.setPrefSize(500,500);

        HBox hBox1 = new HBox(pieChart,back,exit);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
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
