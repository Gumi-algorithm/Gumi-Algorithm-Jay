package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class no4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        while(true){
            String input = br.readLine();
            char word;
            if(input.equals(".")) break; // .이 오면 루프 종
            stack.clear();

            for(int i = 0; i < input.length(); i++){
                word = input.charAt(i);
                if(word == '(' || word == '['){ // (나 [ 가 올경우 그냥 문자 스택에 저장
                    stack.push(word);
                  }
                else if(word == ')' || word == ']'){
                    if(stack.isEmpty() || ( word ==')' && stack.peek() != '(' ) || ( word == ']' && stack.peek() != '[' )){
                        stack.push(word);
                        break;
                    }
                    else
                        stack.pop();
                }
            }
            if (stack.isEmpty()) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }

        }
    }
}
