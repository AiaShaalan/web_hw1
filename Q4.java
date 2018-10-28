import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		int n;
		System.out.print("please enter a number (between 1 and 50): ");
		Scanner scanner = new Scanner(System.in);
		n= scanner.nextInt();
		while(n<1 || n>50){ // if the number is invalid, stay here and try again
			System.out.println("Invalid columns number, try again !!");
			System.out.print("please enter a number (between 1 and 50): ");
			n= scanner.nextInt();
			}
		File file = new File("q.html");
			FileWriter fileWriter = null;
			BufferedWriter bufferedWriter = null;
			try {
				fileWriter = new FileWriter(file);
				bufferedWriter = new BufferedWriter(fileWriter);
				//defining the width of each column in the screen, all the columns have each width 
				double wid= 100.00/n;
				// defining 3 kinds of columns, one for each color
				String blue_column = "<div  style= 'width: "+wid+"%; height: 100%; background-color: #060fbf; float: left;'></div>";
				String red_column = "<div  style= 'width:"+wid+"%; height: 100%; background-color: #cf0000; float: left;'></div> " ;
				String green_column = "<div  style= 'width:"+wid+"%; height: 100%; background-color: #08740a; float: left;'></div> " ;
				String htmlPage = blue_column;
				bufferedWriter.write("<html><body> ");// starting of html file
				for(int i=0;i<n;i++) {
					bufferedWriter.write(htmlPage); // draw a column 
					if(i%3==0) // choose the column color according to order: blue -> red -> green
						htmlPage=red_column;
					else
					{
						if(i%3==1)
							htmlPage=green_column;
						else
							htmlPage=blue_column;
					}
				}
				bufferedWriter.write("</body></html>"); // end of the file
				bufferedWriter.flush();
				fileWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {

					bufferedWriter.close();
					fileWriter.close();
					scanner.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}