package Programmers.예상대진표;

public class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 0;

        while(a!=b){
            if(a%2!=0) a = a/2+1;
            else a/=2;

            if(b%2!=0) b = b/2+1;
            else b/=2;

            round++;
        }

        return round;
    }
}
