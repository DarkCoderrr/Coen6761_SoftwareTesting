package com.project.softwareTesting;



import java.util.Scanner;

public class Project {

	int N;
	int[][] floor ;
	int Xcoordinate;
	int Ycoordinate;
	String facing;
	boolean pen;
	String penValueString;
	boolean movepen=true;

	public int getXcoordinate() { 
		return Xcoordinate;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public int getN() {
		return N;
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
	 public void initialize(int newSize) {
	        this.N = newSize;
	        this.floor = new int[N][N];
	        setXcoordinate(N-1);
	        setYcoordinate(0);
//	        this.Xcoordinate = N-1;
//	        this.Ycoordinate = 0;
	        penUp();
	        this.facing = "North";
	    }

	public char InputCommand() {
       
	 char returncommand='X';
		Scanner objScanner = new Scanner(System.in);
		boolean running = true;
		while(running==true){
			System.out.print("Enter one of the above Command : ");
			
			String inputCommandString = objScanner.nextLine();
			char command = inputCommandString.charAt(0);
			returncommand=command;
			
			switch (command) {
            case 'U':
            case 'u':
                penUp(); 
                break;
            case 'D':
            case 'd':
                penDown();
                break;
            case 'R':
            case 'r':
            	turnRight();            	
                break;
            case 'L':
            case 'l':
            	turnLeft();
                break;
            case 'M':
            case 'm':
                String[] parts = inputCommandString.split(" ");
                int distance = Integer.parseInt(parts[1]);
                moveForwardBackward(distance);
                break;
            case 'P':
            case 'p':
            	print();
                break;
            case 'C':
            case 'c':
            	PrintCurrentLocation();
                break;
            case 'I':
            case 'i':
                String[] sizeParts = inputCommandString.split(" ");
                int newSize = Integer.parseInt(sizeParts[1]);
                initialize(newSize);
                break;
            case 'Q':
            case 'q':
                running = false;
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
	
		}
		objScanner.close();
		return returncommand;
	}
	
	public int[] PrintCurrentLocation() {
		int coordinates[] = new int[2];
		int updatedX=this.N-Xcoordinate-1;
		coordinates[0] = updatedX;
		coordinates[1] = Ycoordinate;
		System.out.println(">Position: " + updatedX + " , " + Ycoordinate + "- Pen: " + penValueString
				+ " - Facing: " + facing);
		return coordinates;

	}

	public boolean BoundaryConditiion(int distance) {
		if ((this.facing=="East" && (this.Ycoordinate + distance < this.N))
				|| (this.facing=="West"&& (this.Ycoordinate - distance >= 0))
				|| (this.facing=="North" && (this.Xcoordinate - distance >= 0))
				|| (this.facing=="South" && (this.Xcoordinate + distance < this.N)))

		{
			this.movepen=true;
			return movepen;
		} else {
			this.movepen=false;
			return movepen;
		}

	}

	public String getFacing() {
		return facing;
	}

	public void turnRight() {
		if (this.facing=="North") {
			setFacing("East");
		} else if (this.facing=="East") {
			setFacing("South");
		} else if (this.facing=="South") {
			setFacing("West");
		} else if (this.facing=="West") {
			setFacing("North");
		}

	}


	public void turnLeft() {
		if (this.facing=="North") {
			setFacing("West");
		} else if (this.facing=="West") {
			setFacing("South");
		} else if (this.facing=="South") {
			setFacing("East");
		} else if (this.facing=="East") {
			setFacing("North");
		}

	}


	
	 public void moveForwardBackward(int distance) {
		 BoundaryConditiion(distance);		 
	        switch (this.facing) {
	            case "North":
	                if (this.pen && movepen) {
	                    for (int i = 1; i <= distance; i++) {
	                        if (this.Xcoordinate - i >= 0) {
	                            this.floor[this.Xcoordinate -i][this.Ycoordinate] = 1;
	                        }
	                    }
	                }
	                else if(!this.pen && movepen) {
	                	for (int i = 1; i <= distance; i++) {
	                        if (this.Xcoordinate - i >= 0) {
	                            this.floor[this.Xcoordinate -i][this.Ycoordinate] = 0;
	                        }
	                    }
	                }
	                else {
	                	System.out.println("Please provide Distance within Floor Space Size");
						break;
					}
	                this.Xcoordinate -= distance;	                
	                break;
	            case "East":
	                if (this.pen && movepen) {
	                    for (int i = 1; i <= distance; i++) {
	                        if (this.Ycoordinate + i < this.N) {
	                            this.floor[this.Xcoordinate][this.Ycoordinate + i] = 1;
	                        }
	                    }
	                }
	                else if(!this.pen && movepen) {
	         
		                    for (int i = 1; i <= distance; i++) {
		                        if (this.Ycoordinate + i < this.N) {
		                            this.floor[this.Xcoordinate][this.Ycoordinate + i] = 0;
		                        }
		                    }
		                }
	                
	                else {
	                	System.out.println("Please provide Distance within Floor Space Size");
						break;
					}
	                this.Ycoordinate += distance;
	                break;
	            case "South":
	                if (this.pen&& movepen) {
	                    for (int i = 1; i <= distance; i++) {
	                        if (this.Xcoordinate + i < this.N) {
	                            this.floor[this.Xcoordinate + i][this.Ycoordinate] = 1;
	                        }
	                    }
	                }
	                else if (!this.pen&& movepen) {
	                    for (int i = 1; i <= distance; i++) {
	                        if (this.Xcoordinate + i < this.N) {
	                            this.floor[this.Xcoordinate + i][this.Ycoordinate] = 0;
	                        }
	                    }
	                }
	                else {
	                	System.out.println("Please provide Distance within Floor Space Size");
						break;
					}
	                this.Xcoordinate += distance;
	                break;
	            case "West":
	                if (this.pen&& movepen) {
	                    for (int i = 1; i <= distance; i++) {
	                        if (this.Ycoordinate - i >= 0) {
	                            this.floor[this.Xcoordinate][this.Ycoordinate - i] = 1;
	                        }
	                    }
	                }
	                else if (this.pen==false && movepen) {
	                    for (int i = 1; i <= distance; i++) {
	                        if (this.Ycoordinate - i >= 0) {
	                            this.floor[this.Xcoordinate][this.Ycoordinate - i] = 0;
	                        }
	                    }
	                }
	                else {
	                	System.out.println("Please provide Distance within Floor Space Size");
						break;
					}
	                this.Ycoordinate -= distance;
	                break;
	            default:
	                System.out.println("Invalid direction");
	                break;
	        }
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


			Project project = new Project();

			project.InputCommand();



	}

}
