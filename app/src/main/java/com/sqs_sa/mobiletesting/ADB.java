package com.sqs_sa.mobiletesting;
import android.support.annotation.VisibleForTesting;
import com.sqs_sa.mobiletesting.api.core.managers.ServerManager;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class ADB
{
    //create a method to run commands in the ADB
    public static String command(String command)
    {
        if(command.startsWith("adb"))  command= command.replace("adb", ServerManager.getAndroidHome()+"/platform-tools/adb");
        //if env is not starting with adb
        else throw new RuntimeException("This method is used to run ADB commands only");
        String output = ServerManager.runCommand(command);
        if(output == null) return "";
        else return output;
    }
    @Test
    public void test()
    {
        System.out.println("adb devices");
    }
}
