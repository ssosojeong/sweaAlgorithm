package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int curI;
    int curJ;
    int totalCost;

    public Point(int curI, int curJ, int totalCost){
        this.curI = curI;
        this.curJ = curJ;
        this.totalCost = totalCost;
    }
}

class exam1249 {
    static int[][] map, cost;
    static int ans, N;
    static int[] di = {1,0,-1,0}, dj = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            cost = new int[N][N];
            for(int i=0; i<N; i++){
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            ans = 0;

            for(int i=0; i<N; i++){
                char[] input = br.readLine().toCharArray();
                for(int j=0; j<N; j++){
                    map[i][j] = input[j]-'0';
                }
            }

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0,0,0));
            while(!queue.isEmpty()){
                Point curP = queue.poll();

                for(int d=0; d<4; d++){
                    int newI = curP.curI + di[d];
                    int newJ = curP.curJ + dj[d];

                    if(newI<0 || newI>N-1 || newJ<0 || newJ>N-1) continue;

                    int newTotalCost = curP.totalCost + map[newI][newJ];
                    if(newTotalCost<cost[newI][newJ]){
                        cost[newI][newJ] = newTotalCost;
                        queue.offer(new Point(newI, newJ, newTotalCost));
                    }
                }
            }
            System.out.printf("#%d %d%n",t,cost[N-1][N-1]);
        }

    }


}

