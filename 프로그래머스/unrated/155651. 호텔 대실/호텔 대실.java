import java.util.*;

class Book implements Comparable<Book> {
    private int startTime;
    private int endTime;
    
    public Book(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public int getStartTime(){
        return this.startTime;
    }
    
    public int getEndTime(){
        return this.endTime;
    }
    
    public int compareTo(Book b){
        if(this.startTime == b.getStartTime()){
            return this.endTime - b.getEndTime();
        }
        return this.startTime- b.getStartTime();
    }
    
}


class Solution {
    
    public int calTime(String s){
        String[] temp = s.split(":");
        int time = Integer.valueOf(temp[0]) * 60 + Integer.valueOf(temp[1]);
        return time;
    }
    
    public int solution(String[][] book_time) {
        //회의 예약과 비슷
        //대실 시작 시간 순 정렬
        //사용 가능 room 없으면 room 하나 추가
        //a 예약의 대실 종료 시간 보다 b 예약의 시작 시각이 더 크면 a 빼고 b
        //시작 시작 같은 예약 여러개면 시간 짧은 거 먼저 넣기
        List<Book> books = new ArrayList<>();
        List<Integer> rooms = new ArrayList<>();
        
        for(String[] time : book_time){
            Book book = new Book(calTime(time[0]), calTime(time[1]));
            books.add(book);
        }
        
        Collections.sort(books);
        
        for(Book book : books){
            //만약 room이 하나도 없으면
            if(rooms.size() == 0){
                rooms.add(book.getEndTime() + 10);
                continue;
            }
            
            //사용 가능한 room이 하나도 없으면
            boolean flag = false;
            
            for(int i = 0; i<rooms.size(); i++){
                if(rooms.get(i) <= book.getStartTime()){
                    rooms.remove(i);
                    rooms.add(i, Integer.valueOf(book.getEndTime()) + 10);
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                rooms.add(book.getEndTime() + 10);
            }
            Collections.sort(rooms);
        }
        
        return rooms.size();
    }
}