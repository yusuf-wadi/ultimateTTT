package ultimategamer;
import java.io.*;
import java.util.*;

class Main{


    //create a board
    char board[] = new char[9];

    Main(){

        //fill board with null symbols
        Arrays.fill(board,'_');

    }

   
    //function to see row and produce true if match and false if not
    boolean scanRow(char arr[]){

        if((arr[0] == arr[1]) && (arr[0] == arr[2]) && (arr[0] != '_')){

            return true;
        }else{

            return false;
        }



    }

    //function to set the position of a character
    boolean setPos(char c, int pos){


        //fail case for taken position 
        if(board[pos] == 'X' || board[pos] == 'O'){

            System.out.println("Position Full. Please try a different positon");
            return false;
        }
        else if(c == 'X' || c == 'O'){

            board[pos] = c;

            return true;

        } else {

            return false;
        }
    }

  

    //a function to check if a final pos leads to a stalemate; necessary for such a game
     boolean scanTie(){

        int count = 0;
        
        for(int i = 0; i < 9; i++){

            if(board[i] == '_'){

                count++;
            }

        }

        if(count == 0){

            return true;
        }

        return false;
    }

      //the display function :)

      void display(int num){

        System.out.println("Board Num - " + num);
        System.out.println();
        
         

        for(int i = 0; i < 9; i++){

            System.out.print(board[i] + "\t");

            if(i%3==2){

                System.out.println();
            }

        }

        //System.out.println();

        
    }

    //scanning for win pos
   
    char scanResult(){

        char row[] = new char[3];

        //row scan

        for(int i = 0; i<9; i+=3){

            for(int j = 0; j<3; j++){

                row[j] = board[i+j];
            }

            if(scanRow(row)){

                return board[i];
            }
        }

        //col scan

        for(int i = 0; i<3; i++){

            for(int j = 0, k = 0; j<9 && k<3; j+=3, k++){

                row[k] = board[i+j];
            }

            if(scanRow(row)){

                return board[i];
            }
        }

        //scan diag

        row[0] = board[0];
        row[1] = board[4];
        row[2] = board[8];
        if(scanRow(row)) return board[0];
        row[0] = board[2];
        row[1] = board[4];
        row[2] = board[6];
        if(scanRow(row)) return board[2];

        // if(scanTie()){

        //     System.out.println("Tied");
        //     System.exit(0);
        // }

        return ' ';
    }





}
