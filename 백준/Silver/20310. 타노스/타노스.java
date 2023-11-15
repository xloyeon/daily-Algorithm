import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0이 짝수개, 1이 짝수개 있는데 절반씩 지움 -> 사전 순으로 가장 빠른 것 : 0이 앞에 많아야
        String s = br.readLine();
        
        int countZero = (s.length() - s.replace("0", "").length())/2;
        int countOne = (s.length() - s.replace("1", "").length())/2;
        
        StringBuilder sb = new StringBuilder(s);
        
        while(countZero-->0){
            sb.deleteCharAt(sb.lastIndexOf("0"));
        }
        
        while(countOne-->0){
            sb.deleteCharAt(sb.indexOf("1"));
        }
        
        System.out.println(sb.toString());
    }
}