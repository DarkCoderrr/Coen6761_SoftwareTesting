package com.project.softwareTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ProjectTest {


	//Testing the Size of the Matrix
	@Test	
	void testfloorSize() {
		int size=10;
		Project projecttestProject=new Project();
		projecttestProject.initialize(10);
		assertEquals(size, projecttestProject.getN(),"Size of floor is verified");
		
	}
	
	
	//Testing the Turn Right movement
	@Test
	void TurnRight() {

		Project projecttestProject=new Project();
		projecttestProject.initialize(10);
		projecttestProject.turnRight();// Calling method to move to Right Direction
		String expectedString="East";
		assertEquals(expectedString, projecttestProject.getFacing(),"The TurnRight commands works Properly");	
	}
	
	
	//Testing the Turn Right movement
	@Test
	void TurnLeft() {

		Project projecttestProject=new Project();
		projecttestProject.initialize(10);
		projecttestProject.turnLeft();// Calling method to move to Left Direction
		String expectedString="West";
		assertEquals(expectedString, projecttestProject.facing," The TurnLeft commands works Properly");	
	}
	
	//Move forward in the path in either direction
	@Test
	void Moveforwardandbackward() {
		Project projecttestProject2=new Project();
		projecttestProject2.initialize(10);
		projecttestProject2.moveForwardBackward(4);
		int expectedXcoordinate=5;
		
	assertEquals(expectedXcoordinate,projecttestProject2.getXcoordinate(),"Change is Coordinates Results in verification of Movement of Pen");
		
	}
	
//	//Determining the current Position of the pointer
	@Test
	void CurrentPosition() {
		Project projecttestProject2=new Project();
		projecttestProject2.initialize(10);
		projecttestProject2.moveForwardBackward(2);//setting up value to move the pointer
		int[] popk=new int[2];
	    popk=projecttestProject2.PrintCurrentLocation();
		int[] expectedXcoordinate= {2,0};
		
		assertArrayEquals(expectedXcoordinate, popk," These are the current coordinates of pen");
	}

	
	@Test
	void XYDefaultpositions() {
		Project project=new Project();
		project.initialize(5);
		int[] popk=new int[2];
	    popk=project.PrintCurrentLocation();
	    int[] expectedXcoordinate= {0,0};
	    assertArrayEquals(expectedXcoordinate, popk,"The initial position of coordinates are verified");
		
	}
	
	@Test
	void TestingDirectionofPen() {
		Project projecttestProject=new Project();
		projecttestProject.setFacing("East");
		projecttestProject.turnRight();// Calling method to move to Right Direction
		String expectedString="South";
		assertEquals(expectedString, projecttestProject.getFacing(),"The Expected Direction Matches with the Tested one.");
	}
	@Test
	void TestingDirectionofPen2() {
		Project projecttestProject=new Project();
		projecttestProject.setFacing("East");
		projecttestProject.turnLeft();// Calling method to move to Right Direction
		String expectedString="North";
		assertEquals(expectedString, projecttestProject.getFacing(),"The Expected Direction Matches with the Tested one.");
	}
	@Test
	void PrintingAstriskSign() {
		Project projecttestProject2=new Project();
		projecttestProject2.initialize(5);
		projecttestProject2.penDown();
		projecttestProject2.moveForwardBackward(2);//setting up value to move the pointer
		
		String expectedmatrix[][]= new String[][] {
			{" "," "," "," "," "},
			{" "," "," "," "," "},
			{"*"," "," "," "," "},
			{"*"," "," "," "," "},
			{" "," "," "," "," "}
		
		}; 
		
		assertArrayEquals(expectedmatrix, projecttestProject2.print(),"Both the Matrix are same");
	}
	
	@Test
	void PrintingAstriskSign2() {
		Project projecttestProject2=new Project();
		projecttestProject2.initialize(5);
		projecttestProject2.penDown();
		projecttestProject2.moveForwardBackward(2);//setting up value to move the pointer
		projecttestProject2.turnRight();
		projecttestProject2.moveForwardBackward(2);
		projecttestProject2.turnRight();
		projecttestProject2.moveForwardBackward(2);
		projecttestProject2.turnRight();
		projecttestProject2.moveForwardBackward(1);
		
		String expectedmatrix[][]= new String[][] {
			{" "," "," "," "," "},
			{" "," "," "," "," "},
			{"*","*","*"," "," "},
			{"*"," ","*"," "," "},
			{" ","*","*"," "," "}
		
		};
		
		assertArrayEquals(expectedmatrix, projecttestProject2.print(),"Both the Matrix are same");
	}
	
	@Test
	void PrintingAstriskSign3() {
		Project projecttestProject3=new Project();
		projecttestProject3.initialize(5);
		projecttestProject3.penUp();
		projecttestProject3.moveForwardBackward(3);//setting up value to move the pointer
		projecttestProject3.turnRight();
		projecttestProject3.moveForwardBackward(2);
		projecttestProject3.turnRight();
		projecttestProject3.moveForwardBackward(2);
		projecttestProject3.turnRight();
		projecttestProject3.moveForwardBackward(2);
		
		
		String expectedmatrix[][]= new String[][] {
			{" "," "," "," "," "},
			{" "," "," "," "," "},
			{" "," "," "," "," "},
			{" "," "," "," "," "},
			{" "," "," "," "," "}
		
		};
		
		assertArrayEquals(expectedmatrix, projecttestProject3.print(),"Both the Matrix are same");
	}
	
	
	//To test if the robot identifies a position outside the grid.
	@Test
	 void TestBoundaryConditions(){
		Project project=new Project();
		project.initialize(10);
		project.turnLeft();
		assertEquals(false,project.BoundaryConditiion(2),"Cannot Move outside of the grid ");
	}
	
////to test whether the pen is up or down.		
	@Test
	void PenUPDown() {
		Project project=new Project();
		project.initialize(10);
		boolean pen=true;
		
		assertEquals(pen, project.penDown(),"CurrentPosition of pen is Down");
		
		assertNotEquals(pen, project.penUp(),"CurrentPosition of pen is UP");
	}

	 @Test
	    public void testInputCommandQ() {
	        Project project = new Project();
	        char expectedCommand = 'Q'; 
	        String inputString = "Q";
	        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
	        System.setIn(in);
//	        System.setIn(new java.io.ByteArrayInputStream(("P\n").getBytes()));
	        char actualCommand = project.InputCommand();
	        assertEquals(expectedCommand, actualCommand);
	    }

	
	
}
