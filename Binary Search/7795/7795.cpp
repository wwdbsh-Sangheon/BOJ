#include <iostream>
#include <algorithm>

using namespace std;

int a[20000], b[20000];
int t, n, m;

int b_search(int start, int end, int target, int idx){
    if(start > end){
        return idx;
    }
    int mid = (start+end)/2;
    if(target > b[mid]){
        return b_search(mid+1, end, target, mid);
    }else{
        return b_search(start, mid-1, target, idx);
    }
}

int main(void){
    cin >> t;
    while(t-- > 0){
        cin >> n >> m;
        for(int i = 0; i < n; i++){
            cin >> a[i];
        }
        for(int i = 0; i < m; i++){
            cin >> b[i];
        }
        sort(b, b+m);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int cnt = b_search(0, m-1, a[i], -1);
            if(cnt != -1){
                ans += (cnt+1);
            }
        }
        cout << ans << "\n";
    }
}