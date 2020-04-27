package VisualRepresentation;
import BookDataBaseFX.*;
import InfoDisplay.UIDisplayFX;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.PriorityData;
import Regression.newVersion.TypeCountRegression;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StackedAreaFX extends Application {

    PriorityData[] priorityData;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    SevenValueCalculation sevenValueCalculation = new SevenValueCalculation();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();


    @Override
    public void start(Stage primaryStage) {

    }

    public void startTyping(Stage primaryStage) throws IOException {
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            UIDisplayFX uiDisplayFX = new UIDisplayFX();
            try {
                uiDisplayFX.typeStatistics(primaryStage);
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
        priorityData =    multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);


        String uponnashType,kobitaType,rochonaBoliType,
                religionType,bigganType,sciFicType,shisuSahittoType,kisoreUponnashType,onubadType,othersType;




        double [] uponnashTypeNO= new double[7] ;
        double []kobitaTypeNO= new double[7] ;
        double []rochonaBoliTypeNO= new double[7] ;
        double []  religionTypeNO= new double[7] ;
        double []bigganTypeNO= new double[7] ;
        double []sciFicTypeNO= new double[7] ;
        double []shisuSahittoTypeNO= new double[7] ;
        double []  kisoreUponnashTypeNO= new double[7] ;
        double []onubadTypeNO= new double[7] ;
        double []othersTypeNO = new double[7];

        uponnashType="Minimum Value";
        kobitaType = "Lower Adjacent Value";
        rochonaBoliType = "First Quartile Value";
        religionType= "Median";
        bigganType = "Third Quartile Value";
        sciFicType = "Upper Adjacent Value";
        shisuSahittoType = "Maximum Value";



        List<Double> list = new ArrayList<>();


        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0,2).equals("01")) {
                //   uponnashTypeNO++;
                list.add(priorityData[iterator].getMLRweight());

            }

            int sizeB = list.size();
            if(sizeB>7){
                uponnashTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }

        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0,2).equals("05")) {
                //    rochonaBoliTypeNO++;

                list.add(priorityData[iterator].getMLRweight());

            }
            int sizeB = list.size();
            if(sizeB>7){
                rochonaBoliTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }

        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("02")) {
            //    kobitaTypeNO++;

            list.add(priorityData[iterator].getMLRweight());

        }
            int sizeB = list.size();
            if(sizeB>7){
                kobitaTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }

        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("13")) {
            //  bigganTypeNO++;

            list.add(priorityData[iterator].getMLRweight());

        }

        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("14")) {
            //   bigganTypeNO++;

            list.add(priorityData[iterator].getMLRweight());

        }
            int sizeB = list.size();
            if(sizeB>7){
                bigganTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }


        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("06")) {
            //   sciFicTypeNO++;

            list.add(priorityData[iterator].getMLRweight());

        }

            int sizeB = list.size();
            if(sizeB>7){
                sciFicTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }


        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("10")) {
            //  kisoreUponnashTypeNO++;

        }  } for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("11")) {
            //  shisuSahittoTypeNO++;

            list.add(priorityData[iterator].getMLRweight());

        }


            int sizeB = list.size();
            if(sizeB>7){
                shisuSahittoTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }


        }
        list.clear();for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("08")) {
            // onubadTypeNO++;

            list.add(priorityData[iterator].getMLRweight());

        }

            int sizeB = list.size();
            if(sizeB>7){

                onubadTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);

            }


        }
        list.clear();for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("12")) {
            //  onubadTypeNO++;

            list.add(priorityData[iterator].getMLRweight());

        }

            int sizeB = list.size();
            if(sizeB>7){
                onubadTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);


            }


        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0,2).equals("04")) {
                //     religionTypeNO++;

                list.add(priorityData[iterator].getMLRweight());

            }

            int sizeB = list.size();
            if(sizeB>7){
                religionTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);

            }


        }for (iterator = 0; iterator < numberOfBooks; iterator++) { {
            //   othersTypeNO++;

        }
        }


        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Types");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");

        StackedAreaChart StackedAreaChart = new StackedAreaChart(categoryAxis,numberAxis);


        XYChart.Series series = new XYChart.Series();
        series.setName(uponnashType);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(kobitaType);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(rochonaBoliType);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(religionType);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(bigganType);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(sciFicType);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(shisuSahittoType);





        series.getData().add(new XYChart.Data(uponnashType,uponnashTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,kobitaTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,rochonaBoliTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,religionTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,bigganTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,sciFicTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,shisuSahittoTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,kisoreUponnashTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,onubadTypeNO[0]));
        series.getData().add(new XYChart.Data(uponnashType,othersTypeNO[0]));



        series1.getData().add(new XYChart.Data(kobitaType,uponnashTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,kobitaTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,rochonaBoliTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,religionTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,bigganTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,sciFicTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,shisuSahittoTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,kisoreUponnashTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,onubadTypeNO[1]));
        series1.getData().add(new XYChart.Data(kobitaType,othersTypeNO[1]));



        series1.getData().add(new XYChart.Data(rochonaBoliType,uponnashTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,kobitaTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,rochonaBoliTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,religionTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,bigganTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,sciFicTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,shisuSahittoTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,kisoreUponnashTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,onubadTypeNO[2]));
        series1.getData().add(new XYChart.Data(rochonaBoliType,othersTypeNO[2]));





        series1.getData().add(new XYChart.Data(religionType,uponnashTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,kobitaTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,rochonaBoliTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,religionTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,bigganTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,sciFicTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,shisuSahittoTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,kisoreUponnashTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,onubadTypeNO[3]));
        series1.getData().add(new XYChart.Data(religionType,othersTypeNO[3]));



        series1.getData().add(new XYChart.Data(bigganType,uponnashTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,kobitaTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,rochonaBoliTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,religionTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,bigganTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,sciFicTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,shisuSahittoTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,kisoreUponnashTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,onubadTypeNO[4]));
        series1.getData().add(new XYChart.Data(bigganType,othersTypeNO[4]));



        series1.getData().add(new XYChart.Data(sciFicType,uponnashTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,kobitaTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,rochonaBoliTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,religionTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,bigganTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,sciFicTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,shisuSahittoTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,kisoreUponnashTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,onubadTypeNO[5]));
        series1.getData().add(new XYChart.Data(sciFicType,othersTypeNO[5]));



        series1.getData().add(new XYChart.Data(shisuSahittoType,uponnashTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,kobitaTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,rochonaBoliTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,religionTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,bigganTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,sciFicTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,shisuSahittoTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,kisoreUponnashTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,onubadTypeNO[6]));
        series1.getData().add(new XYChart.Data(shisuSahittoType,othersTypeNO[6]));



        StackedAreaChart.getData().add(series);
        StackedAreaChart.getData().add(series1);
        StackedAreaChart.getData().add(series2);
        StackedAreaChart.getData().add(series3);
        StackedAreaChart.getData().add(series4);
        StackedAreaChart.getData().add(series5);
        StackedAreaChart.getData().add(series6);



        StackedAreaChart.setTranslateX(65);
        StackedAreaChart.setTranslateY(55);
        StackedAreaChart.setPrefSize(1000,700);




        HBox hBox1 = new HBox(StackedAreaChart,exit,back);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


      /*  Image background = new Image("libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);*/

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();




    }

    public void startTiming(Stage primaryStage) throws IOException {


        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            UIDisplayFX uiDisplayFX = new UIDisplayFX();
            try {
                uiDisplayFX.timeStatistics(primaryStage);
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


        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Generics of Book Bar Chart");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Generics of Book");

        StackedAreaChart StackedAreaChart = new StackedAreaChart(categoryAxis,numberAxis);


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
            } for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("16")){
                year2016Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("15")){
                year2015Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("14")){
                year2014Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("13")){
                year2013Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("0812")){
                year2012Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("0212")){
                year2012Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("1211")){
                year2011Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("0311")){
                year2011Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("1210")){
                year2010Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("0810")){
                year2010Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("0410")){
                year2010Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("1009")){
                year2009Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("0409")){
                year2009Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("1208")){
                year2008Books++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(priorityData[iterator].bookData.bookId.contains("0608")){
                year2008Books++;
            }


        }

        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;



        XYChart.Series series1 = new XYChart.Series();
        series1.setName(year2008);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(year2009);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(year2010);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(year2011);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(year2012);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(year2013);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(year2014);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(year2015);
        XYChart.Series series9 = new XYChart.Series();
        series9.setName(year2016);
        XYChart.Series series10 = new XYChart.Series();
        series9.setName(year2017);




        series1.getData().add(new XYChart.Data(year2008,year2008Books));
        series2.getData().add(new XYChart.Data(year2009,year2009Books));
        series3.getData().add(new XYChart.Data(year2010,year2010Books));
        series4.getData().add(new XYChart.Data(year2011,year2011Books));
        series5.getData().add(new XYChart.Data(year2012,year2012Books));
        series6.getData().add(new XYChart.Data(year2013,year2013Books));
        series7.getData().add(new XYChart.Data(year2014,year2014Books));
        series8.getData().add(new XYChart.Data(year2015,year2015Books));
        series9.getData().add(new XYChart.Data(year2016,year2016Books));
        series10.getData().add(new XYChart.Data(year2017,year2017Books));


        StackedAreaChart.getData().add(series1);
        StackedAreaChart.getData().add(series2);
        StackedAreaChart.getData().add(series3);
        StackedAreaChart.getData().add(series4);
        StackedAreaChart.getData().add(series5);
        StackedAreaChart.getData().add(series6);
        StackedAreaChart.getData().add(series7);
        StackedAreaChart.getData().add(series8);
        StackedAreaChart.getData().add(series9);
        StackedAreaChart.getData().add(series10);



        StackedAreaChart.setTranslateX(65);
        StackedAreaChart.setTranslateY(55);
        StackedAreaChart.setPrefSize(1000,700);




        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;




        series1.getData().add(new XYChart.Data(year2008,year2008Books));
        series1.getData().add(new XYChart.Data(year2009,year2009Books));
        series1.getData().add(new XYChart.Data(year2010,year2010Books));
        series1.getData().add(new XYChart.Data(year2011,year2011Books));
        series1.getData().add(new XYChart.Data(year2012,year2012Books));
        series1.getData().add(new XYChart.Data(year2013,year2013Books));
        series1.getData().add(new XYChart.Data(year2014,year2014Books));
        series1.getData().add(new XYChart.Data(year2015,year2015Books));
        series1.getData().add(new XYChart.Data(year2016,year2016Books));
        series1.getData().add(new XYChart.Data(year2017,year2017Books));

        StackedAreaChart.getData().add(series1);



        StackedAreaChart.setTranslateX(65);
        StackedAreaChart.setTranslateY(55);
        StackedAreaChart.setPrefSize(500,500);


        StackedAreaChart.getData().add(series1);



        StackedAreaChart.setTranslateX(65);
        StackedAreaChart.setTranslateY(55);
        StackedAreaChart.setPrefSize(500,500);

        HBox hBox1 = new HBox(StackedAreaChart,exit,back);


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


    public void startBorrowing(Stage primaryStage) throws IOException {
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            UIDisplayFX uiDisplayFX = new UIDisplayFX();
            try {
                uiDisplayFX.borrowStatistics(primaryStage);
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
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=25.0){
                over25Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=20.0){
                over20Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=15.0){
                over15Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=10.0){
                over10Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=7.0){
                over7Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=4.0){
                over4Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>4.0){
                below4Count++;
            }


        }



        below4 =  "0-3" ;
        over4 =  "4-6" ; over7 =  "7-9" ; over10 =  "10-14" ;
        over15=   "15-19" ;over20 =  "20-24" ; over25 =  "25-29" ;
        over30 =  "30+" ;



        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");

        StackedAreaChart StackedAreaChart = new StackedAreaChart(categoryAxis,numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName(below4);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(over4);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(over7);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(over10);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(over15);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(over20);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(over25);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(over30);
        XYChart.Series series9 = new XYChart.Series();




        series1.getData().add(new XYChart.Data(below4,below4Count));
        series2.getData().add(new XYChart.Data(over4,over4Count));
        series3.getData().add(new XYChart.Data(over7,over7Count));
        series4.getData().add(new XYChart.Data(over10,over10Count));
        series5.getData().add(new XYChart.Data(over15,over15Count));
        series6.getData().add(new XYChart.Data(over20,over20Count));
        series7.getData().add(new XYChart.Data(over25,over25Count));
        series8.getData().add(new XYChart.Data(over30,over30Count));


        StackedAreaChart.getData().add(series1);
        StackedAreaChart.getData().add(series2);
        StackedAreaChart.getData().add(series3);
        StackedAreaChart.getData().add(series4);
        StackedAreaChart.getData().add(series5);
        StackedAreaChart.getData().add(series6);
        StackedAreaChart.getData().add(series7);
        StackedAreaChart.getData().add(series8);
        StackedAreaChart.getData().add(series9);



        StackedAreaChart.setTranslateX(65);
        StackedAreaChart.setTranslateY(55);
        StackedAreaChart.setPrefSize(1000,700);



        HBox hBox1 = new HBox(StackedAreaChart,exit,back);


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

    public void startPricing(Stage primaryStage) throws IOException {

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            UIDisplayFX uiDisplayFX = new UIDisplayFX();
            try {
                uiDisplayFX.priceStatistics(primaryStage);
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


        String over100,over140,over160,over180,over210,over250,over300,over350,over400,over500;
        int  over100Count,over140Count,over160Count,over180Count,over210Count,
                over250Count,over300Count,over350Count,over400Count,over500Count;


        over100Count=0;over140Count=0;over160Count=0;over180Count=0;
        over210Count=0;over250Count=0;over300Count=0;over350Count=0;
        over400Count=0;over500Count=0;

        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();

        for(iterator=0;iterator<numberOfBooks;iterator++){


            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=500.00){
                over500Count++;

            }
            } for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=400.00){
                over400Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=350.00){
                over350Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=300.00){
                over300Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=250.00){
                over250Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=210.00){
                over210Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=180.00){
                over180Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=160.00){
                over160Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>140.00){
                over140Count++;
            }} for (iterator = 0; iterator < numberOfBooks; iterator++) { if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=100.00){
                over100Count++;
            }


        }



        over100 =  "100-140" ;
        over140 =  "140-160" ; over160 =  "160-180" ; over180 =  "180-210" ;
        over210=   "210-250" ;over250 =  "250-300" ; over300 =  "300-350" ;
        over350 =  "350-400" ;over400 =  "400-500" ; over500 =  "500+" ;



        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");

        StackedAreaChart StackedAreaChart = new StackedAreaChart(categoryAxis,numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName(over100);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(over140);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(over160);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(over180);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(over210);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(over250);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(over300);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(over350);
        XYChart.Series series9 = new XYChart.Series();
        series9.setName(over400);
        XYChart.Series series10 = new XYChart.Series();
        series10.setName(over500);



        series1.getData().add(new XYChart.Data(over100,over100Count));
        series2.getData().add(new XYChart.Data(over140,over140Count));
        series3.getData().add(new XYChart.Data(over160,over160Count));
        series4.getData().add(new XYChart.Data(over180,over180Count));
        series5.getData().add(new XYChart.Data(over210,over210Count));
        series6.getData().add(new XYChart.Data(over250,over250Count));
        series7.getData().add(new XYChart.Data(over300,over300Count));
        series8.getData().add(new XYChart.Data(over350,over350Count));
        series9.getData().add(new XYChart.Data(over400,over400Count));
        series10.getData().add(new XYChart.Data(over500,over500Count));

        StackedAreaChart.getData().add(series1);
        StackedAreaChart.getData().add(series2);
        StackedAreaChart.getData().add(series3);
        StackedAreaChart.getData().add(series4);
        StackedAreaChart.getData().add(series5);
        StackedAreaChart.getData().add(series6);
        StackedAreaChart.getData().add(series7);
        StackedAreaChart.getData().add(series8);
        StackedAreaChart.getData().add(series9);
        StackedAreaChart.getData().add(series10);



        StackedAreaChart.setTranslateX(65);
        StackedAreaChart.setTranslateY(55);
        StackedAreaChart.setPrefSize(1000,700);





        HBox hBox1 = new HBox(StackedAreaChart,exit,back);


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
