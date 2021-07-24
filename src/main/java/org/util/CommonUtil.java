package org.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author duanweidong
 * @version 2021/7/24 17:00
 */
public class CommonUtil {

    public static long currentTimestamp() {
        return Timestamp.valueOf(LocalDateTime.now()).getTime();
    }
}
