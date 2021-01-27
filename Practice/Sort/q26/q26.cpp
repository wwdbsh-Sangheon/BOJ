#include <iostream>
#include <algorithm>

using namespace std;

int cards[100000];
int n;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> cards[i];
    }
    if(n == 1){
        return cards[0];
    }
    sort(cards, cards+n);
    int ans = cards[0] + cards[1];
    for(int i = 2; i < n; i++){
        ans += (ans + cards[i]);
    }
    cout << ans << "\n";
}