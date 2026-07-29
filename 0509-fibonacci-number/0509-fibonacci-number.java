class Solution {
    public int fib(int n) {
        int first = 0;
        int second = 1;
        int nextsum = 0;
        if(n<=1) return n;
     for (int i=2;i<=n;i++){
        nextsum=first+second;
        first=second;
        second=nextsum;
        }
        return nextsum;
    }
}