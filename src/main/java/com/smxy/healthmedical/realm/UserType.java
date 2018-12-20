package com.smxy.healthmedical.realm;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/10
 * Time 13:44
 */
public enum UserType {
    /*UserType*/
    ADMIN("Admin"), DOCTOR("Doctor");

    private String type;

    private UserType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return this.type.toString();
    }
}
