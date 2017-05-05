package com.jodiwaljay.lendborrow.Information;

import android.util.Pair;

import com.jodiwaljay.lendborrow.Database.PairDataType;

import java.util.ArrayList;

/**
 * Created by jodiwaljay on 5/5/17.
 */

public class ColumnPairs {
    public static ArrayList<PairDataType> getTripColumns(){

        ArrayList<PairDataType> columnArr = new ArrayList<>();

        columnArr.add(new PairDataType("name",PairDataType.stringData));
        columnArr.add(new PairDataType("timeStamp",PairDataType.stringData));

        return columnArr;
    }
}
