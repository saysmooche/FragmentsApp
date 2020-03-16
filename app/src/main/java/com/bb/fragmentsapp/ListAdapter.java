package com.bb.fragmentsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.fragmentsapp.Fragments.FragmentFraggle;
import com.bb.fragmentsapp.Model.GitResult;
import com.bb.fragmentsapp.Objects.DataNote;
import com.bb.fragmentsapp.Objects.DataNoteInformation;
import com.bb.fragmentsapp.Util.ErrorLogger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.PendingIntent.getActivity;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.GitViewHolder> {
    private List<GitResult> resultList;

    public ListAdapter(List<GitResult> resultList){
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public GitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new GitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitViewHolder holder, int position) {

        String dateUpdate = "";
        try{
            dateUpdate = new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(resultList.get(position).getUpdatedAt()).toString();
        }catch (ParseException e) {
//            ErrorLogger.logError(e);
        }
        holder.reponameTextView.setText(resultList.get(position).getName());
        holder.repodateTextView.setText(dateUpdate);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class GitViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView reponameTextView;

        @BindView(R.id.date)
        TextView repodateTextView;


        public GitViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}


