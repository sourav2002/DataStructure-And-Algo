public class RecursiveFactorial{

   public static int factorial(int n){
      int resp;
      System.out.println("fat (" + n + ")");
      resp = (n == 1) ? 1 : n * factorial(n-1);
      System.out.println("fat n(" + n + "): " + resp);
      return resp;
   }

   public static void main(String[] args){
      int n = Integer.parseInt(args[0]);
      System.out.println("RECURSIVE FACTORIAL(" + n + "): " + factorial(n));
   }
}

