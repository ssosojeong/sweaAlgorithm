package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{ 
	int idx;
	int mid;
	int fin;
	int hw;
	double total;
	
	public Student(int idx, int mid, int fin, int hw) {
		this.idx = idx+1;
		this.mid = mid;
		this.fin = fin;
		this.hw = hw;
		this.total = mid*0.35 + fin*0.45 + hw*0.2;
	}

	@Override
	public int compareTo(Student o) {
		if(this.total>o.total) return -1;
		return 1;
	}
}

class exam1983 {
    public static void main(String[] args) throws Exception {
        //입력 자원
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
      
        //테스트케이스의 수
        int T = Integer.parseInt(br.readLine());

        //테스트케이스의 수만큼 반복한다.
        for(int t=1; t<=T; t++){
        	sb.append("#"+t+" ");
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	Student[] students = new Student[N];
        	
        	for(int n=0; n<N; n++) {
        		st = new StringTokenizer(br.readLine());
        		students[n] = new Student(n,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        	}
        	
        
        	Arrays.sort(students);
        	
        	for(int i=0; i<N; i++) {
        		if(students[i].idx==K) {
        			sb.append(getGrade(N,i)+"\n");
        			break;
        		}
        	}
        }
        System.out.print(sb);
    }
    
    public static String getGrade(int N, int idx) {
    	int limit = N/10;
    	
    	if(idx<limit) return "A+";
    	else if(idx<2*limit) return "A0";
    	else if(idx<3*limit) return "A-";
    	else if(idx<4*limit) return "B+";
    	else if(idx<5*limit) return "B0";
    	else if(idx<6*limit) return "B-";
    	else if(idx<7*limit) return "C+";
    	else if(idx<8*limit) return "C0";
    	else if(idx<9*limit) return "C-";
    	else return "D0";
    	
    }
}
