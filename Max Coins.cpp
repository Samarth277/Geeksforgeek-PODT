//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    int maxCoins(int n,vector<vector<int>> &ranges){
        // Code here
        sort(ranges.begin(), ranges.end(), [&](vector<int> &a, vector<int> &b){
            if(a[0] == b[0])
                return a[1] < b[1];
            return a[0] < b[0];
        });
        vector<int> post(n);
        post[n - 1] = ranges[n - 1][2];
        for(int i = n - 2; i > -1; i--)
            post[i] = max(post[i + 1], ranges[i][2]);
        int answer = 0;
        for(int i = 0; i < n; i++){
            int low= i;
            int high = n;
           while(low < high - 1){
              int mid = low + (high - low) / 2;
                
                if(ranges[mid][0] >= ranges[i][1])
                  high = mid;
                else
                  low = mid;
            }
            int cur = 0;
            if(high < n)
              cur = post[high];
            answer = max(answer, ranges[i][2] + cur);
        }
        
      return answer;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<vector<int>> a(n,vector<int>(3));
        for(int i=0;i<n;i++){
            cin>>a[i][0]>>a[i][1]>>a[i][2];
        }
        Solution ob;
        cout<<ob.maxCoins(n,a)<<endl;
    }
    return 0;
}
// } Driver Code Ends
