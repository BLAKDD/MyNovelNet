package edu.njit.mynovelnet.myutil;

import java.util.UUID;

public class DataUtil {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid + "";
    }

    public static String getCategoryPYById(Integer id) {
        switch (id) {
            case 1:
                return "xuanhuan";
            case 6:
                return "wuxia";
            case 11:
                return "xianxia";
            case 17:
                return "qihuan";
            case 24:
                return "kehuan";
            case 32:
                return "dushi";
            case 39:
                return "yanqing";
            case 46:
                return "lishi";
            case 51:
                return "junshi";
            case 59:
                return "youxi";
            case 64:
                return "tiyu";
            case 70:
                return "lingyi";
            case 76:
                return "danmei";
            case 79:
                return "erciyuan";
            default:
                return null;
        }

    }
}
