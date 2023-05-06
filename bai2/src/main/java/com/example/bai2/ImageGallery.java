package com.example.bai2;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class ImageGallery {
    public static ArrayList<String> listOfImages(Context context){
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        ArrayList<String> listAllImage= new ArrayList<>();
        String abPathImage;
        uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.MediaColumns.DATA,
        MediaStore.Images.Media.BUCKET_DISPLAY_NAME };
        String orderBy = MediaStore.Images.Media.DATE_TAKEN + " DESC";
        cursor= context.getContentResolver().query(uri,projection,null,null,orderBy);
        column_index_data= cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while (cursor.moveToNext()){
            abPathImage= cursor.getString(column_index_data);
            listAllImage.add(abPathImage);
        }
        return listAllImage ;

    }
}
