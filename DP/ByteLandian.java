package DP;

import java.util.HashMap;

public class ByteLandian {
    

    public static long bytelandianMemo(long n, HashMap<Long, Long> memo) {
        // Write your code here
        if(n==1||n==0){
            return n;
        }
        if(memo.get(n)!=null){
            return memo.get(n);
        }
        
        long a=bytelandianMemo(n/2,memo)+bytelandianMemo(n/3,memo)+bytelandianMemo(n/4,memo);
        memo.put(n,Math.max(n,a));
        return memo.get(n);

	}


    public static long bytelandianDP(long n, HashMap<Long,Long> memo){
        memo.put(0l, 0l);
        memo.put(1l, 1l);
        int mod=(int)Math.pow(10, 9)+7;
        for(long i=2;i<=n;i++){
            long a=memo.get(i/2);
            long b=memo.get(i/3);
            long c=memo.get(i/4);
            long ans=((a%mod)+(b%mod)+(c%mod))%mod;
            if(ans<i){
                memo.put(i, i);
            }
            else{
                memo.put(i,ans);
            }
        }
        return memo.get(n);
    }
}
