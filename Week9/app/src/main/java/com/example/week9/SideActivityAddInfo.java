package com.example.week9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SideActivityAddInfo extends AppCompatActivity {

    private TextView firstname;
    private TextView lastname;
    private TextView email;
    private RadioGroup profession;

    private CheckBox cbKandi;
    private CheckBox cbMaister;
    private CheckBox cbTohtori;


    private Context context;

    private RadioGroup face;

    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_add_info);
        context = SideActivityAddInfo.this;
    }
    public void addUser(View view) {
        ArrayList<String> degrees = new ArrayList<>();
        firstname = findViewById(R.id.txtFirstnameInput);
        lastname = findViewById(R.id.txtLastnameInput);
        email = findViewById(R.id.txtEmailInput);
        profession = findViewById(R.id.RadioGroupPro);
        face = findViewById(R.id.RadioGroupFace);
        cbKandi = findViewById(R.id.cbkandi);
        cbMaister = findViewById(R.id.cbMaister);
        cbTohtori = findViewById(R.id.cbTohtori);

        switch (face.getCheckedRadioButtonId()){
            case R.id.imgTroll:
                image = R.drawable.troll;
                break;
            case R.id.imgObanium:
                image = R.drawable.obanium;
                break;
            case R.id.imgFace:
                image = R.drawable.screenshot_20;
                break;
            default:
                image = R.drawable.defaultface;
                break;
        }
        if (cbKandi.isChecked()){
            degrees.add("Kanditaatin tunkinto");
        }
        if (cbMaister.isChecked()){
            degrees.add("Maisterin tunkinto");
        }
        if (cbTohtori.isChecked()){
            degrees.add("Tohtorin tunkinto");
        }


        switch (profession.getCheckedRadioButtonId()) {
            case R.id.radioButtonTite:
                UserStorage.getInstance().addUser(new User(firstname.getText().toString(), lastname.getText().toString(), email.getText().toString(), "Tietotekniikka", image, degrees));
                break;
            case R.id.radioButtonTuta:
                UserStorage.getInstance().addUser(new User(firstname.getText().toString(), lastname.getText().toString(), email.getText().toString(), "Tuotantotalous", image, degrees));
                break;
            case R.id.radioButtonLatex:
                UserStorage.getInstance().addUser(new User(firstname.getText().toString(), lastname.getText().toString(), email.getText().toString(), "Laskennallinen tekniikka", image, degrees));
                break;
            case R.id.radioButtonSahkotekniikka:
                UserStorage.getInstance().addUser(new User(firstname.getText().toString(), lastname.getText().toString(), email.getText().toString(), "Sähkötekniikka", image, degrees));
                break;
            default:
                Toast.makeText(this, "Please input profession", Toast.LENGTH_SHORT).show();
        }
        UserStorage.getInstance().saveUsers(context);

    }

}