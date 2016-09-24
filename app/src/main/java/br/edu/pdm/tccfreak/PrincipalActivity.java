package br.edu.pdm.tccfreak;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabFrequencia);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(PrincipalActivity.this,"Você Selecionou a Frequencia",Toast.LENGTH_SHORT);
                toast.show();
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        String usuario = getIntent().getStringExtra("usuario");
        //Snackbar.make(navigationView, "Seja bem vindo " + usuario,
          //      Snackbar.LENGTH_LONG)
         //       .show();
        TextView txtusuario = (TextView)navigationView.getHeaderView(0).findViewById(R.id.txtusuario);
        TextView txtemail = (TextView)navigationView.getHeaderView(0).findViewById(R.id.textEmail);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mnConfiguracoes) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mnAluno) {
            Toast toast = Toast.makeText(PrincipalActivity.this,"Você Selecionou o menu aluno!",Toast.LENGTH_SHORT);
            toast.show();
            // Handle the camera action
        } else if (id == R.id.mntrabalho) {
            Toast toast = Toast.makeText(PrincipalActivity.this,"Você Selecionou o menu Trabalho!",Toast.LENGTH_SHORT);
            toast.show();

        } else if (id == R.id.mnSobre) {
            Toast toast = Toast.makeText(PrincipalActivity.this,"Você Selecionou o menu Sobre!",Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.mnsair) {
            Toast toast = Toast.makeText(PrincipalActivity.this,"Você Selecionou o menu Sair!",Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.mnSincronizar) {
            Toast toast = Toast.makeText(PrincipalActivity.this,"Você Selecionou o menu Sincronizar'!",Toast.LENGTH_SHORT);
            toast.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
