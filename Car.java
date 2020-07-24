import java.io.*;
import java.util.*; 

class Car extends Thread
{
   private Server S1;
   private String str1;
   public Car(Server s)
   {
      S1 = s;
   }
   public void run() // one thread
   {
     
     try{ 
      while(true){
        str1="";
	str1=S1.receive();
	System.out.println("(Receive): " + str1);
      }
     }catch(IOException e){

     } 
   }
}
