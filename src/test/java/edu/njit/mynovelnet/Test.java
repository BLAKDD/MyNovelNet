package edu.njit.mynovelnet;

public class Test {
    public static void main(String[] args) {
        String old = "sb你好";
        System.out.println(old.replaceFirst("[\u4e00-\u9fa5]+", "aaa"));
    }
}
