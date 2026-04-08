package org.jeyan.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Utility class for automatic logging
 * and customized file savers
 * check target/logs
 */
public class LogUtil {

    // variable initialization
    private static final Logger logger = Logger.getLogger(LogUtil.class.getName());
    private static FileHandler fileHandler;

    /**
     * Standard constructor for initializing by default credentials
     */
    public LogUtil() {
        Path path = Paths.get("target/logs/").toAbsolutePath();


        File folder = new File(path.toUri());

        try {
            // for folder creation if not existing
            if(!Files.exists(path)) {
                logger.info("Initiating Folder creation");
                Files.createDirectories(path);
                logger.info("Folder Created Successfully");
            }
            fileHandler = new FileHandler(folder.getPath()+"/"+getFileName());
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.info("Added File handler successfully");
        } catch(IOException ioException) {
            logger.severe("Adding file handler issue persisting!!");
        }

    }

    /**
     * LogUtil.info()
     * @param msg String for logging information
     */
    public void info(String msg) {
        logger.info(msg);
    }

    /**
     * LogUtil.severe()
     * @param msg String for Logging severe messages
     */
    public void severe(String msg) {
        logger.severe(msg);
    }

    /**
     * LogUtil.error()
     * @param msg String for Logging error
     */
    public void error(String msg) {
        logger.severe(msg);
    }

    /**
     * LogUtil.warn()
     * @param msg String for logging warning message
     */
    public void warn(String msg) {
        logger.warning(msg);
    }

    /**
     * Helper function for making standard filenames
     * @return filename with unique timestamp
     */
    private String getFileName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyy-hhmmss");
        return "log-"+ LocalDateTime.now().format(dtf)+".log";
    }

    public void close() {
        if(fileHandler != null)
            fileHandler.close();
    }


}
