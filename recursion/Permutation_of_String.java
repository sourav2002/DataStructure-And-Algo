package recursion;

import java.util.*;
public class Permutation {
    public static void main(String[] args) {
        permuatation("","abc");
        System.out.println(permuatationList("","abc"));
        System.out.println(permuatationCount("","abc"));
    }
    static void permuatation(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);

        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String e=p.substring(i,p.length());
            permuatation(f+ch+e,up.substring(1));
        }
    }
    static ArrayList<String> permuatationList(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> temp=new ArrayList<String>();
            temp.add(p);
            return temp;
        }
        char ch=up.charAt(0);
        ArrayList<String>ans=new ArrayList<String>();
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String e=p.substring(i,p.length());
            ans.addAll(permuatationList(f+ch+e,up.substring(1)));
        }
        return ans;
    }
    static int permuatationCount(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> temp=new ArrayList<String>();
            temp.add(p);
            return 1;
        }
        char ch=up.charAt(0);
        int count=0;
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String e=p.substring(i,p.length());
            count += permuatationCount(f+ch+e,up.substring(1));
        }
        return count;
    }
}
