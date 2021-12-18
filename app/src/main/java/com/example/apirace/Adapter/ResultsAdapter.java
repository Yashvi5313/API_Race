package com.example.apirace.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apirace.MainActivity;
import com.example.apirace.Model.Race;
import com.example.apirace.Model.Result;
import com.example.apirace.R;
import com.example.apirace.databinding.RacesItemBinding;
import com.example.apirace.databinding.ResultsItemBinding;

import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.MyViewHolder> {

    List<Result> resultList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ResultsItemBinding binding;

        public MyViewHolder(ResultsItemBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }

    public ResultsAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResultsAdapter.MyViewHolder(ResultsItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ResultsItemBinding bind = holder.binding;
        Result result = resultList.get(position);

        holder.binding.position.setText(result.getPosition());
        holder.binding.points.setText(result.getPoints());
        holder.binding.driverId.setText(result.getDriver().getDriverId());
        holder.binding.consturctorId.setText(result.getConstructor().getConstructorId());
        holder.binding.grid.setText(result.getGrid());
        holder.binding.laps.setText(result.getLaps());


        if (result.getStatus().equals("Finished")) {
            holder.binding.status.setText(result.getStatus());
            holder.binding.status.setTextColor(context.getResources().getColor(R.color.green));
        } else {
            holder.binding.status.setText(result.getStatus());
            holder.binding.status.setTextColor(context.getResources().getColor(R.color.red));
        }

        holder.binding.millis.setText(result.getTime().getMillis());
        holder.binding.Ttime.setText(result.getTime().getTime());
        holder.binding.rank.setText(result.getFastestLap().getRank());
        holder.binding.Flap.setText(result.getFastestLap().getLap());
        holder.binding.units.setText(result.getFastestLap().getAverageSpeed().getUnits());
        holder.binding.speed.setText(result.getFastestLap().getAverageSpeed().getSpeed());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}

//    public ResultsAdapter(Context context, List<Result> resultList) {
//        this.context = context;
//        this.resultList = resultList;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.results_item, parent, false);
//        MyHolder holder = new MyHolder(view);
//        return holder;
//    }
//
//    @SuppressLint({"ResourceAsColor", "ResourceType"})
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ResultsAdapter.MyHolder myHolder = (ResultsAdapter.MyHolder) holder;
//        Result result = resultList.get(position);
//        //myHolder.number.setText(result.getNumber());
//        myHolder.position.setText(result.getPosition());
//       // myHolder.positionText.setText(result.getPositionText());
//        myHolder.points.setText(result.getPoints());
//        myHolder.driverId.setText(result.getDriver().getDriverId());
////        myHolder.code.setText(result.getDriver().getCode());
////        myHolder.GName.setText(result.getDriver().getGivenName());
////        myHolder.FName.setText(result.getDriver().getFamilyName());
////        myHolder.DOB.setText(result.getDriver().getDateOfBirth());
////        myHolder.nationality.setText(result.getDriver().getNationality());
//        myHolder.consturctorId.setText(result.getConstructor().getConstructorId());
////        myHolder.CName.setText(result.getConstructor().getName());
////        myHolder.Cnationality.setText(result.getConstructor().getNationality());
//        myHolder.grid.setText(result.getGrid());
//        myHolder.laps.setText(result.getLaps());
//
//        if (result.getStatus().equals("Finished")) {
//            myHolder.status.setText(result.getStatus());
//            //myHolder.status.setTextColor(R.color.green);
//            myHolder.status.setTextColor(context.getResources().getColor(R.color.green));
//        }else {
//            myHolder.status.setText(result.getStatus());
//            myHolder.status.setTextColor(context.getResources().getColor(R.color.red));
//        }
//
//        if (result.getTime().getMillis() != null){
//            myHolder.millis.setText(result.getTime().getMillis());
//        }
//        myHolder.Ttime.setText(result.getTime().getTime());
//        myHolder.rank.setText(result.getFastestLap().getRank());
//        myHolder.Flap.setText(result.getFastestLap().getLap());
//        //myHolder.Ftime.setText("" + result.getFastestLap().getTime().getFTime());
//        myHolder.units.setText(result.getFastestLap().getAverageSpeed().getUnits());
//        myHolder.speed.setText(result.getFastestLap().getAverageSpeed().getSpeed());
//    }
//
//    @Override
//    public int getItemCount() {
//        return resultList.size();
//    }
//
//    class MyHolder extends RecyclerView.ViewHolder {
//        TextView number;
//        TextView position;
//        TextView positionText;
//        TextView points;
//        TextView driverId;
//        TextView code;
//        TextView GName;
//        TextView FName;
//        TextView DOB;
//        TextView nationality;
//        TextView consturctorId;
//        TextView CName;
//        TextView Cnationality;
//        TextView grid;
//        TextView laps;
//        TextView status;
//        TextView millis;
//        TextView Ttime;
//        TextView rank;
//        TextView Flap;
//        TextView Ftime;
//        TextView units;
//        TextView speed;
//
//        public MyHolder(View itemView) {
//            super(itemView);
//            //number = (TextView) itemView.findViewById(R.id.number);
//            position = (TextView) itemView.findViewById(R.id.position);
//            //positionText = (TextView) itemView.findViewById(R.id.positionText);
//            points = (TextView) itemView.findViewById(R.id.points);
//            driverId = (TextView) itemView.findViewById(R.id.driverId);
//            //code = (TextView) itemView.findViewById(R.id.code);
//           // GName = (TextView) itemView.findViewById(R.id.GName);
//            //FName = (TextView) itemView.findViewById(R.id.FName);
//            //DOB = (TextView) itemView.findViewById(R.id.DOB);
//            //nationality = (TextView) itemView.findViewById(R.id.nationality);
//            consturctorId = (TextView) itemView.findViewById(R.id.consturctorId);
//            //CName = (TextView) itemView.findViewById(R.id.CName);
//            //Cnationality = (TextView) itemView.findViewById(R.id.Cnationality);
//            grid = (TextView) itemView.findViewById(R.id.grid);
//            laps = (TextView) itemView.findViewById(R.id.laps);
//            status = (TextView) itemView.findViewById(R.id.status);
//            millis = (TextView) itemView.findViewById(R.id.millis);
//            Ttime = (TextView) itemView.findViewById(R.id.Ttime);
//            rank = (TextView) itemView.findViewById(R.id.rank);
//            Flap = (TextView) itemView.findViewById(R.id.Flap);
//            //Ftime = (TextView) itemView.findViewById(R.id.Ftime);
//            units = (TextView) itemView.findViewById(R.id.units);
//            speed = (TextView) itemView.findViewById(R.id.speed);
//        }
//    }
//}
