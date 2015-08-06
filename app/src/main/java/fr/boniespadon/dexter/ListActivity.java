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

/**
 * Created by Mathieu on 03/08/2015.
 *
 * MB : Activité permettant d'afficher la liste de tous les Pokémon, ou la liste des favoris
 * L'activité comprends également un menu permettant d'afficher un Pokémon au hasard,
 * Et une option de recherche par nom
 */
public class ListActivity extends ActionBarActivity {

    private boolean showOnlyFavorites = false;
    private Menu menu;
    private SqliteController controller = new SqliteController(this);
    private LinearLayout svChildLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //hack MB : suppression a chaque fois de la bdd (plus nécessaire a priori)
        //deleteDatabase("androidsqlite.db");
    }

    @Override
    public void onResume() {
        super.onResume();

        generatePkmnList();

        //MB : Affichage de la bonne option sur le menu (afficher tous/ afficher favoris)
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
        //MB : récupère l'instance du menu
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
                //MB : Clic sur l'action d'affichage d'un Pokémon aléatoire
                Intent intent_detail = new Intent(this, DetailActivity.class);

                //MB : Sélection aléatoire d'un ID de Pokémon à afficher
                int randId = (new Random()).nextInt(150) + 1;
                //MB : Transmission de l'id du Pokémon aléatoire à l'intent détail
                intent_detail.putExtra("selectedPokemonId", randId);
                this.startActivity(intent_detail);
                return true;

            case R.id.action_show:
                //MB : Clic sur l'action de toggle entre "Afficher tous/Afficher favoris"
                showOnlyFavorites = !showOnlyFavorites;
                //MB : Régénère la liste des Pokémons
                generatePkmnList();
                return true;

            case R.id.action_search:
                //MB : Clic sur l'action de recherche d'un Pokémon
                Intent intent_search = new Intent(this, SearchActivity.class);
                this.startActivity(intent_search);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void generatePkmnList() {

        //MB : On récupère le scrollview et on lui ajoute un linearlayout
        HorizontalScrollView sv = (HorizontalScrollView)findViewById(R.id.svPokemons);
        svChildLayout = new LinearLayout(this);
        svChildLayout.setOrientation(LinearLayout.HORIZONTAL);

        //MB : Marges entre les differents elements
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 0, 0, 0);

        //MB : Vidage de la lsite des Pokémons avant de la remplir à nouveau
        sv.removeAllViews();

        //MB : Ajout du linear layout au scrollview des Pokémons
        sv.addView(svChildLayout);

        //MB : Récupération de la bonne liste des Pokémons (complète ou filtrée sur les favoris)
        ArrayList<Pokemon> pokemons;
        if (showOnlyFavorites)
            pokemons =  controller.getFavouritePokemons();
        else
            pokemons =  controller.getAllPokemons();

        //MB : Parcours de la liste des Pokémons et affichage
        for (final Pokemon pkmn : pokemons)
        {
            //MB : Récupération de l'id de la ressource image du Pokémon à partir de son nom
            int id = getResources().getIdentifier(pkmn.getImageName(), "mipmap", getPackageName());

            //MB : Affectation de la bonne image a l'imageview
            ImageView imgv = new ImageView(this);
            imgv.setImageResource(id);

            //MB : Ajout de l'image et du nom du pokemon a un linear layout vertical
            LinearLayout llPkmn = new LinearLayout(this);
            llPkmn.setOrientation(LinearLayout.VERTICAL);
            llPkmn.setLayoutParams(new ActionBar.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            llPkmn.addView(imgv);

            //MB : Création d'un TextView destiné à afficher le nom du Pokémon
            TextView tvPkmnName = new TextView(this);
            tvPkmnName.setTextSize(20);
            tvPkmnName.setText(pkmn.getName());
            tvPkmnName.setGravity(View.TEXT_ALIGNMENT_CENTER);
            llPkmn.addView(tvPkmnName);

            //MB: Ajout d'un événement au clic sur l'image du Pokémon
            imgv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);

                    //MB : Envoi du pokemon selectionne a l'intent detail
                    intent.putExtra("selectedPokemonId", pkmn.getId());
                    view.getContext().startActivity(intent);
                }
            });

            //MB : Ajout du linearLayout au childLayout du scrollview
            svChildLayout.addView(llPkmn);
        }
    }
}
