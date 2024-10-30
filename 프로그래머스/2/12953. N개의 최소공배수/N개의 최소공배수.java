class Solution {
    public int solution(int[] arr) {
        
        int answer = getLCM(arr[0], arr[1]);
        
        for(int i = 2; i < arr.length; i++){
            answer = getLCM(answer, arr[i]);
        }

        return answer;
    }
    
    // 최소공배수 구하기
    static int getLCM(int n1, int n2){
        return (n1*n2)/getGCD(n1, n2);
    }


    // 최대공약수 구하기 
    static int getGCD(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        
        return getGCD(n2, n1%n2);
    }
}

// 두 수의 곱을 최대공약수로 나눈 것이 최소공배수인 것을 알아야 함!
// 최대 공약수는 유클리드 호제법!