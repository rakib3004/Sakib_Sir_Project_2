package ResultPackage;

import Collection.BorrowCollection;
import Collection.TimeCollection;
import Collection.TypeCollection;
import Methods.Searching;
import ObjectOriented.PriorityData;
import Collection.WriterCollection;

import javax.swing.*;
import java.util.Scanner;

public class MLR_Result {
    Searching searching = new Searching();
    WriterCollection writerCollection = new WriterCollection();
    TypeCollection typeCollection = new TypeCollection();
    TimeCollection timeCollection = new TimeCollection();
    BorrowCollection borrowCollection = new BorrowCollection();
    int iterator;

    public void MLR_ResultMethods(PriorityData[] priorityData, int numberOfBooks) {

int enterChoice;
Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your Choice : ");
        System.out.println("1. Show Result");
        System.out.println("2. Sorting and show result");
        System.out.println("3. Type Based Analysis");
        System.out.println("4. Writer Based Analysis");
        System.out.println("5. Price Based Analysis");
        System.out.println("6. Time Based Analysis");
        System.out.println("7. borrow Based Analysis");

enterChoice = scanner.nextInt();
if(enterChoice==1){
    showMLRProcessResult(priorityData,numberOfBooks);
}
else if(enterChoice==2){

}



    }

    public void showMLRProcessResult(PriorityData[] priorityData, int numberOfBooks) {

        System.out.println("Book Name :\t Writer Name : \t Weight ");
        for(iterator=0;iterator<numberOfBooks;iterator++){

            System.out.println(priorityData[iterator].bookData.bookName+"\t"
                    +priorityData[iterator].bookData.writerName+"\t"+priorityData[iterator].getMLRweight());

        }

    }






        public void printOptionMethods(PriorityData[] priorityData, int numberOfBooks){



        double temporary;
        int temp;
        PriorityData tempData;
      /*  for (iterator = 0; iterator < numberOfBooks; iterator++) {
            for (int j = 0; j < numberOfBooks; j++) {
                if (priorityData[iterator].getMLRweight() > priorityData[j].getMLRweight()) {

                    tempData = priorityData[iterator];
                    priorityData[iterator] = priorityData[j];
                    priorityData[j] = tempData;
                }
            }
        }*/

        try {


            String aString = JOptionPane.showInputDialog("Chose OPtion :\n1.Type Base Statitics " +
                    "\n2.Writer Based Statistics \n3.Issue Date Base Statitics " +
                    "\n4.Borrow Based Statistics" + "\n5.Searching by Alphabets");
            //     optimizedResult(priorityData,numberOfBooks);

            int anInt = Integer.parseInt(aString);
            JOptionPane.showMessageDialog(null, "You Pressed " + anInt);

            if (anInt == 1) {

                typeCollection.typeCollectionMLRMethods(priorityData, numberOfBooks);

            } else if (anInt == 2) {

                writerCollection.writerCollectionMLRMethods(priorityData, numberOfBooks);

            } else if (anInt == 3) {

                timeCollection.timeCollectionMLRMethods(priorityData, numberOfBooks);

            } else if (anInt == 4) {

                borrowCollection.borrowCollectionMLRMethods(priorityData, numberOfBooks);

            } else if (anInt == 5) {

                searching.search(priorityData, numberOfBooks);

            } else {
                JOptionPane.showMessageDialog(null, "Empty Command");
            }

        } catch (NullPointerException nullPointerException) {
            System.out.println();

        }



    }

}