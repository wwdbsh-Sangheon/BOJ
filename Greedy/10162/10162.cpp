#include <iostream>

using namespace std;

int t, a, b, c;

int main(void){
    cin >> t;
    while(t >= 10){
        if(t >= 300){
            a = t/300;
            t %= 300;
        }else if(t >= 60){
            b = t/60;
            t %= 60;
        }else{
            c = t/10;
            t %= 10;
        }
    }
    t != 0 ? cout << -1 << "\n" : cout << a << " " << b << " " << c << "\n";
}