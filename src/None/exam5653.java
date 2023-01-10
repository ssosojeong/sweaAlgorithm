package None;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam5653 {
    static class Cell implements Comparable<Cell>{
        int i;
        int j;
        int p;
        boolean isActive;
        int generatedT;
        int cnt;
        public Cell(int i, int j, int p, boolean isActive, int generatedT) {
            super();
            this.i = i;
            this.j = j;
            this.p = p;
            this.isActive = isActive;
            this.generatedT = generatedT;
            this.cnt = 0;
        }

        @Override
        public int compareTo(Cell o) {
            return o.p-this.p;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] di = {-1,0,1,0}, dj= {0,1,0,-1};

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Cell> queue = new ArrayList<>();

            int[][][] map = new int[N+2*K][M+2*K][2];
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++) {
                    int val = Integer.parseInt(st.nextToken());
                    if(val==0) continue;
                    map[n+K][m+K][1] = val;
                    queue.add(new Cell(n,m,val,false,0));
                }
            }
            for(int k=0; k<=K; k++){
                int qSize = queue.size();
                Collections.sort(queue);
                for(int q=0; q<qSize; q++){
                    Cell cur = queue.get(0);
                    queue.remove(0);
                    int curP = cur.p;
                    int curGT = cur.generatedT;
                    cur.cnt++;

                    //cell이 활성 상태일경우
                    if(cur.isActive){
                        //만약 cell이 활성상태가 된지 1시간이 지났다면 번식이 완료되어야 한다.
                        if(curGT+curP+1==k){
                            for(int d=0; d<4; d++){
                                int newI = cur.i+di[d];
                                int newJ = cur.j+dj[d];

                                //아직 map에 해당 자리가 채워지지 않았거나,
                                //채워졌더라도 현재 생명력보다 작고, 같은 시간에 번식된 세포라면 덮어쓴다.
                                //현재 생명력이 큰 순으로 정렬됐으므로 다른 처리 안해줘도 됨
                                if(map[newI+K][newJ+K][1]==0 || (map[newI+K][newJ+K][0]==k && map[newI+K][newJ+K][1]<curP)){
                                    map[newI+K][newJ+K][0] = k;
                                    map[newI+K][newJ+K][1] = curP;
                                    queue.add(new Cell(newI,newJ,curP,false,k));

                                }

                            }
                        }   //번식 끝

                        //만약 cell이 활성상태가 된 후 생명력만큼 시간만큼 살았다면, 죽는다.
                        if(curGT+curP*2==k){
                            continue;
                        } else{
                            queue.add(cur);
                        }

                    }
                    //cell이 비활성 상태일경우
                    else{
                        //만약 cell이 만들어진 시간으로부터 p시간이 지났다면 활성상태로 변한다.
                        if(curGT+curP==k){
                            cur.isActive = true;
                        }
                        //p가 0인 경우는 없으므로, 따로 검사하지 않고 모두 큐에 넣어준다.
                        queue.add(cur);
                    }

                }
            }

            sb.append("#"+t+" "+queue.size()+"\n");
        }
        System.out.println(sb);
    }
}