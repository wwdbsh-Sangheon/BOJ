#include <iostream>

using namespace std;

string n;
int center, l_sum, r_sum;

int main(void){
    cin >> n;
    center = n.length()/2;
    
    for(int i = 0; i < center; i++){
        l_sum += (int)n[i] - '0';
        r_sum += (int)n[center+i] - '0';
    }
    l_sum == r_sum ? printf("%s\n", "LUCKEY") : printf("%s\n", "READY");
}