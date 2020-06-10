package com.blueradix.android.monstersrecyclerviewwithsqlite.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.android.monstersrecyclerviewwithsqlite.R;
import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Task;

import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private List<Task> tasks;
    private  Context context;

    public TaskRecyclerViewAdapter(List<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }



    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View taskViewItem  = inflater.inflate(R.layout.recycler_item_view, parent, false);

        TaskViewHolder taskViewHolder = new TaskViewHolder(taskViewItem);

        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        Task task = tasks.get(position);
        holder.updateTask(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();  // return the number of tasks in the DataBae
    }
}
