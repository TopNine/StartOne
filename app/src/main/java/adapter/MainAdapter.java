package adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import entry.HomePage;
import iface.IOnItemClickListener;
import refactor.flyme.com.refactorproject1.R;

/**
 * Created by msi on 2017/6/11.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private static final String TAG = "MainAdapter";
    public IOnItemClickListener mListener;
    private List<HomePage> mItems = new ArrayList();

    public MainAdapter(List<HomePage> items) {
        mItems.clear();
        mItems.addAll(items);
    }

    public void setItems(List<HomePage> items) {
        mItems.clear();
        Log.i(TAG, "setItems: " + items);
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void setOnClickListener(IOnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, null);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        HomePage homePage = mItems.get(position);
        Log.i(TAG, "onBindViewHolder: " + homePage);
        holder.mIcon.setImageResource(homePage.mIconRes);
        holder.mText.setText(homePage.mText);
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClickListener(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIcon;
        public TextView mText;
        public View mItemView;

        public MainViewHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.item_icon);
            mText = (TextView) itemView.findViewById(R.id.item_text);
            mItemView = itemView.findViewById(R.id.main_item_layout);
        }
    }
}
