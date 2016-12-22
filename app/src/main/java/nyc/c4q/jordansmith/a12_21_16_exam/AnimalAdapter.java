package nyc.c4q.jordansmith.a12_21_16_exam;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nyc.c4q.jordansmith.a12_21_16_exam.Model.Animal;

/**
 * Created by jordansmith on 12/21/16.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {


        List<Animal> animalList;

        AnimalAdapter(List<Animal> houseList){
            this.animalList = houseList;
        }


        @Override
        public AnimalAdapter.AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

            return new AnimalAdapter.AnimalViewHolder (childView);
        }

        @Override
        public void onBindViewHolder(AnimalAdapter.AnimalViewHolder holder, int position) {
            Animal animal = animalList.get(position);
            final String fragmentBackgroundColor = animal.getBackground();
            String animalName = animal.getName();
            String animalTextColor = animal.getTextColor();
            holder.animalTextView.setText(animalName);
            holder.animalTextView.setTextColor(Color.parseColor(animalTextColor));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainFragment.changeFragmentBackground(fragmentBackgroundColor);
                }
            });




        }

        @Override
        public int getItemCount() {
            return animalList.size();
        }

        public class AnimalViewHolder extends RecyclerView.ViewHolder {
            TextView animalTextView;


            public AnimalViewHolder(View itemView) {
                super(itemView);
                animalTextView = (TextView) itemView.findViewById(R.id.name_view);


            }
        }

    }

