package com.baizhi.zy.util;

import java.io.File;
import java.text.DecimalFormat;

public class GetFileSize {

    public static String getSize(File file){
        long size = file.length();
        return FormetFileSize(size);
    }

    public static String FormetFileSize(long fileSize){
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString="";
        if (fileSize < 1024) {
            fileSizeString = df.format((double) fileSize) + "B";
        } else if (fileSize < 1048576) {
            fileSizeString = df.format((double) fileSize / 1024) + "K";
        } else if (fileSize < 1073741824) {
            fileSizeString = df.format((double) fileSize / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileSize / 1073741824) + "G";
        }
        return fileSizeString;
    }
}
