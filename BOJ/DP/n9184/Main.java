package BOJ.DP.n9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c;
    static int[][][] result = new int[21][21][21];

    public static int w(int a, int b, int c){

        //만약 20보다 크거나 0과 같거나 작은 수가 존재하면 바꿔줘야 함
        if(a<=0 || b<=0 || c<=0)
            return 1;

        if(a>20 || b>20 || c>20)
            return w(20, 20, 20);

        if(result[a][b][c] !=0)
            return result[a][b][c];

        if(a<b && b<c)
            result[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        else
            result[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return result[a][b][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) break;

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }
}
