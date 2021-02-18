#include <iostream>
#include <algorithm>

using namespace std;

int numbers[100], ops[4];
int n, maximum = -1e9, minimum = 1e9;

int calc(int op, int a, int b){
    switch(op){
        case 0:
            return a+b;
        case 1:
            return a-b;
        case 2:
            return a*b;
        case 3:
            return a > 0 ? a/b : ((-1*a)/b)*(-1);
    }
    return -1;
}

void get_max_min(int index, int count, int num){
    if(count == n-1){
        maximum = max(maximum, num);
        minimum = min(minimum, num);
        return;
    }
    for(int i = index; i < n; i++){
        for(int j = 0; j < 4; j++){
            if(ops[j] != 0){
                ops[j]--;
                get_max_min(i+1, count+1, calc(j, num, numbers[i]));
                ops[j]++;
            }
        }
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> numbers[i];
    }
    for(int i = 0; i < 4; i++){
        cin >> ops[i];
    }
    get_max_min(1, 0, numbers[0]);
    cout << maximum << "\n" << minimum << "\n";
}