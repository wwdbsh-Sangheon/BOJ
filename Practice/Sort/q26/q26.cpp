#include <iostream>
#include <queue>
#include <functional>

using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;
int n;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        int card;
        cin >> card;
        pq.push(card);
    }
    int ans = 0;
    while(pq.size() > 1){
        int num1 = pq.top(); pq.pop();
        int num2 = pq.top(); pq.pop();
        ans += (num1+num2);
        pq.push(num1+num2);
    }
    cout << ans << "\n"; pq.pop();
}