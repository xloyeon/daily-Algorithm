import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int S = 0;
        
        while(n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;
            
            if(str.equals("add")){
                num = Integer.parseInt(st.nextToken());
                S |= (1<< num-1);
            }else if(str.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                S &= ~(1 << num-1);
            }else if(str.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                sb.append((S & (1<<num-1)) !=0 ? "1\n" : "0\n");
            }else if(str.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                S ^= (1<<num-1);
            }else if(str.equals("all")) {
                S |= (~0);
            }else if(str.equals("empty")) {
                S &= 0;
            }
        }
        
        System.out.println(sb.toString());
    }
}