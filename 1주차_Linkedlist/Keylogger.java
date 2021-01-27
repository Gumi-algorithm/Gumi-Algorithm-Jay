package com.selfstudy;

import java.util.*;

class Keylogger{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 0; t < tc; t++){
            LinkedList<Character> password = new LinkedList<>();
            int index = 0;
            String str = sc.next();
            
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) != '<' && str.charAt(i) != '>' && str.charAt(i) != '-'){
                    password.add(index, str.charAt(i));
                    index++;
                    continue;
                }
                if(str.charAt(i) == '<' && index != 0){
                    index--;
                    continue;
                }
                if(str.charAt(i) == '>' && index <= password.size() - 1){
                    index++;
                    continue;
                }
                if(str.charAt(i) == '-' && index != 0){
                    password.remove(index - 1);
                    index--;
                }
            }
            for(int j = 0; j < password.size(); j++){
                System.out.print(password.get(j));
            }
            System.out.println();
        }
    }
}