package com.zhanghaopeng.day0416demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText ed1;
    private EditText ed2;
    private EditText ed3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        tv1 = findViewById(R.id.textView);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString().trim();
                String age = ed2.getText().toString().trim();
                String classroom = ed3.getText().toString().trim();
                SharedPreferences.Editor editor = getSharedPreferences("key", MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.putString("age", age);
                editor.putString("classroom", classroom);
                editor.commit();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("key", MODE_PRIVATE);
                String name = pref.getString("name", "");
                String age = pref.getString("age", "");
                String classroom = pref.getString("classroom", "");
                if (android.text.TextUtils.isEmpty(name)
                        || android.text.TextUtils.isEmpty(age)
                        || android.text.TextUtils.isEmpty(classroom))
                {
                    tv1.setText("输入数据为空\n请完成所有选项");
                }else {
                    tv1.setText("姓名:" + name + "\n" + "年龄:" + age + "\n" + "班级:" + classroom + "\n");
                }


            }
        });
    }
}
