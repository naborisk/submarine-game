import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static final char[] LETTERS = {'-', 'A', 'B', 'C', 'D', 'E', '-'};

	public static void print(int[][] a){
		int i,j;
		System.out.println("-----------------------------------");
		for(i=0; i<7; i++){
			for(j=0; j<7; j++){
				if(a[i][j] == -1){
					if(j == 0 || j == a.length-1) System.out.print("  " + LETTERS[i] +"  ");
					else System.out.print("  " + j +"  ");
				}else if(a[i][j] > 0){
					System.out.print("  " + a[i][j] + "  ");
				}else{
					System.out.print("     ");
				}
			}
			System.out.print("\n-----------------------------------\n");
		}
		
	}
	
	public static void moveEquation(int moveEq[][], int totalHP, int numSub, int nextMove[][]){
		for(int i=1; i<6; i++){
			for(int j=1; j<6; j++){
				moveEq[i][j] = (totalHP + numSub + nextMove[i][j]) / 2;
			}
		}
	}
	
	public static void moveEquationAr(int moveEq[][], int m, int n, int totalHP, int numSub, int nextMove[][]){
		
		int[][] temArr = {
				{-1, -1, -1, -1, -1, -1, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1, -1, -1, -1, -1, -1, -1},
		};
		
		if(temArr[m+1][n+1] > -1) temArr[m+1][n+1] = 1;  
		if(temArr[m+1][n] > -1) temArr[m+1][n] = 1;
		if(temArr[m+1][n-1] > -1) temArr[m+1][n-1] = 1;
		if(temArr[m][n+1] > -1) temArr[m][n+1] = 1;
		if(temArr[m][n-1] > -1) temArr[m][n-1] = 1;
		if(temArr[m-1][n+1] > -1) temArr[m-1][n+1] = 1;
		if(temArr[m-1][n] > -1) temArr[m-1][n] = 1;
		if(temArr[m-1][n-1] > -1) temArr[m-1][n-1] = 1;
		
		
		for(int i=1; i<6; i++){
			for(int j=1; j<6; j++){
				if(m == i && n == j) moveEq[i][j] = 0;
				else if(temArr[i][j] == 1){
					moveEq[i][j] = totalHP + numSub + nextMove[i][j];
				}else{
					moveEq[i][j] = (totalHP + numSub + nextMove[i][j]) / 2;
				}
			}
		}
	}
	
	public static void _max(int a[][], int m, int n) { 
		int max = a[0][0];
		for(int i=1; i<6; i++){ 
			for(int j=1; j<6; j++){ 
				if(a[i][j] > max){
					max = a[i][j]; 
					m = i;
					n = j;
				}
			}
		}
	}
	
	public static int total(int a[][]){
		int sum = 0;
		int i,j;
		
		for(i=1; i<6; i++){
			for(j=1; j<6; j++){
				sum += a[i][j];
			}
		}
		return sum;
	}
	
	public static int _num(int a[][]){
		int num = 0;
		int i,j;
		
		for(i=1; i<6; i++){
			for(j=1; j<6; j++){
				if(a[i][j] > 0){
					num++;
				};
			}
		}
		
		return num;
	}

	// debug printing
	public static void printArr(String name, int[][] arr) {
		System.out.println(name);
		printArr(arr);
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}




	static int[][] spawnShip() {
		int[][] board = {
				{-1, -1, -1, -1, -1, -1 ,-1},
				{-1, 0, 0, 0, 0, 0, -1},
				{-1, 0, 0, 0, 0, 0, -1},
				{-1, 0, 0, 0, 0, 0, -1},
				{-1, 0, 0, 0, 0, 0, -1},
				{-1, 0, 0, 0, 0, 0, -1},
				{-1, -1, -1, -1, -1, -1 ,-1}
		};

		Random r = new Random();

		// r.nextInt(max - min) + min
		//** Max number is exclusive while min is inclusive **

		board[r.nextInt(3-1) + 1][r.nextInt(3-1) + 1] = 3;
		board[r.nextInt(3-1) + 1][r.nextInt(6-3) + 3] = 3;
		board[r.nextInt(6-3) + 3][r.nextInt(3-1) + 1] = 3;
		board[r.nextInt(6-3) + 3][r.nextInt(6-3) + 3] = 3;

		return board;
	}

	public static void main(String[] args) {
		String[][] panelName = {
				{"N", "N", "N", "N", "N", "N" ,"N"},
				{"N", "A1", "A2", "A3", "A4", "A5", "N"},
				{"N", "B1", "B2", "B3", "B4", "B5", "N"},
				{"N", "C1", "C2", "C3", "C4", "C5", "N"},
				{"N", "D1", "D2", "D3", "D4", "D5", "N"},
				{"N", "E1", "E2", "E3", "E4", "E5", "N"},
				{"N", "N", "N", "N", "N", "N" ,"N"}
			};

		int[][] nextMove = {
				{-1, -1, -1, -1, -1, -1, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1, -1, -1, -1, -1, -1, -1},
		};
		
		int[][] moveEq = {
				{-1, -1, -1, -1, -1, -1, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0, -1},
				{-1, -1, -1, -1, -1, -1, -1},
		};

		
		int totalHp;
		int numSub;
		String order[] = {"print", "move" ,"attack"};
		String direction[] = {"North", "South", "West", "East"};

		String orderInput = null;
		String directionInput = null;
		String moveLengthInput = null;

		int moveLength;
		String To = null;
		Scanner sc = new Scanner(System.in);

		int[][] allies = spawnShip();
		//int[][] enemies = spawnShip();

		// print initial board
		print(allies);

		System.out.println("Input print, move, or attack");

		while(sc.hasNextLine()){
			orderInput = sc.nextLine();

			if(orderInput.equals(order[0])){ // Print
				print(allies);
			}else if(orderInput.equals(order[1])){ // Move
				System.out.print("Direction: ");
				directionInput = sc.nextLine();

				System.out.println("Direction: " + directionInput);
				System.out.print("moveLength: ");
				moveLengthInput = sc.nextLine();

				System.out.println("moveLength = " + moveLengthInput);
				System.out.println(orderInput + " " + directionInput + " " + moveLengthInput);


				// --- nextMove implementation for move
				int dist = Integer.parseInt(moveLengthInput);

				for (int i = 0; i < nextMove.length; i++) {
					for (int j = 0; j < nextMove[0].length; j++) {

						if (nextMove[i][j] >= 12) {

							if(nextMove[i][j] >= 20) nextMove[i][j] = 10;

							if(directionInput.equals("North")) {
								nextMove[i-dist][j] /= nextMove[i-dist][j] == -1 ? 1 : 2;
							} else if(directionInput.equals("East")) {
								nextMove[i][j+dist] /= nextMove[i][j+dist] == -1 ? 1 : 2;
							} else if(directionInput.equals("South")) {
								nextMove[i+dist][j] /= nextMove[i+dist][j] == -1 ? 1 : 2;
							} else if(directionInput.equals("West")) {
								nextMove[i][j-dist] /= nextMove[i][j-dist] == -1 ? 1 : 2;
							}
						}
					}
				}

				printArr("nextMove", nextMove);
				
				totalHp = total(allies);
				numSub = _num(allies);
				moveEquation(moveEq, totalHp, numSub, nextMove);
				
				printArr("moveEq", moveEq);
				
				// --- ends nextMove implementation for move
			}else if(orderInput.equals(order[2])){ // Attack
				System.out.print("To: ");
				To = sc.nextLine();

				System.out.println("To = " + To);
				System.out.println(orderInput + " to " + To);

				// **Attacking our team
				for(int i=1; i<6; i++){
					for(int j=1; j<6; j++){

						if(To.equals(panelName[i][j])){
							if(allies[i][j] > 0){
								allies[i][j]--;
								System.out.println("命中！");

								// --- nextMove Implementation for attacking
								nextMove[i][j] = 0; // Set self to 0

								// Increments
								// corner -> 8, top & bot -> 5, normal -> 3

								// Corner
								if(nextMove[i][j-1] == -1 && nextMove[i-1][j-1] == -1 && nextMove[i-1][j] == -1 || // top left
								   nextMove[i-1][j] == -1 && nextMove[i-1][j+1] == -1 && nextMove[i][j+1] == -1 || // top right
								   nextMove[i][j-1] == -1 && nextMove[i+1][j-1] == -1 && nextMove[i+1][j] == -1	|| // bot left
								   nextMove[i][j+1] == -1 && nextMove[i+1][j+1] == -1 && nextMove[i+1][j] == -1    // bot right
								) {
									for (int k = i-1; k <= i+1; k++) {
										for (int l = j-1; l <= j+1; l++) {
											if(k != i || l != j) nextMove[k][l] += nextMove[k][l] == -1 ? 0 : 8;
										}
									}
								}
								// Top Bottom Left Right
								else if(nextMove[i-1][j] == -1 || nextMove[i+1][j] == -1 || nextMove[i][j-1] == -1 || nextMove[i][j+1] == -1) {
									for (int k = i-1; k <= i+1; k++) {
										for (int l = j-1; l <= j+1; l++) {
											if(k != i || l != j) nextMove[k][l] += nextMove[k][l] == -1 ? 0 : 5;
										}
									}
								}
								// All other cases
								else {
									for (int k = i-1; k <= i+1; k++) {
										for (int l = j-1; l <= j+1; l++) {
											if(k != i || l != j) nextMove[k][l] += nextMove[k][l] == -1 ? 0 : 3;
										}
									}
								}

								printArr("nextMove", nextMove);
								// --- ends nextMove Implementation for attacking

								totalHp = total(allies);
								numSub = _num(allies);
								moveEquationAr(moveEq, i, j, totalHp, numSub, nextMove);

								printArr("moveEq", moveEq);

								if(allies[i][j] == 0){
									System.out.println("命中！撃沈！");
								}
							}else if(allies[i+1][j+1] > 0 || allies[i+1][j] > 0 || allies[i+1][j-1] > 0 || allies[i][j+1] > 0 ||
									allies[i][j-1] > 0 || allies[i-1][j+1] > 0 || allies[i-1][j] > 0 || allies[i-1][j-1] > 0){ // > 0 means there exist an enemy
								System.out.println("波高し！");
								totalHp = total(allies);
								numSub = _num(allies);
								moveEquation(moveEq, totalHp, numSub, nextMove);
							}else{
								System.out.println("ハズレ！");
								totalHp = total(allies);
								numSub = _num(allies);
								moveEquation(moveEq, totalHp, numSub, nextMove);
							}

						}
					}
				}
			}else{
				System.out.println("Error : Input proper order!");
			}
			
			System.out.println("Input print, move, or attack");
        }  
		sc.close();
	}

}
