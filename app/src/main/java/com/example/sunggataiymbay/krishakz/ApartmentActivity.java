package com.example.sunggataiymbay.krishakz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class ApartmentActivity extends AppCompatActivity {

    private static final String TAG = "ApartmentActivity";
    private String cityId;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        listView = findViewById(R.id.listView);

        cityId = getIntent().getExtras().getString("city_id");
        downloadApartments(cityId);
    }

    private void downloadApartments(String cityId) {
        String whereClause = "city.objectId = " + "'" + cityId + "'";

       // BackendlessDataQuery query = new BackendlessDataQuery();
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause(whereClause);

        Backendless.Persistence.of(Apartment.class).find(queryBuilder, new AsyncCallback<List<Apartment>>() {
            @Override
            public void handleResponse(List<Apartment> response) {
                displayApartments(response);
                Log.d(TAG,response.get(2).getTitle());
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }

    private void displayApartments(List<Apartment> response) {
        ApartmentAdapter adapter = new ApartmentAdapter(this,response);
        listView.setAdapter(adapter);
    }
}
