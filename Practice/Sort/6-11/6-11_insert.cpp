#include <iostream>
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

void insert_sort(){
    for(int i = 1; i < n; i++){
        for(int j = i; j > 0; j--){
            if(s[j].second < s[j-1].second){
                swap(s[j], s[j-1]);
            }else{
                break;
            }
        }
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        string name;
        int score;
        cin >> name >> score;
        s.push_back(make_pair(name, score));
    }
    insert_sort();
    print_s();
}