package com.example.android.group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VehiclesActivity extends AppCompatActivity {


    private List<Vehicle> vehiclesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;


    RequestQueue rq;
    private static final String URL_VEHICLES = "http://shikwa.herokuapp.com/api/traffic";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);



        rq = Volley.newRequestQueue(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        vehiclesList = new ArrayList<>();


        prepareWorkoutData();
    }

    private void prepareWorkoutData() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_VEHICLES, null, new Response.Listener<JSONArray>() {
            @Override
                    public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {

                    //getting product object from json array
                    Vehicle vehicle = new Vehicle();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);


                        vehicle.setOffence(jsonObject.getString("offence"));
                        vehicle.setType(jsonObject.getString("type"));
                        vehicle.setRule(jsonObject.getString("rule"));
                        vehicle.setFine(jsonObject.getInt("fine"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    vehiclesList.add(vehicle);
                }
                mAdapter = new VehicleAdapter(VehiclesActivity.this, vehiclesList);
                recyclerView.setAdapter(mAdapter);
            }
                },
                new Response.ErrorListener() {

                    public void onErrorResponse(VolleyError error) {
                    Log.i("Volley Error: ","error");
                }

                });

        //adding our stringrequest to queue
        rq.add(jsonArrayRequest);
    }
}

