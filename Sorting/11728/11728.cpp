#include <iostream>
#include <string>

using namespace std;

int a[1000000], b[1000000];
int n, m;

int main(void){
    
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    for(int i = 0; i < m; i++){
        cin >> b[i];
    }
    int i = 0, j = 0;
    string ans = "";
    while(i < n && j < m){
        if(a[i] < b[j]){
            ans += (to_string(a[i++]) + " ");
        }else{
            ans += (to_string(b[j++]) + " ");
        }
    }
    if(i < n){
        while(i < n){
            ans += (to_string(a[i++]) + " ");
        }
    }
    if(j < m){
        while(j < m){
            ans += (to_string(b[j++]) + " ");
        }
    }
    cout << ans;
}