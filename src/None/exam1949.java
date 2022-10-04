package day0927.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1949 {
	static boolean[][] visit;
	static int[][] map;
	static int[] di = {0,1,0,-1}, dj= {1,0,-1,0};
	static int N,K,ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = 0;
			
			map = new int[N][N];
			int max = -1;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int val = Integer.parseInt(st.nextToken());
					map[i][j] = val;
					if(val>max) max = val;
				}
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==max) {	//시작점이면 dfs go
						visit = new boolean[N][N];
						visit[i][j] = true;
						dfs(i,j, max, false, 1);
						visit[i][j] = false;
					}
				}
			}
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);

	}
	
	public static void dfs(int i, int j, int curL, boolean isBreak, int dist) {
		if(dist>ans) ans = dist;
		
		for(int d=0; d<4; d++) {
			int newI = i+di[d];
			int newJ = j+dj[d];
			
			if(newI<0 || newI>=N || newJ<0 || newJ>=N || visit[newI][newJ]) {
				continue;
			}
			
			if(map[newI][newJ]<curL) {	//깎을필요없음
				visit[newI][newJ] = true;
				dfs(newI, newJ, map[newI][newJ], isBreak, dist+1);
				visit[newI][newJ] = false;
			} else if(map[newI][newJ]-K<curL && !isBreak) {	//깎아야하고 깎을 수 있음
				visit[newI][newJ] = true;
				dfs(newI, newJ, curL-1, true, dist+1);
				visit[newI][newJ] = false;
			}
		}
	}
	
	

}
