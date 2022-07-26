package etc;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Core{
    int i;
    int j;

    public Core(int i, int j){
        this.i = i;
        this.j = j;
    }

}

class exam1767{
    static ArrayList<Core> coreArr;
    static int[][] map;
    static int[] di={-1,1,0,0}, dj={0,0,-1,1};	//상하좌우
    static int coreCnt, N, ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreArr = new ArrayList<>();
            ans = Integer.MAX_VALUE;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<N; j++){
                    int tar = Integer.parseInt(st.nextToken());
                    map[i][j] = tar;
                    if(tar==1) coreArr.add(new Core(i,j));
                }
            }
            coreCnt = coreArr.size();

            dfs(1,0);

            System.out.printf("#%d %d%n",t,ans);
        }
    }

    static void dfs(int level, int dist){
        if((level-1)==coreCnt){	//모든 코어를 다 연결했을 때 -> 전체 연결할 코어개수 core, 연결 코어갯수 level
            //거리의 최소값 따지기
            ans = Math.min(ans, dist);
        }
        else{
            Core curCore = coreArr.get(level-1);
            int i = curCore.i;
            int j = curCore.j;

            if(i==0 || i==N-1 || j==0 || j==N-1) dfs(level+1, dist);
            else{
                for(int d=0; d<4; d++){
                    int newI = i + di[d];
                    int newJ = j + dj[d];

                    if(map[newI][newJ]==1 || map[newI][newJ]==2) continue;

                    int tempCost = createLine(i,j,d);
                    if(tempCost==0) continue;
                    dfs(level+1, dist+tempCost);
                    deleteLine(i,j,(d==1||d==3?N:-1),d);
                }
            }
        }
    }

    static int createLine(int i, int j, int d){	//0을 2로 만드는 과정
        int tempCost = 0;
        switch (d){
            case 0:{	//상
                for(int k=i-1; k>=0; k--){
                    if(map[k][j]==0){
                        map[k][j] = 2;
                        tempCost++;
                    }
                    else{
                        deleteLine(i, j, k, d);
                        return 0;
                    }
                }
                break;
            }
            case 1:{		//하
                for(int k=i+1; k<=N-1; k++){
                    if(map[k][j]==0){
                        map[k][j] = 2;
                        tempCost++;
                    }
                    else{
                        deleteLine( i, j,  k,  d);
                        return 0;
                    }
                }
                break;
            }
            case 2:{	//좌
                for(int k=j-1; k>=0; k--){
                    if(map[i][k]==0){
                        map[i][k] = 2;
                        tempCost++;
                    }
                    else{
                        deleteLine( i, j, k,  d);
                        return 0;
                    }
                }
                break;
            }
            case 3:{	//우
                for(int k=j+1; k<=N-1; k++){
                    if(map[i][k]==0){
                        map[i][k] = 2;
                        tempCost++;
                    }
                    else{
                        deleteLine(i,j,k,d);
                        return 0;
                    }
                }
                break;
            }
        }
        return tempCost;
    }

    static void deleteLine(int i, int j, int tar, int d){	//2를 0으로 만드는 과정
        switch (d){
            case 0:{	//상
                for(int k=i-1; k>tar; k--){
                    if(map[k][j]==2){ map[k][j] = 0;}
                }
                break;
            }
            case 1:{		//하
                for(int k=i+1; k<tar; k++){
                    if(map[k][j]==2){ map[k][j] = 0;}
                }
                break;
            }
            case 2:{	//좌
                for(int k=j-1; k>tar; k--){
                    if(map[i][k]==2){ map[i][k] = 0;}
                }
                break;
            }
            case 3:{	//우
                for(int k=j+1; k<tar; k++){
                    if(map[i][k]==2){ map[i][k] = 0;}
                }
                break;
            }
        }
    }

}
