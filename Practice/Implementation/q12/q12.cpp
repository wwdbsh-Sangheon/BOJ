#include <vector>
#include <algorithm>

using namespace std;

void remove_frame(vector<vector<int>>& answer, int x, int y, int a){
    for(int i = 0; i < answer.size(); i++){
        if(answer[i][0] == x && answer[i][1] == y && answer[i][2] == a){
            answer.erase(answer.begin()+i);
            return;
        }
    }
}

bool contains_frame(vector<vector<int>> answer, int x, int y, int a){
    for(int i = 0; i < answer.size(); i++){
        if(answer[i][0] == x && answer[i][1] == y && answer[i][2] == a){
            return true;
        }
    }
    return false;
}

bool check(vector<vector<int>> answer){
    for(int i = 0; i < answer.size(); i++){
        int x = answer[i][0];
        int y = answer[i][1];
        int a = answer[i][2];
        if(a == 0){
            if(y == 0 || contains_frame(answer, x, y-1, 0) || contains_frame(answer, x-1, y, 1) || contains_frame(answer, x, y, 1)){
                continue;
            }
        }else{
            if(contains_frame(answer, x, y-1, 0) || contains_frame(answer, x+1, y-1, 0) || (contains_frame(answer, x-1, y, 1) && contains_frame(answer, x+1, y, 1))){
                continue;
            }
        }
        return true;
    }
    return false;
}

int compare(vector<int> v1, vector<int> v2){
    if(v1[0] == v2[0] && v1[1] == v2[1]){
        return v1[2] <= v2[2];
    }else{
        if(v1[0] == v2[0]){
            return v1[1] < v2[1];
        }else{
            return v1[0] < v2[0];
        }
    }
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
    vector<vector<int>> answer;
    for(int i = 0; i < build_frame.size(); i++){
        int x = build_frame[i][0];
        int y = build_frame[i][1];
        int a = build_frame[i][2];
        int b = build_frame[i][3];
        if(b == 1){
            answer.push_back({x, y, a});
            if(check(answer)){
                answer.pop_back();
            }
        }else{
            remove_frame(answer, x, y, a);
            if(check(answer)){
                answer.push_back({x, y, a});
            }
        }
    }
    sort(answer.begin(), answer.end(), compare);
    return answer;
}