import java.util.*;

class Point{
    long x;
    long y;
    
    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        Set<Point> set = new HashSet<>();   //교점들의 집합
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for(int i = 0; i<line.length; i++){
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            
            for(int j = i+1; j<line.length; j++){
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                long target = a*d -b*c;
                
                //평행 또는 일치 -> 일치 없으므로 평행
                if(target == 0) continue;
                
                //교점의 x가 정수가 아닐 때 -> 불가능
                if((b*f-e*d)%target!=0) continue;
                
                //y가 정수가 아닐 때
                if((e*c - a*f)%target!=0) continue;
                
                long x = (b*f-e*d)/target;
                long y = (e*c - a*f)/target;
                
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
                
                Point point = new Point(x, y);
                set.add(point); //교점 넣기
            }
        }
        
        String[][] board = new String[(int)(maxY-minY+1)][(int)(maxX-minX+1)];
        for(int i = 0; i<board.length; i++)
            Arrays.fill(board[i], ".");
        
        for(Point p: set){
            long tempX = p.x-minX;
            long tempY = maxY -p.y;
            board[(int)tempY][(int)tempX] = "*";
        }
        
        String[] result = new String[(int)(maxY-minY+1)];
        
        for(int i = 0; i<board.length; i++){
            result[i] = String.join("", board[i]);
        }
        
        return result;
    }
}