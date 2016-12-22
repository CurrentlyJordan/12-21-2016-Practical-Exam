package nyc.c4q.jordansmith.a12_21_16_exam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.List;

import nyc.c4q.jordansmith.a12_21_16_exam.Model.Animal;
import nyc.c4q.jordansmith.a12_21_16_exam.Model.JsonResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by jordansmith on 12/21/16.
 */

public class MainFragment extends Fragment {

    List<Animal> animalList;
    RecyclerView recyclerView;
    static LinearLayout fragmentLinearLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_activity_fragment_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        fragmentLinearLayout = (LinearLayout) view.findViewById(R.id.fragment_view);
        requestAnimals();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        requestAnimals();
    }

    public void requestAnimals() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimalService animalService = retrofit.create(AnimalService.class);
        Call<JsonResponse> httpRequest = animalService.getAnimals();
        httpRequest.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        animalList = response.body().getAnimals();
                        AnimalAdapter animalAdapter = new AnimalAdapter(animalList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(animalAdapter);



                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("failure", "no connection");

            }
        });

    }

    public static void changeFragmentBackground(String colorString){
        fragmentLinearLayout.setBackgroundColor(Color.parseColor(colorString));

    }


}