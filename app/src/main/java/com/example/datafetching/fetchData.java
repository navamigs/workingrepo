package com.example.datafetching;

import android.content.Context;
import android.content.Intent;
import android.icu.util.RangeValueIterator;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.util.Log;
import android.widget.Toast;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import static android.support.constraint.Constraints.TAG;

public class fetchData extends AsyncTask<Void, Void, Void> {
    String data = "";
    boolean dataParsed;
    String singleParsed = "CERRA";
    String DeviceSerialNumber;
    //String line = "";
    int statusCode;
    //Context context;
    boolean flag = true;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://192.168.123.254/boafrm/SerialNumforApp");//kxhc1
            //need to create Http connection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            statusCode = httpURLConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                //if (commandType == COMMAND_GET_SERIAL_NUM) {
                Document document = Jsoup.parse(data);
                Element link = document.select("h4").first();
                try {
                    JSONObject jsonObject1 = new JSONObject(document.body().text());
                    DeviceSerialNumber = jsonObject1.getString("SerialNum");
                        Log.d(TAG, "In parseForCommanResponseData : SerialNum" + DeviceSerialNumber);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //creating jsonobject to jsonarray
             /*   JSONArray jsonArray = new JSONArray(data);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    singleParsed = "Device name: " + jsonObject.get("SerialNum") + "\n";
                    //"contact: " + jsonObject.get("contact") + "\n";
                    dataParsed = dataParsed + singleParsed;
                }*/

                //Intent intent= new Intent(context,SecondActivity.class);
                //context.startActivity(intent);
            } else {
                //singleParsed = "null";
                // dataParsed = dataParsed + singleParsed;
                ;
                // Toast.makeText(context,"Fail!", Toast.LENGTH_LONG).show();
            }

            for (int i = 0; i < 5; i++) {
                if (singleParsed.charAt(i) != DeviceSerialNumber.charAt(i)) {
                    flag = false;
                    break;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    //UI theard
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //if (statusCode ==HttpURLConnection.HTTP_OK){//if (dataParsed != "null") {
        // MainActivity.data.setText(this.DeviceSerialNumber);
        // for(int i=0;i<=5;i++)
        if (flag) {
            MainActivity.data.setText(this.DeviceSerialNumber);
        } else {

        }

    }
}


/*
public class fetchData extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls) {
        //URL urls = new URL("http://192.168.123.254/boafrm/SerialNumforApp");
        StringBuilder builder = new StringBuilder(100000);

        for (String url : urls) {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            try {
                HttpResponse execute = client.execute(httpGet);
                InputStream content = execute.getEntity().getContent();

                BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                String s = "";
                while ((s = buffer.readLine()) != null) {
                    builder.append(s);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return builder.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        //if (statusCode == HttpURLConnection.HTTP_OK){//if (dataParsed != "null") {
        //     MainActivity.data.setText(this.dataParsed);
        //}
    }}*/

/*   public void DialogAppear() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RovrDetectedActivity.this);
        builder.setTitle("info");
        builder.setMessage("Select Rovr");

        builder.setNegativeButton("Diamond", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dailog, int which) {
                Intent intent = new Intent(RovrDetectedActivity.this, RovrDiamond.class);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("Ruby", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dailog, int which) {
                //when ok is Clicked, it open Wifi settings
                Intent intent = new Intent(RovrDetectedActivity.this, RovrRuby.class);
                startActivity(intent);
            }
        });
        builder.show();
    }*/


//creating jsonobject to jsonarray
                 /*   JSONArray jsonArray = new JSONArray(data);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        singleParsed = "Device name: " + jsonObject.get("SerialNum") + "\n";
                        //"contact: " + jsonObject.get("contact") + "\n";
                        dataParsed = dataParsed + singleParsed;
                    }*/

               /* } else {
                    singleParsed = "fail";
                    dataParsed = dataParsed + singleParsed;
                    ;
                    // Toast.makeText(context,"Fail!", Toast.LENGTH_LONG).show();
                }*/