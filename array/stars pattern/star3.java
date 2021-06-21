public class star3 {
    public static void main(String [] args){
        for (int i=0; i<=4; i++){
            for(int  j=0; j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        } // complexity =  O(n2)
        for (int a=0; a<=4; a++){
            for (int b=4; b>a; b--){
                System.out.print("* ");
            }
            System.out.println();
        } // complexity = O(n2)
    }

    //    total complexity =     n2 + n2 =         2(n^2)
}
