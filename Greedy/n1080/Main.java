package Greedy.n1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;

    public static void changeMatrix(boolean[][] matrixA, boolean[][] matrixB){
        int count = 0;

        if(n<3 || m<3){
            if(Arrays.deepEquals(matrixA, matrixB))
                System.out.println(count);
            else
                System.out.println(-1);
            return;
        }

        for(int i = 0; i<n-2; i++){
            for(int j = 0; j<m-2; j++){
                if(matrixA[j][i] != matrixB[j][i]){
                    count++;

                    for(int indexY = i; indexY<i+3; indexY++){
                        for(int indexX = j; indexX<j+3; indexX++){
                            matrixA[indexX][indexY] = !matrixA[indexX][indexY];
                        }
                    }
                }

                if(Arrays.deepEquals(matrixA, matrixB)){
                    System.out.println(count);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] sb;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] matrixA = new boolean[m][n];
        boolean[][] matrixB = new boolean[m][n];

        for(int i = 0 ; i<n; i++){
            sb  = br.readLine().split("");
            for(int j = 0 ; j<m; j++){
                int temp = Integer.parseInt(sb[j]);
                if(temp == 1)
                    matrixA[j][i] = true;
            }
        }

        for(int i = 0; i<n; i++){
            sb = br.readLine().split("");
            for(int j = 0; j<m; j++){
                int temp = Integer.parseInt(sb[j]);
                if(temp == 1)
                    matrixB[j][i] = true;
            }
        }

        changeMatrix(matrixA, matrixB);
    }
}
