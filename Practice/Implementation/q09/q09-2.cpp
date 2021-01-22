#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int solution(string s){
    int len = s.length();
    int ans = len;
    for(int unit = 1; unit <= len/2; unit++){
        string c_s;
        for(int idx = 0; idx < len;){
            string block = s.substr(idx, unit);
            int count = 0;
            while(block == s.substr(idx, unit)){
                count++;
                idx += unit;
                if(idx >= len) break;
            }
            c_s = count != 1 ? c_s + to_string(count) + block : c_s + block;
        }
        ans = min(ans, (int)c_s.length());
    }
    return ans;
}