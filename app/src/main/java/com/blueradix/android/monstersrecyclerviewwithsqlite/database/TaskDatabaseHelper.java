package com.blueradix.android.monstersrecyclerviewwithsqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Monster;
import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper class where we will write all operations related to the database
 */
public class TaskDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = TaskDatabaseHelper.class.getName();

    private static TaskDatabaseHelper mInstance = null;
    private Context context;

    //create database constants
    private static final String DATABASE_NAME = "monster.db";
    private static final Integer DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "monster";

    //private static final String DATABASE_NAME = ""


    //create constants for the table's column name
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    //private static final String COL_DESCRIPTION = "DESCRIPTION";
    //private static final String COL_SCARINESS = "SCARINESS";
    //private static final String COL_IMAGE = "IMAGE";
    //private static final String COL_VOTES = "VOTES";
    //private static final String COL_STARS = "STARS";




    //create sql statements initial version
    private static final String CREATE_TABLE_ST = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT)";


    //create sql statements initial version
//    private static final String CREATE_TABLE_ST = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            COL_NAME + " TEXT, " +
//            COL_DESCRIPTION + " TEXT, " +
//            COL_SCARINESS + " INTEGER, " +
//            COL_IMAGE + " TEXT, " +
//            COL_VOTES + " INTEGER DEFAULT 0, " +
//            COL_STARS + " INTEGER DEFAULT 0 )";





    private static final String DROP_TABLE_ST = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String GET_ALL_ST = "SELECT * FROM " + TABLE_NAME;

    public static synchronized TaskDatabaseHelper getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new TaskDatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    /**
     * Set the new version of the database (newVersion specified in the constant DATABASE_VERSION),
     * if the database new version is greater than the
     * database version stored inside of the database( oldVersion, written there when the db was created ) then
     * the onUpgrade method will be called.
     *
     * @param context provides access to the Activity resources
     */
    private TaskDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /**
     * this method gets executed only if the database does not exists
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE_ST);
        onCreate(sqLiteDatabase);
    }

    /**
     * Add a monster to the database
     * @param name          Monster's name
     * @param description   Monster's description
     * @param scariness     Monster's scariness level
     * @return      if it succeeded, the autogenerated id (primary key) of the recently added monster
     *              otherwise -1
     */
    public Long insert(String name, String description, Integer scariness) {
        //create an instance of SQLITE database
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        //contentValues.put(COL_DESCRIPTION, description);
       // contentValues.put(COL_SCARINESS, scariness);
        //we store the image name, after using
        //contentValues.put(COL_IMAGE, getRandomImageName());

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        //if result is -1  insert was not performed due to an error, otherwise will have the row ID of the newly inserted row
        return result;
    }

    /**
     * @return  A cursor of all monsters in the table called monster.
     */
    private Cursor getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(GET_ALL_ST, null);
    }

    /**
     * Update a monster record in the database
     * @param id            Primary key of the task
     * @param name          New Task's name
//
     * @return      true is the task record in the database was updated, otherwise false.
     */
    public boolean update(Long id, String name, String description, Integer scariness) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, id);
        contentValues.put(COL_NAME, name);
        //contentValues.put(COL_DESCRIPTION, description);
        //contentValues.put(COL_SCARINESS, scariness);

        int numOfRowsUpdated = db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id.toString()});
        db.close();
        return numOfRowsUpdated == 1; //if your query is going to update more than 1 record (this is not the case) then the condition will be numRowsUpdated > 0
    }

    /**
     * Delete a monster from the database
     * @param id    Monster's primary key
     * @return      true if the monster was deleted, otherwise false
     */
    public boolean delete(Long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //delete return the # of rows affected by the query
        int numOfRowsDeleted = db.delete(TABLE_NAME, "ID = ?", new String[]{id.toString()});
        db.close();
        return numOfRowsDeleted == 1;//if your query is going to delete more than 1 record (this is not the case) then the condition will be numOfRowsDeleted > 0
    }

    /**
     * @return an autogenerated image name string value
     */
    private String getRandomImageName() {
        Random ran = new Random();
        int value = ran.nextInt(30) + 1;
        return "monster_" + value;
    }

    /**
     * @return a list of all monsters from the database table called monster
     */
//    public List<Monster> getMonsters() {
//        List<Monster> monsters = new ArrayList<>();
//        Cursor cursor = getAll();
//
//        if(cursor.getCount() > 0) {
//            Monster monster;
//            while (cursor.moveToNext()) {
//                Long id = cursor.getLong(0);
//                String name = cursor.getString(1);
//                String description = cursor.getString(2);
//                Integer scariness = cursor.getInt(3);
//                String imageFileName = cursor.getString(4);
//                Integer votes = cursor.getInt(5);
//                Integer stars = cursor.getInt(6);
//
//                monster = new Monster(id, name, description, scariness, imageFileName, votes, stars);
//                monsters.add(monster);
//            }
//        }
//        cursor.close();
//        return monsters;
//    }

    public Long insert(String name, Long id) {
    }

    public boolean update(String name, Long id) {
    }

    public List<Task> getTasks() {
        // fix database errors
        List<Task> tasks = new ArrayList<>();
        Cursor cursor = getAll();

        if(cursor.getCount() > 0) {

            Task task;
            while (cursor.moveToNext()) {
                Long id = cursor.getLong(0);
                String name = cursor.getString(1);

                task = new Task(id, name);
               tasks.add(task);
            }
        }
        cursor.close();
        return tasks;

    }
}

