package mylist.projeto.com.mylist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import mylist.projeto.com.mylist.R;
import mylist.projeto.com.mylist.adapter.ListasAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;

    public static final ArrayList<String> LISTAS = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        android.app.ActionBar actionBar = getActionBar();

        recebeDados();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LISTAS);

        lista = (ListView) findViewById(R.id.lvListas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NovaListaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void recebeDados(){
        Bundle args = getIntent().getExtras();

        if (args != null) {
            String nomeNovaLista = args.getString("nomeNovaLista");
            if (nomeNovaLista != null){
                LISTAS.add(nomeNovaLista);
            }
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
}
