/**
 * @author Grzegorz Samociak
 * 
 * this takes rrr ggg bbb rrr ggg bbb arguments to change first three to other three
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PaletteSwapper {

	ImageIcon sourceICON;
	BufferedImage sourceBI;
	ArrayList<Integer> RGBPalette;
	private static int r,g,b,r2,g2,b2;
	private static Color c2;
	private static Color c3;
//	private static int swapColor;
	private static String fileName;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		fileName = args[0];
		r = Integer.parseInt(args[1]);
		g = Integer.parseInt(args[2]);
		b = Integer.parseInt(args[3]);
		r2= Integer.parseInt(args[4]);
		g2= Integer.parseInt(args[5]);
		b2= Integer.parseInt(args[6]);
		
		c2 = new Color(r, g, b);
		c3 = new Color(r2,g2,b2);
		System.out.println("changing from "+c2.getRed()+c2.getGreen()+c2.getBlue()+
				" to "+c3.getRed()+c3.getGreen()+c3.getBlue());
		new PaletteSwapper();
					
	}
	
private PaletteSwapper() throws IOException{
		
		loadImage();
		swapRGB();
		saveImage();
		
	}
	
private void saveImage() throws IOException {
	ImageIO.write(sourceBI, "png", new File(fileName));
}
private void swapRGB() {
	Color colorInFile;
	
		for (int x=0;x<sourceBI.getWidth();x++) {
			for(int y=0; y<sourceBI.getHeight();y++) {
				colorInFile = new Color(sourceBI.getRGB(x, y));
				if (colorInFile.getRGB()==c2.getRGB()) {
					sourceBI.setRGB(x, y, c3.getRGB());
				}
			}
		}
		System.out.println("done!");
	}

private void loadImage(){
	System.out.println("loading image");
	sourceICON = new ImageIcon(fileName);
	Image img = sourceICON.getImage();
	sourceBI = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
	Graphics bg = sourceBI.getGraphics();
	bg.drawImage(img, 0, 0, null);
	bg.dispose();
}

}
