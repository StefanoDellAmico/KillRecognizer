import org.sikuli.script.*;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import javax.imageio.ImageIO;


public class recognizer {
	public static Match m = new Match();
	public static boolean leaderbool = false;
	public static int actkill = 0;
	public static int expander = 0;
	
	public static void main(String args[]) throws AWTException, IOException, InterruptedException {
		
		boolean found = false;
		ImagePath.setBundlePath("./");
		Screen s = new Screen();
		
		Thread.sleep(5000);
		while(true) {
			try {
				m = s.find("./imgs/leader.PNG");
				leaderbool = true;
				System.out.println("hai ucciso qualcuno e sei kill leader");
			} catch (FindFailed e) {
				leaderbool = false;
				try {
					m= s.find("./imgs/kills.PNG");
					found = true;
					System.out.println("hai ucciso qualcuno");
				} catch (FindFailed e1) {
					found = false;
					System.out.println("Inattivo o stai svolgendo altre attività che nascondono il contatore delle kill");
				}
			}
			
			if(found == true || leaderbool == true) {
				screener();
				
				Thread.sleep(3500);
				
				if(actkill >= 10) {
					expander = 10;
				}else {
					expander = 0;
				}
			}
			//OCR.reset();
		}
	}
	
	public static void screener() throws AWTException, IOException {
		Robot r = new Robot();
		Rectangle rect = null;
		File file;
		BufferedImage img;
		
		rect = new Rectangle(m.getX() + ImageIO.read(new File("./imgs/kills.png")).getWidth() + expander, m.getY() + 2, 17, 30);

		img = r.createScreenCapture(rect);

		file = new File("imgs/kill.png");
		
		ImageIO.write(img, "png", file);
		
		polish();

	}
	
	public static void polish() throws IOException {
		File f = new File("imgs/kill.png");
		int tollerance = 200;
		BufferedImage img = ImageIO.read(f);
		boolean isChanging = false;
		
		for(int x = 0; x < img.getWidth(); x++) {
			for(int y = 0; y < img.getHeight(); y++) {
				Color c = new Color(img.getRGB(x,  y));
				if(c.getRed() <= tollerance && c.getGreen() <= tollerance && c.getBlue() <= tollerance) {
					
					if(c.getRed() <= 134 && c.getRed() >= 104 && c.getGreen() <= 17 && c.getGreen() >= 2 && c.getBlue() <= 19 && c.getBlue() >= 0) {
						System.out.println("KillField in aggiornamento, aspetto...");
						isChanging = true;
						break;
					}
					img.setRGB(x, y, 0); 
				}
			}
		}
		
        if(isChanging == false) {
    		File file = new File("./imgs/killpolished.png");
            ImageIO.write(img, "png", file);
        	decode();
        }
	}

	public static void decode() throws IOException {
		
		File file;

		Tesseract tesseract = new Tesseract();
		String s = "";

		file = new File("imgs/kill.png");
		
		System.out.println("decodifico...");

		tesseract.setTessVariable("tessedit_char_whitelist", "0123456789");
        try {
            tesseract.setDatapath("./lib/Tess4J/tessdata");
            s = tesseract.doOCR(file);
            System.out.print(s);
        }
        catch (TesseractException e) {
        	
        }

        if(!s.equals(""))
        	actkill = Integer.parseInt(s.replaceAll("\\s", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\b", ""));
		
		writeout();
	}
	
	public static void writeout() throws IOException {
		
		File f = new File("./variables.js");
		Scanner gotIt = new Scanner(f);
		
		List<String> allData = new ArrayList<String>();
		
		while(gotIt.hasNextLine()) {
			
			String adder = gotIt.nextLine();
			if(!adder.contains("{") && !adder.contains("}"))
				allData.add(adder);
		}
		
		int counted = 0, previous = 0, printed = 0;
		
		for(String s : allData) {
			//System.out.println(s);
			if(s.contains("counted"))
				counted = Integer.parseInt(s.split(": ")[1].replaceAll(",", ""));
			else if(s.contains("previous"))
				previous = Integer.parseInt(s.split(": ")[1].replaceAll(",", ""));
			else
				printed = Integer.parseInt(s.split(": ")[1].replaceAll(",", ""));
		}
		
		//if(actkill > counted && actkill < 60 && actkill - counted < 5) {
		if(actkill < 60 && actkill - counted < 5) {
			counted = actkill;
		}else {
			actkill = counted;
		}
		
		FileWriter writer = new FileWriter("./variables.js");		
		
		writer.write("var variables = {\n");
		writer.write("\tcounted: " + counted + ",\n");
		writer.write("\tprevious: " + previous + ",\n");
		writer.write("\tprinted: " + printed + ",\n");
		writer.write("}");
		
		writer.close();
	}
}
