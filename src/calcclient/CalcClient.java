package calcclient;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CalcClient 
{

    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Operazioni op = new Operazioni();
        op.operazione("add");
        op.operazione("sub");
        op.operazione("mul");
        op.operazione("div");
        op.operazione("pow");
    }
    
}
