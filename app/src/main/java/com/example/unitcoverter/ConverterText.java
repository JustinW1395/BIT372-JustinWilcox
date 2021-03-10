package com.example.unitcoverter;
import androidx.lifecycle.MutableLiveData;

public class ConverterText {

    public MutableLiveData<String> text;

    public ConverterText(String text){
        this.text = new MutableLiveData<>();
        this.text.setValue(text);
    }

    public void setText(String newText){
        this.text.setValue(newText);
    }

    public void getText(){
        this.text.getValue();
    }

}
