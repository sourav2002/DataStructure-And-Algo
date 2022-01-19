package extra;

import java.util.Random;

class Bike8{
    public static String st = "sourav";

     Bike8(String st){
         Bike8.st = st;
         System.out.println("constructor is invoked = "+ st);
     }

     static {
         System.out.println("instance initializer block invoked");
     }
    static {
         System.out.println("static instance initializer block invoked");
     }


    static void print(){
        System.out.println("bike 8 method");
    }

    public static void main(String[] args){
        new Bike8(st);
        print();

        Random r = new Random();
        System.out.println(r.nextInt(11));

    }
}  