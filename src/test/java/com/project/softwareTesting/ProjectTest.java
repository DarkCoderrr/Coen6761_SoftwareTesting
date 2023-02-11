package com.project.softwareTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProjectTest {


	//Testing the Size of the Matrix
	@Test	
	void testfloorSize() {
		int size=10;
		Project projecttestProject=new Project(size);
		
		assertEquals(size, projecttestProject.getN(),"Size of floor is verified");
		
	}
	
	
	//Testing the Turn Right movement
	@Test
	void TurnRight() {

		Project projecttestProject=new Project(10);
		projecttestProject.setFacing("east");
		projecttestProject.TurnRight();// Calling method to move to Right Direction
		String expectedString="south";
		assertEquals(expectedString, projecttestProject.facing,"The TurnRight commands works Properly");	
	}
	
	
	//Testing the Turn Right movement
	@Test
	void TurnLeft() {

		Project projecttestProject=new Project(10);
		projecttestProject.setFacing("east");
		projecttestProject.TurnLeft();// Calling method to move to Left Direction
		String expectedString="north";
		assertEquals(expectedString, projecttestProject.facing," The TurnLeft commands works Properly");	
	}
	
	//Move forward in the path in either direction
	@Test
	void Moveforwardandbackward() {
		Project projecttestProject2=new Project(10);
		int Matrix[][]=new int[10][10];
		projecttestProject2.setMatrix(Matrix); //initializing matrix
		projecttestProject2.setXcoordinate(0); // giving default coordinate of x-axis
		
		//setting up all conditions to move pointer forward to south direction
		// for backward we can change the existing facing to north and changing x-coordinate
		projecttestProject2.pen=true;
		projecttestProject2.setFacing("south");
		projecttestProject2.BoundaryConditiion(5);
		projecttestProject2.Move(5);
		int expectedXcoordinate=5;
		
	assertEquals(expectedXcoordinate,projecttestProject2.getXcoordinate(),"Change is Coordinates Results in verification of Movement of Pen");
		
	}
	
	//Determining the current Position of the pointer
	@Test
	void CurrentPosition() {
		Project projecttestProject2=new Project(10);
		int Matrix[][]=new int[10][10];
		projecttestProject2.setMatrix(Matrix); //initializing matrix
		projecttestProject2.setXcoordinate(5); // giving default coordinate of x-axis
		projecttestProject2.setYcoordinate(5);// giving default coordinate of Y-axis
		//setting up all conditions to move pointer forward to south direction
		// for backward we can change the existing facing to north and changing x-coordinate
		projecttestProject2.pen=true;
		projecttestProject2.setFacing("south");
		projecttestProject2.BoundaryConditiion(2); //setting up Boundary Condition
		projecttestProject2.Move(2);//setting up value to move the pointer
		int[] popk=new int[2];
	    popk=projecttestProject2.PrintCurrentLocation();
		int[] expectedXcoordinate= {7,5};
		
		assertArrayEquals(expectedXcoordinate, popk," These are the current coordinates of pen");
	}

	
	@Test
	void XYDefaultpositions() {
		Project project=new Project(10);
		project.setXcoordinate(5);
		project.setYcoordinate(5);
		int[] popk=new int[2];
	    popk=project.PrintCurrentLocation();
	    int[] expectedXcoordinate= {5,5};
	    assertArrayEquals(expectedXcoordinate, popk,"The initial position of coordinates are verified");
		
	}
	
	@Test
	void TestingDirectionofPen() {
		Project projecttestProject=new Project(10);
		projecttestProject.setFacing("east");
		projecttestProject.TurnRight();// Calling method to move to Right Direction
		String expectedString="south";
		assertEquals(expectedString, projecttestProject.getFacing(),"The Expected Direction Matches with the Tested one.");
	}
	
	@Test
	void PrintingAstriskSign() {
		Project projecttestProject2=new Project(5);
		int Matrix[][]=new int[5][5];
		projecttestProject2.setMatrix(Matrix); //initializing matrix
		
		projecttestProject2.setXcoordinate(1); // giving default coordinate of x-axis
		projecttestProject2.setYcoordinate(1);// giving default coordinate of Y-axis
		//setting up all conditions to move pointer forward to south direction
		// for backward we can change the existing facing to north and changing x-coordinate
		projecttestProject2.pen=true;
		projecttestProject2.setFacing("south");
		projecttestProject2.BoundaryConditiion(2); //setting up Boundary Condition
		projecttestProject2.Move(2);//setting up value to move the pointer
		
		String expectedmatrix[][]= new String[][] {
			{" "," "," "," "," "},
			{" ","*"," "," "," "},
			{" ","*"," "," "," "},
			{" "," "," "," "," "},
			{" "," "," "," "," "}
		
		};
		
		assertArrayEquals(expectedmatrix, projecttestProject2.print(),"Both the Matrix are same");
	}
	
	
	//To test if the robot identifies a position outside the grid.
	@Test
	 void TestBoundaryConditions(){
		Project project=new Project(5);
		project.setXcoordinate(4); // giving default coordinate of x-axis
		project.setYcoordinate(0);
		project.pen=true;
		project.setFacing("north");
		project.TurnLeft();
		project.BoundaryConditiion(2);
		
		assertEquals(false,project.BoundaryConditiion(2),"Cannot Move outside of the grid ");
//		project.Move(2);
	}
	
//to test whether the pen is up or down.		
	@Test
	void PenUPDown() {
		Project project=new Project(5);
		project.setXcoordinate(4); // giving default coordinate of x-axis
		project.setYcoordinate(0);
		project.penDown();
		boolean pen=true;
		
		assertEquals(pen, project.penDown(),"CurrentPosition of pen is Down");
		
		assertNotEquals(pen, project.penUp(),"CurrentPosition of pen is UP");
	}
}
