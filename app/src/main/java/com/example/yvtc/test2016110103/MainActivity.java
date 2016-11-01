package com.example.yvtc.test2016110103;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int ch = -1;
    int tmp = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void click1(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("對話框測試");
            builder.setMessage("這是對話框內容\n第二行");

            builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "確定被按下", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "取消被按下", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "忽略被按下", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        }
        public void click2(View v)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("輸入對話框測試");
            builder.setMessage("請輸入你的暱稱");
            final EditText ed = new EditText(MainActivity.this);
            builder.setView(ed);
            builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    TextView tv2 = (TextView) findViewById(R.id.textView);
                    String str = ed.getText().toString();
                    tv2.setText(str);
                }
            });
            builder.show();
        }
        public void click3(View v)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("選項測試框測試");
            builder.setSingleChoiceItems(R.array.drinks,ch, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tmp = which;
                }
            });
            builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ch = tmp;
                    if (ch >= 0) {
                        String[] drinks = getResources().getStringArray(R.array.drinks);
                        TextView tv3 = (TextView) findViewById(R.id.textView2);
                        tv3.setText(drinks[ch]);
                    }
                }
            });

            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tmp = ch;
                }
            });
            builder.show();
        }
}
