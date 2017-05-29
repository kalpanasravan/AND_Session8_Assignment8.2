package com.kalpana.user.and_session8_assignment82;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1,b2;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Age = "ageKey";
    public static final String City = "cityKey";
    public static final String Phone = "phoneKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                //Initializing the variables
        ed1=(EditText)findViewById(R.id.name_label);
        ed2=(EditText)findViewById(R.id.age_text);
        ed3=(EditText)findViewById(R.id.phone_text);
        ed4=(EditText)findViewById(R.id.city_text);

        b1=(Button)findViewById(R.id.save_button);
        b2=(Button)findViewById(R.id.show_button);
        //Setting the shared preference mode
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = ed1.getText().toString();
                String a  = ed2.getText().toString();
                String ph  = ed3.getText().toString();
                String c=ed4.getText().toString();
                //Setting the editor to put the values in shared prefernce

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("Name", n);
                editor.putString("Age", ph);
                editor.putString("Phone", a);
                editor.putString("City",c);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);

                    String name = prefs.getString("Name", "No name defined");//"No name defined" is the default value.
                    String age=prefs.getString("Age","No no defined"); //0 is the default value.
                    String phn=prefs.getString("Phone","No Age defined"); //0 is the default value.
                    String cty=prefs.getString("City","No City defined"); //0 is the default value.
                    System.out.println("name"+name+"Age"+age+"phone"+phn+"City"+cty);
                    Toast.makeText(MainActivity.this,"name"+name+"Age"+age+"phone"+phn+"City"+cty,Toast.LENGTH_LONG).show();


            }
        });
    }

}