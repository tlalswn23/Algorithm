import java.util.*;

class Solution {
    class Task{
        String name;
        int hour;
        int minute;
        int time;
        
        public Task(String name, int hour, int minute, int time){
            this.name = name;
            this.hour = hour;
            this.minute = minute;
            this.time = time;
        }
    }
    
    static Stack<Task> stopTask;
    static List<Task> tasks;
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;
        stopTask = new Stack<>();
        tasks = new LinkedList<>();
        
        for(int i = 0; i < plans.length; i++){
            String[] temp = plans[i][1].split(":");
            int hour = Integer.parseInt(temp[0]);
            int min = Integer.parseInt(temp[1]);
            
            tasks.add(new Task(plans[i][0], hour, min, Integer.parseInt(plans[i][2])));
        }
        
        Collections.sort(tasks, (o1, o2) -> o1.hour == o2.hour ? o1.minute - o2.minute : o1.hour - o2.hour);
        
        int em = 0, eh = 0, idx = 1;
        
        Task current = tasks.get(0);
        
        while(idx < tasks.size()){
            Task next = tasks.get(idx);
            int sum = current.minute + current.time;
            int startH = current.hour;
            int startM = current.minute;
            current.minute = sum % 60;
            current.hour += sum / 60;
            
            // System.out.println(current.name +" "+next.name);
            // System.out.println(current.hour+":"+current.minute+" "+next.hour+":"+next.minute);
            
            // 끝나는 시간과 딱 맞으면 무조건 다음 과제 실행
            // 끝나는 시간과 딱 맞지않으면 스택에 있는 거 실행 
            
            if((current.hour == next.hour && current.minute == next.minute)){
                //System.out.println(1);
                answer[index] = current.name;
                current = next;
                index++;
                idx++;
            }
            else if(current.hour < next.hour || ((current.hour == next.hour) && (current.minute < next.minute))){
                //System.out.println(2);
                if(stopTask.isEmpty()){
                    answer[index] = current.name;
                    current = next;
                    index++;
                    idx++;
                    continue;
                }
                
                Task s = stopTask.pop();
                s.hour = current.hour;
                s.minute = current.minute;
                answer[index] = current.name;
                current = s;
                index++;
            }
            else{
                // 남은 시간 계산해서 스택에 넣기 
                //System.out.println(3);
                int rest = 0;
                int nh = next.hour;
                int nm = next.minute;

                if(startM > next.minute){
                    next.minute += 60;
                    next.hour--;
                }

                rest = current.time - ((next.minute - startM) + (next.hour - startH) * 60);
                current.time = rest;
                current.hour = nh;
                current.minute = nm;
                stopTask.push(current);
                

                // 다음 과제를 현재 과제로 교체
                current = tasks.get(idx);
                idx++;
            }
        }
        
        answer[index] = current.name;
        index++;
        
        while(!stopTask.isEmpty()){
            Task t = stopTask.pop();
            answer[index] = t.name;
            index++;
        }

        return answer;
    }
}