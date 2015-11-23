package com.rongpencil.app.stories;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
    
    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        HashMap<String, String> story = new HashMap<String, String>();
        story = data.get(position);

        ((TextView)vi).setText(story.get(StoriesParser.TAG_Title));
        //TextView title = (TextView)vi.findViewById(R.id.title); // title
        //ImageView thumb_image = (ImageView)vi.findViewById(R.id.list_image); // thumb image

        // Setting all values in listview
        //title.setText(story.get(StoriesParser.TAG_Title));
        //imageLoader.DisplayImage(story.get(StoriesParser.TAG_PreviewImg), thumb_image);

        return vi;
    }
}