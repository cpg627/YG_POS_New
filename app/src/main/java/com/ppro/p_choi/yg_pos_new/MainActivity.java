package com.ppro.p_choi.yg_pos_new;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_1_1, btn_1_2, btn_1_3, btn_1_4, btn_1_5, btn_1_6;
    EditText m_rev;//총계
    TextView m_total, m_return;//받은돈, 거스름돈
    Integer m_rev_int, m_total_int, m_return_int;
    ListView listView1;
    ListViewAdapter m_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼에 리스너 달기
        btn_1_1=(Button)findViewById(R.id.btn_1_1);
        btn_1_2=(Button)findViewById(R.id.btn_1_2);
        btn_1_3=(Button)findViewById(R.id.btn_1_3);
        btn_1_4=(Button)findViewById(R.id.btn_1_4);
        btn_1_5=(Button)findViewById(R.id.btn_1_5);
        btn_1_6=(Button)findViewById(R.id.btn_1_6);

        //받은돈 입력창
        m_rev = (EditText) findViewById(R.id.m_rev);
        //숫자가 아닌것이 들어올 경우를 대비
        if(m_rev.getText().toString().equals(null)) {
            m_rev_int = 0;
        }
        else
        {
            m_rev_int = Integer.parseInt(m_rev.getText().toString());
        }

        //받은돈에 맞춰 거스름돈 계산
        m_total = (TextView)findViewById(R.id.m_total);//총계
        m_return = (TextView)findViewById(R.id.m_return);//거스름돈
        m_total_int = Integer.parseInt(m_total.getText().toString());
        m_return_int = m_rev_int - m_total_int;//받은돈-총계
        //돈을 받기전은 무조건0으로 표시
        if(m_return_int <= 0){
            m_return_int=0;
        }

        //어댑터 생성
        m_adapter = new ListViewAdapter();
        //리스트뷰 생성
        listView1 = (ListView)findViewById(R.id.listview1);
        //리스트에 어댑터 추가** 에러가 발생하는 부분
        listView1.setAdapter(m_adapter);
        listView1.setBackgroundColor(Color.GRAY);//배경색 바꾸기
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //커스텀 리스트 생성
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                M_ListItem item = (M_ListItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable iconDrawble = item.getIcon();
            }
        });//헷갈리기 쉬운부분
        m_adapter.addItem(ContextCompat.getDrawable(this, R.mipmap.ic_launcher),"Box","Account box Black");
        Button.OnClickListener listener = new Button.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_1_1:
                        System.out.println("1_1 눌림");
                        //ListView에 Item추가
                        //m_adapter.addItem(ContextCompat.getDrawable(this, R.mipmap.ic_launcher),"Box","Account box Black");
                        //총계금액에 추가
                        m_total_int += getPrice(v.getId());
                        break;
                    case R.id.btn_1_2:
                        System.out.println("1_2 눌림");
                        //ListView에 Item추가
//                        m_adapter.add("2000");
                        m_total_int += getPrice(v.getId());
                        break;
                    case R.id.btn_1_3:
                        System.out.println("1_3 눌림");
                        //ListView에 Item추가
//                        m_adapter.add("3000");
                        m_total_int += getPrice(v.getId());
                        break;
                    case R.id.btn_1_4:
                        System.out.println("1_4 눌림");
                        //ListView에 Item추가
                        //                       m_adapter.add("4000");
                        m_total_int += getPrice(v.getId());
                        break;
                    case R.id.btn_1_5:
                        System.out.println("1_5 눌림");
                        //ListView에 Item추가
                        //                       m_adapter.add("5000");
                        m_total_int += getPrice(v.getId());
                        break;
                    case R.id.btn_1_6:
                        System.out.println("1_6 눌림");
                        //ListView에 Item추가
//                        m_adapter.add("6000");
                        m_total_int += getPrice(v.getId());
                        break;
                }
                //총계 금액 업데이트
                m_total = (TextView)findViewById(R.id.m_total);
                m_total.setText(m_total_int.toString());
                //거스름돈 업데이트
                m_return_int = m_rev_int - m_total_int;
                m_return = (TextView)findViewById(R.id.m_return);
                m_return.setText(m_return_int.toString());
            }
        };//이부분에서 세미콜론;을 찍는것을잊어서는안된다
        btn_1_1.setOnClickListener(listener);
        btn_1_2.setOnClickListener(listener);
        btn_1_3.setOnClickListener(listener);
        btn_1_4.setOnClickListener(listener);
        btn_1_5.setOnClickListener(listener);
        btn_1_6.setOnClickListener(listener);

    }

    //제품 가격을 호출하는 메서드
    private Integer getPrice(int id) {
        int price = 0;
        switch (id){
            case R.id.btn_1_1://아메리카노
                price = 1000;
                break;
            case R.id.btn_1_2://라떼
                price = 2000;
                break;
            case R.id.btn_1_3:
                price = 3000;
                break;
            case R.id.btn_1_4:
                price = 4000;
                break;
            case R.id.btn_1_5:
                price = 5000;
                break;
            case R.id.btn_1_6:
                price = 6000;
                break;
        }

        return price;
    }



}
