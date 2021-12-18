package com.example.apirace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apirace.Adapter.RacesAdapter;
import com.example.apirace.Adapter.ResultsAdapter;
import com.example.apirace.Model.Race;
import com.example.apirace.Model.Result;
import com.example.apirace.Model.Root;
import com.example.apirace.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RacesAdapter racesAdapter;
    ResultsAdapter resultsAdapter;
//    RecyclerView idRecyclerview1, idRecyclerview2;
//    TextView series, limit, offset, total, season, round;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main);

//        idRecyclerview1 = (RecyclerView) findViewById(R.id.idRecyclerview1);
//        idRecyclerview2 = (RecyclerView) findViewById(R.id.idRecyclerview2);

//        series = (TextView) findViewById(R.id.series);
//        limit = (TextView) findViewById(R.id.limit);
//        offset = (TextView) findViewById(R.id.offset);
//        total = (TextView) findViewById(R.id.total);
//        season = (TextView) findViewById(R.id.season);
//        round = (TextView) findViewById(R.id.round);
        getContact();
    }

    private void getContact() {
        Call<Root> call = RetrofitClient.getInstance().getMyApi().getcontact();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Root root = new Root();
                root = response.body();

                List<Race> raceList = new ArrayList<>();
                raceList = root.getMRData().getRaceTable().getRaces();

                racesAdapter = new RacesAdapter(MainActivity.this, raceList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                binding.idRecyclerview1.setLayoutManager(layoutManager);
                binding.idRecyclerview1.setAdapter(racesAdapter);
                //LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                //idRecyclerview1.setAdapter(racesAdapter);
                //idRecyclerview1.setLayoutManager(layoutManager);

                /****************/

                List<Result> resultList = new ArrayList<>();
                resultList = root.getMRData().getRaceTable().getRaces().get(0).getResults();

                resultsAdapter = new ResultsAdapter(MainActivity.this, resultList);
                RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                binding.idRecyclerview2.setAdapter(resultsAdapter);
                binding.idRecyclerview2.setLayoutManager(layoutManager1);

                binding.series.setText(root.getMRData().getSeries());
                binding.limit.setText(root.getMRData().getLimit());
                binding.offset.setText(root.getMRData().getOffset());
                binding.total.setText(root.getMRData().getTotal());

                binding.season.setText(root.getMRData().getRaceTable().getSeason());
                binding.round.setText(root.getMRData().getRaceTable().getRound());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}