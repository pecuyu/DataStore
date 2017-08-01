package com.yu.datastore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * 数据存储技术
 */
public class MainActivity extends AppCompatActivity {
    private EditText mEtFile,mEtKeySp,mEtValueSp;
    private Button mReadButton, mWriteButton,mReadButtonSp, mWriteButtonSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtFile = (EditText) findViewById(R.id.id_et_file);
        mReadButton = (Button) findViewById(R.id.btn_read_file);
        mWriteButton = (Button) findViewById(R.id.btn_write_file);
        mReadButtonSp = (Button) findViewById(R.id.btn_read_sp);
        mWriteButton = (Button) findViewById(R.id.btn_write_sp);
        mEtKeySp = (EditText) findViewById(R.id.id_et_key);
        mEtValueSp = (EditText) findViewById(R.id.id_et_value);
    }

    public void write_file(View view) {
        String input = mEtFile.getText().toString();
        if (!TextUtils.isEmpty(input)) {
            FileUtils.writeFile(this, input);
        }
    }

    public void read_file(View view) {
        String content = FileUtils.getFileContent(this,"file.txt");
        mEtFile.setText(content);
    }

    public void read_sp(View view) {
        String key = mEtKeySp.getText().toString();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        mEtValueSp.setText(SpUtils.getInstance(this).getString(key));
    }

    public void write_sp(View view) {
        String key = mEtKeySp.getText().toString();
        String value = mEtValueSp.getText().toString();
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return;
        }
        SpUtils.getInstance(this).putString(key, value);
    }



}
