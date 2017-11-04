package com.example.nbacademy.pedrocrespoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.nbacademy.pedrocrespoapp.persistence.DbManager;

public class SearchPlayer extends AppCompatActivity {

    private EditText searchPlayer;
    private ArrayAdapter<String> listPlayers;
    private Button insertPlayer;
    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_player);

        dbManager = new DbManager(getApplicationContext());

        searchPlayer = (EditText) findViewById(R.id.searchPlayer);
        ListView itemList = (ListView) findViewById(R.id.listPlayers);

        dbManager.insertPlayer(new Player(1, "Fofo", "Field Player", 69, "bbbbb", "nnnnnn", "qqqqqq", true));

        /*List<Player> lPlayer = dbManager.getTeam();
        List<String> lPlayerString = new ArrayList<>();

        for(Player player : lPlayer){
            lPlayerString.add(player.toString());
        }

        listPlayers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, lPlayerString);
        itemList.setAdapter(listPlayers);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/

        searchPlayer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SearchPlayer.this.listPlayers.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        insertPlayer = (Button) findViewById(R.id.insertPlayer);
        insertPlayer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent in = new Intent(SearchPlayer.this, InsertPlayer.class);
                startActivity(in);
            }
        });
    }
}
