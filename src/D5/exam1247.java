package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calcDis(Point p) {
        return Math.abs((x-p.x))+Math.abs((y-p.y));
    }


}

class exam1247{
    static int[] dis;
    static int N;
    static int ans;
    static Point company, home;
    static ArrayList<Point> customers;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            dis = new int[N+1];
            ans = 2147483647;
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            customers = new ArrayList<>();
            for(int i=1; i<=N; i++) {
                customers.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            for(int i=0; i<N; i++) {
                dis[i] = 1;
                dfs(i,1,customers.get(i).calcDis(company));
                dis[i] = 0;

            }
            System.out.printf("#%d %d\n",t,ans);
        }




    }
    public static void dfs(int i, int l, int totalDis) {
        if(totalDis>ans) {
            return;
        } else if(l==N) {
            ans = Math.min(totalDis+home.calcDis(customers.get(i)), ans);

        } else {
            for(int next=0; next<N; next++) {
                if(dis[next]!=1) {
                    dis[next] = 1;
                    dfs(next, l+1, totalDis += customers.get(i).calcDis(customers.get(next)));
                    totalDis -= customers.get(i).calcDis(customers.get(next));
                    dis[next] = 0;
                }
            }
        }
    }


}