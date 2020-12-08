#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, result = 1;
vector<pair<int, int>> meeting;

bool compare(pair<int, int> a, pair<int, int> b){
    if(a.second == b.second){ // 끝나는 시간이 같다면 빨리 시작하는 회의를 앞으로 배치
        return a.first < b.first;
    }else{ // 끝나는 시간이 빠른 회의를 앞으로 배치
        return a.second < b.second;
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        int s, e;
        cin >> s >> e;
        meeting.push_back(make_pair(s, e));    
    }

    sort(meeting.begin(), meeting.end(), compare);

    int prev_e = meeting[0].second;
    for(int i = 1; i < n; i++){
        int s = meeting[i].first;
        if(s >= prev_e){ // 회의 시작 시작이 이전 회의의 끝나는 시간과 같거나 늦다면 회의를 진행
            prev_e = meeting[i].second; // 다음 회의를 정하기 위해 이전 회의 끝 시간 갱신
            result++;
        }
    }
    cout << result << "\n";
}