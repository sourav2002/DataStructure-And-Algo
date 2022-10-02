class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> v;
        
        sort(nums.begin(),nums.end());
        
        do{
            for(int i=0;i<nums.size();i++)
            {
                v.push_back(nums[i]);
            }
            
            ans.push_back(v);
            v.clear();
            
        }while (next_permutation(nums.begin(),nums.end()));
        
        return ans;
    }
};