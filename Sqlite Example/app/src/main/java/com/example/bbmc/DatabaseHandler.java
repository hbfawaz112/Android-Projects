package com.example.bbmc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
//use database :
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "BBMC";
    // Contacts table name
    private static final String TABLE_USER = "user_login";
    private static final String TABLE_DONOR = "new_donor";



    // Contacts Table Columns names  user
    private static final String username = "username";
    private static final String password = "password";

    // Contacts Table Columns names  New_donor
    private static final String id = "id";
    private static final String first_name = "first_name";
    private static final String last_name = "Last_name";
    private static final String dateofbirthb = "dateofbirth";
    private static final String phnb = "phone_number";
    private static final String blood_type = "blood_type";
    private static final String iscorona = "iscorona";


   //
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        // queries of create tables :
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("  + username + " TEXT," + password + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
        String CREATE_DONOR_TABLE = "CREATE TABLE " + TABLE_DONOR + "(" +id + " TEXT,"+ first_name + " TEXT," + last_name + " TEXT," + dateofbirthb + " TEXT," + phnb + " TEXT," + blood_type + " TEXT," + iscorona + " TEXT" +")";
        db.execSQL(CREATE_DONOR_TABLE);


    }
  //if you would to upgrade the table you inserted here :
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//insert data to database :
    boolean add_user_login() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql_q = "Insert into user_login values ('admin','admin')";
        db.execSQL(sql_q);
        return true;
    }

//Select inserted data from database :
    boolean login(String username , String password){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM user_login where username ='"+username +"' and password ='"+password+"'" ;
        Cursor cursor = db.rawQuery(query, null);
        List<User_Login> users = new ArrayList<User_Login>();
        if(cursor.moveToFirst()){
            do{
                User_Login c = new User_Login(
                        cursor.getString(0),
                        cursor.getString(1));
                users.add(c);
            }while(cursor.moveToNext());
        } db.close();
        if(users.size()==0){
            return false;
        }
        else{
            return  true;
        }


    }

    public boolean add_donor(String id , String fname,String lname,String dbirth,String phnb,String bdt,String iscorona){

        SQLiteDatabase dbb= this.getWritableDatabase();
        String sql_q = "Insert into new_donor values ('"+ id +"', '"+ fname +"','"+lname+"','"+dbirth+"','"+phnb+"','"+bdt+"','"+iscorona+"')";
        dbb.execSQL(sql_q);
        return true;


    }

    public Donor get_specific_donor(int newid){
        SQLiteDatabase dbb= this.getReadableDatabase();
        String idd="";
        Donor d=null;
        String fname="",lname="",dateofbirth="",phnb="",bloodtype="",iscorona="";
        Cursor c = dbb.rawQuery("Select * from new_donor Where id="+newid , null);


        if(c.moveToFirst()){

            idd = c.getString(0);
            fname = c.getString(1);
            lname=c.getString(2);
            dateofbirth=c.getString(3);
            phnb = c.getString(4);
            bloodtype = c.getString(5);
            iscorona=c.getString(6);

             d = new Donor(idd,fname,lname,dateofbirth,phnb,bloodtype,iscorona);

        }

        return d;
    }

    public boolean delete(int idd){
        SQLiteDatabase dbb= this.getWritableDatabase();

        dbb.delete(TABLE_DONOR,"id=?", new String[]{String.valueOf(idd)});
        dbb.close();

        return true;

    }

    public int count_donors(){
        int count=0;
        SQLiteDatabase dbb= this.getReadableDatabase();
        Cursor c = dbb.rawQuery("Select count(*) from new_donor " , null);
        if(c.moveToFirst()){
            count=c.getInt(0);
        }
        return count;
    }

    public boolean update(String id , String fname,String lname,String dbirth,String phnb,String bdt){
        SQLiteDatabase dbb= this.getWritableDatabase();
        String q = "UPDATE new_donor set first_name='"+fname+"',Last_name='"+lname+"',dateofbirth='"+dbirth+"',phone_number='"+phnb+"',blood_type='"+bdt+"'where id='"+id+"'";
        dbb.execSQL(q);
        return true;
    }

// function retur typr: list , ex: [d1,d2,d3,d4] // d1 = (1,fname,lname,ect...)
    List<Donor> getAllDonros(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM new_donor";
        Cursor cursor = db.rawQuery(query, null);
        List<Donor> donors = new ArrayList<Donor>();
        if(cursor.moveToFirst()){
            do{
                Donor c = new Donor(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
);
                donors.add(c);
            }while(cursor.moveToNext());
        } db.close();
            System.out.println("*********dd*"+donors.get(0).getFname());
        return donors;
    }

    List<Donor> getAllDonrosBD(String blood){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM new_donor Where blood_type = '"+blood+"'";
        Cursor cursor = db.rawQuery(query, null);
        List<Donor> donors = new ArrayList<Donor>();
        if(cursor.moveToFirst()){
            do{
                Donor c = new Donor(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                donors.add(c);
            }while(cursor.moveToNext());
        } db.close();
        System.out.println("*********dd*"+donors.get(0).getFname());
        return donors;
    }
    List<Donor> getAllDonrosIC(String iscorona){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM new_donor Where iscorona = '"+iscorona+"'";
        Cursor cursor = db.rawQuery(query, null);
        List<Donor> donors = new ArrayList<Donor>();
        if(cursor.moveToFirst()){
            do{
                Donor c = new Donor(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                donors.add(c);
            }while(cursor.moveToNext());
        } db.close();
        System.out.println("*********dd*"+donors.get(0).getFname());
        return donors;
    }
}
