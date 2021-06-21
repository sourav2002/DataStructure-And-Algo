package IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStream1 {
    public static void main(String args[])throws Exception{
        FileOutputStream fout = new FileOutputStream("/home/sourav/Desktop/output.txt");
        BufferedOutputStream bout=new BufferedOutputStream(fout);
        String s="Welcome to sourav's world.";
        byte b[]=s.getBytes();
        bout.write(b);
        bout.flush();
        bout.close();
        fout.close();
        System.out.println("success");
    }
}
