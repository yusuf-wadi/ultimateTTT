/*

    Name:YMW200000 Yusuf Wadi

    Class:2336.002

    Analysis: This is a code that runs a version of Ultimate Tic Tac Toe. Ultimate Tic Tac Toe is a game of Tic Tac Toe within a game of Tic Tac Toe. Very cool!

    Design: The game design is as follows: Begins by Welcoming the player. Then the game board is instantiated. Then the user is prompted to select a board, then select a piece.
            Once this is completed, it is the next players turn. This continues until a result occurs. 

    Test:



*/


package ultimategamer;
import java.io.*;   
import java.util.*;


class Game {

        public static void main(String[] args) throws IOException {

            int bnum = 0, pos = 0, currP = 1; /*turns = 0;*/
            char c = ' ';
            Main winner = new Main();

            

            BufferedReader buffR = new BufferedReader(new InputStreamReader(System.in));

            //welcome them to the game

            System.out.println("Hello there! Welcome to the Ultimate Game of TICTACTOE.");
            
            //instantiate the playing field

            System.out.println();

          

            System.out.println();

            Main boards[] = new Main[9];

                for(int i=0; i < 9; i++){

                    boards[i] = new Main();
                    boards[i].display(i);

                    // if(i%3==2){

                    //     System.out.println();
                    // }
        
                }

                

            //UI to select a board

            System.out.println("Select a Board 0-8");
            bnum = Integer.parseInt(buffR.readLine());

            //Gameplay loop

            while(true){

                //alternate between 1 and 2 for player selection (start with 1)

                if(currP == 1){

                    System.out.println(" Current P: P1, Board:  " + bnum);

                    c = 'X';
                    currP = 2;

                } else {

                    System.out.println(" Current P: P2, Board: " + bnum );
                    c = 'O';
                    currP = 1;
                }

                //Input and Validation Logic loop

                System.out.println("Input board position 0-8 to place your piece.");

                while(true){

                    String in;
                    in = buffR.readLine();

                    if(in.equals("ai")){

                        pos = (int)Math.floor(Math.random()*9);
                        break;
                        

                    }else{

                        pos = Integer.parseInt(in);

                        if(pos>8){

                            System.out.println("Input out of range, cannot be greater than 8.");
    
                        } else if(pos<0){
    
                            System.out.println("Input out of range, cannot be less than 0.");
                        } else{

                            break;
                        }

                    }

                  
                }

          
    
                boards[bnum].setPos(c,pos);
              

                System.out.println();
                
                //Display new boards after input

                
                for(int i=0; i < 9; i++){

                  
                    boards[i].display(i);

                    // if(i%3==2){

                    //     System.out.println();
                    // }
                }
        
                


                    //check for winner in current board


                    char result = boards[bnum].scanResult();

                    //once winner of a certain board is ascertained, add the winner to a new array at bnum

                    winner.board[bnum] = result;

                    //part of the rules of ultimate tictactoe is to move the next player to the board corresponding to the larger field based on the pos picked by the previous player
                    bnum = pos;

                      

                            if(winner.scanResult() == 'X'){

                                System.out.println("P1 wins!");
                                break;
                            }else if(winner.scanResult() == 'O'){

                                System.out.println("P2 wins!");
                                break;
                            }else{

                                winner.scanTie();

                            }
                    
                
              

            }


        
        }

    
}



