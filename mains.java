import java.io.*;
import java.util.*; 

class mains { 
public static void main(String args[])throws IOException { 

BufferedReader br;
String   str1, str2;

// initial the connection
Server S1 = new Server(1000);
S1.accept();
Car car1=new Car(S1);
car1.start();

System.out.println("<<Please input your message ! close connection==> /over");
while(true)
{
	
	br = new BufferedReader(new InputStreamReader(System.in));
    str1 = br.readLine();
    if(str1.equals("/over")) S1.close();	
	S1.send(str1);
}

}
}