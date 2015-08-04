package fr.boniespadon.dexter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.Locale;

public class DetailActivity
        extends Activity
        implements OnInitListener {

    private int DATA_CHECKING = 0;

    private TextToSpeech myTTS;

    TextView name;
    ImageView img;
    TextView descriptions;

    private Pokemon selectedPokemon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        selectedPokemon = (Pokemon) i.getParcelableExtra("selectedPokemon");
        img = (ImageView) findViewById(R.id.imgPokeman);
        name =  (TextView) findViewById(R.id.namePokeman);
        descriptions = (TextView) findViewById(R.id.DesPokeman);
        int id = getResources().getIdentifier(selectedPokemon.getImageName(), "mipmap", getPackageName());
        img.setImageResource(id);
        name.setText(selectedPokemon.getName());
        descriptions.setText(selectedPokemon.getDescription());

        //create an Intent
        Intent checkData = new Intent();
        //set it up to check for tts data
        checkData.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        //start it so that it returns the result
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
        if (status == TextToSpeech.SUCCESS) {
            myTTS.setLanguage(Locale.FRENCH);

            //Utilisation de la methode depreciee pour rester compatible avec l'api 17 d'Android
            myTTS.speak(selectedPokemon.getDescription(), TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        myTTS.shutdown();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //do they have the data
        if (requestCode == DATA_CHECKING) {
            //yep - go ahead and instantiate
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS)
                myTTS = new TextToSpeech(this, this);
                //no data, prompt to install it
            else {
                Intent promptInstall = new Intent();
                promptInstall.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(promptInstall);
            }
        }
    }
}
