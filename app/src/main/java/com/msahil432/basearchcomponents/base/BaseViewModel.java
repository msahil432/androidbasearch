package com.msahil432.basearchcomponents.base;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

public class BaseViewModel<T> extends ViewModel {

    protected LiveData<T> data;

    public BaseViewModel(LiveData<T> data){
        this.data = data;
    }

    public LiveData<T> getData() {
        return data;
    }

    public void setData(LiveData<T> data) {
        this.data = data;
    }
}
