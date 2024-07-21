package org.leetcode.weekly.july.week2;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOfParentheses r = new ReverseSubstringsBetweenEachPairOfParentheses();
        String res = r.reverseParentheses("(u(love)i)");
        System.out.println(res);
    }

    int index = 0;
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        index = 0;
        return reverse(s).toString();
    }

    private StringBuilder reverse(String s){
        StringBuilder sb = new StringBuilder();
        while(index < s.length()){
            char c = s.charAt(index);
            index = index+1;
            if(c == '('){
                sb.append(reverse(s));
            }else if(c == ')'){
                return sb.reverse();
            }else{
                sb.append(c);
            }
        }
        return sb;
    }
}
