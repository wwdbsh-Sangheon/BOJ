#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool check_correct_str(string p){
    stack<char> s;
    for(int i = 0; i < p.length(); i++){
        char c = p[i];
        if(c == '('){
            s.push(c);
        }else{
            if(s.empty()){
                return false;
            }
            s.pop();
        }
    }
    return true;
}

string reorganize_u(string u){
    string reorg_u = "";
    for(int i = 1; i < u.length()-1; i++){
        char c = u[i];
        if(c == '('){
            reorg_u += ')';
        }else{
            reorg_u += '(';
        }
    }
    return reorg_u;
}

string reorganize_p(string p){
    if(p == ""){
        return p;
    }
    int l_count = 0;
    int r_count = 0;
    int s_point = p.length();
    for(int i = 0; i < p.size(); i++){
        char c = p[i];
        if(c == '('){
            l_count++;
        }else{
            r_count++;
        }
        if(l_count == r_count){
            s_point = i+1;
            break;
        }
    }
    string u = p.substr(0, s_point);
    string v = s_point != p.length() ? p.substr(s_point, p.length()-1) : "";
    if(check_correct_str(u)){
        return u + reorganize_p(v);
    }else{
        return "(" + reorganize_p(v) + ")" + reorganize_u(u);
    }
}

string solution(string p) {
    return reorganize_p(p);
}

int main(void){
    cout << solution("()))((()") << "\n";
}