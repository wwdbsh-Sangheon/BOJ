#include <iostream>
#include <algorithm>

using namespace std;

string str;

int main(void){

    cin >> str;
    
    long long result = str[0] - '0';

    for(int idx = 1; idx < str.size(); idx++){
      int number = str[idx] - '0';
      if(result <= 1 || number <= 1){
          result += number;
      }else{
          result *= number;
      }
    }
    cout << result << "\n";
}