import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class TicTacToe {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int pos;
		int cpuPos;
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
							  {'-', '+', '-', '+', '-'}, 
							  {' ', '|', ' ', '|', ' '}, 
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '}};
		
		showBoard(gameBoard);
		
		while(true)
		{
			System.out.println("Enter your space 1-9: ");
			pos = input.nextInt();
			
			while(playerPositions.contains(pos) || cpuPositions.contains(pos))
			{
				System.out.println("Position taken. Enter again: ");
				pos = input.nextInt();
			}
			fillBoard(gameBoard, pos, "Player");
			System.out.println();

			String result = checkWinner();
			if(result.length() > 0)
			{
				System.out.println(result);
				break;
			}
			
			cpuPos = rand.nextInt(9) + 1;
			while(cpuPositions.contains(cpuPos) || playerPositions.contains(cpuPos))
			{
				cpuPos = rand.nextInt(9) + 1;
			}
			fillBoard(gameBoard, cpuPos, "CPU");
			System.out.println();
			System.out.println();
			
			result = checkWinner();
			if(result.length() > 0)
			{
				System.out.println(result);
				break;
			}
		
		}
		
		
		
		}
	
	public static void showBoard(char gameBoard[][])
	{
		
		for(int i = 0; i < gameBoard.length; i++)
		{
			for(int j = 0; j < gameBoard[i].length; j++)
			{
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();

		}
	}
	
	public static void fillBoard(char gameBoard[][], int pos, String user)
	{
		char mark = ' ';
		if(user.equals("Player"))
		{
			mark = 'X';
			playerPositions.add(pos);
		}
		else if(user.equals("CPU"))
		{
			mark = 'O';
			cpuPositions.add(pos);
		}
		
		
		
		switch(pos)
		{
		case 1:
			gameBoard[0][0] = mark;
			break;
		case 2:
			gameBoard[0][2] = mark;
			break;
		case 3:
			gameBoard[0][4] = mark;
			break;
		case 4:
			gameBoard[2][0] = mark;
			break;
		case 5:
			gameBoard[2][2] = mark;
			break;
		case 6:
			gameBoard[2][4] = mark;
			break;
		case 7:
			gameBoard[4][0] = mark;
			break;
		case 8:
			gameBoard[4][2] = mark;
			break;
		case 9:
			gameBoard[4][4] = mark;
			break;
		default:
			break;
		}
		
		showBoard(gameBoard);
	}
	
	public static String checkWinner()
	{
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);

		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning)
		{
			if(playerPositions.containsAll(l))
			{
				return "Congratulations you won!";
			}
			else if(cpuPositions.containsAll(l))
			{
				return "CPU wins, sorry :(";
			}
			else if(playerPositions.size() + cpuPositions.size() == 9)
			{
				return "Tie!";
			}
		}
		
		
		return "";
	}


	}



