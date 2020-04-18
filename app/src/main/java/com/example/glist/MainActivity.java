package com.example.glist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etItemName,etQuantity,etPrice;
    Button btnAdd,btnView;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPrice= (EditText) findViewById(R.id.etPrice);
        etItemName = (EditText) findViewById(R.id.etItemName);
        etQuantity = (EditText) findViewById(R.id.etQuantity);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eItem = etItemName.getText().toString();
                String eQuan = etQuantity.getText().toString();
                String ePrice = etPrice.getText().toString();
                if (eItem.length() != 0 && eQuan.length() != 0 && ePrice.length() != 0 ){
                    AddData(eItem,eQuan,ePrice);
                    etPrice.setText("");
                    etQuantity.setText("");
                    etItemName.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You have input something in the text field", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String itemName,String quantity, String price ){
        boolean insertData = myDB.addData(itemName,quantity,price);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }

}
