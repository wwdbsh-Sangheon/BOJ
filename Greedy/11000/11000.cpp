#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

priority_queue<int> pq;
vector<vector<int>> classes;
int n;

int compare(vector<int> a, vector<int> b){
    if(a[0] == b[0]){
        return a[1] < b[1];
    }else{
        return a[0] < b[0];
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        int s, t;
        cin >> s >> t;
        classes.push_back({s, t});
    }
    sort(classes.begin(), classes.end(), compare);
    pq.push(-classes[0][1]);
    for(int i = 1; i < n; i++){
        int s = classes[i][0];
        int t = classes[i][1];
        if(s >= -pq.top()){
            pq.pop();
        }
        pq.push(-t);
    }
    cout << pq.size() << "\n";
}