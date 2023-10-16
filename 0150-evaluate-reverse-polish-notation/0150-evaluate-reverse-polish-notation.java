class Solution {
        private static final Set<String> operands = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Stack<Integer> operationsStk = new Stack<>();
        for (String token : tokens) {
            if (operands.contains(token)) {
                doOperation(operationsStk, token);
            } else operationsStk.push(Integer.valueOf(token));
        }
        return operationsStk.pop();
    }

    private void doOperation(Stack<Integer> operationsStk, String token) {
        Integer secondNo = operationsStk.pop();
        Integer firstNo = operationsStk.pop();
        Integer result;
        
        if ("+".equals(token)) result = firstNo + secondNo;
        else if ("-".equals(token)) result = firstNo - secondNo;
        else if ("*".equals(token)) result = firstNo * secondNo;
        else result = firstNo / secondNo;

        operationsStk.push(result);
    }

}