package com.selfstudy;

//import java.util.*;
import java.io.*;
import java.util.LinkedList;

class Keylogger{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int tc = Integer.parseInt(br.readLine());
//        Scanner sc = new Scanner(System.in);
//        int tc = sc.nextInt();

        for(int i = 0; i < tc; i++){
            LinkedList<Character> password = new LinkedList<Character>(); // 리스트 생성

            int index = 0;
            String str = br.readLine();
//            String str = sc.next();

            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) != '<' && str.charAt(j) != '>' && str.charAt(j) != '-'){
                    password.add(index, str.charAt(j));
                    index++;
                    continue;
                }
                if(str.charAt(j) == '<' && index != 0){
                    index--;
                    continue;
                }
                if(str.charAt(j) == '>' && index <= password.size() - 1){
                    index++;
                    continue;
                }
                if(str.charAt(j) == '-' && index != 0){
                    password.remove(index - 1);
                    index--;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int p = 0; p < password.size(); p++){
                sb.append(password.get(p));
            }
            System.out.print(sb);
//            for(int k = 0; k < password.size(); k++){
//                System.out.print(password.get(k));
//            }
//            System.out.println();
        }
        System.out.println();
        bw.flush();
        bw.close();
    }
}
