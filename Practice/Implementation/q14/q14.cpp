#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int solution(int n, vector<int> weak, vector<int> dist) {
    int length = weak.size();
    for(int i = 0; i < length; i++){
        weak.push_back(weak[i] + n);
    }
    int answer = dist.size() + 1;
    for(int start = 0; start < length; start++){
        do{
            int cnt = 1;
            int position = weak[start] + dist[cnt-1];
            for(int index = start; index < start+length; index++){
                if(position < weak[index]){
                    cnt++;
                    if(cnt > dist.size()){
                        break;
                    }
                    position = weak[index] + dist[cnt-1];
                }
            }
            answer = min(answer, cnt);
        }while(next_permutation(dist.begin(), dist.end()));
    }
    if(answer > dist.size()){
        return -1;
    }
    return answer;
}