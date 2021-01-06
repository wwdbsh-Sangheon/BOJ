#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;
vector<pair<string,int>> s;

void print_s(){
    for(int i = 0; i < s.size(); i++){
        cout << s[i].first << " ";
    }
    cout << "\n";
}

int compare(pair<string,int> a,pair<string,int> b){
    return a.second < b.second;
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        string name;
        int score;
        cin >> name >> score;
        s.push_back(make_pair(name, score));
    }
    sort(s.begin(), s.end(), compare);
    print_s();
}