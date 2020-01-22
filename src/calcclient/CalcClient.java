package calcclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class CalcClient 
{

    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Operazioni op = new Operazioni();
        op.add();
    }
    
}
