package nyc.c4q.jordansmith.a12_21_16_exam;

import nyc.c4q.jordansmith.a12_21_16_exam.Model.JsonResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jordansmith on 12/21/16.
 */

public interface AnimalService {


        @GET("cgi-bin/12_21_2016_exam.pl")
        Call<JsonResponse> getAnimals();

}
