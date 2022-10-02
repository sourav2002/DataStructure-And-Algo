#include <bits/stdc++.h>
using namespace std;

int main(){
	int x;
	cin>>x;
	int l = 1, h = x;
	long long mid;
	int ans = 0;

	while(l <= h){
		mid = (l+h)/2;
		if((mid*mid) <= x){
           ans = mid;
           l = mid + 1;
		}
		else{
			h = mid - 1;
		}
	}  
	cout<<ans<<endl;
}
