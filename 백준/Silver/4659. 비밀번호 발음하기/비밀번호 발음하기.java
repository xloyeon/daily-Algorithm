import java.util.*;
import java.io.*;


public class Main {
    public static List<String> vowel = List.of(new String[]{"a", "e", "i", "o", "u"});

    public static boolean valuatePW(String pw){
        boolean flag = false;   //모음 포함 여부
        int vowelCnt = 0;
        int consonantCnt = 0;
        int eCnt = 0;
        int oCnt = 0;
        String x = "";

        String[] pwArr = pw.split("");

        for(String p : pwArr){
            //자음, 모음이 연속 3개인지 확인
            if(vowel.contains(p)){
                vowelCnt++;
                consonantCnt = 0;
                flag = true;
                if(vowelCnt == 3) return false;
            }else{
                consonantCnt++;
                vowelCnt = 0;
                if(consonantCnt == 3) return false;
            }

            if(p.equals(x)){
                if(!p.equals("e") && !p.equals("o"))
                    return false;
            }

            x = p;
        }

        return flag;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String testString = br.readLine();

            if (testString.equals("end"))
                return;

            if (valuatePW(testString))
                System.out.println("<" + testString + "> is acceptable.");
            else
                System.out.println("<" + testString + "> is not acceptable.");

        }
    }
}