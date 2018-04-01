package com.driff.apps.advancedandroid.testutils;

import com.driff.apps.advancedandroid.model.AdapterFactory;
import com.driff.apps.advancedandroid.model.ZoneDatetimeAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/**
 * Created by johnj on 3/19/2018.
 */

public class TestUtils {

    private static TestUtils INSTANCE = new TestUtils();
    private static final Moshi TEST_MOSHI = initializeMoshi();

    private TestUtils(){

    }

    public static <T> T loadJson(String path, Type type){
        try{
            String json = getFileString(path);
            //noinspection unchecked
            return (T) TEST_MOSHI.adapter(type).fromJson(json);
        }catch (IOException e){
            throw new IllegalArgumentException("Could not deserialize: "+ path + " into type: "+type);
        }
    }

    public static <T> T loadJson(String path, Class<T> clazz){
        try{
            String json = getFileString(path);
            //noinspection unchecked
            return (T) TEST_MOSHI.adapter(clazz).fromJson(json);
        }catch (IOException e){
            throw new IllegalArgumentException("Could not deserialize: "+ path + " into class: "+clazz);
        }
    }

    private static String getFileString(String path){
        try{
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    INSTANCE.getClass().getClassLoader().getResourceAsStream(path)));
            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();
        }catch (IOException e){
            throw new IllegalArgumentException("Could not read from resources at: "+path);
        }
    }

    private static Moshi initializeMoshi(){
        Moshi.Builder builder = new Moshi.Builder();
        builder.add(AdapterFactory.create());
        builder.add(new ZoneDatetimeAdapter());
        return builder.build();
    }


}
