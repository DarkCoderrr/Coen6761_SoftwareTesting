# Coen6761_SoftwareTesting

This Java program simulates the robot capabilities to move through the floor. The program must keep track of the current position of the robot at all times and whether the pen is up or down. As the robot moves with the pen down, set the appropriate elements of the array floor to 1 (no matter how many time it has been traced). When the 6 command (i.e. print) is given, wherever there is a 1 in the array, display an asterisk; wherever there is a zero, displays a blank.

Command: I 10
(This should initialize the system as a 10 x 10 array. The values of the array floor are all set to zeros and the robot is back to [0, 0], pen up and facing north.)

Command: C
Position: 0, 0 - Pen: up - Facing: north
(This is output by the program to indicate the position of the robot and the whether the pen is up or down)

Command: D
(Orders the robot pen down)

Command: M 4
(Orders the robot move 4 cells forward, the new position of the robot is now 0, 4)

Command: R
(Orders the robot turn right)

Command: P
(To display the floor)
