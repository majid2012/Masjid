package com.example.majid.masjid;

/**
 * Created by Majid on 28-Oct-17.
 */

public class Salat {
    String salat_id;
    String salat_name;
    String salat_time;
    String salat_after;

    public Salat() {

    }

    public Salat(String salat_id, String salat_name, String salat_time, String salat_after) {
        this.salat_id = salat_id;
        this.salat_name = salat_name;
        this.salat_time = salat_time;
        this.salat_after = salat_after;
    }

     public String getSalat_id() {
         return salat_id;
      }

    public String getSalat_name() {
        return salat_name;
    }

    public String getSalat_time() {
        return salat_time;
    }

    public String getSalat_after() {
        return salat_after;
    }
}

