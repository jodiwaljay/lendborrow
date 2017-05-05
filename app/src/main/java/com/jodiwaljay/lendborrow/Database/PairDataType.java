package com.jodiwaljay.lendborrow.Database;
/**
 * Created by jodiwaljay on 12/7/16.
 */
public class PairDataType {


    public PairDataType(String ColName, String dataType){
        ColumnName = ColName;
        dtType = dataType;
    }


    public String getColumnName() {
        return ColumnName;
    }

    public String getDtType() {

        if(dtType.equals(intData)){
            return intData;
        }

        if(dtType.equals(stringData)){
            return stringData;
        }

        return stringData;
    }

    private final String ColumnName;
    private String dtType;
    public static final String intData = "INT";
    public static final String stringData = "VARCHAR";

}
