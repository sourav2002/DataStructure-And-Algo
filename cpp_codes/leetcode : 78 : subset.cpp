class Solution {
public:
    void subsets(int index, vector<int> &v, vector<vector<int>> &ans, vector<int> &nums, int n)
    {
        if(index >= n)
        {
            ans.push_back(v);
            return;
            
        }
        
        v.push_back(nums[index]);
        subsets(index+1,v,ans,nums,n);
        v.pop_back();
        
        subsets(index+1,v,ans,nums,n);
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> v;
        
        int n = nums.size();
        
        subsets(0,v,ans,nums,n);
        
        return ans;
    }
};