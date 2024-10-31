import java.util.*;
import java.io.*;

public class Main {
	static class Node{
		int num;
		Node leftNode;
		Node rightNode;
		
		public Node(int num) {
			this.num = num;
		}
	}
	
	static Node[] tree;
	static int colNum = 1; // 열번호
	static Map<Integer, int[]> levelMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		boolean[] isChild = new boolean[N+1]; // 루트노드 찾기 위한 배열
		levelMap = new HashMap<>();
		
		// 트리 초기화
		for(int i = 0; i <= N; i++) {
			tree[i] = new Node(i);
		}
		
		// 입력 받기
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);
			int left = Integer.parseInt(input[1]);
			int right = Integer.parseInt(input[2]);
			
			if(left != -1) { // 왼쪽 자식노드가 있으면 
				tree[num].leftNode = tree[left]; // 자식노드와 연결
				isChild[left] = true;
			}
			
			if(right != -1) { // 오른쪽 자식노드가 있으면
				tree[num].rightNode = tree[right]; // 자식노드와 연결
				isChild[right] = true;
			}
		}
		
		// root 찾기 
		int root = 0;
		for(int i = 1; i <= N; i++) {
			if(isChild[i]) {
				continue;
			}
			root = i;
		}
		
		// 중위 순회하면서 열번호 부여, 레벨별 최대최소 값 저장
		inOrder(tree[root], 1);
		
		// 레벨 맵 돌면서 차이가 최대인 값 구하기
		int answerLevel = 1;
		int answer = 0;
		
		for(Integer level : levelMap.keySet()) {
			int[] info = levelMap.get(level);
			if(answer < (info[1] - info[0])) {
				answer = info[1] - info[0];
				answerLevel = level;
			}
		}
		
		bw.write(Integer.toString(answerLevel)+" "+Integer.toString(answer+1));
		
		bw.close();
		br.close();
		
	}
	
	// 중위순회
	static void inOrder(Node root, int depth) {
		if(root == null) { // 더 이상 부모노드가 없으면(루트노드이면) 리턴
			return;
		}
		
		inOrder(root.leftNode, depth+1);
		saveMinMax(depth);
		colNum++;
		inOrder(root.rightNode, depth+1);
		
	}
	
	static void saveMinMax(int level) {
		if(!levelMap.containsKey(level)) {
			levelMap.put(level, new int[] {colNum, colNum});
		}else {
			int[] minMax = levelMap.get(level);
			minMax[0] = Math.min(minMax[0], colNum);
			minMax[1] = Math.max(minMax[1], colNum);
			levelMap.put(level, minMax);
		}
	}
}
