#include<bits/stdc++.h>
using namespace std;
const int N = 1e5+10;

vector<int> g[N];
bool visited[N];

vector<int> cc;
vector<int> current_cc;

void dfs(int vertex){
  
  visited[vertex] = true;
  current_cc.push_back(vertex);
  
  for(int child : g[vertex]){
  	
  	if(visited[child] == true)
  		continue;
  	dfs(child);
  }
}



int main(){
	int n,e;
	cin>>n>>e;

	for(int i=0;i<e;i++){
		int x,y;
		cin>>x>>y;
		g[x].push_back(y);
		g[y].push_back(x);
	}
    

    int ct = 0;
	for(int i=1;i<=e;i++){
		if(visited[i] == true) 
			continue;

		current_cc.clear();
		dfs(i);
		cc.push_back(current_cc);
		ct++;
	}
  
  cout<<ct<<endl;

  for(int c_cc : cc){
  	for(int vertex : c_cc){
  		cout<<vertex<<" ";
  	}
  	cout<<endl;
  }
  


}

