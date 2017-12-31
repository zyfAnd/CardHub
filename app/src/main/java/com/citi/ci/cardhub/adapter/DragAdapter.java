package com.citi.ci.cardhub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.shake.DragGridListener;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author zhangyanfu
 *
 */
public class DragAdapter extends BaseAdapter implements DragGridListener {
	private List<HashMap<String, Object>> list;
	private LayoutInflater mInflater;
	private int mHidePosition = -1;
	
	public DragAdapter(Context context, List<HashMap<String, Object>> list){
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 由于复用convertView导致某些item消失了，所以这里不复用item，
	 */
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(R.layout.grid_item, null);
		ImageView mImageView = (ImageView) convertView.findViewById(R.id.item_image);
		TextView mTextView = (TextView) convertView.findViewById(R.id.item_text);
		final ImageView chooseImage = (ImageView) convertView.findViewById(R.id.select_choose);
		
		mImageView.setImageResource((Integer) list.get(position).get("item_image"));
		mTextView.setText((CharSequence) list.get(position).get("item_text"));
//		chooseImage.setImageResource((Integer) list.get(position).get("choose_image"));
		if(position!=7){
			mImageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					chooseImage.setEnabled(false);
				}
			});
		}

		if(position == mHidePosition){
			convertView.setVisibility(View.INVISIBLE);
		}
		
		return convertView;
	}
	

	@Override
	public void reorderItems(int oldPosition, int newPosition) {
		HashMap<String, Object> temp = list.get(oldPosition);
		if(oldPosition < newPosition){
			for(int i=oldPosition; i<newPosition; i++){
				Collections.swap(list, i, i+1);
			}
		}else if(oldPosition > newPosition){
			for(int i=oldPosition; i>newPosition; i--){
				Collections.swap(list, i, i-1);
			}
		}
		
		list.set(newPosition, temp);
	}

	@Override
	public void setHideItem(int hidePosition) {
		this.mHidePosition = hidePosition; 
		notifyDataSetChanged();
	}

	@Override
	public void removeItem(int deletePosition) {
		
		list.remove(deletePosition);
		notifyDataSetChanged();
	}


}
