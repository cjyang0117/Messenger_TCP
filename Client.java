import java.io.*;
import java.net.*;

public class Client {
  Socket socket;
  DataOutputStream  outstream;
  DataInputStream  instream;
  String messagein;
  static String messageout;
  byte[] inByte = new byte[1024];

				
public Client(String ip, int port) 
  {
     try{
         socket=new Socket(InetAddress.getByName(ip),port);
         outstream = new DataOutputStream(socket.getOutputStream());
         instream=new DataInputStream(socket.getInputStream());
      }
      catch(IOException e){
         System.out.println("IOException when connecting Server!"); 
      }
  }

public void send(String s) throws IOException
 {
    //outstream.writeUTF(s);
	 byte[] outByte=s.getBytes();
	 outstream.write(outByte,0,outByte.length);		
 } 
 
public String receive1() throws IOException
 {
    //tring messagein = instream.readUTF();
	String messagein;
         instream.read(inByte);
         String message = new String(inByte,0,inByte.length);
	     messagein=message.trim();	
	System.out.println("message: " + messagein);
	return messagein;
 } 
public String receive() throws IOException
 {
    //String messagein = instream.readUTF();
	String messagein;
	     instream.read(inByte);
         String message = new String(inByte,0,inByte.length);
	     messagein=message.trim();
	return messagein;
 } 
public void close() throws IOException
 {
    socket.close(); 
 }   
  
}
