package ru.alexbykov.sailesstat.remote.dto.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;


/**
 * Created by Alexey on 12.07.2016.
 */
public class ManagerDTO extends RealmObject  {


    @Ignore
    @JsonSerialize
    private ArrayList<ManagerDTO> managerLists;


    @PrimaryKey
    String name;
    int plan;


    public ManagerDTO() {

    }

    public ManagerDTO(String name, int plan) {
        this.name = name;
        this.plan = plan;
    }


    public void setManagerLists(ArrayList<ManagerDTO> managerLists) {
        this.managerLists = managerLists;
    }

    public ArrayList<ManagerDTO> getManagerLists() {

        return managerLists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }


    public int getPlan() {

        return plan;
    }

}
