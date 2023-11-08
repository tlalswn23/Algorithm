import java.util.*;
import java.io.*;

public class Main {
    static class Vertex implements Comparable<Vertex> {
        int v;
        long w;
        public Vertex(int v, long w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Vertex o) {
            return (int) (this.w - o.w);
        }
    }
    static int V, E;
    static long result;
    static boolean[] visited;
    static List<Vertex>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        for(int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[V+1];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            // 양방향 그래프
            graph[v1].add(new Vertex(v2, w));
            graph[v2].add(new Vertex(v1, w));
        }

        prim(new Vertex(1, 0));

        System.out.println(result);
    }

    // 간선 수가 v-1개
    static void prim(Vertex start){
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(start);

        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            if(visited[current.v]){
                continue;
            }

            visited[current.v] = true;
            result += current.w;

            for(int i = 0; i < graph[current.v].size(); i++){
                Vertex v = graph[current.v].get(i);

                if(visited[v.v]){
                    continue;
                }
                
                queue.add(v);

            }

        }

    }
}
