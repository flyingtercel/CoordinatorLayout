package us.mifeng.coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class Coordinator02 extends AppCompatActivity {

    private AppBarLayout appBarLayout;
    private TextView tView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        //tView = (TextView) findViewById(R.id.textView);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                Log.i("tag", "onOffsetChanged: "+appBarLayout.getHeight()+"  "+verticalOffset+"  " +toolbar.getHeight() );
               /* if (appBarLayout.getHeight()+verticalOffset == toolbar.getHeight()){
                    tView.setVisibility(View.VISIBLE);
                }else{
                    tView.setVisibility(View.GONE);
                }*/
            }
        });

    }
}
