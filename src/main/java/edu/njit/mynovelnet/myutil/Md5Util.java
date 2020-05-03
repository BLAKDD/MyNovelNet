package edu.njit.mynovelnet.myutil;

import org.springframework.util.DigestUtils;

public class Md5Util {
    public static String md5(String text, String key) {
        String rst = DigestUtils.md5DigestAsHex((text + key).getBytes());
        return rst;
    }
}
