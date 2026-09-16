class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) return "";

        int x = strs[0].size();

        for (int i = 0; i < x; i++) {
            char z = strs[0][i];

            for (int j = 1; j < strs.size(); j++) {
                if (i >= strs[j].size() || strs[j][i] != z) {
                    return strs[0].substr(0, i);
                }
            }
        }

        return strs[0];
    }
};