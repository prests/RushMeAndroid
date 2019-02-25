package com.example.prests1.rushmeandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class FraternityDetail extends AppCompatActivity {

    ImageView profileImage;
    ImageView calendarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraternity_detail);

        Intent i = getIntent();
        Fraternity fraternity = (Fraternity) i.getParcelableExtra("Fraternity");

        TextView fratName = (TextView) findViewById(R.id.titleView);
        fratName.setText(fraternity.getName());

        TextView chapter = (TextView) findViewById(R.id.chapter);
        chapter.setText(fraternity.getChapter());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(fraternity.getDescription());

        TextView memberCount = (TextView) findViewById(R.id.memberCount);
        if (fraternity.getMemberCount() == 1) {
            memberCount.setText("1 member");
        } else {
            memberCount.setText(Integer.toString(fraternity.getMemberCount()) + " members");
        }


        profileImage = (ImageView) findViewById(R.id.profileImageView);
        new DownloadImagesTask(profileImage, "https://s3.us-east-2.amazonaws.com/rushmepublic/"+fraternity.getKey()+"profsemi.jpg").execute();

        calendarImage = (ImageView) findViewById(R.id.calendarImageView);
        new DownloadImagesTask(calendarImage, "https://s3.us-east-2.amazonaws.com/rushmepublic/"+fraternity.getKey()+"semi.jpg").execute();
    }


    public class DownloadImagesTask extends AsyncTask<Void, Void, Bitmap> {
        ImageView image;
        String url;

        public DownloadImagesTask(ImageView img, String uri) {
            this.image = img;
            this.url = uri;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            return download_Image(url);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
        }

        private Bitmap download_Image(String uri) {
            try {
                URL url = new URL(uri);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (IOException e) {
                // Log exception
                return null;
            }
        }
    }
}