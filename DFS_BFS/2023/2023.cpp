#include <iostream>
#include <cmath>

using namespace std;

int n;

bool is_prime_number(int num){
    if(num == 1){
        return false;
    }
    if(num%2 == 0){
        return num == 2 ? true : false;
    }
    for(int i = 3; i <= sqrt(num); i += 2){
        if(num%i == 0){
            return false;
        }
    }
    return true;
}

void dfs(int num, int n){
    if(n == 0){
        cout << num << "\n";
        return;
    }
    for(int i = 1; i < 10; i += 2){
        int temp = num*10+i;
        if(is_prime_number(temp)){
            dfs(temp, n-1);
        }
    }
}

int main(void){
    cin >> n;
    int first_digits[4] = {2, 3, 5, 7};
    for(int i = 0; i < 4; i++){
        dfs(first_digits[i], n-1);
    }
}