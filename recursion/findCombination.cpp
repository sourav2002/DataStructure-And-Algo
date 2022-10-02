// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.


class Solution {
public:
    void findcombination(int index, int target, vector<int> &arr, vector<vector<int>> &ans,vector<int> &v)
    {
      if(target == 0)
      {
          ans.push_back(v);
          return;
      }
        
      for(int i=index;i<arr.size();i++)
      {
          if(i>index && arr[i] == arr[i-1]) continue;
          if(arr[i] > target) break;
          v.push_back(arr[i]);
          findcombination(i+1,target-arr[i],arr,ans,v);
          v.pop_back();
      }
          
    }
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        vector<vector<int>> ans;
        vector<int> v;
        
        findcombination(0,target,candidates,ans,v);
        return ans;
    }
};