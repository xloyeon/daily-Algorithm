import java.util.*;
import java.io.*;


public class Main {
    public static int L = 0;
    public static int C = 0;
    public static String[] alphas;
    public static StringBuilder sb;

    public static boolean checkVowel(String c){
        return "aeiou".indexOf(c) >=0;
    }
    public static void pickAlphabets(int idx, int depth, int vowelCnt, int consonantCnt){
        if(depth == L){
            if(vowelCnt >=1 && consonantCnt >=2) {
                System.out.println(sb.toString());
            }
            return;
        }

        if(idx >= C)
            return;

        for(int i = idx; i<C; i++){
            String c = alphas[i];

            sb.append(c);

            if(checkVowel(c))
                pickAlphabets(i+1, depth+1, vowelCnt+1, consonantCnt);
            else
                pickAlphabets(i+1, depth+1, vowelCnt, consonantCnt+1);

            sb.delete(sb.length()-1, sb.length());

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphas = br.readLine().split(" ");
        Arrays.sort(alphas);

        sb = new StringBuilder();
        pickAlphabets(0, 0, 0, 0);
    }
}