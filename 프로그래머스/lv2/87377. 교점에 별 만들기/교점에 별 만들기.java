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
        Set<Point> set = new HashSet<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for(int i = 0; i<line.length; i++){
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            
            for(int j = i+1; j<line.length; j++){
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                long parallel = a*d - b*c;
                
                if(parallel == 0) continue;
                
                if((b*f-e*d)%parallel !=0) continue;
                
                if((e*c-a*f)%parallel !=0) continue;
                
                long x = (b*f-e*d)/parallel;
                long y = (e*c-a*f)/parallel;
                
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            
                set.add(new Point(x, y));
            }
        }
        
        long lenY = maxY - minY +1;
        long lenX = maxX-minX+1;
        String[][] points = new String[(int)lenY][(int)lenX];
        
        for(int i = 0; i<lenY; i++){
            Arrays.fill(points[i], ".");
        }
        
        for(Point p : set){
            long x = p.x - minX;
            long y = maxY - p.y;
            points[(int)y][(int)x] ="*";
        }
        
        String[] result = new String[(int)lenY];
        
        for(int i = 0; i<lenY; i++){
            result[i] = String.join("", points[i]);
        }
        return result;
    }
}