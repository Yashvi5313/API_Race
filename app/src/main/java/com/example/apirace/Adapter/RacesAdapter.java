package com.example.apirace.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.apirace.Model.Race;
import com.example.apirace.R;
import com.example.apirace.databinding.RacesItemBinding;

import java.util.List;

public class RacesAdapter extends RecyclerView.Adapter<RacesAdapter.MyViewHolder> {
    List<Race> raceList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RacesItemBinding binding;

        public MyViewHolder(RacesItemBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }

    public RacesAdapter(Context context, List<Race> raceList) {
        this.context = context;
        this.raceList = raceList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RacesItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RacesItemBinding bind = holder.binding;
        Race race = raceList.get(position);

        holder.binding.season.setText(race.getSeason());
        holder.binding.round.setText(race.getRound());
        holder.binding.raceName.setText(race.getRaceName());
        holder.binding.date.setText(race.getDate());
        holder.binding.circuitId.setText(race.getCircuit().getCircuitId());
        holder.binding.circuitName.setText(race.getCircuit().getCircuitName());
        holder.binding.lat.setText(race.getCircuit().getLocation().getLat());
        holder.binding.Long.setText(race.getCircuit().getLocation().getLong());
        holder.binding.locality.setText(race.getCircuit().getLocation().getLocality());
        holder.binding.country.setText(race.getCircuit().getLocation().getCountry());
    }

    @Override
    public int getItemCount() {
        return raceList.size();
    }
}

//    public RacesAdapter(Context context, List<Race> raceList) {
//        this.context = context;
//        this.raceList = raceList;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.races_item, parent, false);
//        MyHolder holder = new MyHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        MyHolder myHolder = (MyHolder) holder;
//        Race race  = raceList.get(position);
//        myHolder.season.setText(race.getSeason());
//        myHolder.round.setText(race.getRound());
//        myHolder.raceName.setText(race.getRaceName());
//        myHolder.date.setText(race.getDate());
//        myHolder.circuitId.setText(race.getCircuit().getCircuitId());
//        myHolder.circuitName.setText(race.getCircuit().getCircuitName());
//        myHolder.lat.setText(race.getCircuit().getLocation().getLat());
//        myHolder.Long.setText(race.getCircuit().getLocation().getLong());
//        myHolder.locality.setText(race.getCircuit().getLocation().getLocality());
//        myHolder.country.setText(race.getCircuit().getLocation().getCountry());
//    }
//
//    @Override
//    public int getItemCount() {
//        return raceList.size();
//    }
//
//    class MyHolder extends RecyclerView.ViewHolder{
//        TextView season;
//        TextView round;
//        TextView raceName;
//        TextView date;
//        TextView circuitId;
//        TextView circuitName;
//        TextView lat;
//        TextView Long;
//        TextView locality;
//        TextView country;
//
//        public MyHolder(View itemView){
//            super(itemView);
//            season = (TextView) itemView.findViewById(R.id.season);
//            round = (TextView) itemView.findViewById(R.id.round);
//            raceName = (TextView) itemView.findViewById(R.id.raceName);
//            date = (TextView) itemView.findViewById(R.id.date);
//            circuitId = (TextView) itemView.findViewById(R.id.circuitId);
//            circuitName = (TextView) itemView.findViewById(R.id.circuitName);
//            lat = (TextView) itemView.findViewById(R.id.lat);
//            Long = (TextView) itemView.findViewById(R.id.Long);
//            locality = (TextView) itemView.findViewById(R.id.locality);
//            country = (TextView) itemView.findViewById(R.id.country);
//        }
//    }
//}
