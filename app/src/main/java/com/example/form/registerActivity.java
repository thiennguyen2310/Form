package com.example.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class registerActivity extends AppCompatActivity {
    TextView tvName, tvPhone, tvSex, tvAge, tvSport, tvMusic, tvLevel;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle bundle = getIntent().getExtras();
        tvName = findViewById(R.id.name2);
        str = tvName.getText() + bundle.getString("keyName");
        tvName.setText(str);
        tvPhone = findViewById(R.id.phone2);
        str = tvPhone.getText() + bundle.getString("keyPhone");
        tvPhone.setText(str);
        tvSex = findViewById(R.id.sex2);
        str = tvSex.getText() + bundle.getString("keySex");
        tvSex.setText(str);
        tvAge = findViewById(R.id.age2);
        str = tvAge.getText() + bundle.getString("keyAge");
        tvAge.setText(str);
        tvSport = findViewById(R.id.sport2);
        str = tvSport.getText() + bundle.getString("keySport");
        tvSport.setText(str);
        tvMusic = findViewById(R.id.music2);
        str = tvMusic.getText() + bundle.getString("keyMusic");
        tvMusic.setText(str);
        tvLevel = findViewById(R.id.level2);
        str = tvLevel.getText() + bundle.getString("keyLevel");
        tvLevel.setText(str);
    }
}
