package day0927.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1952 {
	static int[] costs, plans;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			costs = new int[4];
			for(int c=0; c<4; c++) {
				costs[c] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			plans = new int[12];
			for(int p=0; p<12; p++) {
				plans[p] = Integer.parseInt(st.nextToken());
			}
			
			ans = costs[3];
			dfs(0,0);
			
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.print(sb);
	}
	
	public static void dfs(int level, int totalCost) {
		if(totalCost>ans) {
			return;
		} else if(level>=12) {
			ans = Math.min(totalCost, ans);
		} else {
			//1일권 선택한다
			dfs(level+1, totalCost+(costs[0]*plans[level]));
			//1달권 선택한다
			dfs(level+1, totalCost+costs[1]);
			//3달권 선택한다
			dfs(level+3, totalCost+(costs[2]));
		}
	}

}

