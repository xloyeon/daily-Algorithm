import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        
        //64, 32, 16, -> 2의 제곱 수들
        //반으로 자른다면? 2의 제곱 수들의 합-> 막대를 자르고 절반을 버리기 때문에 
        //1의 개수가 곧 막대의 개수
        
        int result = 0;
        for(int i = 0; i<=6; i++){
            if((X & (1<<i))!=0) result++; //해당 자리에 1이 있으면 막대 수 증가
        }
        System.out.println(result);
    }
}