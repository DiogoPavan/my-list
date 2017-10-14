package mylist.projeto.com.mylist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import mylist.projeto.com.mylist.R;
import mylist.projeto.com.mylist.adapter.CategoriasAdapter;

public class NovaListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public ListView categoria;

    public static final ArrayList<String> CATEGORIAS = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_lista);

        android.app.ActionBar actionBar = getActionBar();

        recebeDados();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CATEGORIAS);

        CategoriasAdapter adapter2 = new CategoriasAdapter(this, CATEGORIAS);

        categoria = (ListView) findViewById(R.id.lvCategoria);
        categoria.setAdapter(adapter);
        categoria.setOnItemClickListener(this);
    }

    public void recebeDados(){
        Bundle args = getIntent().getExtras();

        if (args != null) {
            String nomeCategoria = args.getString("nomeCategoria");

            if (nomeCategoria != null){
                CATEGORIAS.add(nomeCategoria);
            }
        }
    }

    public void toAdicionarCategoria(View v) {

        Intent intent = new Intent(this, CategoriaActivity.class);
        startActivity(intent);
    }

    public void criarLista (View v){
        EditText edtNomeNovaLista = (EditText) findViewById(R.id.edtNomeNovaLista);
        String nomeNovaLista = edtNomeNovaLista.getText().toString();

            Intent intent = new Intent(this, MainActivity.class);
            Bundle parametros = new Bundle();
            parametros.putString("nomeNovaLista", nomeNovaLista);

        if (!parametros.getString("nomeNovaLista").equals("")) {
            intent.putExtras(parametros);
            startActivity(intent);
            finish();
        } else {
            toastNomeNovaListaEmpty();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String s = (String) adapterView.getAdapter().getItem(i);
        Toast.makeText(this, "Texto selecionado: " + s + "posicao: " + i,
                Toast.LENGTH_SHORT).show();
    }

    private void toastNomeNovaListaEmpty() {
        Toast.makeText(this, "Nome da lista está vazio", Toast.LENGTH_SHORT).show();
    }
}
