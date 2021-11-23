package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Numbr{
        int number;
        public boolean isSquare(){
            double squrt=Math.sqrt(number);
            if(squrt==Math.floor(squrt)){
                return true;
            }
            else{
                return false;
            }
        }
        public boolean isTriangular(){
            int x=1;
            int triangularnumber=1;
            while(triangularnumber<number){
                x++;
                triangularnumber=triangularnumber+x;

            }
            if (triangularnumber==number){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void testNumber(View view){
        Log.i("info","button clicked");
        EditText editText=(EditText)findViewById(R.id.editTextNumber);
        String message;
        if (editText.getText().toString().isEmpty()){
            message="Please enter a number";
        }
        else {
            Numbr mynumber = new Numbr();
            mynumber.number=Integer.parseInt(editText.getText().toString());
            message=editText.getText().toString();
            if (mynumber.isSquare()&&mynumber.isTriangular()){
                message+="is both triangular and square.";
            }
            else if (mynumber.isTriangular()){
                message+="is Triangular but not square.";
            }
            else if (mynumber.isSquare()){
                message+="is square but not triangular.";
            }
            else {
                message+="is neither square nor triangular";
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}