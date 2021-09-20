package recursion;

public class AllXtoRightSide {
    public static void allXtoRightSide(String st,int index,int count, String newSt){
        if (index == st.length()){
            for (int i = 0; i< count; i++){
                newSt += 'x';
            }
            System.out.print(newSt);
            return;
        }

        char currCh = st.charAt(index);
        if (currCh == 'x'){
            count++;
            allXtoRightSide(st,index+1,count,newSt);
        }else {
            newSt += currCh;
            allXtoRightSide(st,index+1,count,newSt);
        }
    }
    public static void main(String[] args) {
        String st = "adxjlxxjxsjldxj";
        String newSt = "";
        int startIndex = 0;
        int count = 0;
        allXtoRightSide(st,startIndex, count,newSt);

    }
}
