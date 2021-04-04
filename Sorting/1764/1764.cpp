#include <iostream>
#include <algorithm>
#include <iterator>
#include <map>
#include <vector>

using namespace std;

map<string,int> no_hear_see;
vector<string> ans;
int n, m;

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        string name;
        cin >> name;
        no_hear_see[name] = 1;
    }
    for(int i = 0; i < m; i++){
        string name;
        cin >> name;
        no_hear_see[name] = no_hear_see[name]+1;
    }
    for(map<string,int>::iterator it = no_hear_see.begin(); it != no_hear_see.end(); ++it){
        if(it->second == 2){
            ans.push_back(it->first);
        }
    }
    sort(ans.begin(), ans.end());
    cout << ans.size() << "\n";
    for(int i = 0; i < ans.size(); i++){
        cout << ans[i] << "\n";
    }
}