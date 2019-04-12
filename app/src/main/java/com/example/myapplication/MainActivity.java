package com.example.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.myapplication.adpter.MyAdapterItem;
import com.example.myapplication.bean.Gupian_Bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    EditText et_code;
    RecyclerView recy_test01;
    MyAdapterItem myAdapterItem;
    LinearLayout ll_erro_view;
    private List<Gupian_Bean> list = new ArrayList<>();
    String a;

    String url = "http://hq.sinajs.cn/list=";
    Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_code = findViewById(R.id.et_code);
        recy_test01 = findViewById(R.id.recy_test01);
        ll_erro_view = findViewById(R.id.ll_erro_view);
        myAdapterItem = new MyAdapterItem(list, MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recy_test01.setLayoutManager(linearLayoutManager);
        recy_test01.setAdapter(myAdapterItem);

    }

    public void btgushi(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url001 = url + et_code.getText().toString().trim();
                //okHttp的基本使用 --- get方法
                //1,创建OKHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //2,创建一个Request
                Request request = new Request.Builder().url(url001).build();
                //3,创建一个call对象
                Call call = mOkHttpClient.newCall(request);
                //4,将请求添加到调度中
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        final String message = response.body().string();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                String[] name = message.split("\"");
                                for (int i = 0; i < name.length; i++) {
                                    //  System.out.println(name[i]);
                                    if (i == 1) {
                                        a = name[i];
                                    }
                                }
                                System.out.println("aasdasdas" + a);
                                String[] b = a.split(",");
                                list.add(new Gupian_Bean(b[0], b[1], b[2]));
                                myAdapterItem.notifyDataSetChanged();
                            }
                        });

                    }
                });

            }
        }).start();
    }

}
