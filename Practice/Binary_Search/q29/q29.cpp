#include <iostream>
#include <algorithm>

using namespace std;

int homes[200000];
int n, c;

int main(void){
    cin >> n >> c;
    for(int i = 0; i < n; i++){
        cin >> homes[i];
    }
    sort(homes, homes+n);
    
}