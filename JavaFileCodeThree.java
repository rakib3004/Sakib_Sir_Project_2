package BasicJava;
import java.io.*;

import java.io.IOException;

public class OutStream {

    public static void main(String [] args) throws IOException{

        File file = new File("C:\\Users\\Rakib\\Desktop\\IIT_SPL.txt");
        FileReader fr = new FileReader(file);
        char [] a = new char[12050];
        fr.read(a);   // reads the content to the array

        String bookName [] = new String[1050];
        String writerName [] = new String[1050];
        String bookId [] = new String[1050];
        String bookType [] = new String[1050];
        String priority [] = new  String[1050];
        String borrowCount [] = new String[1050];
        String monthCount [] = new String[1050];
        int x=1;
        int t=0;
      for(int i =0 ;a[i]!='\0';i++) {
          if(a[i]=='\t'){
              i++;
              t++;
              t=t%7;
          }
          if(a[i]=='\n'){
              i++;
              t++;
              t=t%7;
              x++;
              bookName [x] = "\0";
               writerName [x]  = "\0";
               bookId [x] = "\0";
               bookType [x] = "\0";
               priority [x] = "\0";
               borrowCount [x] ="\0";
               monthCount [x] = "\0";

          }
          if(t==0){

              bookName[x]  =bookName[x] + a[i];
              System.out.println(bookName[x]);
          }
else if(t==1){
    writerName[x] = writerName[x]+a[i];
              System.out.println(writerName[x]);

          }
else if(t==2){
    bookId[x] = bookId[x]+a[i];
              System.out.println(bookId[x]);

          }
     else if(t==3){
    bookType[x] = bookType[x]+a[i];
              System.out.println(bookType[x]);
          }
     else if(t==4){
    priority[x] = priority[x]+a[i];
              System.out.println(priority[x]);
          }
     else if(t==5){
    borrowCount[x] = borrowCount[x]+a[i];
              System.out.println(borrowCount[x]);
          }
     else if(t==6){
    monthCount[x] = monthCount[x]+a[i];
              System.out.println(monthCount[x]);
          }


      }

      fr.close();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(monthCount[7]);
      }
}
