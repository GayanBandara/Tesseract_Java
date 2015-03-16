/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract_java;

import java.io.*;
import net.sourceforge.tess4j.*;


/**
 *
 * @author Kasun Balasooriya
 */
public class Tesseract_java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, TesseractException {
        // TODO code application logic here
        
        File imageFile = new File("input/eurotext.tif");
        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
        // File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Maven build bundles English data
        // instance.setDatapath(tessDataFolder.getAbsolutePath());
        try{
        
        File file = new File("output/filename.txt");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
                        
                        String result = instance.doOCR(imageFile);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(result);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
        
//        try {
//            String result = instance.doOCR(imageFile);
//            System.out.println(result);
//        } catch (TesseractException e) {
//            System.err.println(e.getMessage());
//        }
    }
    
}
