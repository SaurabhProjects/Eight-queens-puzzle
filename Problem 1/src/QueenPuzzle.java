/**
 * Eight queens puzzle
 * @authors Denesh Partipan
 *
 */
public class QueenPuzzle

{
	//Initializing the size of the board 
	//Making the array to store our board
	//Keep track of solutions
    private int boardSize = 8; 
    private String [][] QueenBoard; 
    private int solutions; 
   
    //Constructor
    public QueenPuzzle ()
    {
        solutions = 0;
        QueenBoard = new String[boardSize][boardSize];
        
        //Emptying the board
        for (int m = 0; m<boardSize; m++)
        {
            for (int n = 0; n<boardSize; n++)
            {
                QueenBoard[m][n] = "-";
            }
        }
    }
   
   
   
    //Main
    public static void main(String args[])
    {
        QueenPuzzle TestRun = new QueenPuzzle();
        TestRun.QueenPlay(0);
        System.out.println("We have " + TestRun.solutions + " Solutions");
   
    }
    
    
    //To check if Queen has been placed on that space
    public int QueenCheck(int row, int col)
    {
        int occuppied = 1;
        for (int i = 0; i <= row; i++)
        {
            for (int m = 0; m <= col; m++)
            {
            	//Checking top left diagonal
                if((col < 8) && (col >= 0) && (row > col) && (QueenBoard[row-m][col-m].equals("X")))
                {
                    occuppied = 2;
                    return occuppied;
                }
            }
           
           //Checking each row on a column to verify no Queen has already been placed
            if ((col < 8) && (col >= 0) && QueenBoard[i][col].equals("X"))
            { 
                occuppied = 2;
                return occuppied;
            }
           
            //Checks top left diagonal 
            else if ((col < 8) && (col >= 0) && (col >= row) && (QueenBoard[row-i][col-i].equals("X")))
            {
                occuppied = 2;
                return occuppied;
            }
            //Check bottom left diagonal
            else if ((col < 8) && (col >= 0) && ((col+i) < 8) && (QueenBoard[row-i][col+i].equals("X")))
            { 
                occuppied = 2;
                return occuppied;
            }
        }
       
       
        return occuppied;
    }
    
    
    public void QueenPlay(int row)
    {
        for (int col = 0; col < 8; col++)
        {
            if (QueenCheck(row, col) == 1)
            {
                QueenBoard[row][col] = "X"; 
               
               //Outputs the locations of the Queens placed for each solution
                if (row == boardSize-1 )
                { 
                    solutions++;   
                    System.out.println("Solution #"+ solutions);
                    for (int s = 0; s < 8; s++)
                    {
                    	for (int t = 0; t < 8; t++)
                    	{
                    		if (QueenBoard[s][t].equals("X"))
                    		{
                    			
                    			System.out.println("( "+ s + ","+ t + ")"); 
                    		}
                    	}
                    }
                }
                //Recursive part that recursively goes through each row until end of board
                else
                { 
                    QueenPlay(row+1);
                }
                QueenBoard[row][col] = "-"; 
            }
        }
    }
               

   
   
}