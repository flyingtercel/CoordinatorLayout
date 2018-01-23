package us.mifeng.coordinatorlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;

    /**
     * coordinatorLayout
     * http://blog.csdn.net/xyz_lmn/article/details/48055919
     * SnackBar
     * http://blog.csdn.net/snow_lu/article/details/51385072
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab1:
                startActivity(new Intent(this,Coordinator01.class));
                break;
            case R.id.fab2:
                startActivity(new Intent(this,Coordinator02.class));
                break;
            case R.id.fab3:
                startActivity(new Intent(this,Coordinator03.class));
                break;
        }
    }
}
