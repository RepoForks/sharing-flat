package com.costular.flatsharing.util;

import java.io.IOException;

/**
 * Created by diego on 8/12/15.
 */
public interface ImageFile {

    void create(String filename, String extension) throws IOException;

    void override(String filename, String extension) throws IOException;

    void setPath(String uriFile);

    boolean exists();

    String getPath();

    void delete() throws IOException;
}
