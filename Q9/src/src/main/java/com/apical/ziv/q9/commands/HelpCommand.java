/**
 * HelpCommand.java
 */
package com.apical.ziv.q9.commands;

import com.apical.ziv.q9.interfaces.Command;

/**
 * @author ziv
 *
 */
public class HelpCommand implements Command {

	@Override
	public void execute() {
		System.out.println("This application can handle shape, such as clac area, or if a point is in a shape, and so on.");
		System.out.println("You can give the file path via -DinputFile=/file/to/path, and then program will read the file as console");
		System.out.println("command :help  display the instructions of this application");
		System.out.println("command :exit  exit this application");

		System.out.println("command :rectangle ${x} ${y} ${width} ${height} to add rectangle into this application");
		System.out.println("         (x,y) is the left bottom point of this rectangle , width is the width of this rectangle, height is the height of this rectangle");
		System.out.println("         for example:rectangle 0 0 2 4");

		System.out.println("command :square ${x} ${y} ${length}  to add square into this application");
		System.out.println("         (x,y) is the left bottom point of this square , length is the length of square's side");
		System.out.println("         for example:rsquare 0 0 4");

		System.out.println("command :triangle ${x1} ${y1} ${x2} ${y2} ${x3} ${y3}  to add triangle into this application");
		System.out.println("         (x1,y1) (x2,y2) (x3,y3) are the coordinates of three points");
		System.out.println("         for example:triangle 0 0 2 0 0 2");

		System.out.println("command :circle ${x} ${y} ${radius} to add circle into this application");
		System.out.println("         (x,y) is the  coordinate of the heart of this circle , radius is the radius of this circle");
		System.out.println("         for example:circle 0 0 2");

		System.out.println("command :donut ${x} ${y} ${innerradius} ${outterradius} to add a donut into this application");
		System.out.println("         (x,y) is the  coordinate of the heart of this donut , innerradius is the inner radius of this donut , outterradius is the outer radius of this donut.");
		System.out.println("         for example:donut 0 0 2 4");

		System.out.println("command :${x},${y} to input a point, and the system will find all shapes that contains this point");
		System.out.println("         (x,y) is the  coordinate of this point");
		System.out.println("         for example:1,2");

		System.out.println("command :overlap ${typeofshape} ${parameterofshape}");
		System.out.println("         typeofshape includes rectangle square triangle circle donut, parameterofshape like those parameter in those shape command");
		System.out.println("         for example:overlap circle 0 0 2");

	}

}
