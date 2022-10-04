package day0927.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam7733 {
	static int[][] map, visit;
	static int[] di = {0,1,0,-1}, dj= {1,0,-1,0};
	static int N, day;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 1;														//ans: 최종 정답 변수
			for(day=1; day<=100; day++) {								//1일부터 100일까지 따진다.
				int cnt = 0;													//cnt: 해당 날짜의 덩어리 수 
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j]==day || map[i][j]==0) {										//만약 탐색할 자리가 오늘 없어질 자리라면 0으로 갱신하고,
							map[i][j] = 0;
						} else if(visit[i][j]!=day) {								//오늘 없어질 자리가 아니고, 오늘 날짜에 방문하지 않았다면
							cnt++;													//덩어리의 수를 늘리고,
							visit[i][j] = day;										// 방문했다고 표시하고,
							dfs(i,j);													//깊이우선탐색을 진행한다.
						}
					}
				}
				ans = Math.max(ans, cnt);
			}
			
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int i, int j) {

		for(int d=0; d<4; d++) {
			int newI = i+di[d];
			int newJ = j+dj[d];
			
            // 바운더리에서 벗어나거나, (아직 갱신하지 않았지만) 이미 사라진 자리거나, 이미 오늘 방문한 자리라면 다음 방향 탐색을 진행한다.
			if(newI<0 || newI>=N || newJ<0 || newJ>=N || map[newI][newJ]==day || visit[newI][newJ]==day) {
				continue;
			}
			
            //오늘 사라져야 할 자리라면 0으로 갱신한뒤 다음 방향 탐색을 진행한다.
			if(map[newI][newJ]<=day) {
				map[newI][newJ] = 0;
				continue;
			}
			
            //그게 아니라면, visit배열의 자리를 오늘 날짜로 갱신하고, 다음 자리로 이동하여 dfs를 수행한다.
			visit[newI][newJ] = day;
			dfs(newI, newJ);
		}
	}

}
