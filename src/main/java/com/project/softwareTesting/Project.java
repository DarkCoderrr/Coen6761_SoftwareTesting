package com.project.softwareTesting;

import java.util.Scanner;

public class Project {

	int N;
	int[][] floor = new int[N][N];
	int Xcoordinate = N - 1;
	int Ycoordinate = 0;

	String facing = "north";
	boolean pen;
	String penValueString = "Up";

	public Project(int n) {
		this.N = n;
	}

	public int getXcoordinate() {
		return Xcoordinate;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public int getN() {
		return N;
	}

	public void setMatrix(int[][] matrix) {
		this.floor = matrix;
	}

	public void setXcoordinate(int xcoordinate) {
		Xcoordinate = xcoordinate;
	}

	public void setYcoordinate(int ycoordinate) {
		Ycoordinate = ycoordinate;
	}

	public boolean penDown() {
		this.pen = true;
		this.penValueString = "Down";
		return true;
	}

	public boolean penUp() {
		this.pen = false;
		this.penValueString = "UP";
		return false;
	}

//	public int[][] initializeFloor(int size) {
//		int matrix[][]=new int[size][size];
//		for(int i=0;i<size;i++) {
//			for(int j=0;j<size;j++) {
//				matrix[i][j]=0;
//			}
//		}
//		this.floor=matrix;
//		this.N=N;
//		return matrix;
//	}
	public void InputCommand() {

		for (int i = 0; i < N * N; i++) {
			System.out.print("Enter one of the above Command : ");
			Scanner objScanner = new Scanner(System.in);
			String inputCommandString = objScanner.nextLine();

			if (inputCommandString.equalsIgnoreCase("U") || inputCommandString.equalsIgnoreCase("u")) {
				penUp();
			} else if (inputCommandString.equalsIgnoreCase("D") || inputCommandString.equalsIgnoreCase("d")) {
				penDown();
			} else if (inputCommandString.equalsIgnoreCase("R") || inputCommandString.equalsIgnoreCase("r")) {
				TurnRight();
			} else if (inputCommandString.equalsIgnoreCase("L") || inputCommandString.equalsIgnoreCase("l")) {
				TurnLeft();
			} else if (inputCommandString.equalsIgnoreCase("C") || inputCommandString.equalsIgnoreCase("c")) {
				PrintCurrentLocation();
			} else if (inputCommandString.equalsIgnoreCase("P") || inputCommandString.equalsIgnoreCase("p")) {
				print();
			} else if (inputCommandString.equalsIgnoreCase("Q") || inputCommandString.equalsIgnoreCase("q")) {
				break;
			} else {
				if (inputCommandString.charAt(0) == 'M' || inputCommandString.charAt(0) == 'm') {
					String digits[] = inputCommandString.split(" ");
					int distance = Integer.parseInt(digits[1]);
					Move(distance);
				}
			}
		}

	}

	public int[] PrintCurrentLocation() {
		int coordinates[] = new int[2];
		coordinates[0] = Xcoordinate;
		coordinates[1] = Ycoordinate;
		System.out.println(">Position: " + Xcoordinate + " , " + Ycoordinate + "- Pen: " + penValueString
				+ " - Facing: " + facing);
		return coordinates;

	}

	public boolean BoundaryConditiion(int distance) {
		if ((facing.equals("east") && (distance <= (N - Ycoordinate)))
				|| (facing.equals("west") && (distance <= Ycoordinate))
				|| (facing.equals("north") && (distance <= Xcoordinate))
				|| (facing.equals("south") && (distance <= (N - Xcoordinate))))

		{
			return true;
		} else {
			return false;
		}

	}

	public String getFacing() {
		return facing;
	}

	public void TurnRight() {
		if (facing.equals("north")) {
			facing = "east";
		} else if (facing.equals("east")) {
			facing = "south";
		} else if (facing.equals("south")) {
			facing = "west";
		} else if (facing.equals("west")) {
			facing = "north";
		}

	}

	public void TurnLeft() {
		if (facing.equals("north")) {
			facing = "west";
		} else if (facing.equals("west")) {
			facing = "south";
		} else if (facing.equals("south")) {
			facing = "east";
		} else if (facing.equals("east")) {
			facing = "north";
		}

	}

	public void Move(int distance) {

		for (int j = distance; j > 0; j--) {

			if (facing.equals("north") && pen && BoundaryConditiion(j)) {
				floor[Xcoordinate][Ycoordinate] = 1;
				Xcoordinate--;
			}

			else if (facing.equals("east") && pen && BoundaryConditiion(j)) {
				floor[Xcoordinate][Ycoordinate] = 1;
				Ycoordinate++;
			}

			else if (facing.equals("south") && pen && BoundaryConditiion(j)) {
				floor[Xcoordinate][Ycoordinate] = 1;
				Xcoordinate++;
			}

			else if (facing.equals("west") && pen && BoundaryConditiion(j)) {
				floor[Xcoordinate][Ycoordinate] = 1;
				Ycoordinate--;
			}

			else if (!pen) {
				floor[Xcoordinate][Ycoordinate] = 2;
				if (facing.equals("north")) {
					Xcoordinate--;
				} else if (facing.equals("east")) {
					Ycoordinate++;
				} else if (facing.equals("south")) {
					Xcoordinate++;
				} else {
					Ycoordinate--;
				}
			}

			else if (!BoundaryConditiion(distance)) {
				System.out.println("Cannot move outside of floor boundaries.");
			}
		}
	}

	public void setN(int n) {
		N = n;
	}

	public String[][] print() {
		String testmatrix[][] = new String[N][N]; // Defined matrix for testing purpose
//		System.out.println(n);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (floor[i][j] == 1) {
					System.out.print("*");
					testmatrix[i][j] = ("*");// setting value for testing
				}
//               	else if  (floor[i][j] == 2) {
//                    System.out.print("$");
//                }
				else {
					System.out.print(" ");
					testmatrix[i][j] = (" "); // setting value for testing
				}

			}
			System.out.println();
		}
		return testmatrix;
	}

	public static void main(String[] args) {

		System.out.println("[U|u] Pen up\r\n" + "[D|d] Pen down\r\n" + "[R|r] Turn right\r\n" + "[L|l] Turn left\r\n"
				+ "[M s|m s] Move forward s spaces (s is a non-negative integer)\r\n"
				+ "[P|p] Print the N by N array and display the indices\r\n"
				+ "[C|c] Print current position of the pen and whether it is up or down and its\r\n"
				+ "facing direction\r\n" + "[Q|q] Stop the program\r\n"
				+ "[I n|i n] Initialize the system: The values of the array floor are zeros and the robot\r\n"
				+ "is back to [0, 0], pen up and facing north. n size of the array, an integer\r\n"
				+ "greater than zero");

		System.out.println("Enter The First command to initialize Size of Array: ");
		Scanner objScanner = new Scanner(System.in);
		String sizeString = objScanner.nextLine();

		if (sizeString.charAt(0) == 'I' || sizeString.charAt(0) == 'N' || sizeString.charAt(0) == 'i'
				|| sizeString.charAt(0) == 'n') {

			String digits[] = sizeString.split(" ");
			int distance = Integer.parseInt(digits[1]);

			Project project = new Project(distance);

			int matrix[][] = new int[distance][distance];
			project.setMatrix(matrix);
			project.setXcoordinate(distance - 1);

			project.InputCommand();

		}

	}

}
