package com.example.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button register, clear;
    EditText name, phone;
    CheckBox college, university, graduated, sport;
    Switch sex;
    SeekBar age;
    RadioButton rock, rap, pop;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, registerActivity.class);

        name = findViewById(R.id.inputName);
        phone = findViewById(R.id.inputPhone);
        college = findViewById(R.id.college);
        university = findViewById(R.id.university);
        graduated = findViewById(R.id.graduated);
        sport = findViewById(R.id.checkSport);
        sex = findViewById(R.id.switchSex);
        age = findViewById(R.id.seekAge);
        rock = findViewById(R.id.rock);
        rap = findViewById(R.id.rap);
        pop = findViewById(R.id.pop);

        assignId(register, R.id.btRegister);
        assignId(clear, R.id.btClear);

        age.setMax(100);
        age.setProgress(0);

        if (graduated.isChecked()) {
            intent.putExtra("keyLevel", graduated.getText());
        } else if (university.isChecked()) {
            intent.putExtra("keyLevel", university.getText());
        } else {
            intent.putExtra("keyLevel", college.getText());
        }

        if (sport.isChecked()) {
            intent.putExtra("keySport",sport.getText());
        } else {
            intent.putExtra("keySport","Không tham gia");
        }

        if (rock.isChecked()) {
            intent.putExtra("keyMusic", rock.getText());
        } else if (rap.isChecked()) {
            intent.putExtra("keyMusic", rap.getText());
        } else {
            intent.putExtra("keyMusic", pop.getText());
        }

        sex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {@Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) //checking if the user turned on the switch
            {
                intent.putExtra("keySex",sex.getTextOn().toString());

            } else {
                intent.putExtra("keySex", sex.getTextOff().toString());
            }
        }
        });

        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                intent.putExtra("keyAge", String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void assignId(Button bt, int id) {
        bt = findViewById(id);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btRegister: {
                intent.putExtra("keyName",name.getText().toString());
                intent.putExtra("keyPhone",phone.getText().toString());
                startActivity(intent);
                break;
            }
            case R.id.btClear: {
                name.setText("");
                phone.setText("");
                college.setChecked(false);
                university.setChecked(false);
                graduated.setChecked(false);
                sport.setChecked(false);
                sex.setChecked(false);
                age.setProgress(0);
                rock.setChecked(false);
                rap.setChecked(false);
                pop.setChecked(false);
                break;
            }
        }
    }
}