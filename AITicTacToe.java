import java.util.*;


public class AITicTacToe {

   
	static int[][] grid; 

   public static int counter = 0;
   
	public static void main (String[ ] args) {

		grid = new int[3][3];

		System.out.println();
      System.out.println("Welcome to Tic Tac Toe with Jarvis, the unbeatable Tic Tac Toe player");
      System.out.println("Take the Challenge, you will never win.");
		System.out.println("Here are the grid positions:");
		System.out.println(" 1 2 3 ");
		System.out.println(" 4 5 6 ");
		System.out.println(" 7 8 9 ");
     
      		
		askForInput1();

	}

	public static void askForInput1() { 
		int first = jarvisMove(counter);  
		System.out.println("Jarvis takes Spot " + first + ".");
		boolean duplicate = checkForDuplicate(first);
		if (!duplicate){
			System.out.println("That spot is already taken!");
			askForInput1();
		}

		if (first < 0 || first > 9) {
			System.out.println("That is an invalid slot. Please retry.");
			askForInput1();
		}


		markGrid("one", first);
		boolean win1 = checkForWin();

		if (win1) {
			print();
			System.out.println("So sorry, Jarvis Wins.");
			System.out.println();
			System.exit(0);
		}

		if(checkForTie()) {
			print();
			System.out.println("Sorry! It's a tie! No one wins :(");
			System.out.println();
			System.exit(0);
		}

		print();
		askForInput2();
	}

	public static void askForInput2() {

		Scanner inputScanner = new Scanner(System.in);
		System.out.println();
		System.out.println("Player TWO, which slot would you like to take?");
		int second = inputScanner.nextInt();

		boolean duplicate = checkForDuplicate(second);
		if (!duplicate) {
			System.out.println("That spot is already taken!");
			askForInput2();
		}

		if (second <= 0 || second > 9) {
			System.out.println("That is an invalid slot. Please retry.");
			askForInput2();
		}


		markGrid("two", second);
		boolean win2 = checkForWin();

		if (win2) {
			print();
			System.out.println("Good job Player TWO! You Win!");
			System.out.println();
			System.exit(0);
		}

		if(checkForTie()) {
			print();
			System.out.println("Sorry! It's a tie! No one wins :(");
			System.out.println();
			System.exit(0);
		}


		print();
		askForInput1();
	}

	public static boolean checkForTie() {
		
		boolean tie = true; 
		for (int x = 0; x <= 2; x++) {
			for (int y = 0; y <= 2; y++) {
				if (grid[x][y] == 0)
					tie = false;
			}
		}

		return tie; 
	}

	public static boolean checkForDuplicate(int input) {
		
		if (input == 1) {
			if (grid[0][0] != 0)
				return false; 
		} 

		if (input == 2) {
			if (grid[0][1] != 0)
				return false;
		}

		if (input == 3) {
			if (grid[0][2] != 0)
				return false; 
		}

		if (input == 4) {
			if (grid[1][0] != 0)
				return false;  
		}

		if (input == 5) {
			if (grid[1][1] != 0)
				return false;  
		}

		if (input == 6) {
			if (grid[1][2] != 0) 
				return false;
		}

		if (input == 7) {
			if (grid[2][0] != 0) 
				return false;
		}

		if (input == 8) {
			if (grid[2][1] != 0) 
				return false; 
		}

		if (input == 9) {
			if (grid[2][2] != 0)
				return false;  
		}

		return true;
	}

	public static boolean checkForWin() {

		//Check for rows 
		for (int x = 0; x <= 2; x++) {
			
			int beginning = grid[x][0];

			if (grid[x][1] == beginning && grid[x][2] == beginning && beginning != 0)
				return true; 
			
		}

		//Check for columns
		for (int y = 0; y <= 2; y++) {
			
			int beginning = grid[0][y];

			if (grid[1][y] == beginning && grid[2][y] == beginning && beginning != 0)
				return true; 
			
		}

		//Check for diagonals
		int beginning = grid[1][1];

		if(grid[0][0] == beginning && grid[2][2] == beginning && beginning != 0)
			return true;

		if(grid[0][2] == beginning && grid[2][0] == beginning && beginning != 0)
			return true;

		return false; 
	}

