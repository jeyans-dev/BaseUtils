package org.jeyan;

import org.jeyan.utils.LogUtil;

class Main {
    public static void main(String[] args) {
        // sample Usage
        LogUtil log  = new LogUtil();
        log.info("This is a information");
        log.warn("This is a warning");
        log.error("This is a error");
    }
}