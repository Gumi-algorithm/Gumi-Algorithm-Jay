package boj;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
public class no14501 { 
    private static int n, res = 0; 
    private static int[] T, P; //T : 상담완료하는데 걸리는 시간, P : 금
    public static void main(String[] args) throws Exception 
    { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; n = Integer.parseInt(br.readLine()); 
        
        T = new int[n]; 
        P = new int[n]; 
        
        for (int i = 0; i < n; i++) { 
            st = new StringTokenizer(br.readLine()); 
            T[i] = Integer.parseInt(st.nextToken()); 
            P[i] = Integer.parseInt(st.nextToken()); 
        } 
        
        dfs(0, 0); 
        System.out.println(res); 
    } 
    
    private static void dfs(int index, int val) {
        if (index >= n) { // 종료조건.
            res = Math.max(res, val); 
            return; 
        } 
        if (index + T[index] <= n) 
        	dfs(index + T[index], val + P[index]); 
        
        else dfs(index + T[index], val);

        dfs(index + 1, val);

    }
}