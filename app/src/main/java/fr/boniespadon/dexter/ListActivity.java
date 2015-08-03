package fr.boniespadon.dexter;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;


public class ListActivity extends ActionBarActivity {

    SqliteController controller = new SqliteController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //hack : suppression a chaque fois de la bdd
        deleteDatabase("androidsqlite.db");

        HorizontalScrollView sv = (HorizontalScrollView)findViewById(R.id.svPokemons);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        //Marges entre les differents elements
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 0, 0, 0);

        //Ajout du linear layout au scrollview
        sv.addView(ll);

        ArrayList<Pokemon> pokemons =  controller.getAllPokemons();
        if(pokemons.size()!= 0) {

            Log.v("dexter", Integer.toString(pokemons.size()) + " trouves");

            //todo affiche images
            for (Pokemon pkmn : pokemons)
            {
                Log.v("dexter", pkmn.toString());

                //recuperation de l'id de la ressource
                int id = getResources().getIdentifier(pkmn.getImageName(), "mipmap", getPackageName());
                Log.v("dexter", "Identifiant pour " + pkmn.getName() + " : " + Integer.toString(id));
                //Affectation de la bonne image a l'imageview
                ImageView imgv = new ImageView(this);
                imgv.setImageResource(id);

                //Ajout de l'image du pokemon au linear layout
                ll.addView(imgv);
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
