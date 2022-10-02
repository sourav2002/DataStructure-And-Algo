#include <bits/stdc++.h>
using namespace std;
string isBalanced(string s);

unordered_map<char,int> symbols = {{'[',-1},{'{',-2},{'(',-3}}

string isBalanced(string s){
	stack<char> st;
	for(auto bracket : s){
		if(symbols[bracket] < 0){
           st.push(bracket);
		}
		else{
			if(st.empty()) return "No";
			char top = st.top();
			st.pop();
			if(symbols[top] + symbols[bracket] !=0) return "No";
		}


	}
	if(st.empty()) return "Yes";
	else return "No";
}


int main(){
	int t; 
	cin>>t;
	while(t--){
		string s; 
		cin>>s;
		auto ans = isBalanced(s);
		cout<< ans<<endl;
	}
}