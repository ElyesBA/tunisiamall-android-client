package edu.esprit.delegates;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import edu.esprit.entities.User;
import edu.esprit.tools.TM_HTTP;

public class UserDelegate {
    final static String URN = "http://10.0.3.2:18080/tunisiamall.server-web/rest/";
    String JSONResponse;
    int idSrc;
    int idDest;

    public ArrayList<User> findAll() {
        try {
            JSONResponse = new Task1().execute(URN + "users/findAll").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return parseArray();
    }

    public void addFriend(int idSrc, int idDest) {
        this.idSrc = idSrc;
        this.idDest = idDest;
        new Task2().execute(URN + "friends/add");
    }

    public void deleteFriend(int id) {
        new Task3().execute(URN + "friends/delete/" + id);
    }

    public User find(int id) {
        try {
            JSONResponse = new Task4().execute(URN + "users/find/" + id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return parseObject();
    }

    private class Task1 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return TM_HTTP.GetJSONArray(urls[0], "User");
            } catch (IOException e) {
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            JSONResponse = result;
        }
    }

    private class Task2 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("idSrc", idSrc);
                jsonParam.put("idDest", idDest);
                TM_HTTP.PostObject(urls[0], jsonParam);
                return "OK";
            } catch (IOException e) {
                return "Error";
            } catch (JSONException e) {
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
        }
    }

    private class Task3 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            TM_HTTP.Delete(urls[0]);
            return "OK";
        }

        @Override
        protected void onPostExecute(String result) {
        }
    }

    private class Task4 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return TM_HTTP.GetJSONObject(urls[0]);
            } catch (IOException e) {
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            JSONResponse = result;
        }
    }

    private ArrayList<User> parseArray() {
        ArrayList<User> resultList = new ArrayList<>();
        try {
            JSONObject jsonRootObject = new JSONObject(JSONResponse);
            JSONArray jsonArray = jsonRootObject.optJSONArray("User");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                User u = new User();
                u.setIdUser(jsonObject.optInt("idUser"));
                u.setFirstName(jsonObject.optString("firstName"));
                u.setLastName(jsonObject.optString("lastName"));
                u.setGender(jsonObject.optString("gender"));
                resultList.add(u);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private User parseObject() {
        User user = new User();
        try {
            JSONObject jsonObject = new JSONObject(JSONResponse);
            user.setIdUser(jsonObject.getInt("idUser"));
            user.setFirstName(jsonObject.getString("firstName"));
            user.setLastName(jsonObject.getString("lastName"));
            user.setGender(jsonObject.optString("gender"));
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return user;
    }

}
