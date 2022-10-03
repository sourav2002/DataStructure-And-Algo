/* Given an integer array, find all distinct combinations of a given length k, where the repetition of elements is allowed.

For example,

Input:  {1, 2, 3}, k = 2
Output: {1, 1}, {1, 2}, {1, 3}, {2, 2}, {2, 3}, {3, 3}
 
 
Input:  {1, 2, 3, 4}, k = 2
Output: {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {3, 4}, {4, 4}
 
 
Input:  {1, 2, 1}, k = 2
Output: {1, 1}, {1, 2}, {2, 2}
The program should print only distinct combinations. For example, for the last input, either {1, 2} or {2, 1} should be considered.

Practice This Problem

 
We can use recursion to solve this problem. The idea is to add each array element to the output starting from the last considered element and recur for the remaining elements. To avoid printing permutations, construct each tuple in the same order as array elements. If the combination of size k is found, print it.

Following is the implementation in C++, Java, and Python based on the above idea: */


#include <iostream>
#include <vector>
using namespace std;
 
// Function to print the contents of the vector
void printVector(vector<int> const &out)
{
    for (auto it = out.begin(); it != out.end(); it++) {
        cout << *it << " ";
    }
    cout << endl;
}
 
// Function to print all distinct combinations of length `k`, where the
// repetition of elements is allowed
void findCombinations(int arr[], vector<int> &out, int k, int i, int n)
{
    // base case: if the combination size is `k`, print it
    if (out.size() == k)
    {
        printVector(out);
        return;
    }
 
    // start from the previous element in the current combination
    // till the last element
    for (int j = i; j < n; j++)
    {
        // add current element `arr[j]` to the solution and recur with the
        // same index `j` (as repeated elements are allowed in combinations)
        out.push_back(arr[j]);
        findCombinations(arr, out, k, j, n);
 
        // backtrack: remove the current element from the solution
        out.pop_back();
    }
}
 
int main()
{
    int arr[] = { 1, 2, 1 };
    int k = 2;
 
    int n = sizeof(arr) / sizeof(arr[0]);
 
    vector<int> out;
    findCombinations(arr, out, k, 0, n);
 
    return 0;
}
