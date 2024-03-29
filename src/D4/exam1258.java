package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//자꾸 문제는 pc로 풀라고 떠서ㅠㅠ 제출을 못했습니다
//테케는 다 맞아요
public class exam1258 {
    static class Area implements Comparable<Area>{
        int x;
        int y;
        public Area(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Area o) {
            return Integer.compare(this.x*this.y, o.x*o.y);
        }
    }
    static int[][] map;
    static ArrayList<Area> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = st.nextToken().charAt(0)-'0';
                }
            }

            res = new ArrayList<>();
            //시작점 구하기
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]>0){
                        int eI, eJ = 0;
                        for(eI=i; eI<N; eI++){
                            if(map[eI][j]==0) break;

                            for(eJ=j; eJ<N; eJ++){
                                if(map[eI][eJ]!=0){
                                    map[eI][eJ]=-1;
                                } else{
                                    break;
                                }
                            }
                        }

                        res.add(new Area(eI-i, eJ-j));
                    }
                }
            }

            Collections.sort(res);
            sb.append("#"+t+" "+res.size());
            for(Area a : res){
                sb.append(" "+a.x+" "+a.y);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
