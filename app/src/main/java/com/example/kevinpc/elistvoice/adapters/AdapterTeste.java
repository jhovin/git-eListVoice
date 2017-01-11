package com.example.kevinpc.elistvoice.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevinpc.elistvoice.ListActivity;
import com.example.kevinpc.elistvoice.R;
import com.example.kevinpc.elistvoice.banco.BeanElist;

import java.util.List;

/**
 * Created by kevinPC on 14/07/2016.
 */
public class AdapterTeste extends ArrayAdapter<BeanElist> {
    private ListActivity mList;
    private int resource = 0;
    private LayoutInflater inflater;
    ViewHolder viewHolder;
    private Context context;
    private List<BeanElist> lstBeanElists;
    private int contador = 5;

    public AdapterTeste(Context context, int resource, List<BeanElist> lstBeanElists) {
        super(context, 0, lstBeanElists);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            view = inflater.inflate(resource, parent, false);
            viewHolder.txt_item = (TextView) view.findViewById(R.id.txt_item_list);
            viewHolder.txt_num = (TextView) view.findViewById(R.id.txt_num_item);

            view.setTag(viewHolder);
            convertView = view;

        } else {

            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }


        BeanElist bean = getItem(position);
        viewHolder.txt_item.setText(bean.getNome());
        viewHolder.txt_num.setText(bean.getNumeroItens());
        //viewHolder.txt_num.setText(bean.getTelefone());

        return view;
    }

    static class ViewHolder {
        TextView txt_item;
        TextView txt_num;

    }
   // public BeanElist getItem(int position){return lstBeanElists.get(position);}
}
