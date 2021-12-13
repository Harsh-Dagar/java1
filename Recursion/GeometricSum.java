package Recursion;
/* Given k, find the geometric sum i.e.
      1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 
*/
public class GeometricSum {
    public static double findGeometricSum(int k){
		// Write your code here
        if(k==0){
            return 1;
        }
        double ans=(1/Math.pow(2, k))+findGeometricSum(k-1);
        return ans;
	}
}
