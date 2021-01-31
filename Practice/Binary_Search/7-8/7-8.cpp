#include <iostream>
#include <algorithm>

using namespace std;

int n, m, ans;
int rc[1000000];

int b_search(int start, int end){
    if(start > end){
        return ans;
    }
    int mid = (start + end)/2;
    int sum = 0;
    for(int i = n-1; rc[i] > mid; i--){
        sum += (rc[i] - mid);
    }
    if(sum < m){
        return b_search(start, mid-1);
    }else{
        ans = mid;
        return b_search(mid+1, end);
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> rc[i];
    }
    sort(rc, rc+n);
    cout << b_search(0, rc[n-1]) << "\n";
}