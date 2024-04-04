package com.example.admin_college_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.admin_college_app.faculty.UpdateFaculty;
import com.example.admin_college_app.notice.DeleteNoticeActivity;
import com.example.admin_college_app.notice.UploadNotice;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     CardView uploadNotice, addGalleryImage, addEbook, faculty, deleteNotice, logout;

     private SharedPreferences sharedPreferences;
     private SharedPreferences.Editor editor;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
         editor = sharedPreferences.edit();

         if (sharedPreferences.getString("isLogin","false").equals("false")){
             openLogin();
         }

         uploadNotice = findViewById(R.id.addNotice);
         addGalleryImage = findViewById(R.id.addGalleryImage);
         addEbook = findViewById(R.id.addEbook);
         deleteNotice = findViewById(R.id.deleteNotice);
         faculty = findViewById(R.id.faculty);
         logout = findViewById(R.id.logout);

         uploadNotice.setOnClickListener(this);
         addGalleryImage.setOnClickListener(this);
         addEbook.setOnClickListener(this);
         deleteNotice.setOnClickListener(this);
         faculty.setOnClickListener(this);
         logout.setOnClickListener(this);
     }

     private void openLogin() {
         startActivity(new Intent(MainActivity.this,LoginActivity.class));
         finish();
     }

     @Override
     public void onClick(View view) {
         Intent intent;
         switch (view.getId()) {
             case R.id.addNotice:
                 intent = new Intent(MainActivity.this, UploadNotice.class);
                 startActivity(intent);
                 break;
             case R.id.addGalleryImage:
                 intent = new Intent(MainActivity.this,UploadImage.class);
                 startActivity(intent);
                 break;
                 case R.id.addEbook:
                 intent = new Intent(MainActivity.this,UploadPdfActivity.class);
                 startActivity(intent);
                 break;
                 case R.id.faculty:
                 intent = new Intent(MainActivity.this, UpdateFaculty.class);
                  startActivity(intent);
                 break;
                 case R.id.deleteNotice:
                 intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                  startActivity(intent);
                 break;
             case R.id.logout:
                 editor.putString("isLogin","false");
                 editor.commit();
                 openLogin();
                 break;
         }
     }
 }