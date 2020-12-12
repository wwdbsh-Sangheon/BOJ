#include <iostream>
#include <algorithm>

using namespace std;

int n, m, k;
int numbers[1000];

int main(void){
    cin >> n >> m >> k;
    for(int i = 0; i < n; i++){
        cin >> numbers[i];
    }

    sort(numbers, numbers+n);

    int result = 0;
    result += (m/k)*k*numbers[n-1];
    result += m%k*numbers[n-2];
    printf("%d\n", result);
}