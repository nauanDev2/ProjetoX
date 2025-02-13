package br.com.etecia.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText txtEmail, txtSenha;
    TextView lblEsqueceuSenha;
    MaterialButton btnEntrar, btnCadastreSe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        lblEsqueceuSenha = findViewById(R.id.lblEsqueceuSenha);
        btnCadastreSe = findViewById(R.id.btnCadastraSe);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, senha;
                email = txtEmail.getText().toString();
                senha = txtSenha.getText().toString();

                if(email.equals("eteccia@eteccia.com.br") && senha.equals("etecia")){
                    startActivity(new Intent(getApplicationContext(),MenuPrincipalActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Email ou senha inválidos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}