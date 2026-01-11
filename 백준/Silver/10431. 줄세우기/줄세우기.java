import java.util.*;
import java.io.*;


public class Main {
    public static int P, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        P = Integer.parseInt(br.readLine());
        int[] result = new int[P];

        for(int i = 0; i<P; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            Stack<Integer> children = new Stack<>();
            Stack<Integer> tempStack = new Stack<>();


            for(int j = 0; j<20; j++){
                int k = Integer.parseInt(st.nextToken());

                while(!children.isEmpty() && children.peek()>k){
                    tempStack.push(children.pop());
                    result[T-1]++;
                }

                children.push(k);

                while(!tempStack.isEmpty()){
                    children.push(tempStack.pop());
                }

            }
        }

        for(int i = 1; i<=result.length; i++){
            System.out.println(i + " " + result[i-1]);
        }

    }
}