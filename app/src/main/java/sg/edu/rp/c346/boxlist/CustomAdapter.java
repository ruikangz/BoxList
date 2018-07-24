package sg.edu.rp.c346.boxlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<BoxListItem> boxlist;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<BoxListItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        boxlist = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        ImageView ivBlue = rowView.findViewById(R.id.imageViewBlue);

        BoxListItem currentItem = boxlist.get(position);
        if (currentItem.isBlue()) {
            ivBlue.setImageResource(R.drawable.blue_box);
        } else if (currentItem.isOrange()) {
            ivBlue.setImageResource(R.drawable.orange_box);
        } else {
            ivBlue.setImageResource(R.drawable.brown_box);
        }

        return rowView;
    }
}