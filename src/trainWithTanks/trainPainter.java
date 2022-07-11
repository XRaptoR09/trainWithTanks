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
		int locMainY = 100, locMainWidth = 120, locMainHeight = 60;
		
		int locCabinWidth = 35;
		
		int locLeftConnectX = 50, connectWidth = 11, connectHeight = 6, connectPaddingFromBottom = 3;
		
		int wheelDiameter = 16, wheelPadding = 20, amountOfBlocks = 2;
		int wheelConnectorWidth = 10;
		
		//*Platform variables
		int amountOfWheels = 2, amountOfPairs = 2;

		
		int platMainY = 145, platMainWidth = 120, platMainHeight = 15;
		
		int amountOfPlatforms = 2;

		//*Tank variables

		int bodyWidth = 80;

		int dullDiameter = 2;

		int flagstockWidth = 2;

		int amountOfColors = 2;

		int caterpillarPadding = 4;
		

		//*Carriage variables
		int roofY = 100, roofHeight = 5;
		
		int mainHeight = 55;
		
		int amountOfWindows = 4, windowHeight = 15;
		int windowWidth = 15;
		int windowPadding = 20;
		
		int amountOfCarriages = 4;
		
		//*Countable variables
		int mainWidth = ((windowWidth * amountOfWindows) + (windowPadding * (amountOfWindows + 1)));
		
		int roofWidth = mainWidth + 20; 

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

		int	platMainX = (platLeftConnectX + connectWidth),
		
		platRightConnectX = (platMainX + platMainWidth);
		int
		wheelX = (platMainX + wheelPadding),

		platformWidth = (connectWidth * 2) + platMainWidth,

		platPairShift = ((platMainWidth) - (((wheelDiameter * amountOfWheels) * amountOfPairs) + (wheelPadding * 2)));
		
		for (int p = 0; p < amountOfPlatforms; p++) {
		if (amountOfPairs > 2) {
			platPairShift = platPairShift / (amountOfPairs - 1);
		}
			
				g.setColor(Color.black);
				g.drawRect(platLeftConnectX, connectY, connectWidth, connectHeight);		//connect-left
				g.drawRect(platMainX, platMainY, platMainWidth, platMainHeight);			//main
				g.drawRect(platRightConnectX, connectY, connectWidth, connectHeight);		//connect-right
				for (int i = 0; i < amountOfPairs; i++) {
					
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
			//!Tank
				//*Counting variables
				
				int bodyX = (platMainX + ((platMainWidth - bodyWidth) / 2)) - platformWidth;
				
				
				int towerWidth =  bodyWidth / 3;
				towerWidth = (towerWidth + (towerWidth / 5));
				
				int towerHeight = (towerWidth / 2),
				towerX = (bodyX + towerWidth) - (towerWidth / 5);

				
				int
				bodyHeight = bodyWidth / 4;
				
				int towerY = (platMainY - ((towerHeight * 2) + bodyHeight));

				int bodyY = towerY + towerHeight,
				
				dullLength = bodyWidth / 2,
				dullX = towerX + towerWidth,
				dullY = towerY + ((towerHeight - dullDiameter) / 2),
				
				flagstockX = towerX - ((towerWidth / 5) + flagstockWidth),
				flagstockY = towerY,
				flagstockHeight = towerHeight,
		
				flagHeight = (flagstockHeight / 3) * 2,
				flagWidth = flagstockHeight,
				
				tankWheelDiameter = towerHeight,
				tankWheelsY = bodyY + bodyHeight,
				tankWheelXStart = (bodyX + caterpillarPadding) + ((bodyWidth - ((tankWheelDiameter *4) + (caterpillarPadding * 2))) / 2),
				tankWheelX = tankWheelXStart;
				
				for (int c = 0; c < 4; c++) {
					tankWheelX = tankWheelX + tankWheelDiameter;
				}
				int tankWheelXEnd = tankWheelX;
		
				int
				leftLineX1 = bodyX,
				rightLineX1 = bodyX + bodyWidth,
				linesBetweenY1 = tankWheelsY,
				leftLineX2 = tankWheelXStart + (tankWheelDiameter / 3),
				rightLineX2 = tankWheelXEnd - (tankWheelDiameter / 4),
				linesBetweenY2 = tankWheelsY + tankWheelDiameter,
				
				lowLineX1 = tankWheelXStart + (tankWheelDiameter / 2),
				lowLineY1 = linesBetweenY2,
				lowLineX2 = tankWheelXEnd - (tankWheelDiameter / 2),
				lowLineY2 = lowLineY1;
		
				//*Flag
				int flagXStart = (flagstockX - flagWidth);
				int colorHeight = (flagHeight / amountOfColors);
				if (flagHeight % amountOfColors != 0) {
					flagHeight = flagHeight + (amountOfColors - (flagHeight % amountOfColors));
				}
				colorHeight = (flagHeight / amountOfColors);
		
				g.setColor(Color.blue);
				g.fillRect(flagXStart, flagstockY, flagWidth, colorHeight);
				g.setColor(Color.yellow);
				g.fillRect(flagXStart, flagstockY + colorHeight, flagWidth, colorHeight);
				g.setColor(Color.lightGray);
				g.fillRect(flagstockX, flagstockY, flagstockWidth, flagstockHeight);
				
				g.setColor(Color.black);
				g.drawRect(flagXStart, flagstockY, flagWidth, flagHeight);
				g.drawRect(flagstockX, flagstockY, flagstockWidth, flagstockHeight);
				g.drawRect(towerX, towerY, towerWidth, towerHeight);
				g.drawRect(dullX, dullY, dullLength, dullDiameter);
				g.drawRect(bodyX, bodyY, bodyWidth, bodyHeight);
				
				g.drawLine(leftLineX1, linesBetweenY1, leftLineX2, linesBetweenY2);
				g.drawLine(rightLineX1, linesBetweenY1, rightLineX2, linesBetweenY2);
				g.drawLine(lowLineX1, lowLineY1, lowLineX2, lowLineY2);
		
				tankWheelX = tankWheelXStart;
				g.setColor(Color.white);
				for (int tb = 0; tb < 4; tb++) {
					g.fillOval(tankWheelX, tankWheelsY, tankWheelDiameter, tankWheelDiameter);
					tankWheelX = tankWheelX + tankWheelDiameter;
				}
				g.setColor(Color.black);
		
				tankWheelX = tankWheelXStart;
				for (int t = 0; t < 4; t++) {
					g.drawOval(tankWheelX, tankWheelsY, tankWheelDiameter, tankWheelDiameter);
					tankWheelX = tankWheelX + tankWheelDiameter;
				}
		}
		platLeftConnectX = platLeftConnectX - (platformWidth);
		platMainX = (platLeftConnectX + connectWidth);
		platRightConnectX = (platMainX + platMainWidth);
		wheelX = (platMainX + wheelPadding);


		//! Carriage 
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
		

		int pairShift = ((mainWidth) - (((wheelDiameter * amountOfWheels) * amountOfPairs) + (wheelPadding * 2)));
		
		
		//!Code
		for (int i = 0; i < amountOfCarriages; i++) {
			if (roofWidth < mainWidth) {
				System.out.println("Roof is too short!!!");
			}else{
				
				g.setColor(Color.black);
				for(int w = 0; w < amountOfWindows; w++) {									//windows
					g.drawRect(windowX, windowsY, windowWidth, windowHeight);		
					windowX = windowX + (windowWidth + windowPadding);
				}
				roofWidth = (windowX - mainX) + 20;
				mainWidth = ((windowWidth * amountOfWindows) + (windowPadding * (amountOfWindows + 1)));
				rightConnectX = (mainX + mainWidth);
				wheel1X = (mainX + wheelPadding);
				pairShift = ((mainWidth) - (((wheelDiameter * amountOfWheels) * amountOfPairs) + (wheelPadding * 2)));

				for (int p = 0; p < amountOfPairs; p++) {
					
					for (int j = 0; j < amountOfWheels; j++) {
						g.drawOval(wheel1X, wheelsY, wheelDiameter, wheelDiameter);		//2 wheels
						wheel1X = wheel1X + wheelDiameter;
					}
					wheel1X = wheel1X + pairShift;
				}

				g.setColor(Color.black);
				g.drawRect(roofX, roofY, roofWidth, roofHeight);				//roof
				g.drawRect(mainX, mainY, mainWidth, mainHeight);				//main
				g.drawRect(leftConnectX, connectY, connectWidth, connectHeight);	//connect-left
				g.drawRect(rightConnectX, connectY, connectWidth, connectHeight);	//connect-right
			}
			leftConnectX = leftConnectX + ((connectWidth * 2) + mainWidth);
			mainX = (leftConnectX + connectWidth);
			roofX = (mainX - ((roofWidth - mainWidth) / 2));
			rightConnectX = (mainX + mainWidth);

			wheel1X = (mainX + wheelPadding);
			windowX = (mainX + windowPadding);


		}
	}
}
