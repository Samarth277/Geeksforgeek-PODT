//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] a, int n, int s) 
    {
        // Your code here
        int sum=0,start=0,end=0;
        ArrayList<Integer> num=new ArrayList<Integer>();
        
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            end=i;
            
            while(sum>s)
            {
                sum-=a[start];
                start++;
            }
            
            if(sum==s)
            {
                break;
            }
        }
        
        if(sum!=s || start>end)
        {
          num.add(-1);
          return num;
        }
        else
        {
            num.add(start+1);
            num.add(end+1);
            return num;
        }
    }
       
}
