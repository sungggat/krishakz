package com.example.sunggataiymbay.krishakz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.List;

public class CityActivity extends AppCompatActivity {

    //hi

    private static final String TAG = "CityActivity";
    private ListView listView;
    private List<City> cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        listView = findViewById(R.id.listView);

        Backendless.initApp(this, Konst.API_ID, Konst.ANDROID_KEY);
        downloadCitites();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openCity(i);
            }
        });
    }

    private void openCity(int i) {
        Intent intent = new Intent(this,ApartmentActivity.class);
        intent.putExtra("city_id",cities.get(i).getObjectId());
        startActivity(intent);

    }

    private void downloadCitites() {
        Backendless.Persistence.of(City.class).find(new AsyncCallback<List<City>>() {
            @Override
            public void handleResponse(List<City> response) {
                displayCity(response);
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });


    }

    private void displayCity(List<City> response) {
        this.cities = response;
        CityAdapter adapter = new CityAdapter(this, response);
        listView.setAdapter(adapter);
    }
}
