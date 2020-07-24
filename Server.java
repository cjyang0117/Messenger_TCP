import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
  ServerSocket  SS; 
  DataOutputStream   outstream;
  DataInputStream    instream;
  Socket  socket;
  byte[] inByte = new byte[1024];


public Server(int port) {
     try{
         SS = new ServerSocket(port);
         System.out.println("waiting for client to connect...");			
      }
      catch(IOException e){
           System.out.println(e.toString());
           e.printStackTrace();
           System.exit(1);
      }		
  }
  
public void accept() throws IOException
 {
    socket = SS.accept();
    instream = new DataInputStream(socket.getInputStream());
    outstream = new DataOutputStream(socket.getOutputStream());   
 } 
  
public void send(String s) throws IOException
 {
    //outstream.writeUTF(s);
	 byte[] outByte=s.getBytes();
	 outstream.write(outByte,0,outByte.length);		

 } 
 
public String receive1() throws IOException
 {
    //String messagein = instream.readUTF();
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
