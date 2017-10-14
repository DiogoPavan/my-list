package mylist.projeto.com.mylist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import mylist.projeto.com.mylist.R;

/**
 * Created by Usuario on 12/10/2017.
 */
public class CategoriasAdapter extends BaseAdapter {

    private static final String[] CATEGORIAS = new String[]{

    };

    private Context context;
    private ArrayList<String> categorias;

    public CategoriasAdapter(Context context, ArrayList<String> categorias) {
        super();
        this.context = context;
        this.categorias = categorias;
    }

    @Override
    public int getCount() {
        return CATEGORIAS.length;
    }

    @Override
    public Object getItem(int i) {
        return CATEGORIAS[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        String lista = CATEGORIAS[i];
        View view = LayoutInflater.from(context).inflate(R.layout.listas, viewGroup, false);
        TextView txtListas = (TextView) view.findViewById(R.id.txt_listas);
        txtListas.setText(lista);

        return view;
    }
}
