import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)-> o1[1] - o2[1]); // 소요 시간 순으로 정렬(종료시간)
        
        // 종료 시간이 빠른 순서대로 수행
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 시작이 빠른 순으로 정렬
        int currentTime = 0; // 현재 시간 
        int index = 0;
        
        while(index < jobs.length || !queue.isEmpty()){
            while(index < jobs.length && jobs[index][0] <= currentTime){ // 현재 시간에 시작할 수 있는 작업 큐에 넣기 
                queue.add(jobs[index]);
                index++;
            }
            
            if(!queue.isEmpty()){ // 수행할 수 있는 작업이 있으면
                int[] next = queue.poll(); // 종료시간이 가장 빠른 작업 수행
                answer += currentTime - next[0] + next[1];
                currentTime += next[1]; // 현재 시간 변경
            }else{
                currentTime = jobs[index][0]; // 가장 빠른 다음 작업을 수행
            }
        }
        
        
        return answer / jobs.length;
    }
}