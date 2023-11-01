import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String[] s = br.readLine().split("");
        int[] burgers = new int[N];
        List<Integer> people = new ArrayList<>();
        
        for(int i = 0; i<s.length; i++) {
            if(s[i].equals("P")) {
                burgers[i] = 1;
                people.add(i);
            }
        }
        
        int result = 0;
        
        for(int person : people) {
            for(int j = person-K; j<=person+K; j++){
                if(j<0 || j>=N) continue;
                
                if(burgers[j] == 0) {
                    burgers[j] = 1;
                    result++;
                    break;
                }
            }
        }
        
        System.out.println(result);
    }
}