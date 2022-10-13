#include <bits/stdc++.h>
using namespace std;
void printMissing(int arr[], int n, int low,int high)
{
	sort(arr, arr + n);
	int* ptr = lower_bound(arr, arr + n, low);
	int index = ptr - arr;
	int i = index, x = low;
	while (i < n && x <= high) {
		if (arr[i] != x)
			cout << x << " ";
		else
			i++;
		x++;
	}
	while (x <= high)
		cout << x++ << " ";
}
int main()
{
	int arr[] = { 1, 3, 5, 4 };
	int n = sizeof(arr) / sizeof(arr[0]);
	int low = 1, high = 10;
	printMissing(arr, n, low, high);
	return 0;
}
