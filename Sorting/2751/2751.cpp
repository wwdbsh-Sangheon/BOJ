#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> arr;
int n;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        int digit;
        cin >> digit;
        arr.push_back(digit);
    }
    sort(arr.begin(), arr.end());
    for(int i = 0; i < n; i++){
        cout << arr[i] << "\n";
    }
}