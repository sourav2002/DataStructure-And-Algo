
#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define vi vector<int>
#define vll vector<ll>
#define pll pair<ll, ll>
#define pb push_back
#define endl '\n'

signed main()
{
    vll temp;
    for (int i = 0; i < 17; i++)
    {
        for (int j = i + 1; j < 18; j++)
        {
            for (int k = j + 1; k < 19; k++)
            {
                for (int l = k + 1; l < 20; l++)
                {
                    ll val = (1 << l) + (1 << k) + (1 << j) + (1 << i);
                    temp.pb(val);
                }
                if (temp.size() == 1000)
                {
                    break;
                }
            }
            if (temp.size() == 1000)
            {
                break;
            }
        }
        if (temp.size() == 1000)
        {
            break;
        }
    }

    int tc = 0, tt = 1;
    cin >> tt;
    while (tc++ < tt)
    {
        ll n;
        cin >> n;
        for (int i = 0; i < n; i++)
        {
            cout << temp[i] << " ";
        }
        cout << endl;
    }

    return 0;
}
