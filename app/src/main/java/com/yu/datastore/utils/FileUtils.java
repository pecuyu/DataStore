package com.yu.datastore.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by D22436 on 2017/8/1.
 * 文件工具类，对/data/data/package-name/files中的文件进行读写
 */

public class FileUtils {
    /**
     * 使用文件存储
     */
    public static void writeFile(Context context, String input) {
        BufferedWriter br = null;
        try {
            FileOutputStream fos = context.openFileOutput("file.txt", Context.MODE_APPEND);
            br = new BufferedWriter(new OutputStreamWriter(fos));
            br.write(input);
            br.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取文件内容
     *
     * @param fileName
     * @return
     */
    public static String getFileContent(Context context,String fileName) {
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            fis = context.openFileInput(fileName);
            br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
