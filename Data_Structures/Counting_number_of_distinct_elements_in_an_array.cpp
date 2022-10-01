/*
Keep going. Be all in
*/
#include <bits/stdc++.h>

using namespace std;

#define inf             9223372036854775807
#define int       long long
#define F         first
#define S         second
#define pb         push_back
#define double       long double
#define endl       "\n"
#define bug(...)     __f (#__VA_ARGS__, __VA_ARGS__)
#define print(a)        for(auto x : a) cout << x << " "; cout << endl
#define print1(a)       for(auto x : a) cout << x.F << " " << x.S << endl
#define print2(a,x,y)   for(int i = x; i < y; i++) cout<< a[i]<< " "; cout << endl
#define PYES       cout << "YES\n"
#define PNO       cout << "NO\n"

const int N=7+1e6;

template <typename Arg1>
void __f (const char* name, Arg1&& arg1) { cout << name << " : " << arg1 << endl; }
template <typename Arg1, typename... Args>
void __f (const char* names, Arg1&& arg1, Args&&... args)
{
  const char* comma = strchr (names + 1, ',');
  cout.write (names, comma - names) << " : " << arg1 << " | "; __f (comma + 1, args...);
}


void solve(){
    cout << "Enter Size of the array" << endl;
    int n;
    cin >> n;

    cout << "Enter elements of the array" << endl;

    vector<int>v(n);
    set<int>s;

    for (int i = 0; i < n; ++i)
    {
      cin >> v[i];
      s.insert(v[i]);
    }

    cout << "The number of distinct elements in the array are " << s.size << endl;




  

}


int32_t main(){

  ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

  int t = 1;
  //cin >> t; // COMMENT this line out when no test cases

  while(t--) solve();

  return 0;

  
}