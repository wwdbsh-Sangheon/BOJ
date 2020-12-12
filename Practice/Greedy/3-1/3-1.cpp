#include <iostream>

using namespace std;

int coins[] = {500, 100, 50, 10};
int n, result;

int main(void){
    cin >> n;

    for(int i = 0; i < 4; i++){
        result += n/coins[i];
        n -= (n/coins[i])*coins[i];
    }
    printf("%d\n", result);
}