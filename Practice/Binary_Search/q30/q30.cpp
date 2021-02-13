#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int count_by_range(vector<string>& v, string left_value, string right_value){
    vector<string>::iterator right_idx = upper_bound(v.begin(), v.end(), right_value);
    vector<string>::iterator left_idx = lower_bound(v.begin(), v.end(), left_value);
    return right_idx - left_idx;
}

string replaceAll(string str, string from, string to){
    string res = str;
    int pos = 0;
    while((pos = res.find(from, pos)) != string::npos){
        res.replace(pos, from.size(), to);
        pos += to.size();
    }
    return res;
}

vector<string> arr[10001];
vector<string> reversed_arr[10001];

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;
    for(int i = 0; i < words.size(); i++){
        string word = words[i];
        arr[word.size()].push_back(word);
        reverse(word.begin(), word.end());
        reversed_arr[word.size()].push_back(word);
    }
    for(int i = 0; i < 10001; i++){
        sort(arr[i].begin(), arr[i].end());
        sort(reversed_arr[i].begin(), reversed_arr[i].end());
    }
    for(int i = 0; i < queries.size(); i++){
        string q = queries[i];
        int res = 0;
        if(q[0] != '?'){
            res = count_by_range(arr[q.size()], replaceAll(q, "?", "a"), replaceAll(q, "?", "z"));
        }else{
            reverse(q.begin(), q.end());
            res = count_by_range(reversed_arr[q.size()], replaceAll(q, "?", "a"), replaceAll(q, "?", "z"));
        }
        answer.push_back(res);
    }
    return answer;
}

int main(void){
    vector<int> ans = solution({"frodo", "front", "frost", "frozen", "frame", "kakao"}, {"fro??", "????o", "fr???", "fro???", "pro?"});
    for(int i = 0; i < ans.size(); i++){
        cout << ans[i] << " ";
    }
    cout << "\n";
}