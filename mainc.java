import java.io.*;
import java.util.*; 

class mainc { 
public static void main(String args[])throws IOException { 

BufferedReader br;
String     str1, str2;

// initial the connection
Client C1 = new Client("127.0.0.1",1000);
CCar car1=new CCar(C1);
car1.start();

System.out.println("<<Please input your message ! close connection==> /over");
while(true)
{
	br = new BufferedReader(new InputStreamReader(System.in));
    str1 = br.readLine();	
	if(str1.equals("/over")){
		C1.close();
	}	
	C1.send(str1);
	
 
}		


}
}