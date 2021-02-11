#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

map<int, vector<string>> word_map;

void optimize_words(vector<string> words){
    string temp = words[0];
    word_map[temp.length()].push_back(words[0]);
    for(int i = 1; i < words.size(); i++){
        if(temp.compare(words[i]) != 0){
            word_map[words[i].length()].push_back(words[i]);
            temp = words[i];
        }
    }
}

int check_keyword(string keyword){
    int type = -1;
    for(int i = 0; i < keyword.length(); i++){
        if(keyword[i] != '?') break;
        if(i == keyword.length()-1) type = 2;
    }
    if(type == 2){ // every character is '?'
        return type;
    }
    if((keyword[0] == '?' && keyword[keyword.length()-1] == '?') ||
     (keyword[0] != '?' && keyword[keyword.length()-1] != '?')){
        return type;
    }
    if(keyword[0] == '?'){ // prefix
        int count = 0;
        char temp = 'c';
        for(int i = 0; i < keyword.length(); i++){
            if(temp != '?'){
                if(keyword[i] == '?'){
                    count++;
                    temp = '?';
                }
            }else{
                if(keyword[i] != '?'){
                    temp = 'c';
                }
            }
            if(count == 2){
                return type;
            }
        }
        type = 0; // prefix
    }
    if(keyword[keyword.length()-1] == '?'){ // postfix
        int count = 0;
        char temp = 'c';
        for(int i = keyword.length()-1; i >= 0; i--){
            if(temp != '?'){
                if(keyword[i] == '?'){
                    count++;
                    temp = '?';
                }
            }else{
                if(keyword[i] != '?'){
                    temp = 'c';
                }
            }
            if(count == 2){
                return type;
            }
        }
        type = 1; // postfix
    }
    return type;
}

bool check_match(string keyword, string word, int start, int end, int type){
    if(start > end || type == 2){
        return true;
    }
    int mid = (start+end)/2;
    if(type == 0){ // prefix
        if(keyword[mid] == '?'){
            return check_match(keyword, word, mid+1, end, type);
        }
        if(keyword[mid] == word[mid]){
            if(keyword[mid-1] != '?'){
                return check_match(keyword, word, start, mid-1, type) && check_match(keyword, word, mid+1, end, type);
            }else{
                return check_match(keyword, word, mid+1, end, type);
            }
        }else{
            return false;
        }
    }else{ // postfix
        if(keyword[mid] == '?'){
            return check_match(keyword, word, start, mid-1, type);
        }
        if(keyword[mid] == word[mid]){
            if(keyword[mid+1] != '?'){
                return check_match(keyword, word, start, mid-1, type) && check_match(keyword, word, mid+1, end, type);
            }else{
                return check_match(keyword, word, start, mid-1, type);
            }
        }else{
            return false;
        }
    }
}

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;
    map<string, int>::iterator it;
    map<string, int> m;
    sort(words.begin(), words.end());
    optimize_words(words);
    for(int i = 0; i < queries.size(); i++){
        string keyword = queries[i];
        int key_len = keyword.length();
        int type = check_keyword(keyword);
        int count = 0;
        it = m.find(keyword);
        if(it != m.end()){
            answer.push_back(it->second);
            continue;
        }
        if(type != -1){
            for(int j = 0; j < word_map[key_len].size(); j++){
                string word = word_map[key_len][j];
                if(check_match(keyword, word, 0, key_len-1, type)){
                    count++;
                }
            }
            m.insert(make_pair(keyword, count));
        }
        answer.push_back(count);
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