import java.io.*;
import java.util.*; 

class CCar extends Thread
{
   private Client C1;
   private String str1;
   public CCar(Client c)
   {
      C1 = c;
   }
   public void run() // one thread
   {
     
     try{ 
      while(true){
        str1="";
	str1=C1.receive();
	System.out.println("(Receive): " + str1);
      }
     }catch(IOException e){

     } 
   }
}