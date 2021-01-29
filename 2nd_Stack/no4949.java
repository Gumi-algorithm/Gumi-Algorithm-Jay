package bojAlgorithm;

import java.io.*;
import java.util.Stack;

public class no4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        while(true){
            String input = br.readLine();
            char word;
            if(input.equals(".")) break;
            stack.clear();

            for(int i = 0; i < input.length(); i++){
                word = input.charAt(i);
                if(word == '(' || word == '['){
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
