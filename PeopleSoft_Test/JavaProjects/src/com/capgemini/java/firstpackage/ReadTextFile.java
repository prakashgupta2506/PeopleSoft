package com.capgemini.java.firstpackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTextFile {

	public static void main(String[] args) {

		FindAndReportError errReport=new FindAndReportError();
		errReport.findAndReportError();
		System.exit(0);
		TextFileWriting w=new TextFileWriting();
		w.writeFile();
		
		
		/* ReadFileUsingFileInputStream r=new ReadFileUsingFileInputStream();
		 r.readFile();
		 
		ReadFileUsingReadAllBytes r1 = new ReadFileUsingReadAllBytes();
		r1.readFile();

		ReadFileUsingScanner r2 = new ReadFileUsingScanner();
		r2.readFileLineByLine();
		r2.readWholeFile();
*/	}

}

class ReadFileUsingReadAllBytes {
	String file = "C:\\Users\\Prakash's\\Desktop\\aa.txt";

	void readFile() {

		Path path = Paths.get(file);
		try {
			String stringFromFile = new String(java.nio.file.Files.readAllBytes(path));

			System.out.println(stringFromFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
	
	

	class ReadFileUsingScanner {

		String file = "C:\\Users\\Prakash's\\Desktop\\aa.txt";

		
		void readFileLineByLine() {
int i=1;
			try {
				FileInputStream fis = new FileInputStream(file);

				Scanner scan = new Scanner(fis);
				while(scan.hasNextLine()){
		            System.out.println(scan.nextLine());
		            System.out.println("printed line no. "+i);
		            i++;
		        }
		      
		        scan.close();

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

		}
		
		
		void readWholeFile() {

			try {
				FileInputStream fis = new FileInputStream(file);

				Scanner scan = new Scanner(fis);
				scan.useDelimiter("\\Z");
				String content = scan.next();
				System.out.println(content);
				scan.close();

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

		}
	}
	
class ReadFileUsingFileInputStream {	
	String file = "C:\\Users\\Prakash's\\Desktop\\aa.txt";
	void readFile() {
		
		try {
			FileInputStream fis = new FileInputStream(file);
			int i = 0;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
				fis.close();
			}
			

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}



 class TextFileWriting {
	 String file = "C:\\Users\\Prakash's\\Desktop\\bb.txt";
   void writeFile() {
        try {
            FileWriter writer = new FileWriter(file, true);   
           
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
            //OR            
           /* BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("hhhh");      
            bufferedWriter.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}


class FindAndReportError {
	String fileToRead = "C:\\Users\\Prakash's\\Desktop\\aa.txt";
	String fileToWriteErrors = "C:\\Users\\Prakash's\\Desktop\\bb.txt";
	String readLine = null;
	ArrayList<String> arrErrors=new ArrayList<String>();

	void findAndReportError() {

		try {
			FileInputStream fis = new FileInputStream(fileToRead);

			Scanner scan = new Scanner(fis);
			while (scan.hasNextLine()) {
				readLine = scan.nextLine();
				arrErrors=findErrors(readLine);
				
				WriteErrorIntoFile(arrErrors);
				
				
			}

			scan.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		
	}
	
	
	ArrayList<String> findErrors(String strLine) {
		ArrayList<String> arrList = new ArrayList<String>();

		//length must be 6 characters starting with ca
		String REGEX = "[c][a][a-zA-Z0-9]{4}";
		String INPUT = strLine;
		Pattern p = Pattern.compile(REGEX);

		Matcher m = p.matcher(INPUT);

		while (m.find()) {

			arrList.add(INPUT.substring(m.start(), m.end()));

		}
		return arrList;
	}
	

	void WriteErrorIntoFile(ArrayList<String> errorsToWrite) {
		try {
			FileWriter writer = new FileWriter(fileToWriteErrors, true);

			for (int i = 0; i < errorsToWrite.size(); i++) {
				writer.write(errorsToWrite.get(i)+"\r\n");
			

			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

	
	

