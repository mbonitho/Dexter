package fr.boniespadon.dexter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mathieu on 05/08/2015.
 *
 * MB : Activité de recherche de Pokémon
 */
public class SearchActivity
        extends Activity {

    private SqliteController controller;
    private LinearLayout svChildLayout;
    private ScrollView svResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //MB : Initialisation du contrôleur SQL
        controller = new SqliteController(this);

        //MB : Récupération de la scrollview destinée à afficher les résultats de la recherche
        svResult = (ScrollView) findViewById(R.id.svSearchResults);
        //Création et ajout d'un linearlayout à cette scrollview
        svChildLayout = new LinearLayout(this);
        svChildLayout.setOrientation(LinearLayout.VERTICAL);
        svResult.addView(svChildLayout);

        //MB : Récupération de l'EditText dans lequel le nom du pokémon à chercher
        final EditText tbNameSearched = (EditText)findViewById(R.id.tbNameSearched);
        //MB : Ajout d'un listener à l'editText pour rechercher les Pokemon
        tbNameSearched.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable e) {

                //MB : Récupération de la saisie de l'utilisateur
                String nameSearched = tbNameSearched.getText().toString();

                //MB : Appel au contrôleur SQL pour récupérer les Pokémon
                // dont le nom contient ce qui a été saisi
                ArrayList<Pokemon> pkmnsFound = controller.getPokemons(nameSearched);

                //MB : Récumpération de la TextView qui indique
                TextView tvNbResults = (TextView) findViewById(R.id.tvNbFound);
                tvNbResults.setText(pkmnsFound.size() + " Pokémon trouvés.");

                //MB : On vide le layout qui contiens les résultats
                // au cas où il contenait de précédents résultats
                svChildLayout.removeAllViews();

                //MB : Parcours des Pokémon trouvés et affichage dans une TextView
                for (final Pokemon pkmn : pkmnsFound)
                {
                    TextView tvPkmnName = new TextView(SearchActivity.this.getApplicationContext());
                    tvPkmnName.setTextSize(24);
                    tvPkmnName.setText(pkmn.getName());

                    //MB : une fois la vue affichée, ajout d'un onClickListener dessus qui appelle l'activité Détail
                    tvPkmnName.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(view.getContext(), DetailActivity.class);

                            //MB : Passage du Pokémon cliqué dans l'intent
                            intent.putExtra("selectedPokemonId", pkmn.getId());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            view.getContext().startActivity(intent);
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                        }
                    });

                    svChildLayout.addView(tvPkmnName);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Crée le menu
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
