package com.sqs_sa.mobiletesting.api.core.managers;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

//creating a server manager class
public class ServerManager
{
    //defining the OS' ill be running my framework on
    //declaring the environmental variables that'll be holding my values
    private static String OS;
    private static String ANDROID_HOME;

    public static String getAndroidHome()
    {
        if (ANDROID_HOME == null)
        {
            //getting the environmental variables
            ANDROID_HOME = System.getenv("ANDROID_HOME");
            //assigning the OS value for android
            if(ANDROID_HOME == null) throw new RuntimeException("Failed to find ANDROID_HOME, make sure that your environment variable is set");
        }
        return ANDROID_HOME;
    }

    private static String getOS() {
        if (OS == null) OS = System.getenv("OS.name");
            return OS;
    }

    public static boolean isWindows()
    {
        return getOS().startsWith("Windows");
    }

    public static boolean isMac()
    {
        return getOS().startsWith("Mac");
    }

    //method to execute cmd through java for the ADB
    public static String runCommand(String command) {
        //handle scanner exceptions here
        String output;
        try {
            output = null;
            Scanner scanner = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");

            if (scanner.hasNext()) output = scanner.next();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return output;
    }
}

