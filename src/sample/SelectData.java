package sample;

import javafx.beans.property.SimpleStringProperty;

public class SelectData{
    public SimpleStringProperty mIdProperty = new SimpleStringProperty();
    public SimpleStringProperty mTimeProperty = new SimpleStringProperty();
    public SimpleStringProperty mStationProperty = new SimpleStringProperty();
    public SimpleStringProperty mZuobiaoProperty = new SimpleStringProperty();
    public SimpleStringProperty mEnergyProperty = new SimpleStringProperty();
    public SimpleStringProperty mJibieProperty = new SimpleStringProperty();

    public SelectData(String Id,String Time,String Station,String Zuobiao,String Energy,String Jibie){
        mIdProperty.set(Id);
        mTimeProperty.set(Time);
        mStationProperty.set(Station);
        mZuobiaoProperty.set(Zuobiao);
        mEnergyProperty.set(Energy);
        mJibieProperty.set(Jibie);
    }


    //getter setter方法
    public void setId(String Id){
        mIdProperty.set(Id);
    }
    public String getId(){
        return mIdProperty.get();
    }
    public void setTime(String Time){
        mTimeProperty.set(Time);
    }
    public String getTime(){
        return mTimeProperty.get();
    }
    public void setStation(String Station){
        mStationProperty.set(Station);
    }
    public String  getStation(){
        return mStationProperty.get();
    }
    public void  setZuobiao(String Zuobiao){
        mZuobiaoProperty.set(Zuobiao);
    }
    public String getZuobiao(){
        return mZuobiaoProperty.get();
    }
    public void setEnergy(String Energy){
        mEnergyProperty.set(Energy);
    }
    public String getEnergy(){
        return mEnergyProperty.get();
    }
    public void setJibie(String Jibie){
        mJibieProperty.set(Jibie);
    }
    public String getJibie(){
        return mJibieProperty.get();
    }
}
