#include <iostream>
#include <algorithm>

using namespace std;

char s[10000];

int main(void){
    string input_s;
    cin >> input_s;
    int len = input_s.length();
    for(int i = 0; i < len; i++){
        s[i] = input_s[i];
    }
    sort(s, s+len);
    int sum = 0;
    for(int i = 0; i < len; i++){
        char c = s[i];
        if(c >= '0' && c <= '9'){
            sum += (int)c - '0';
        }else{
            cout << s[i];
        }
    }
    cout << sum << "\n";
}