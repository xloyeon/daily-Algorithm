class Solution {
    public double[][] times;
    
    private double convertToTime(String s){
        String[] temp = s.split(":");
        
        double time = Integer.parseInt(temp[0])*60*60;
        time += Integer.parseInt(temp[1])*60;
        time += Double.parseDouble(temp[2]);
        
        return time;
    }
    
    public int solution(String[] lines) {
        times = new double[lines.length][2];
        
        int idx = 0;
        
        for(String line : lines){
            String[] temp = line.substring(11).split(" ");
            
            temp[1] = temp[1].replace("s", "");
            double process = Double.parseDouble(temp[1]);
            
            times[idx][1] = convertToTime(temp[0]);
            times[idx][0] = times[idx][1]-process+ 0.001;
            idx++;
        }
        
        int max = 1;
        
        for(int i = 0; i < times.length; i++){
            int count = 1;
            
            for(int j = i+1; j < times.length; j++){
                if(times[i][1] + 1 > times[j][0]) count ++;

            }
            max = Math.max(max, count);
        }


        return max;
    }
}