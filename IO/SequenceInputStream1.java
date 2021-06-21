package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

public class SequenceInputStream1 {
    public static void main(String args[])throws Exception{
        FileOutputStream out1 = new FileOutputStream("/home/sourav/Desktop/testin.txt");
        FileOutputStream out2 = new FileOutputStream("/home/sourav/Desktop/testout.txt");
        FileInputStream input1=new FileInputStream("/home/sourav/Desktop/testin.txt");
        FileInputStream input2=new FileInputStream("/home/sourav/Desktop/testout.txt");

        FileOutputStream fout=new FileOutputStream("/home/sourav/Desktop/testout2.txt");


        String out11= "this is the first file that is created by me.";
        String out22 = "I will change the game. sooon";
        byte b1 []  = out11.getBytes();
        byte b2 [] = out22.getBytes();
        out1.write(b1);
        out2.write(b2);
        SequenceInputStream inst=new SequenceInputStream(input1, input2);
        int j;
        while((j=inst.read())!=-1){
            System.out.print((char)j);
            fout.write((char)j);
        }
        inst.close();
        input1.close();
        input2.close();
        fout.close();
    }
}
