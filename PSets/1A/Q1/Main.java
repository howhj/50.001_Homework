package com.example.lib;

public class Main {

    public static void main(String[] args) {

        int n;
        //n = Integer.parseInt(args[0]);
        n = 1;
        String ans = "";

        Fibonacci fibo = new Fibonacci();
        ans = fibo.fibonacci(n);

        System.out.println(ans);
    }
}
