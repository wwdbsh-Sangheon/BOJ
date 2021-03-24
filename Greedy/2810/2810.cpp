#include <iostream>

using namespace std;

int n;
string seats;

int main(void){
    cin >> n >> seats;
    int ans = 1;
    for(int i = 0; i < seats.length(); i++){
        if(seats[i] == 'L'){
            i++;
        }
        ans++;
    }
    if(ans > seats.length()){
        cout << seats.length() << "\n";
    }else{
        cout << ans << "\n";
    }
}