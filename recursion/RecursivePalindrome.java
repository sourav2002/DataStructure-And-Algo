import java.util.Scanner;

class RecursivePalindrome{

    public static boolean isEnd(String s){
        return (s.length() >= 3 && s.charAt(0) == 'E' && s.charAt(1) == 'N' && s.charAt(2) == 'D');
    }
    
    /*
    *Performs the recursion call for the first time and initializes the counter
    */
    public static boolean isPalindrome(String s){
        boolean resp =  isPalindrome(s, 0);
        return resp;
    }
    
    /*
    *The code verifies recursively if a input string is a palindrome
    *@param s input String
    *@param i int counter used to traverse the string
    *@return resp boolean <true> if input String is a palindrome <false> if it's not
    */
    public static boolean isPalindrome(String s, int i){
        boolean resp;
        int j = s.length() - i - 1;
        if(i > s.length()/2){
            resp = true;
        }else{
            if(s.charAt(i) != s.charAt(j)){
                resp = false;
            }else{
                resp = isPalindrome(s, i+1);
            }
        }
  
        return resp;
    }
    
    public static void main(String[] args) {
        String[] input = new String[1000];
        int inputCounter = 0;
        boolean resp;
        Scanner sc = new Scanner(System.in);
        
        //The input ends with the word 'END'
        do{
            input[inputCounter] = sc.nextLine();
        }while(isEnd(input[inputCounter++]) == false);
        inputCounter--;
  
        for(int i = 0; i < inputCounter; i++){
            resp = isPalindrome(input[i]);
            if(resp){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
