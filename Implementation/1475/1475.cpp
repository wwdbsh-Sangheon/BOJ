#include <iostream>
#include <algorithm>

using namespace std;

int arr[9];
string n;

int main(void){
    cin >> n;
    for(int i = 0; i < n.length(); i++){
        char c= n[i];
        if(c == '9'){
            arr[6]++;
        }else{
            arr[(int)(c-'0')]++;
        }
    }
    if(arr[6]%2 == 1){
        arr[6] /= 2;
        arr[6]++;
    }else{
        arr[6] /= 2;
    }
    int ans = 0;
    for(int i = 0; i < 9; i++){
        ans = max(ans, arr[i]);
    }
    cout << ans << "\n";
}