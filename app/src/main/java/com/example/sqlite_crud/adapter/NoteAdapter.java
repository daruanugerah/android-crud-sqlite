package com.example.sqlite_crud.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_crud.AddUpdateActivity;
import com.example.sqlite_crud.R;
import com.example.sqlite_crud.model.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteVIewHolder> {

    private ArrayList<Note> data;
    private Activity activity;

    ArrayList<Note> getListNote() {
        return data;
    }

    public NoteAdapter(Activity activity){
        this.activity = activity;

    }

    public void setListNote(ArrayList<Note> dataNote){
        data = new ArrayList<>();
        this.data = dataNote;
    }

    @NonNull
    @Override
    public NoteVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteVIewHolder(LayoutInflater.from(activity).inflate(R.layout.item_nota, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVIewHolder holder, final int position) {
        holder.tvJudul.setText(getListNote().get(position).getJudul());
        holder.tvDesc.setText(getListNote().get(position).getDeskripsi());
        holder.tvTanggal.setText(getListNote().get(position).getTanggal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, AddUpdateActivity.class);
                intent.putExtra(AddUpdateActivity.EXTRA_NOTE, getListNote().get(position));
                intent.putExtra(AddUpdateActivity.EXTRA_POSITION, position);
                activity.startActivityForResult(intent, AddUpdateActivity.REQUEST_UPDATE);
            }
        });

    }

    @Override
    public int getItemCount() {

        //bikin null dulu
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    public class NoteVIewHolder extends RecyclerView.ViewHolder {

        TextView tvJudul, tvDesc, tvTanggal;

        public NoteVIewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvDesc = itemView.findViewById(R.id.tv_deskripsi);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
        }
    }
}
