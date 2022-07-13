package trainWithTanks;

import java.awt.*;
import java.awt.event.*;
import trainWithTanks.trainPainter;

public class trainMover extends trainPainter{
	public static void main(String[] args) {
		trainMover trainMover = new trainMover("My Locomotive Mover");
		trainMover.setSize(frameLength, 700);
		trainMover.setVisible(true);

	}
	trainMover(String title){
		super(title);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}
		});
	}
	static int frameLength = 900;

	boolean isMoveToLeft = false;

	int animationShift = 0;
	
	//!Declarating variables
	//*Locomotive variables
	int locMainY = 100, locMainWidth = 120, locMainHeight = 60;
	
	
	int locCabinWidth = 35;
	
	int locLeftConnectX = 50, connectWidth = 11, connectHeight = 6, connectPaddingFromBottom = 3;
	
	int wheelDiameter = 16, wheelPadding = 20, amountOfBlocks = 2;
	int wheelConnectorWidth = 10;
	//*Locomotive

	int locCabinX = (locLeftConnectX + connectWidth),
	locCabinHeight = (locMainHeight / 3),
	locCabinY = (locMainY + locMainHeight) - locCabinHeight,

	
	connectY = (((locMainY + locMainHeight) - connectPaddingFromBottom) - connectHeight),
	locMainX = (locCabinX + locCabinWidth),
	locRightConnectX = (locMainX + locMainWidth),
	
	wheelsY = (locMainY + locMainHeight),
	locWheelX = (locCabinX + wheelPadding),
	wheelConnectorX = locWheelX + wheelDiameter,
	wheelConnectorY = wheelsY + (wheelDiameter / 3),
	wheelConnectorHeight = (wheelDiameter / 3),

	glassX1 = locCabinX,
	glassY1 = locCabinY,
	glassX2 = locMainX,
	glassY2 = locMainY;

	
	int blockShift = ((locCabinWidth + locMainWidth) - (((wheelDiameter * 2) * 2) + (wheelPadding * 2) + (wheelConnectorWidth * 2)));
	
	public void paint(Graphics g) {
		if (amountOfBlocks > 2) {
			blockShift = blockShift / (amountOfBlocks - 1);
		}

		//! Locomotive
		g.drawRect(locMainX, locMainY, locMainWidth, locMainHeight);			//main
		g.drawRect(locCabinX, locCabinY, locCabinWidth, locCabinHeight);		//cabin
		g.drawRect(locLeftConnectX, connectY, connectWidth, connectHeight);		//connect-left
		g.drawRect(locRightConnectX, connectY, connectWidth, connectHeight);	//connect-right
		g.drawLine(glassX1, glassY1, glassX2, glassY2);		//glass
		// locWheelX = locWheelX - ((connectWidth * 2) + locCabinWidth + locMainWidth);
		// wheelConnectorX = wheelConnectorX - ((connectWidth *2) + locCabinWidth + locMainWidth);
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
	}


	// public void go() throws Exception{
	// 	while(true) {
	// 		repaint();                    
	// 		Thread.sleep(50);
	// 		if(!isMoveToLeft) {
	// 			if(animationShift < (frameLength)) {
					
	// 				animationShift++;
	// 			}else{
	// 				isMoveToLeft=true;
	// 			}
	// 		}else{
	// 			if(animationShift > locMainX){
	// 				animationShift--;
	// 			}else{
	// 				isMoveToLeft=false;
	// 			}
	// 		}
	// 	}
	// }
}
