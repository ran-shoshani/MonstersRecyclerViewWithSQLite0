package com.blueradix.android.monstersrecyclerviewwithsqlite.service;

import android.content.Context;

import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Monster;
import com.blueradix.android.monstersrecyclerviewwithsqlite.database.TaskDatabaseHelper;
import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Task;


import java.util.List;

public class DataService {
    public Object TaskRecyclerViewAdapter;
    private TaskDatabaseHelper sqlite;

    public void connect(){

    }

    public void disconnect(){

    }

    public void init(Context context){
        sqlite = sqlite.getInstance(context);
    }


    //    public Long add(Monster monster){
//        return sqlite.insert(monster.getName(), monster.getDescription(), monster.getScariness());
//    }

    public Long add(Task task){
        return sqlite.insert(task.getName(), task.getId());
    }


    //
//    public boolean delete(Monster monster){
//        return sqlite.delete(monster.getId());
//    }

    public boolean delete(Task task){
        return  sqlite.delete(task.getId());
    }




    public boolean update(Task task){
        return sqlite.update(task.getName(), task.getId());
    }

//    public boolean update(Monster monster){
//        return sqlite.update(monster.getId(), monster.getName(), monster.getDescription(), monster.getScariness());
//    }
//

    public List<Task> getTasks(){
        List<Task> tasks = sqlite.getTasks();
        return tasks;
    }

//    public List<Monster> getMonsters(){
//        List<Monster> monsters = sqlite.getMonsters();
//        return monsters;
//    }

}
