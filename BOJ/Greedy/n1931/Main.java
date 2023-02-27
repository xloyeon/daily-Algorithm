package BOJ.Greedy.n1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Meeting implements Comparable<Meeting>{
    private int start;
    private int end;

    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart(){
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end>o.end){
            return 1;
        }else if(this.end == o.end){
            if(this.start>o.start){
                return 1;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Meeting> meetingList = new ArrayList<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingList.add(new Meeting(start, end));
        }

        Collections.sort(meetingList);

        int startTime = 0;
        int count = 0;

        for(Meeting m : meetingList){
            if(startTime<=m.getStart()){
                startTime = m.getEnd();
                count++;
            }
        }

        System.out.println(count);
    }
}
