package com.example.cs403cw2;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ScaleGestureDetector mScaleDetector;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScaleDetector = new ScaleGestureDetector(getApplicationContext(), new ScaleListener());
        text = findViewById(R.id.txtChange);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Let the ScaleGestureDetector inspect all events.
        mScaleDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener
            extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Log.i("scaling",""+detector.getScaleFactor());
            if (detector.getScaleFactor() < 1) {
                text.setText("Zoomed out");
            } else if (detector.getScaleFactor() > 1) {
                text.setText("Zoomed in");
            }

            return true;
        }
        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            text.setText("Hello World!");
            return;
        }
    }

}
