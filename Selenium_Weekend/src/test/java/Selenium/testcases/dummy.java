package Selenium.testcases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class dummy {

	public static void main(String[] args)throws IOException{
	
		try {
			
			File obj = new File("training.txt");
//			if(obj.createNewFile()) {
//				System.out.println("File Created");
//			}else {
//				System.out.println("File is not Created");
//			}
			
//			FileWriter writer = new FileWriter("training.txt");
//			writer.write("This is the content for Writing the file");
//			writer.close();
//			System.out.println("Writing is completed");
			
			Scanner reader = new Scanner(obj);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.println(data);
			}
			reader.close();
			
		}catch(Exception e) {
			
			System.out.println("File cannot be Created");
			e.printStackTrace();
			
		}
	}

}
