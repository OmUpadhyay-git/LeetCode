class MinStack {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        a.push(x);
        b.push(b.empty() ? x : Math.min(x, b.peek()));
    }

    public void pop() {
        a.pop();
        b.pop();
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */