package trainWithTanks;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class trainPainter extends Frame{

	public static void main(String[] args) {
		trainPainter trainPainter = new trainPainter("My Train Painter");
		trainPainter.setSize(1300, 700);
		trainPainter.setVisible(true);
	}
	trainPainter(String title){
		super(title);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}
		});
	}
	public void paint(Graphics g) {
		//! Carriage for variables
		//*Declarating variables
		int mainY = 100, mainWidth = 240, mainHeight = 40;
		int leftConnectX = 50, connectWidth = 6, connectHeight = 12, connectPaddingFromBottom = 15;
		int wheelDiameter = 16, wheelPadding = 20, amountOfWheels = 3, amountOfPairs = 3;
		//!Amount of colours should be the same as amountOfPairs
		Color[] pairsColours = {Color.red, Color.green, Color.CYAN};

		//*Countable variables
		//Добавляем смещение из-за начала координат вне Фрейма
		mainY = mainY + 30;
		leftConnectX = leftConnectX + 8;

		int	mainX = (leftConnectX + connectWidth),
		
		connectY = (((mainY + mainHeight) - connectPaddingFromBottom) - connectHeight),
		rightConnectX = (mainX + mainWidth),
		
		wheelsY = (mainY + mainHeight),
		wheelX = (mainX + wheelPadding),

		pairWidth = wheelDiameter * amountOfWheels,
		pairShift = ((mainWidth) - (((wheelDiameter * amountOfWheels) * amountOfPairs) + (wheelPadding * 2)));
		if (amountOfPairs > 2) {
			pairShift = pairShift / (amountOfPairs - 1);
		}

		//!Code
		if (pairsColours.length != amountOfPairs) {
			g.setColor(Color.red.brighter());
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Mistake in your code!!!".toUpperCase(), 30, 100);
		}else{
			g.drawRect(mainX, mainY, mainWidth, mainHeight);						//main
			g.drawRect(leftConnectX, connectY, connectWidth, connectHeight);			//connect-left
			g.drawRect(rightConnectX, connectY, connectWidth, connectHeight);			//connect-right
			for (int i = 0; i < amountOfPairs; i++) {
				g.setColor(pairsColours[i]);
				for (int j = 0; j < amountOfWheels; j++) {
					g.drawOval(wheelX, wheelsY, wheelDiameter, wheelDiameter);		//2 wheels
					wheelX = wheelX + wheelDiameter;
				}
				wheelX = wheelX + pairShift;
			}
		}
	}
}
