package com.fyj.elinksdk.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/11/23
 * 邮箱: blq_ssnb@outlook.com
 * 修改次数: 1
 * 描述:
 * 添加描述
 * ================================================
 */
public abstract class BaseRecyclerAdapter<T,HV extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<HV> {
    public static final int ITEM_TYPE_NO = -1;
    public static final int ITEM_TYPE_ONE = 0;
    public static final int ITEM_TYPE_TWO = 1;
    public static final int ITEM_TYPE_THREE = 2;
    public static final int ITEM_TYPE_FOUR = 3;
    public static final int ITEM_TYPE_FIVE = 4;
    public static final int ITEM_TYPE_SIX = 5;
    public static final int ITEM_TYPE_SEVEN = 6;
    public static final int ITEM_TYPE_EIGHT = 7;
    public static final int ITEM_TYPE_NINE = 8;
    public static final int ITEM_TYPE_TEN = 9;

    private Context context;
    private List<T> mData;
    private OnItemClickListener itemClickListener;
    private OnItemLongClickListener itemLongClickListener;
    public interface OnItemClickListener{
        void onItemClickListener(View view, int position);
    }
    public interface OnItemLongClickListener{
        void onItemLongClickListener(View view, int position);
    }

    public BaseRecyclerAdapter(Context context){
        this(context,null);
    }

    public BaseRecyclerAdapter(Context context, List<T> data){
        this.context = context;
        this.mData = (data == null? new ArrayList<T>():data);
    }

    @Override
    public void onBindViewHolder(final HV holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener!=null){
                    itemClickListener.onItemClickListener(v,holder.getAdapterPosition());
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(itemLongClickListener!=null){
                    itemLongClickListener.onItemLongClickListener(v,holder.getAdapterPosition());
                    return true;
                }
                return false;
            }
        });
        mBindViewHolder(holder,position);
    }


    public abstract void mBindViewHolder(HV holder, int position);

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    public T getItemBean(int position){
        return mData.size()>position?mData.get(position):null;
    }

    public void addData(List<T> data){
        if(data!=null){
            this.mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addItemByIndex(int index ,T data){
        if(data!=null&&this.mData.size() >= index){
            this.mData.add(index,data);
        }
    }

    public void addItem(T data){
        if(data!=null){
            this.mData.add(data);
            notifyDataSetChanged();
        }
    }
    public void update(List<T> data){
        if(data!=null){
            this.mData.clear();
            this.mData.addAll(data);
        }else{
            this.mData = new ArrayList<>();
        }
        notifyDataSetChanged();
    }
    public T removeItemByIndex(int index){
        T removeData = null;
        if(mData!=null&&mData.size()>index){
            removeData = mData.remove(index);
            notifyItemRemoved(index);
            notifyItemRangeChanged(index,getItemCount());
        }
        return removeData;
    }

    public void removeAllItem(){
        if(mData!=null){
            mData.clear();
        }else{
            mData = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    public List<T> getData(){
        return mData;
    }

    protected Context getContext(){
        return context;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.itemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener){
        this.itemLongClickListener = listener;
    }
}
