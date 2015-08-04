package fr.boniespadon.dexter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity {
    TextView name;
    ImageView img;
    TextView descriptions;
    Button retour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        Pokemon pkmn = (Pokemon) i.getParcelableExtra("selectedPokemon");
        img = (ImageView) findViewById(R.id.imgPokeman);
        name =  (TextView) findViewById(R.id.namePokeman);
        descriptions = (TextView) findViewById(R.id.DesPokeman);
        int id = getResources().getIdentifier(pkmn.getImageName(), "mipmap", getPackageName());
        img.setImageResource(id);
        name.setText(pkmn.getName());
        descriptions.setText(pkmn.getDescription());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
