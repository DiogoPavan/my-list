package mylist.projeto.com.mylist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mylist.projeto.com.mylist.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void entrar(View v) {
        EditText edtLogin = (EditText) findViewById(R.id.edtLogin);
        EditText edtSenha = (EditText) findViewById(R.id.edtSenha);

        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();

        validar(login, senha);
    }

    private void validar(String login, String senha) {
        if (login.equals("diogo") && senha.equals("123")) {
            Intent intent = new Intent(this, MainActivity.class);
            toastLoginMessage();
            startActivity(intent);
        } else {
            toastMessageError();
        }
    }

    private void toastLoginMessage() {
        Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
    }

    private void toastMessageError() {
        Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
    }
}
