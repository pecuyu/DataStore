package com.yu.datastore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 数据存储技术
 */
public class MainActivity extends AppCompatActivity {
    private EditText mEtFile;
    private Button mReadButton, mWriteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtFile = (EditText) findViewById(R.id.id_et_file);
        mReadButton = (Button) findViewById(R.id.btn_read_file);
        mWriteButton = (Button) findViewById(R.id.btn_write_file);

    }

    public void write_file(View view) {
        String input = mEtFile.getText().toString();
        if (!TextUtils.isEmpty(input)) {
            useFile(input);
        }
    }

    public void read_file(View view) {
        getFileContent("file.txt");
    }

    /**
     * 使用文件存储
     */
    private void useFile(String input) {
        BufferedWriter br = null;
        try {
            FileOutputStream fos = openFileOutput("file.txt", MODE_APPEND);
            br = new BufferedWriter(new OutputStreamWriter(fos));
            br.write(input);
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

    /**
     * 读取文件内容
     * @param fileName
     * @return
     */
    private String getFileContent(String fileName) {
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            fis = openFileInput(fileName);
            br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while (br.readLine() != null) {
                sb.append(line);
            }
            return sb.toString();
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
        return null;
    }

}
