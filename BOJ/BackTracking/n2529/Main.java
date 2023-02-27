package BOJ.BackTracking.n2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[] sign;
    static List<Integer> temp = new ArrayList<>();
    static List<String> result = new ArrayList<>();

    public static void findResult(int idx){
        if(idx == n+1){
            StringBuilder sb = new StringBuilder();
            for(int i : temp)
                sb.append(i);
            result.add(sb.toString());
            return;
        }

        for(int i = 0; i<=9; i++){
            if(!temp.contains(i) && check(i)){
                temp.add(i);
                findResult(idx+1);
                temp.remove(temp.size()-1);
            }
        }
    }


    private static boolean check(int k){
        if(temp.isEmpty()) return true;

        int last = temp.get(temp.size()-1);
        String checkSign = sign[temp.size()-1];

        if(checkSign.equals("<")){
            if(last>k) return false;
        }else if(checkSign.equals(">")){
            if(last<k) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sign = new String[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            sign[i] = st.nextToken();
        }

        findResult(0);
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));
    }
}
