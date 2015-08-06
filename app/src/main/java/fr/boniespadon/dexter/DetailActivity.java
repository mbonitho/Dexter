package fr.boniespadon.dexter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.Locale;

/**
 * Created by Mathieu on 03/08/2015.
 *
 * MB : Activité permettant d'afficher le nom, l'image et le texte résumé d'un Pokémon
 */
public class DetailActivity
        extends Activity
        implements OnInitListener {

    private int DATA_CHECKING = 0;
    private TextToSpeech myTTS;

    private TextView tvPokemonName;
    private ImageView imgvPokemonImage;
    private ImageView imgvFavImage;
    private TextView tvDescriptionPokemon;

    private Pokemon selectedPokemon;

    private SqliteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //MB : Initialisation du contrôleur SQL
        controller = new SqliteController(this);

        //YL : Récupération du Pokémon qui avait été sélectionné à partir de son Id
        Intent i = getIntent();
        int pId = i.getIntExtra("selectedPokemonId", 1);
        selectedPokemon = controller.getPokemon(pId);

        //YL : Récupération des vues de la page pour les peupler avec les infos des Pokémon
        imgvPokemonImage = (ImageView) findViewById(R.id.imgPokemon);
        imgvFavImage = (ImageView) findViewById(R.id.imgFavourite);
        tvPokemonName =  (TextView) findViewById(R.id.namePokemon);
        tvDescriptionPokemon = (TextView) findViewById(R.id.DescPokemon);

        //MB : Suivant que le Pokémon soit favori ou non, affiche d'une étoile jaune ou grise
        if (selectedPokemon.isFavourite())
            imgvFavImage.setImageResource(R.mipmap.fav);
        else
            imgvFavImage.setImageResource(R.mipmap.fav2);

        //MB : Ajout d'une action de clic sur l'image
        imgvFavImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //MB : Inversion du statut favori du Pokémon et enregistrement en base de données
                selectedPokemon.setIsFavourite(!selectedPokemon.isFavourite());
                controller.updatePokemon(selectedPokemon);

                //MB : Affichage de l'étoile jaune si le Pokémon est favori, grise sinon
                if (selectedPokemon.isFavourite())
                    imgvFavImage.setImageResource(R.mipmap.fav);
                else
                    imgvFavImage.setImageResource(R.mipmap.fav2);
            }
        });

        //YL : Remplissage des vues avec les informations du Pokémon sélectionné
        int pokemonImageId = getResources().getIdentifier(selectedPokemon.getImageName(), "mipmap", getPackageName());
        imgvPokemonImage.setImageResource(pokemonImageId);
        tvPokemonName.setText(selectedPokemon.getName());
        tvDescriptionPokemon.setText(selectedPokemon.getDescription());

        //MB : Création d'une Intent pour le TextToSpeech
        Intent checkData = new Intent();
        checkData.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkData, DATA_CHECKING);
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

    @Override
    public void onInit(int status) {
        //MB : Si l'appareil le permet, on passe en TTS en français
        if (status == TextToSpeech.SUCCESS) {
            myTTS.setLanguage(Locale.FRENCH);

            //MB : Utilisation de la methode depreciee pour rester compatible avec l'api 17 d'Android
            myTTS.speak(selectedPokemon.getDescription(), TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onPause()
    {
        //MB : Dès lors que l'activité quitte l'écran, on "coupe la parole" du TTS
        super.onPause();
        if (myTTS != null)
            myTTS.shutdown();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Vérification de la disponibilité d'un TextToSpeech sur le device
        if (requestCode == DATA_CHECKING) {

            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS)
                //MB : Si les data sont trouvées, on instancie le TextToSpeech
                myTTS = new TextToSpeech(this, this);

            else {
                //MB : Si aucune data n'est trouvée, on propose de l'installer
                Intent promptInstall = new Intent();
                promptInstall.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(promptInstall);
            }
        }
    }
}
