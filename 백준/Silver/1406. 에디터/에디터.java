import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> left = new Stack<>();    //커서 앞
        Stack<String> right = new Stack<>();    //커서 뒤
        
        String[] sArr = br.readLine().split("");
        
        for(String s : sArr){
            left.push(s);
        }
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            char c = s.charAt(0);
            
            if(c == 'L' && !left.isEmpty()){
                right.push(left.pop());
            }else if(c == 'D' && !right.isEmpty()){
                left.push(right.pop());
            }else if(c == 'B' && !left.isEmpty()){
                left.pop();
            }else if(c == 'P'){
                left.push(String.valueOf(s.charAt(2)));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!left.isEmpty()){
            sb.append(left.pop());
        }
        
        sb = sb.reverse();
        
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        
        System.out.println(sb.toString());
    }
}