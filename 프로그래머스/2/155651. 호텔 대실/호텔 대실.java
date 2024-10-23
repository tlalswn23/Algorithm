import java.util.*;

class Solution {
    class Booking{ // 입실 시간과 퇴실 시간을 모두 분으로 바꾸어서 저장
        int inTime;
        int outTime;
        
        public Booking(int inTime, int outTime){
            this.inTime = inTime;
            this.outTime = outTime;
        }
    }
    
    static PriorityQueue<Booking> list;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        list = new PriorityQueue<>((o1, o2) -> o1.inTime == o2.inTime ? o1.outTime - o2.outTime : o1.inTime - o2.inTime);
        
        // 모든 예약 분으로 바꿔서 list에 저장
        for(int i = 0; i < book_time.length; i++){
            String[] in = book_time[i][0].split(":");
            String[] out = book_time[i][1].split(":");
            
            int in_minute = Integer.parseInt(in[0])*60+Integer.parseInt(in[1]);
            int out_minute = Integer.parseInt(out[0])*60+Integer.parseInt(out[1]);
            
            list.add(new Booking(in_minute, out_minute));
        }
        
        // 리스트 돌면서 객실 할당
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        Booking first = list.poll();
        rooms.add(first.outTime);
        
        while(!list.isEmpty()){ // 모든 예약 다 끝날 때까지
            
            int size = list.size();
            
            for(int i = 0; i < size; i++){
                Booking next = list.poll(); // 다음 예약 
                int pre_endTime = rooms.poll(); // 존재하는 객실 중 가장 퇴실 시간이 빠른 것  
                
                if(pre_endTime+10 <= next.inTime){ // 입실 가능 
                    rooms.add(next.outTime);
                }else{ // 입실 불가능
                    rooms.add(pre_endTime); // 기존 객실 그대로
                    rooms.add(next.outTime); // 새로운 객실 추가
                }
            }
        }

        
        return rooms.size();
    }
}