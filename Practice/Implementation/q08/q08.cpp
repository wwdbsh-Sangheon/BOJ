#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

string s;
int sum;

int main(void){
    cin >> s;
    
    string result;

    for(int i = 0; i < s.length(); i++){
        char c = s[i];
        if(c < 'A'){
            sum += (int)s[i] - '0';
        }else{
            result += s[i];
        }
    }
    sort(result.begin(), result.end());
    cout << result + to_string(sum) << "\n";
}