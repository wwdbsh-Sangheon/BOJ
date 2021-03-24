#include <iostream>

using namespace std;

string word;

int main(void){
    cin >> word;
    int ans = 0;
    for(int i = word.length()-1; i >= 0; i--){
        char c = word[i];
        if(c == '='){
            if(i-2 >= 0 && word[i-1] == 'z' && word[i-2] == 'd'){
                i -= 2;
            }else{
                i--;
            }
        }else if(c == '-'){
            i--;
        }else if(c == 'j'){
            if(i-1 >= 0 && (word[i-1] == 'l' || word[i-1] == 'n')){
                i--;
            }
        }
        ans++;
    }
    cout << ans << "\n";
}