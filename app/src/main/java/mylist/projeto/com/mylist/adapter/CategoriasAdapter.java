package mylist.projeto.com.mylist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import mylist.projeto.com.mylist.R;

/**
 * Created by Usuario on 12/10/2017.
 */
public class CategoriasAdapter extends BaseAdapter {

    private String[] categorias = new String[]{
            "Frios",
            "Legumes",
            "Carne",
            "Bebidas"
    };

    private Context context;

    public CategoriasAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return categorias.length;
    }

    @Override
    public Object getItem(int i) {
        return categorias[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        String lista = categorias[i];
        View view = LayoutInflater.from(context).inflate(R.layout.listas, viewGroup, false);
        TextView txtListas = (TextView) view.findViewById(R.id.txt_listas);
        txtListas.setText(lista);

        return view;
    }
}
