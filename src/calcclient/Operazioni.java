package calcclient;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Operazioni 
{
    private Socket s;
    private Scanner input;
    private PrintWriter output;
    private BufferedOutputStream dataOut;
    
    public Operazioni()
    {
        try
        {
            s = new Socket("websrv.cs.fsu.edu", 80);
            input = new Scanner(s.getInputStream(), "UTF-8");
            output = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);
            dataOut = new BufferedOutputStream(s.getOutputStream());
        }catch(Exception e){}
    }
    
     private byte[] readFileData(File file, int fileLength) throws IOException 
    {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
                fileIn = new FileInputStream(file);
                fileIn.read(fileData);
        } finally {
                if (fileIn != null) 
                        fileIn.close();
        }

        return fileData;
    }
     
    public void add() throws IOException
    {
        File file = new File("add.xml");
      //  FileInputStream fileis = new FileInputStream(file);
        byte[] fileData = readFileData(file, (int)file.length());

        output.println("POST /~engelen/calcserver.cgi HTTP/1.1");
        output.println("Host: websrv.cs.fsu.edu");
        output.println("Connection: Keep-Alive");
        output.println("Content-Type: text/xml");
        output.println("Content-Length: "+file.length());
        output.println("");
        output.flush();
        dataOut.write(fileData,0,(int)file.length());
        
        dataOut.flush();
        
        while(!input.hasNextLine()){}
        while(input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
    }
}
