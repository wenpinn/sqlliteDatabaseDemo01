package tools.wpfang.sqllitedatabasedemo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView showDatabaseText;
    MyCoreDatabase db;
    EditText flowerName;
    EditText flowerColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flowerName=findViewById(R.id.flowername);
        flowerColor=findViewById(R.id.flowercolor);
        showDatabaseText=findViewById(R.id.databaseresult);
        db=new MyCoreDatabase(this);
    }

    public void doLoaddata(View view) {
        String result=db.getAllFlower();
        showDatabaseText.setText(result);
    }

    public void doSaveData(View view) {

        String v1=flowerName.getText().toString();
        String v2=flowerColor.getText().toString();
        db.insertFlowerData(v1,v2);
    }
}
