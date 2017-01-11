package com.example.kevinpc.elistvoice.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kevinpc.elistvoice.R;
import com.example.kevinpc.elistvoice.banco.BeanElist;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by kevinPC on 23/06/2016.
 */
public class ListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;


    // private static CallbackManager callback;

   // public static void setCallback(CallbackManager callback) {
  //      ListItemAdapter.callback = callback;
  //  }

   // @Override
   // public void onItemSelected(int dialogId, int position) {

   // }

    public void setContext(Context context) {
        this.context = context;
    }

    public class ApplicationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.txt_item_list) TextView txt_item;
      //  @Bind(R.id.txt_num_item)  TextView txt_num;


        public ApplicationViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mItemClickListener != null && view.isEnabled()){
                mItemClickListener.onItemClick(view.getId(), getAdapterPosition());
            }
        }
    }

    private List<BeanElist> mLista;
    private AdapterItemClickListener mItemClickListener;

    public ListItemAdapter(List<BeanElist> lista){ mLista = lista;}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final int layout = R.layout.fragment_list_item;

        final View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        RecyclerView.ViewHolder holder = new ApplicationViewHolder(view);

        return holder;
    }

    public BeanElist getItem(int position){return mLista.get(position);}
    @Override
    public int getItemViewType(int position){return mLista.get(position).getId();}

    public void setItemClickListener(AdapterItemClickListener listener){mItemClickListener = listener;}

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        BeanElist beanElist = getItem(position);

        ApplicationViewHolder holder = (ApplicationViewHolder) viewHolder;

        //holder.txt_item.setText(beanElist.getNome());
        //holder.txt_num.setText(beanElist);

    }

    @Override
    public int getItemCount() {
       return mLista.size();
    }

    public void setData(List<BeanElist> beanElists) {
        mLista = beanElists;
        notifyDataSetChanged();
    }
}
