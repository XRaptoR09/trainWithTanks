package trainWithTanks;

import java.awt.*;
import java.awt.event.*;

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
		//!Declarating variables
		//*Locomotive variables
		int locMainY = 100, locMainWidth = 120, locMainHeight = 40;
		
		int locCabinWidth = 35;
		
		int locLeftConnectX = 50, connectWidth = 11, connectHeight = 6, connectPaddingFromBottom = 3;
		
		int wheelDiameter = 16, wheelPadding = 20, amountOfBlocks = 2;
		int wheelConnectorWidth = 10;
		
		//*Platform variables
		int amountOfWheels = 2, amountOfPairs = 2;
		//!Amount of colours should be the same as amountOfPairs
		Color[] pairsColours = {Color.red, Color.CYAN};
		
		int platMainY = 125, platMainWidth = 120, platMainHeight = 15;
		
		int amountOfPlatforms = 3;

		//*Carriage variables
		int roofY = 100, roofWidth = 170, roofHeight = 5;
		
		int mainWidth = roofWidth - 20, mainHeight = 35;
		int amountOfWindows = 5, windowHeight = 15;
		
		int spaceAround = mainWidth / ((amountOfWindows * 2) + 1);

		int windowWidth = 15, windowPadding = windowWidth;

		int amountOfCarriages = 2;

		//*Countable variables
		//*Locomotive
		//Добавляем смещение из-за начала координат вне Фрейма
		locMainY = locMainY + 30;
		locLeftConnectX = locLeftConnectX + 8;

		int	
		locCabinX = (locLeftConnectX + connectWidth),
		locCabinHeight = (locMainHeight / 3),
		locCabinY = (locMainY + locMainHeight) - locCabinHeight,

		locMainX = (locCabinX + locCabinWidth),
		
		connectY = (((locMainY + locMainHeight) - connectPaddingFromBottom) - connectHeight),
		locRightConnectX = (locMainX + locMainWidth),
		
		wheelsY = (locMainY + locMainHeight),
		locWheelX = (locCabinX + wheelPadding),
		wheelConnectorX = locWheelX + wheelDiameter,
		wheelConnectorY = wheelsY + (wheelDiameter / 3),
		wheelConnectorHeight = (wheelDiameter / 3),

		glassX1 = locCabinX,
		glassY1 = locCabinY,
		glassX2 = locMainX,
		glassY2 = locMainY,


		blockShift = ((locCabinWidth + locMainWidth) - (((wheelDiameter * 2) * 2) + (wheelPadding * 2) + (wheelConnectorWidth * 2)));
		if (amountOfBlocks > 2) {
			blockShift = blockShift / (amountOfBlocks - 1);
		}

		

		//! Locomotive
			g.drawRect(locMainX, locMainY, locMainWidth, locMainHeight);			//main
			g.drawRect(locCabinX, locCabinY, locCabinWidth, locCabinHeight);		//cabin
			g.drawRect(locLeftConnectX, connectY, connectWidth, connectHeight);		//connect-left
			g.drawRect(locRightConnectX, connectY, connectWidth, connectHeight);	//connect-right
			g.drawLine(glassX1, glassY1, glassX2, glassY2);		//glass
			for (int i = 0; i < amountOfBlocks; i++) {
				for (int j = 0; j < 2; j++) {
					g.drawOval(locWheelX, wheelsY, wheelDiameter, wheelDiameter);		//2 wheels
					locWheelX = locWheelX + wheelConnectorWidth + wheelDiameter;
				}
				g.drawRect(wheelConnectorX, wheelConnectorY, wheelConnectorWidth, wheelConnectorHeight);
				wheelConnectorX = (wheelConnectorX + blockShift) + ((wheelDiameter * 2) + wheelConnectorWidth);
				locWheelX = locWheelX - wheelConnectorWidth;
				locWheelX = locWheelX + blockShift;
			}

		//!Platform
		int platLeftConnectX = (locRightConnectX + connectWidth);

		platMainY = platMainY + 30;

		int	platMainX = (platLeftConnectX + connectWidth),
		
		platRightConnectX = (platMainX + platMainWidth);
		int
		wheelX = (platMainX + wheelPadding),

		platformWidth = (connectWidth * 2) + platMainWidth,

		platPairShift = ((platMainWidth) - (((wheelDiameter * amountOfWheels) * amountOfPairs) + (wheelPadding * 2)));
		
		//*Paint
		for (int p = 0; p < amountOfPlatforms; p++) {
		if (amountOfPairs > 2) {
			platPairShift = platPairShift / (amountOfPairs - 1);
		}
			if (pairsColours.length != amountOfPairs) {
				g.setColor(Color.red.brighter());
				g.setFont(new Font("Arial", Font.BOLD, 50));
				g.drawString("Mistake in your code!!!".toUpperCase(), 30, 100);
			}else{
				g.setColor(Color.black);
				g.drawRect(platLeftConnectX, connectY, connectWidth, connectHeight);		//connect-left
				g.drawRect(platMainX, platMainY, platMainWidth, platMainHeight);			//main
				g.drawRect(platRightConnectX, connectY, connectWidth, connectHeight);		//connect-right
				for (int i = 0; i < amountOfPairs; i++) {
					g.setColor(pairsColours[i]);
					for (int j = 0; j < amountOfWheels; j++) {
						g.drawOval(wheelX, wheelsY, wheelDiameter, wheelDiameter);		//2 wheels
						wheelX = wheelX + wheelDiameter;
					}
					wheelX = wheelX + platPairShift;
				}
				platLeftConnectX = platLeftConnectX + (platformWidth);
				platMainX = (platLeftConnectX + connectWidth);
				platRightConnectX = (platMainX + platMainWidth);
				wheelX = (platMainX + wheelPadding);
			}
		}
		platLeftConnectX = platLeftConnectX - (platformWidth);
		platMainX = (platLeftConnectX + connectWidth);
		platRightConnectX = (platMainX + platMainWidth);
		wheelX = (platMainX + wheelPadding);

		//! Carriage for variables
		roofY = roofY + 30;
		//*Countable variables
		int leftConnectX = (platRightConnectX + connectWidth);
		
		int	mainY = (roofY + roofHeight),
		mainX = (leftConnectX + connectWidth),
		
		roofX = (mainX - ((roofWidth - mainWidth) / 2)),
		
		rightConnectX = (mainX + mainWidth),
		
		wheel1X = (mainX + wheelPadding),
		
		windowShift = (mainWidth - (windowPadding * 2)) / ((amountOfWindows * 2) - 1),
		windowsY = (mainY + (windowHeight / 2)),
		windowX = (mainX + windowPadding);
		
		if (windowWidth != windowPadding){
			windowX = (mainX + windowPadding) + ((windowPadding - windowWidth));
		}

		int pairShift = ((mainWidth) - (((wheelDiameter * amountOfWheels) * amountOfPairs) + (wheelPadding * 2)));
		
		
		//!Code
		for (int i = 0; i < amountOfCarriages; i++) {
			if (roofWidth < mainWidth) {
				System.out.println("Roof is too short!!!");
			}else{
				for (int p = 0; p < amountOfPairs; p++) {
					g.setColor(pairsColours[i]);
					for (int j = 0; j < amountOfWheels; j++) {
						g.drawOval(wheel1X, wheelsY, wheelDiameter, wheelDiameter);		//2 wheels
						wheel1X = wheel1X + wheelDiameter;
					}
					wheel1X = wheel1X + pairShift;
				}
				g.setColor(Color.black);
				g.drawRect(mainX, mainY, mainWidth, mainHeight);				//main
				g.drawRect(roofX, roofY, roofWidth, roofHeight);				//roof
				g.drawRect(leftConnectX, connectY, connectWidth, connectHeight);	//connect-left
				g.drawRect(rightConnectX, connectY, connectWidth, connectHeight);	//connect-right
				for(int w = 0; w < amountOfWindows; w++) {									//windows
					g.drawRect(windowX, windowsY, windowWidth, windowHeight);		
					windowX = windowX + (spaceAround * 2);
				}
			}
			leftConnectX = leftConnectX + ((connectWidth * 2) + mainWidth);
			mainX = (leftConnectX + connectWidth);
			roofX = (mainX - ((roofWidth - mainWidth) / 2));
			rightConnectX = (mainX + mainWidth);
			wheel1X = (mainX + wheelPadding);
			windowX = (mainX + windowPadding);
			if (windowWidth != windowPadding){
				windowX = (mainX + windowPadding) + ((windowPadding - windowWidth));
			}
		}
	}
}
