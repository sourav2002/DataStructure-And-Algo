package extra;


import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//
//        while(t-->0){
//            int n = sc.nextInt();
//            int [] arr = new int[n];
//            String s = sc.nextLine();
//            for (int i=0; i<n;i++){
//                arr[i] = sc.nextInt();
//            }
        String s = "aba";
        int[] arr = {2,3,4};
        int n = 3;
        int ans = solve(s,arr,n);
        System.out.println(ans);
//        }
    }


    public static int solve(String s , int[] arr, int n){
        Map<Character, Integer> freq = new HashMap<>();
        int i = 0;
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        boolean poss = true;
        while(poss){
            for(Map.Entry<Character, Integer> entry : freq.entrySet()){
                freq.put(entry.getKey(), entry.getValue() -1);
                update(arr, s);
                if(freq.get(entry.getKey()) == 0){
                    poss = false;
                    break;
                }
            }
        }

        int ans = 0;

        for(int x : arr){
            ans += x;
        }

        return ans;

    }

    public static void update(int[] arr, String s){
        char last = '*';
        int i =0;
        for(char c : s.toCharArray()){
            if(c == last){
                i++;
                continue;
            }
            last = c;
            arr[i++] = 0;


        }

    }
}
