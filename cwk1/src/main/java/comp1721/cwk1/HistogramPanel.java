package comp1721.cwk1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class HistogramPanel extends JPanel {
	private List<Integer> guessList;
	
	public HistogramPanel(List<Integer> gusList) {
		// TODO Auto-generated constructor stub
		super();
		this.guessList = new LinkedList<Integer>();
		this.guessList.addAll(gusList);
	}


	@Override
	protected void paintComponent(Graphics g) {
		// Get the height of the current JFrame
		int frameHeight = getHeight();
		// Get the weight of the current JFrame
		int frameWidth = getWidth();
		// Font
		String font = "Arial";
		// Fontsize
		int fontSize = 20;
		// The width of the histogram
		int width = 40;
		// The height of the histogram
		int height = 40;
		// Set the color of the brush
		g.setColor(Color.white);
		// Draw the background color
		g.fillRect(0, 0, frameWidth, frameHeight);
		// Set the color of font
		g.setColor(Color.BLACK);
		// set the font
		g.setFont(new Font(font, 1, 20));
		//set the title
		String title = "Histogram of Guess Distribution";
		// draw the title
		int titlex = frameWidth/2 - 170;
		g.drawString(title, titlex, frameHeight / 2 - 180);
		// Draw the line in the bottom
		g.drawLine(frameWidth / 2 - 200, frameHeight / 2 + 150, frameWidth / 2 + 200, frameHeight / 2 + 150);
		// Draw the line on the left
		g.drawLine(frameWidth / 2 - 200, frameHeight / 2 + 150, frameWidth / 2 - 200, frameHeight / 2 - 150);
		// Set the font of coordinates
		g.setFont(new Font(font, 1, 12));
		// draw the font of coordinates
		g.drawString("y", frameWidth / 2 - 200 - 20, frameHeight / 2 - 150);
		g.drawString("x", frameWidth / 2 + 200 + 20, frameHeight / 2 + 150);
		// the initial height and width of the coordinates
		int initHeight = frameHeight / 2 + 150;
		int initWidth = frameWidth / 2 - 180;
		// Draw the histogram
		String[] KeyStr = {"1 time", "2 times", "3 times", "4 times", "5 times", "6 times"};
		for (int i = 0; i < this.guessList.size(); i++) {
			int h = this.guessList.get(i);
			// set the color of the brush
			g.setColor(Color.BLUE);
			//x-coordinate of bars
			int x = initWidth + i * (width + 20);
			//y-coordinate of bars
			int y = initHeight - h * height;
			//Draw the bars of the histogram
			g.fillRect(x, y, width, h * height);
			
			
			FontMetrics metrics = null;
			metrics = g.getFontMetrics();
			//Draw the number of each bar beneath it
			g.drawString(this.guessList.get(i) + "", x - ((metrics.stringWidth(this.guessList.get(i) + "") - width) >> 1),y);
			//draw the key of every bar
			g.drawString(KeyStr[i], x-((metrics.stringWidth(KeyStr[i]) - width) >> 1), frameHeight / 2 + 170);

		}
	}
}


