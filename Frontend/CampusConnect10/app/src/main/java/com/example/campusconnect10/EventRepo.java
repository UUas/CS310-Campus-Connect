package com.example.campusconnect10;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class EventRepo {

    public void getAllEvents(ExecutorService srv, Handler uiHandler){
        srv.submit(()->{
            try {

                List<Event> data = new ArrayList<>();

                URL url =
                        new URL("http://10.0.2.2:8080/event/getallevents");


                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader
                        = new BufferedReader(
                        new InputStreamReader(
                                conn.getInputStream()));
                StringBuilder buffer = new StringBuilder();
                String line ="";
                while((line=reader.readLine())!=null){
                    buffer.append(line);
                }

                JSONArray arr = new JSONArray(buffer.toString());

                for (int i = 0; i <arr.length() ; i++) {

                    JSONObject current = arr.getJSONObject(i);

                    Event event = new Event(current.getString("eventId"),
                            current.getString("eventName"),
                            current.getString("location"),
                            current.getString("date"),
                            current.getString("topic"),
                            current.getString("text"),
                            current.getString("club"));

                    data.add(event);
                }

                Message msg = new Message();
                msg.obj = data;
                uiHandler.sendMessage(msg);



            } catch (MalformedURLException e) {
                Log.e("DEV",e.getMessage());
            } catch (IOException e) {
                Log.e("DEV",e.getMessage());
            } catch (JSONException e) {
                Log.e("DEV",e.getMessage());
            }


        });

    }

    public void findEventById(ExecutorService srv, Handler uiHandler, String eventId) {
        srv.submit(()->{
            try {

                List<Event> data = new ArrayList<>();

                URL url =
                        new URL("http://10.0.2.2:8080/event/getallevents");


                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader
                        = new BufferedReader(
                        new InputStreamReader(
                                conn.getInputStream()));
                StringBuilder buffer = new StringBuilder();
                String line ="";
                while((line=reader.readLine())!=null){
                    buffer.append(line);
                }

                JSONArray arr = new JSONArray(buffer.toString());

                for (int i = 0; i <arr.length() ; i++) {
                    JSONObject current = arr.getJSONObject(i);
                    String temp = current.getString("eventId");
                    if (temp.equals(eventId)) {
                        Event event = new Event(current.getString("eventId"),
                                current.getString("eventName"),
                                current.getString("location"),
                                current.getString("date"),
                                current.getString("topic"),
                                current.getString("text"),
                                current.getString("club"));

                        data.add(event);
                    }

                }

                Message msg = new Message();
                msg.obj = data.get(0);
                uiHandler.sendMessage(msg);



            } catch (MalformedURLException e) {
                Log.e("DEV",e.getMessage());
            } catch (IOException e) {
                Log.e("DEV",e.getMessage());
            } catch (JSONException e) {
                Log.e("DEV",e.getMessage());
            }


        });

    }

}
