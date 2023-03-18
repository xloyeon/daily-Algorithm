package Programmers.n진수게임;

public class Solution {
    public String[] upperCase = {"A", "B", "C", "D", "E", "F"};

    public StringBuilder changeInt(int n, int target){
        StringBuilder changed = new StringBuilder();
        if(target==0) return changed.append(0);

        while(target>0){
            int temp = target%n;
            if(temp>=10 && temp<=15){
                changed.insert(0, upperCase[temp-10]);
            }else{
                changed.insert(0, temp);
            }

            target /=n;
        }
        return changed;
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder allNums = new StringBuilder();

        int border = (t-1)*m+p;

        int idx = 0;
        while(allNums.length()<border){
            allNums.append(changeInt(n, idx));
            idx++;
        }

        for(int i = p-1; i<border; i+=m){
            sb.append(allNums.substring(i, i+1));
        }
        return sb.toString();
    }
}
