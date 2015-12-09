package com.costular.flatsharing.util;

import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by diego on 8/12/15.
 */
public class AndroidImageFile implements ImageFile{

    private File imageFile;
    File storageDir;

    public static AndroidImageFile newInstance() {
        return new AndroidImageFile();
    }

    @Override
    public void create(String filename, String extension) throws IOException {
        setStorageDir();
        createFile(filename, extension);
    }

    @Override
    public void override(String filename, String extension) throws IOException {
        if(storageDir == null) {
            setStorageDir();
        }
        createFile(filename, extension);
    }

    private void setStorageDir() {
        storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
    }

    private void createFile(String filename, String extension) throws IOException{
        imageFile = File.createTempFile(
                filename,  /* prefix */
                extension, /* suffix */
                storageDir /* directory */
        );
    }

    @Override
    public boolean exists() {
        if(imageFile != null) {
            return imageFile.exists();
        }
        return false;
    }

    @Override
    public String getPath() {
        return Uri.fromFile(imageFile).toString();
    }

    @Override
    public void delete() throws IOException{
        imageFile.delete();
        imageFile = null;
    }
}
