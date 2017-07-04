package com.example.thandiwe.menu2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox ckCoffe, ckJava, ckExpres;
    TextView tv_total, tv_order_no, tv_amount, tv_change, tv_dis_tot, tvDis_item;
    Button btn_order;
    EditText etQua1, etQua2, etQua3, et_amount;

    int totalItems = 0;
    int totalAmount =0;
    int order =0;
    int quantity =0;
    int amount = 0;
    int change = 0;
    final int COFFEE_PRICE = 15;
    final int JAVA_PRICE = 30;
    final int EXPRESS0_PRICE = 45;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ckCoffe = (CheckBox) findViewById(R.id.cb_coffe);
        ckJava = (CheckBox) findViewById(R.id.cb_java);
        ckExpres = (CheckBox) findViewById(R.id.ck_expresso);

        tv_total = (TextView) findViewById(R.id.tvTotal);
        tv_order_no =(TextView)findViewById(R.id.tvOrder_no);
        tv_amount=(TextView)findViewById(R.id.tvAmount1);
        tv_change =(TextView)findViewById(R.id.tvChange1);
        tv_dis_tot =(TextView)findViewById(R.id.tvDis_Tot);
        tvDis_item =(TextView)findViewById(R.id.tv_dis_item);

        btn_order = (Button) findViewById(R.id.btnOrder);

        etQua1 =(EditText)findViewById(R.id.etCoffe);
        etQua2 =(EditText)findViewById(R.id.etJava);
        etQua3 =(EditText)findViewById(R.id.etExpresso);
        et_amount =(EditText)findViewById(R.id.editText4);

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                   // totalItems =totalItems +1;

                    tvDis_item.setText("" + totalItems);
                    tv_dis_tot.setText("" + totalAmount);

                    amount = Integer.parseInt(et_amount.getText().toString());
                    tv_amount.setText("R" + amount);


                    change = amount - totalAmount;
                    tv_change.setText("    R"+change);

                    amount=0;

                    order =++ order;




        }
        });



    }

    public void checkbox1(View v)
    {
        if(ckCoffe.isChecked())
        {


            quantity =Integer.parseInt(etQua1.getText().toString());



            totalItems =totalItems +1;
            totalAmount += COFFEE_PRICE;
            totalAmount = totalAmount*quantity;
            Toast.makeText(getApplicationContext()," plain coffee is : R " + totalAmount , Toast.LENGTH_SHORT).show();




        }
        else if(ckCoffe.isChecked() == false)
        {
            totalItems =totalItems -1;
            totalAmount =totalAmount - totalAmount;
            Toast.makeText(getApplicationContext()," plain coffee is : R " + totalAmount , Toast.LENGTH_SHORT).show();
        }

    }


    public void checkbox2(View v)
    {

        if(ckJava.isChecked())
        {

            quantity =Integer.parseInt(etQua2.getText().toString());

            totalItems =totalItems +1;
            totalAmount += JAVA_PRICE;
            totalAmount = totalAmount*quantity;

            Toast.makeText(getApplicationContext()," java is: R" + totalAmount, Toast.LENGTH_SHORT).show();
        }
        else if(ckJava.isChecked() == false)
        {
            totalItems =totalItems -1;
            totalAmount =totalAmount- totalAmount;
            Toast.makeText(getApplicationContext()," plain coffee is : R " + totalAmount , Toast.LENGTH_SHORT).show();
        }
    }

    public void checkbox3(View v)
    {


        if(ckExpres.isChecked())
        {
            quantity =Integer.parseInt(etQua3.getText().toString());

            totalItems =totalItems +1;
            totalAmount+= EXPRESS0_PRICE;
            totalAmount = totalAmount*quantity;
            Toast.makeText(getApplicationContext()," Expresso is: R" + totalAmount, Toast.LENGTH_SHORT).show();
        }
        else if(ckExpres.isChecked() == false)
        {
            totalItems =totalItems -1;
            totalAmount =totalAmount- totalAmount;
            Toast.makeText(getApplicationContext()," plain coffee is : R " + totalAmount , Toast.LENGTH_SHORT).show();
        }
    }


    public void next(View v) {
        order = ++order;
        totalAmount -= totalAmount;
        tv_order_no.setText("your order number: 0" + order);


        //tv_total.setText("next order please!!");

        ckCoffe.setChecked(false);
        ckJava.setChecked(false);
        ckExpres.setChecked(false);

        etQua1.setText(" ");
        etQua2.setText("");
        etQua3.setText("");

        et_amount.setText("");


        tv_amount.setText("R " + 0.0);
        // tv_total.setText("R " + 0);
        tv_dis_tot.setText("R " + 0.0);
        tv_change.setText("R " + 0.0);
        tvDis_item.setText("" + 0);
        totalItems = 0;


    }
}