package fr.boniespadon.dexter;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends ActionBarActivity {

    private boolean showOnlyFavorites = false;
    private Menu menu;
    private SqliteController controller = new SqliteController(this);

    private LinearLayout svChildLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //hack : suppression a chaque fois de la bdd
        //deleteDatabase("androidsqlite.db");
    }

    private void generatePkmnList() {

        //On récupère le scrollview et onlui ajoute un linearlayout
        HorizontalScrollView sv = (HorizontalScrollView)findViewById(R.id.svPokemons);
        svChildLayout = new LinearLayout(this);
        svChildLayout.setOrientation(LinearLayout.HORIZONTAL);

        //Marges entre les differents elements
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 0, 0, 0);

        sv.removeAllViews();

        //Ajout du linear layout au scrollview
        sv.addView(svChildLayout);

        ArrayList<Pokemon> pokemons;

        if (showOnlyFavorites)
            pokemons =  controller.getFavouritePokemons();
        else
            pokemons =  controller.getAllPokemons();


        if(pokemons.size()!= 0) {

            Log.v("dexter", Integer.toString(pokemons.size()) + " trouves");

            for (final Pokemon pkmn : pokemons)
            {
                //Log.v("dexter", pkmn.toString());

                //recuperation de l'id de la ressource
                int id = getResources().getIdentifier(pkmn.getImageName(), "mipmap", getPackageName());
                //Log.v("dexter", "Identifiant pour " + pkmn.getName() + " : " + Integer.toString(id));
                //Affectation de la bonne image a l'imageview
                ImageView imgv = new ImageView(this);
                imgv.setImageResource(id);
                imgv.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), DetailActivity.class);

                        //Envoi du pokemon selectionne a l'intent detail
                        intent.putExtra("selectedPokemonId", pkmn.getId());
                        view.getContext().startActivity(intent);
                    }
                });

                //Ajout de l'image et du nom du pokemon a un linear layout vertical
                LinearLayout llPkmn = new LinearLayout(this);
                llPkmn.setOrientation(LinearLayout.VERTICAL);
                llPkmn.setLayoutParams(new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                llPkmn.addView(imgv);
                TextView tvPkmnName = new TextView(this);
                tvPkmnName.setTextSize(20);
                tvPkmnName.setText(pkmn.getName());
                tvPkmnName.setGravity(View.TEXT_ALIGNMENT_CENTER);
                llPkmn.addView(tvPkmnName);


                //Ajout du linearLayout au childLayout du scrollview
                svChildLayout.addView(llPkmn);
            }

        }
    }

    @Override
    public void onResume() {
        super.onResume();

        generatePkmnList();

        //Affichage de la bonne option sur le menu (afficher tous/ afficher favoris)
        if (this.menu != null)
        {
            MenuItem showItem = this.menu.findItem(R.id.action_show);
            if (showOnlyFavorites)
                showItem.setTitle(getResources().getString(R.string.action_show_all));
            else
                showItem.setTitle(getResources().getString(R.string.action_show_favourites));
        }

        this.invalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //récupère l'instance du menu
        this.menu = menu;

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.action_random:
                Intent intent_detail = new Intent(this, DetailActivity.class);
                int randId = (new Random()).nextInt(150) + 1;
                intent_detail.putExtra("selectedPokemonId", randId);
                this.startActivity(intent_detail);
                return true;

            case R.id.action_show:
                showOnlyFavorites = !showOnlyFavorites;
                generatePkmnList();
                return true;

            case R.id.action_search:
                Intent intent_search = new Intent(this, SearchActivity.class);
                this.startActivity(intent_search);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
