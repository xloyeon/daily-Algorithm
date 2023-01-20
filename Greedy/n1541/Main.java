package Greedy.n1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void insertBrackets(List<String> expressions){
        boolean isFirst = true;
        int result = 0;

        for(String s : expressions){
            int temp = 0;
            StringTokenizer st = new StringTokenizer(s, "+");
            while(st.hasMoreTokens()){
                temp += Integer.parseInt(st.nextToken());
            }
            if(isFirst){
                result+=temp;
                isFirst = false;
            }else{
                result-=temp;
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        List<String> expressions = new ArrayList<>();

        while(st.hasMoreTokens()){
            expressions.add(st.nextToken());
        }

        insertBrackets(expressions);
    }
}
