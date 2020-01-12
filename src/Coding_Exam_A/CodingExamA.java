package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		int i = Integer.parseInt(JOptionPane.showInputDialog("How many robots?"));
		String [] color  = new String [i];
		int [] sides = new int [i];
		Thread [] t = new Thread [i];
		Robot [] r = new Robot [i];
		for (int j = 0; j < r.length; j++) {
			color[j] = JOptionPane.showInputDialog("What color?");
		}
		for (int j = 0; j < r.length; j++) {
			sides[j] = Integer.parseInt(JOptionPane.showInputDialog("How many sides?"));
		}
		for (int j = 0; j < r.length; j++) {
			r[j] = new Robot((j * 100) + 50, 250);
				//r[j].setPenColor(Color.getColor(color[j]));
				r[j].penDown();
				r[j].hide();
		}
		for (int j = 0; j < i; j++) {
			int num = j;
			t[j] = new Thread (()->{
				System.out.println(sides[num]);
				if(sides[num] == 3){
					for (int k = 0; k < 3; k++) {
						r[num].move(50);
						r[num].turn(60);
					}
				}
				if(sides[num] == 4){
					for (int k = 0; k < 4; k++) {
						r[num].move(50);
						r[num].turn(90);
					}
				}
				else{
					for (int k = 0; k < sides[num]; k++) {
					r[num].move(50);
					r[num].turn((60*(sides[num]+1))/sides[num]);
				}
				}
				
				
			});
		}
		for (Thread thread : t) {
			thread.start();
		}

		
		



	}
}
