package kr.co.fastcampus.android.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.fastcampus.android.R;
import kr.co.fastcampus.android.adapter.Data;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(new ArrayList<Data>(),LayoutInflater.from(this)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Calendar calendar = Calendar.getInstance();
    }



}

class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>{

    List<Data> datas;
    LayoutInflater inflater;
    public CustomRecyclerViewAdapter(List<Data> datas, LayoutInflater inflater) {
        this.datas = datas;
        this.inflater = inflater;
    }

    // listView에서 convertView 가 null일 때에 해당하는 로직
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  inflater.inflate(R.layout.item_recyclerview, null);
        return new ViewHolder(view);
    }

    // listView에서 convertView 가 null이 아니어서 ViewHolder를 가지고 재활용할 때에 해당하는 로직
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txt1.setText(datas.get(position).toString());
        holder.txt1.setText(datas.get(position).toString());
        holder.txt1.setText(datas.get(position).toString());
        holder.txt1.setText(datas.get(position).toString());
        holder.txt1.setText(datas.get(position).toString());
    }
    @Override
    public int getItemCount() {
        return datas.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img1,img2;
        TextView txt1,txt2;
        public ViewHolder(View v) {
            super(v);
            img1 = (ImageView) v.findViewById(R.id.img1);
            img2 = (ImageView) v.findViewById(R.id.img2);
            txt1 = (TextView) v.findViewById(R.id.txt1);
            txt2 = (TextView) v.findViewById(R.id.txt2);
        }
    }

}
