#include <iostream>
#include <algorithm>

using namespace std;

int n;
int house[200000];

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> house[i];
    }
    sort(house, house+n);
    cout << house[n/2-1] << "\n";
}