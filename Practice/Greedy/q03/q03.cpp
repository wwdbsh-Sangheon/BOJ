#include <iostream>
#include <algorithm>

using namespace std;

int result, zero, one;
string s;

int main(void){
    cin >> s;
    if(s[0] == '1'){
        zero++;
    }else{
        one++;
    }
    for(int i = 1; i < s.length()-1; i++){
        if(s[i] != s[i+1]){
            if(s[i+1] == '1'){
                zero++;
            }else{
                one++;
            }
        }
    }
    printf("%d\n", min(zero, one));
}