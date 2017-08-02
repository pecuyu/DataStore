package com.yu.datastore;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yu.datastore.utils.DBHelper;
import com.yu.datastore.utils.FileUtils;
import com.yu.datastore.utils.SpUtils;

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

//------------- 数据库操作 --------------
    public void write_db(View view) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "first line code");
        values.put("author", "guolin");
        values.put("price", 66.6);
        values.put("pages", 580);
        db.insert("book", null, values);
        values.clear();
        values.put("name", "the art of android developing explore");
        values.put("author", "ryg");
        values.put("price", 69.6);
        values.put("pages", 490);
        db.insert("book", null, values);
        db.close();
    }

    public void update_db(View view) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pages", 600);  // 要更新的数据
        db.update("book", values, "name=?", new String[]{"first line code"});
    }

    public void query_db(View view) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("book", new String[]{"name", "author", "price", "pages"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String author = cursor.getString(cursor.getColumnIndex("author"));
            float price = cursor.getFloat(cursor.getColumnIndex("price"));
            int pages = cursor.getInt(cursor.getColumnIndex("pages"));
            Log.e("TAG", "name=" + name + ",author=" + author + ",price=" + price + ",pages=" + pages);
        }
        cursor.close();
        db.close();

    }

    public void delete_db(View view) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("book", "author=?", new String[]{"guolin"});
        db.close();

    }


}
