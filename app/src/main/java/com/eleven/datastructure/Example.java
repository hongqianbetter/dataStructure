package com.eleven.datastructure;

import android.util.Log;

public class Example {

    //检测括号匹配
    private boolean check() {
        String str = "({[}})";
        Stack<Character> stack = new ArrayStack<>();
        xiaom:   for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {//第一个字符是右值 或者没有字符
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '[' && c == ']') {
                    Log.e("SSS",pop+"---"+i);
                    continue xiaom;
                }
                if (pop == '{' && c == '}') {
                    Log.e("SSS",pop+"---"+i);
                    continue xiaom;
                }
                if (pop == '(' && c == ')') {
                    Log.e("SSS",pop+"---"+i);
                    continue xiaom;
                }
                return false;

            }

        }

        return stack.isEmpty();
    }

    public  static void main(String []args){
        Example example = new Example();
        boolean check = example.check();
        System.out.println(check+"------");

    }
}
