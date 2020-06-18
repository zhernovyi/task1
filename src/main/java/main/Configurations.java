package main;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Configurations {
    private static final String PATH_TO_CONFIG_FILE = "/Users/vladislavzhernovii/IdeaProjects/task1/src/recources/config.ini";

    private static int defaultPosition;
    private static String pathToOpenFile;
    private static String pathToSaveFile;
    private static String dateFormat;
    private static String printCounters;


    public static int getDefaultPosition() {
        return defaultPosition;
    }
    public static String getPathToOpenFile() {
        return pathToOpenFile;
    }
    public static String getPathToSaveFile() {
        return pathToSaveFile;
    }
    public static String getDateFormat() {
        return dateFormat;
    }
    public static String getPrintCounters() {
        return printCounters;
    }

    public Configurations() throws Exception{
        Properties props = new Properties();
        props.load(new InputStreamReader(new FileInputStream(PATH_TO_CONFIG_FILE)));
        defaultPosition = Integer.valueOf(props.getProperty("defaultPosition","0"));
        pathToOpenFile = props.getProperty("pathToOpenFile");
        pathToSaveFile = props.getProperty("pathToSaveFile");
        dateFormat = props.getProperty("dateFormat");
        printCounters=props.getProperty("printCounters");
    }
}
