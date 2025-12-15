import java.util.*;

class Date implements Comparable<Date> {
    int year;
    int month;
    int day;
    
    public Date(String d){
        String[] dateString = d.split("\\.");
        this.year = Integer.parseInt(dateString[0]);
        this.month = Integer.parseInt(dateString[1]);
        this.day = Integer.parseInt(dateString[2]);
    }
    
    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public void updateYear(int year){
        this.year = year;
    }
    
    public void updateMonth(int month){
        this.month = month;
    }
    
    public void updateDay(int day){
        this.day = day;
    }
    
    public int compareTo(Date d){
        if(this.year == d.year){
            if(this.month == d.month)
                return this.day - d.day;
            return this.month - d.month;
        }
        return this.year - d.year;
    }
}

class Solution {
    public String[][] validations;
    
    public Date calExpiration(Date date, String term){
        int year = date.year;
        int month = date.month;
        int day = date.day;
        
        for(int i = 0; i<validations.length; i++){
            if(validations[i][0].equals(term)){
                month += Integer.parseInt(validations[i][1]);
                break;
            }
        }
        
        day--;
        
        if(day<=0){
            month--;
            day = 28;
        }
        
        while(month>12){
            month-=12;
            year++;
        }
        
        if(month==0){
            month = 12; 
        }
        
        return new Date(year, month, day);
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        Date tDay = new Date(today);
        validations = new String[terms.length][2];
        
        for(int i = 0; i<terms.length; i++){
            validations[i] = terms[i].split(" ");
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        for(int i = 0; i<privacies.length; i++){
            String[] ss = privacies[i].split(" ");
            Date date = new Date(ss[0]);
            Date expiration = calExpiration(date, ss[1]);
            
            if(expiration.compareTo(tDay)<0)
                resultList.add(i+1);
        }
        
        int[] answer = new int[resultList.size()];
        
        for(int i = 0; i<answer.length; i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}