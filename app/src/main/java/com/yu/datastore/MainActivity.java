package com.yu.datastore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 数据存储技术
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useFiles();
    }

    /**
     * 使用文件存储
     */
    private void useFiles() {
        BufferedWriter br = null;
        try {
            FileOutputStream fos = openFileOutput("file.txt", MODE_APPEND);
            br = new BufferedWriter(new OutputStreamWriter(fos));
            br.write("this is a test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
