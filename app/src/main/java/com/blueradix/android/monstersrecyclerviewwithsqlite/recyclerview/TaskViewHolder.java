package com.blueradix.android.monstersrecyclerviewwithsqlite.recyclerview;

import com.blueradix.android.monstersrecyclerviewwithsqlite.R;
import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Task;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class TaskViewHolder extends RecyclerView.ViewHolder {

    public  TextView taskTextView = null;
    public  TextView idTextView = null;


    // maps the UI components to the XML layout
    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);

        // link our UIComponents with the xml file tags
        taskTextView = itemView.findViewById(R.id.taskTextView);
        idTextView = itemView.findViewById(R.id.taskTextView);
    }


    //puts data into my ViewHolder
    public void updateTask(Task task){



        taskTextView.setText(task.getName());
        idTextView.setText(task.getId().toString());    // long to string

        View rootView = taskTextView.getRootView();
        // not sure ABOUT THIS LINE , BECAUSE I DONT USE IMAGES FROM RESOURCES
        int resID = rootView.getResources().getIdentifier(task.getName(), "drawable" ,rootView.getContext().getPackageName());
        //taskImageView.setImageResource(resID);
    }


//    public final ImageView taskImageView = null;
//    public final TextView taskNameView = null;
//    //public final TeetView

//        //link our UI components with the xml file tags.
//        // itemView.findViewById(R.id.task);                 ----------------------------------------------------
//    }
//
//    public void updateTask(Task task){
//
//        //View rootView = taskImageView.getRootView();
//        //int resID = rootView.getResources().getIdentifier(task.getImageFileName(), "drawable", rootView.getContext().getPackageName());
//
//    }
//


}
