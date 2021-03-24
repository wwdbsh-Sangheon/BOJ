#include <iostream>
#include <algorithm>

using namespace std;

int arr[30000];
int n;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    int ans = 0;
    for(int i = 0; i < n-1; i++){
        int cnt = 0;
        for(int j = i; j < n-1; j++){
            if(arr[i] < arr[j+1]){
                break;
            }
            cnt++;
        }
        ans = max(ans, cnt);
    }
    cout << ans << "\n";
}