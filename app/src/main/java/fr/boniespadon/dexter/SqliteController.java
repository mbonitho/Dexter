package fr.boniespadon.dexter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mathieu on 03/08/2015.
 */
public class SqliteController extends SQLiteOpenHelper {

    public SqliteController(Context applicationcontext) {
        super(applicationcontext, "androidsqlite.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creation de la table des pokemons
        String query;
        query = "CREATE TABLE pokemon ( id INTEGER PRIMARY KEY, name TEXT, description TEXT, imgName TEXT)";
        db.execSQL(query);
        Log.d("dexter", "Table Pokemon Creee dans la BDD");

        //Insertion des donnees
        db.execSQL("insert into pokemon (name, description, imgName) values ('Bulbizarre', 'desciption 1', 'pkmn_001')");
        db.execSQL("insert into pokemon (name, description, imgName) values ('Herbizarre', 'description 2', 'pkmn_002')");
        db.execSQL("insert into pokemon (name, description, imgName) values ('Florizarre', 'description 3', 'pkmn_003')");
        db.execSQL("insert into pokemon (name, description, imgName) values ('Carapuce', 'desciption 4', 'pkmn_004')");
        db.execSQL("insert into pokemon (name, description, imgName) values ('Carabaffe', 'description 5', 'pkmn_005')");
        db.execSQL("insert into pokemon (name, description, imgName) values ('Tortank', 'description 6', 'pkmn_006')");
        db.execSQL("insert into pokemon (name, description, imgName) values ('Salamèche', 'desciption 7', 'pkmn_007')");
        db.execSQL("insert into pokemon (name, description, imgName) values ('Reptincel', 'description 8', 'pkmn_008')");
        db.execSQL("insert into pokemon (name, description, imgName) values ('Dracaufeu', 'description 9', 'pkmn_009')");
    }

    public void insertPokemon(Pokemon pkmn) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", pkmn.getName());
        values.put("description", pkmn.getDescription());
        values.put("imgName", pkmn.getImageName());
        database.insert("pokemon", null, values);
        database.close();
    }

    public ArrayList<Pokemon> getAllPokemons() {

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

        String selectQuery = "SELECT  * FROM pokemon";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                String imgName = cursor.getString(3);
                pokemons.add(new Pokemon(id, name, description, imgName));
            } while (cursor.moveToNext());
        }

        // return contact list
        return pokemons;
    }

    public Pokemon getPokemon(int id) {

        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM pokemon where id='" + id + "'";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String imgName = cursor.getString(3);
            return new Pokemon(id, name, description, imgName);
        }

        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query = "DROP TABLE IF EXISTS pokemon";
        db.execSQL(query);
        onCreate(db);
    }
}
