import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int size = A.length;
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int i = 0; i < size; i++){
            q1.add(A[i]);
            q2.add(B[i]);
        }
        
        for(int i = 0; i < size; i++){
            answer += (q1.poll() * q2.poll());
        }

        return answer;
    }
}