	public static void markGrid(String player, int input) {

		int mark = -1; 

		if (player.equals("one"))
			mark = 1; 

		if (player.equals("two"))
			mark = 2;

		if (input == 1) 
			grid[0][0] = mark; 

		if (input == 2) 
			grid[0][1] = mark; 

		if (input == 3) 
			grid[0][2] = mark; 

		if (input == 4) 
			grid[1][0] = mark; 

		if (input == 5) 
			grid[1][1] = mark; 

		if (input == 6) 
			grid[1][2] = mark; 

		if (input == 7) 
			grid[2][0] = mark; 

		if (input == 8) 
			grid[2][1] = mark; 

		if (input == 9) 
			grid[2][2] = mark; 

      counter++;
	}

	public static void print() {

		System.out.println();

		for (int x = 0; x <= 2; x++) {
			for (int y = 0; y <=2; y++) {

				if (grid[x][y] == 0)
					System.out.print(" - ");

				if (grid[x][y] == 1)
					System.out.print(" X ");

				if (grid[x][y] == 2)
					System.out.print(" O ");
			}

			System.out.println();
		} 

	}
   
      
   public static int jarvisMove(int counter){
   System.out.println(counter); 
      //turn one logic
      if( counter == 0){
         return 1;
      }
      
      // turn two logic
      if (counter ==2){
         if(checkForDuplicate(3)){
           return 3;
         }
         else{
            return 7; 
         }        
      }      
      
      //turn three logic
      if(counter == 4){
         if(CheckForTwo()){
            if(checkForDuplicate(MoveForTwo())){
               return MoveForTwo();
            }
         }    
                     
         if(!checkForDuplicate(6)){
            return 5;         
         }else if(checkForDuplicate(9)){
               return 9; 
         }else if (checkForDuplicate(7)){
               return 7; 
         }else if (checkForDuplicate(3)){
               return 3; 
         }
       }   
                
     //turn four logic       
      if(counter == 6){
         if(CheckForTwo()){
            if(checkForDuplicate(MoveForTwo())){
               return MoveForTwo();
            }
         }                                      
         if(checkForDuplicate(9)){
               return 9; 
            }else  if (checkForDuplicate(7)){
               return 7; 
            }else if (checkForDuplicate(3)){
               return 3; 
            }
      }         
      
      
       //turn five logic       
      if(counter == 8){
         if(CheckForTwo()){
            if(checkForDuplicate(MoveForTwo())){
               return MoveForTwo();
            }
         }    
         if(checkForDuplicate(9)){
               return 9; 
            } else if (checkForDuplicate(7)){
               return 7; 
            }else if (checkForDuplicate(3)){
               return 3; 
            }
         } 
         
         //turn six logic       
      if(counter == 10){
         if(CheckForTwo()){
            if(checkForDuplicate(MoveForTwo())){
               return MoveForTwo();
            }
         }           
      } 
      
       System.out.println("Spillage");
       return 7;    
    }   

 
   public static boolean CheckForTwo() {
            
            int beginning = 0; 
            
   			if(counter % 2 != 0){
                 beginning = 2;
            }else{
               beginning = 1; 
             }   

   		//Check for rows 
   		for (int x = 0; x <= 2; x++) {
   			
   			if (grid[x][1] == beginning && grid[x][0] == beginning || grid[x][2] == beginning && grid[x][0] == beginning || grid[x][2] == beginning && grid[x][1] == beginning){
               return true; 
   			
   		   }
         }   
   
   		//Check for columns
   		for (int y = 0; y <= 2; y++) {
   			
            if (grid[1][y] == beginning && grid[0][y] == beginning || grid[2][y] == beginning && grid[0][y] == beginning || grid[2][y] == beginning && grid[1][y] == beginning){
           
   				return true; 
   			
            }            
   		}
   
   		//Check for diagonals
         
   		if(grid[0][0] == beginning && grid[1][1] == beginning){
            return true; 
         }
         else if(grid[2][2] == beginning && grid[1][1] == beginning){
            return true; 
         }
         else if(grid[2][2] == beginning && grid[0][0] == beginning){
   			return true;
         }   
   		return false; 
   	}
   
      
   public static int MoveForTwo() {
   
            int beginning = 0; 
            
   			if(counter % 2 != 0){
                 beginning = 2;
            }else{
               beginning = 1; 
             }   

   		//Move for rows 
   		for (int x = 0; x <= 2; x++) {
   			           
   			if (grid[x][1] == beginning && grid[x][0] == beginning && grid[x][2] == 0){
                  if(x == 1){
                     if(checkForDuplicate(6)){
                        return 6; }
                  }if (x == 0){
                     if(checkForDuplicate(3)){
                        return 3; }
                  }if (x == 2){
                     if(checkForDuplicate(9)){
                        return 9; }
 
                  }
               }
            
            if( grid[x][2] == beginning && grid[x][0] == beginning && grid[x][1] == 0){
                  if(x == 1){
                     if(checkForDuplicate(5)){
                        return 5; }
                  }if (x == 0){
                     if(checkForDuplicate(2)){
                        return 2; } 
                  }if(x ==2){
                    if(checkForDuplicate(8)){
                        return 8; }
 
                  }
            }
           
            if(grid[x][2] == beginning && grid[x][1] == beginning && grid[x][0] == 0){
               if(x == 1){
                  if(checkForDuplicate(4)){
                        return 4; }
               }if (x == 0){
                  if(checkForDuplicate(1)){
                        return 1; } 
               }if(x == 2){
                  if(checkForDuplicate(7)){
                        return 7; } 
               }
            }   
   			
   		}
   
   			//Move for columns 
   		for (int y = 0; y <= 2; y++) {
   		   
   			if (grid[1][y] == beginning && grid[0][y] == beginning && grid[2][y] == 0){
               if(y == 1){
                  if(checkForDuplicate(8)){
                        return 8; } 
               }if (y == 0){
                  if(checkForDuplicate(7)){
                        return 7; }
               }else {
                  if(checkForDuplicate(9)){
                        return 9; }
               }
   
   
            }
            
            
            if( grid[2][y] == beginning && grid[0][y] == beginning && grid[1][y] == 0){
               if(y == 1){
                  if(checkForDuplicate(5)){
                        return 5; } 
               }else if (y == 0){
                  if(checkForDuplicate(4)){
                        return 4; } 
               }else {
                  if(checkForDuplicate(6)){
                        return 6; } 
               }
   
            }
               
            if(grid[2][y] == beginning && grid[1][y] == beginning && grid[0][y] == 0){
                if(y == 1){
                 if(checkForDuplicate(2)){
                        return 2; }
               }else if (y == 0){
                  if(checkForDuplicate(1)){
                        return 1; } 
               }else {
                  if(checkForDuplicate(3)){
                        return 3; } 
               }
   
            }   
   			
   
   		//Move for diagonals
   	
   		if(grid[0][0] == beginning && grid[2][2] == beginning){
           if(checkForDuplicate(5)){   
             return 5;  
            }   
         }
            
   		if(grid[0][2] == beginning && grid[2][0] == beginning){
   			 if(checkForDuplicate(5)){   
               return 5;  
            }    
         }
         
         if(grid[0][2] == beginning && grid[1][1] == beginning){
   			 if(checkForDuplicate(7)){   
                return 7;  
            }    
         }
      
         if(grid[2][0] == beginning && grid[1][1] == beginning){
   			 if(checkForDuplicate(3)){   
                return 3;  
            }    
         }
         
         if(grid[1][1] == beginning && grid[2][2] == beginning){
            if(checkForDuplicate(1)){   
                return 1;  
            }     
         }
         
         if(grid[1][1] == beginning && grid[0][0] == beginning){
             if(checkForDuplicate(9)){   
                return 9;  
            }   
         }
         
   	 }
      return 1;   
      }
   
   
}