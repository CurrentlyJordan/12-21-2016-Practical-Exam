package nyc.c4q.jordansmith.a12_21_16_exam.Model;

import java.util.List;

/**
 * Created by jordansmith on 12/21/16.
 */

public class JsonResponse {


        private Boolean success;
        private List<Animal> animals = null;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public List<Animal> getAnimals() {
            return animals;
        }

        public void setAnimals(List<Animal> animals) {
            this.animals = animals;
        }

    }

