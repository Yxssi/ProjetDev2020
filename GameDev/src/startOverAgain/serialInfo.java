package startOverAgain;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class serialInfo {
	  public static void main(String[]args){
	        mjISkram mj = new mjISkram();
	        mj.sAuthor = "Tanguy & Yessi";
	          mj.iID = 92590;
	        mj.sDescription = "Duel : Luffy vs Naruto !";
	        mj.sInstruction = "Test";
	 
	  try{
	      FileOutputStream fileOut = new FileOutputStream("file/kramzoft.dat");
	      ObjectOutputStream out = new ObjectOutputStream(fileOut);
	       out.close();
	       fileOut.close();
	    }catch(IOException i){
	       i.printStackTrace();
	    }
	  }
}
