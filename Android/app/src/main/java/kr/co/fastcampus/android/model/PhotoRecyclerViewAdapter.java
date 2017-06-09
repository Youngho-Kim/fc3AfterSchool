package kr.co.fastcampus.android.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by DoDo on 2017-05-31.
 */

public class PhotoRecyclerViewAdapter extends RecyclerView.Adapter<PhotoRecyclerViewAdapter.ViewHolder> {

    ArrayList<Photo> data;


    public PhotoRecyclerViewAdapter(ArrayList<Photo> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Photo photo = getItem(position);
        holder.thumnailView.setImageURI(photo.photoUri);
        holder.delteable.setChecked(photo.deletable);
        holder.delteable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                photo.deletable = isChecked;
            }
        });
//        holder.delteable.addTextChangedListener();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Photo getItem(int position){
       return data.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView thumnailView;
        CheckBox delteable;
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
