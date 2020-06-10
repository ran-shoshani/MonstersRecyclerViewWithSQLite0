package com.blueradix.android.monstersrecyclerviewwithsqlite.entities;

import java.io.Serializable;




public class Task implements Serializable {

    //public static final String MONSTER_KEY = "monster_key";
    public static final String TASK_KEY = "task_key";


    public Long id;
    public String name;
    //public String description;
    //public Integer scariness;
    //public String imageFileName;
    //private Integer votes;
    //private Integer stars;


    public Task() {

    }

    public Task(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


//    public String getImageFileName() {
//
//    }


}
