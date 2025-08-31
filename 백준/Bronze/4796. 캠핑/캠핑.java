import java.util.*;
import java.io.*;


public class Main {
    public static int L, P, V;
    public static int calculate(){
        int n = V/P;
        int remain = V%P;

        return n*L + Math.min(remain, L);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;

        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0)
                break;

            count++;
            int result = calculate();

            System.out.println("Case " + count + ": " + result);

        }
    }
}