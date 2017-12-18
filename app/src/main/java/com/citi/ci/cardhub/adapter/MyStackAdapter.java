package com.citi.ci.cardhub.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citi.cardstack.CardStackView;
import com.citi.cardstack.StackAdapter;
import com.citi.ci.cardhub.R;
import com.lqm.roundview.RoundImageView;
import com.orhanobut.logger.Logger;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;


/**
 * zhangyanfu
 */
public class MyStackAdapter extends com.citi.cardstack.StackAdapter<Integer> {

    private OnItemClickListener onItemClickListener;
    public void setOnItemCilckListener(OnItemClickListener onItemCilckListener){
        this.onItemClickListener = onItemCilckListener;
    }

//    Logger log = Logger.getLogger("=====MyStackAdapter=======");

    public MyStackAdapter(Context context) {
        super(context);
    }

    @Override
    public void bindView(Integer data, final int position, CardStackView.ViewHolder holder) {
//        if (holder instanceof ColorItemLargeHeaderViewHolder) {
//            ColorItemLargeHeaderViewHolder h = (ColorItemLargeHeaderViewHolder) holder;
//            h.onBind(data, position);
//        }
//        if (holder instanceof ColorItemWithNoHeaderViewHolder) {
//            ColorItemWithNoHeaderViewHolder h = (ColorItemWithNoHeaderViewHolder) holder;
//            h.onBind(data, position);
//        }
        if (holder instanceof ColorItemViewHolder) {
            ColorItemViewHolder h = (ColorItemViewHolder) holder;
            h.onBind(data, position);
            Logger.e("position====="+position);
            if(onItemClickListener!=null){
                ((ColorItemViewHolder) holder).imageCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v,position);
                    }
                });
            }
        }
    }

    @Override
    protected CardStackView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view;
//        log.info("viweType--" + viewType);
//        switch (viewType) {
//            case R.layout.list_card_item_larger_header:
//                view = getLayoutInflater().inflate(R.layout.list_card_item_larger_header, parent, false);
//                return new ColorItemLargeHeaderViewHolder(view);
//            case R.layout.list_card_item_with_no_header:
//                view = getLayoutInflater().inflate(R.layout.list_card_item_with_no_header, parent, false);
//                return new ColorItemWithNoHeaderViewHolder(view);
//            default:
        view = getLayoutInflater().inflate(R.layout.list_card_item, parent, false);
        return new ColorItemViewHolder(view);
//        }
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 6) {//TODO TEST LARGER ITEM
//            return R.layout.list_card_item_larger_header;
//        } else if (position == 10) {
//            return R.layout.list_card_item_with_no_header;
//        } else {
        return R.layout.list_card_item;
//        }
    }

    class ColorItemViewHolder extends CardStackView.ViewHolder {
        View mLayout;
        View mContainerContent;
        TextView mTextTitle;
        ImageView imageCard;

        public ColorItemViewHolder(View view) {
            super(view);
//            mLayout = view.findViewById(R.id.frame_list_card_item);
//            mContainerContent = view.findViewById(R.id.container_list_content);

//            mTextTitle = (TextView) view.findViewById(R.id.text_list_card_title);
            imageCard = (ImageView) view.findViewById(R.id.show_card_image);
        }

        @Override
        public void onItemExpand(boolean b) {
            Logger.e(b+"--onItemExpand--");
//            mContainerContent.setVisibility(b ? View.VISIBLE : View.GONE);
        }


        public void onBind(Integer data, int position) {
//            mLayout.setBackgroundResource(data);
//            mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), data), PorterDuff.Mode.SRC_IN);
//            mTextTitle.setText(String.valueOf(position));
//            imageCard.setImageResource(imageData[position]);
            imageCard.setImageResource(data);

        }

    }

    @Override
    public Integer getItem(int position) {
//        Logger.e("position+"+position);
        return super.getItem(position);
    }
    //    static class ColorItemWithNoHeaderViewHolder extends CardStackView.ViewHolder {
//        View mLayout;
//        TextView mTextTitle;
//
//        public ColorItemWithNoHeaderViewHolder(View view) {
//            super(view);
//            mLayout = view.findViewById(R.id.frame_list_card_item);
////            mTextTitle = (TextView) view.findViewById(R.id.text_list_card_title);
//        }
//
//        @Override
//        public void onItemExpand(boolean b) {
//        }
//
//        public void onBind(Integer data, int position) {
//            mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), data), PorterDuff.Mode.SRC_IN);
////            mTextTitle.setText(String.valueOf(position));
//        }
//
//    }
//
//    static class ColorItemLargeHeaderViewHolder extends CardStackView.ViewHolder {
//        View mLayout;
//        View mContainerContent;
//        TextView mTextTitle;
//
//        public ColorItemLargeHeaderViewHolder(View view) {
//            super(view);
//            mLayout = view.findViewById(R.id.frame_list_card_item);
//            mContainerContent = view.findViewById(R.id.container_list_content);
////            mTextTitle = (TextView) view.findViewById(R.id.text_list_card_title);
//        }
//
//        @Override
//        public void onItemExpand(boolean b) {
//            mContainerContent.setVisibility(b ? View.VISIBLE : View.GONE);
//        }
//
//        @Override
//        protected void onAnimationStateChange(int state, boolean willBeSelect) {
//            super.onAnimationStateChange(state, willBeSelect);
//            if (state == CardStackView.ANIMATION_STATE_START && willBeSelect) {
//                onItemExpand(true);
//            }
//            if (state == CardStackView.ANIMATION_STATE_END && !willBeSelect) {
//                onItemExpand(false);
//            }
//        }
//
//        public void onBind(Integer data, int position) {
//
//            mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), data), PorterDuff.Mode.SRC_IN);
////            mTextTitle.setText(String.valueOf(position));
////
////            itemView.findViewById(R.id.text_view).setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    ((CardStackView) itemView.getParent()).performItemClick(ColorItemLargeHeaderViewHolder.this);
////                }
////            });
//        }
//
//    }

    public  interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
