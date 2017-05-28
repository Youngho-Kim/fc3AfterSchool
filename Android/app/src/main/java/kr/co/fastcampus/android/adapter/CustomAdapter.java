package kr.co.fastcampus.android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import kr.co.fastcampus.android.adapter.Data;
/*
  Adapter는 필요로 하는 형식이 아닌 무언가를 필요로 되는 형식으로 바꿔주는 일을 합니다.
  220V에 110V를 끼기 위해 사용되는 '어뎁터를 떠올리시면 됩니다.'
*/

public class CustomAdapter extends BaseAdapter {

    List<Data> mDatas;
    LayoutInflater mInflater;

    public CustomAdapter(List<Data> datas, LayoutInflater inflater) {
      mDatas = datas;
      mInflater = inflater;
    }
    /*
    getCount(): 리스트에 표시될 아이템의 개수를 반환합니다.
    return 값으로 개수를 넣어주시면 됩니다.
    */
    @Override
    public int getCount() {
        return 0;// <- 여기에
    }
    /*
    getItem(): 리스트의 각 position에 해당하는 데이터 객체를 반환합니다.
    */
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}
