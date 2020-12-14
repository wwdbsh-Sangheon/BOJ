#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int solution(string s) {
    int answer = s.length(), unit = 1, len = s.length();

    while(unit <= len/2){
        string c_s;
        for(int i = 0; i < len; ){
            string s_unit = s.substr(i, unit);
            int count = 0;
            while(s_unit == s.substr(i, unit)){
                i += unit;
                count++;
                if(i >= len) break;
            }
            c_s = count != 1 && count != 0 ? c_s + to_string(count) + s_unit : c_s + s_unit;
        }
        answer = min(answer, (int)c_s.length());
        unit++;
    }
    return answer;
}