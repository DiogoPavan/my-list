package mylist.projeto.com.mylist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import mylist.projeto.com.mylist.R;
import mylist.projeto.com.mylist.adapter.CategoriasAdapter;

public class CategoriaActivity extends AppCompatActivity {

    private String[] categorias = new String[] {
            "Frios e Laticínios", "Açougue", "Higiene",
            "Bebidas", "Padaria", "Mercearia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        final Spinner comboCategorias = (Spinner) findViewById(R.id.comboCategorias);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categorias);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboCategorias.setAdapter(adapter);
    }

    public void salvarCategoria(View v) {
        Spinner spinner = (Spinner) findViewById(R.id.comboCategorias);
        String nomeCategoria = spinner.getSelectedItem().toString();

        Intent intent = new Intent(this, NovaListaActivity.class);
        Bundle parametros = new Bundle();

        parametros.putString("nomeCategoria", nomeCategoria);

        intent.putExtras(parametros);
        startActivity(intent);
        finish();
    }
}
