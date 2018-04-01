package com.driff.apps.advancedandroid.model;

import android.support.annotation.Nullable;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.threeten.bp.ZonedDateTime;
/**
 * Created by johnj on 3/11/2018.
 */

public class ZoneDatetimeAdapter {

    @FromJson
    ZonedDateTime fromJson(String json){
        return ZonedDateTime.parse(json);
    }

    @ToJson
    String toJson(@Nullable ZonedDateTime value){
        return value!=null ? value.toString():null;
    }

}
