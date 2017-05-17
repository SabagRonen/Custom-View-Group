package com.example.ronensabag.customviewgroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layouts_container = (LinearLayout) findViewById(R.id.layouts_container);
        setChildViewName(layouts_container, 4, R.string.long_name);
        setChildViewName(layouts_container, 7, R.string.short_name);
        setChildViewName(layouts_container, 10, R.string.long_name);
        setChildViewName(layouts_container, 13, R.string.long_name);
        setChildViewName(layouts_container, 16, R.string.long_name);
        setChildViewName(layouts_container, 19, R.string.long_name);
    }

    private void setChildViewName(LinearLayout layouts_container, int index, int stringResourceId) {
        TextView linearWithSpaceName = (TextView) layouts_container.getChildAt(index).findViewById(R.id.name);
        linearWithSpaceName.setText(stringResourceId);
    }
}
