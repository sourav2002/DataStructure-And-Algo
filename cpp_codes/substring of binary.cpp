#include<bits/stdc++.h>
using namespace std;

vector<string> sub;
void subString(string s, int n)
{
    
    for (int i = 0; i < n; i++)
        for (int len = 1; len <= n - i; len++)
             sub.push_back(substr(i, len));
}

int main(){
	int tc;
	cin>>tc;

	while(tc--){
		string s;
		cin>>s;
		subString(s,s.length());

		if(sub.find("11") || sub.find("10")){
			cout<<"Yes"<<endl;
		}
		else{
			cout<<"No"<<endl;
		}



	}
}