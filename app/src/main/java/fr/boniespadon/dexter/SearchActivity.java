package fr.boniespadon.dexter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;


public class SearchActivity
        extends ActionBarActivity {

    SqliteController controller;
    LinearLayout svChildLayout;
    ScrollView svResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        controller = new SqliteController(this);
        svResult = (ScrollView) findViewById(R.id.svSearchResults);
        svChildLayout = new LinearLayout(this);
        svChildLayout.setOrientation(LinearLayout.HORIZONTAL);
        //Ajout du linear layout au scrollview
        svResult.addView(svChildLayout);

        final EditText tbNameSearched = (EditText)findViewById(R.id.tbNameSearched);
        //Ajout d'un listener à l'editText pour rechercher les Pokemon
        tbNameSearched.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable e) {

                String nameSearched = tbNameSearched.getText().toString();

                ArrayList<Pokemon> pkmnsFound = controller.getPokemons(nameSearched);

                TextView tvNbResults = (TextView) findViewById(R.id.tvNbFound);
                tvNbResults.setText(pkmnsFound.size() + " Pokémon trouvés.");

                //On vide le layout qui contiens les résultats
                svChildLayout.removeAllViews();

                for (final Pokemon pkmn : pkmnsFound)
                {
                    TextView tvPkmnName = new TextView(SearchActivity.this.getApplicationContext());
                    tvPkmnName.setText(pkmn.getName());
                    svChildLayout.addView(tvPkmnName);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
}
