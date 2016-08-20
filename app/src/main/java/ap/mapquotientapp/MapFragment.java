package ap.mapquotientapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MapFragment extends Fragment {

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_map, container, false);
        textView = (TextView) v.findViewById(R.id.textView);
        View tv = v.findViewById(R.id.touchView);
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                textView.setText(" Coords x,y => "+ motionEvent.getX() + ", " + motionEvent.getY());
                return true;
            }
        });
        v.post(new Runnable() {
            @Override
            public void run() {
                v.getHeight(); //height is ready
                textView.setText(" Coords width,height => "+ v.getWidth() + ", " + v.getHeight());
            }
        });

        return v;
    }
    TextView textView;
    
}
