/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        map<int, map<int , multiset<int>>> nodes;
        queue<pair<TreeNode*, pair<int,int>>> q;
        q.push({root,{0,0}});
        
        while(!q.empty())
        {
            auto p = q.front();
            q.pop();
            
            TreeNode * roots = p.first;
            int x = p.second.first;
            int y = p.second.second;
            
            nodes[x][y].insert(roots->val);
            if(roots->left)
            {
                q.push({roots->left,{x-1,y+1}});
            }
            if(roots->right)
            {
                q.push({roots->right,{x+1,y+1}});
            }
        }
                
        vector<vector<int>> ans;
        for(auto p : nodes)
        {
            vector<int> col;
            for(auto t : p.second)
            {
                col.insert(col.end(), t.second.begin(),t.second.end());
            }
            
            ans.push_back(col);
        }
                
        return ans;        
    }
};