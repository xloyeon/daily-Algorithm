import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        
        int result = A.length();
        
        for(int i = 0; i<B.length()-A.length()+1; i++){
            int count = 0;
            
            for(int j = 0; j<A.length();j++){
                if(A.charAt(j) != B.charAt(i+j))
                    count++;
            }
            
            if(result > count)
                result = count;
        }
        System.out.println(result);
    }
}