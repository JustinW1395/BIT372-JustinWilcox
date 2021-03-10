package com.example.unitcoverter;


import androidx.lifecycle.MutableLiveData;

public class Title {
    public MutableLiveData<String> title;

    public Title(String title){
        this.title = new MutableLiveData<>();
        this.title.setValue(title);
    }

    public void setTitle(String newTitle){
        this.title.setValue(newTitle);
    }
}