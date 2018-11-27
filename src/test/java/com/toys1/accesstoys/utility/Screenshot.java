package com.toys1.accesstoys.utility;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot {
    	public void screenShot(String fileName) throws AWTException, IOException {
        	Robot robot = new Robot();
        	BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
           	ImageIO.write(screenShot, "JPG", new File("./ScreenShots/"+fileName+".jpg"));
    	}          
}
