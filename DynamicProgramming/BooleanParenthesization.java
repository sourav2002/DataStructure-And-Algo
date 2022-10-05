import java.util.*;
public class BooleanParenthesization{
    public static HashMap<String,Integer> map = new HashMap<>();
    public static int cw(String S,int s,int e,boolean isTrue){
        if(s>e){
            return 0;
        }
        if(s==e){
            return isTrue?(S.charAt(s)=='T'?1:0):(S.charAt(s)=='T'?0:1);
        }
        String key = Integer.toString(s)+Integer.toString(e)+Boolean.toString(isTrue);
        if(map.containsKey(key)){
            return map.get(key);
        }
        int ans =0;
        for(int k=s+1;k<=e;k+=2){
            int lt = cw(S,s,k-1,true);
            int lf = cw(S,s,k-1,false);
            int rt = cw(S,k+1,e,true);
            int rf = cw(S,k+1,e,false);
            if(S.charAt(k)=='&'){
                if(isTrue){
                    ans+=lt*rt;
                }else{
                    ans+=lt*rf+lf*rt+lf*rf;
                }
            }else if(S.charAt(k)=='|'){
                if(isTrue){
                    ans+=lt*rt+lt*rf+lf*rt;
                }else{
                    ans+=lf*rf;
                }
            }else{
                if(isTrue){
                    ans+=lt*rf+lf*rt;
                }else{
                    ans+=lt*rt+lf*rf;
                }
            }
        }
        ans = ans%1003;
        map.put(key,ans);
        return ans;
    }
    public static int countWays(int N, String S){
        map.clear();
        return cw(S,0,N-1,true);
    }
	public static void main(String[] args) {
		System.out.println(countWays(7,"T|T&F^T"));
	}
}