package mylist.projeto.com.mylist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import mylist.projeto.com.mylist.R;

/**
 * Created by Usuario on 05/10/2017.
 */
public class ListasAdapter extends BaseAdapter {

    private String[] listas = new String[]{
            "Lista 1 - Festa de Aniversário",
            "Almoço de domingo",
            "Festa da Robertinha",
            "Almoço de domingo"
    };

    private Context context;

    public ListasAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return listas.length;
    }

    @Override
    public Object getItem(int i) {
        return listas[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        String lista = listas[i];
        View view = LayoutInflater.from(context).inflate(R.layout.listas, viewGroup, false);
        TextView txtListas = (TextView) view.findViewById(R.id.txt_listas);
        txtListas.setText(lista);

        return view;
    }
}
