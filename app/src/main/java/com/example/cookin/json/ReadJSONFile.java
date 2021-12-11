package com.example.cookin.json;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cookin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ReadJSONFile {

    public static Bundle getRecipe(String recipe_name, Context context) {
        Bundle recipe_info = new Bundle();
        try {
            JSONArray array = new JSONArray(readJSON(context));
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String json_recipe_name = jsonObject.getString("name");
                if (json_recipe_name.equals(recipe_name)) {
                    recipe_info.putString("name", json_recipe_name);
                    recipe_info.putString("title", jsonObject.getString("title"));
                    recipe_info.putString("time", jsonObject.getString("time"));
                    recipe_info.putString("img", jsonObject.getString("img"));
                    recipe_info.putString("ingredients", jsonObject.getString("ingredients"));
                    recipe_info.putString("preparation", jsonObject.getString("preparation"));
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipe_info;
    }

    public static String readJSON(Context context) {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = context.getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }
}
