// 숫자 카드 게임 96p
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int n, m;
int result;

int main(void){

    cin >> n >> m;

    for(int i = 0; i < n; i++){
        int min_value = 10001;
        for(int j = 0; j < m; j++){
            int card;
            cin >> card;
            min_value = min(min_value, card);
        }
        result = max(result, min_value);
    }
    printf("%d", result);
}