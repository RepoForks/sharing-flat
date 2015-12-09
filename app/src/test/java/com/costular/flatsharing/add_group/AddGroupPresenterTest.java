package com.costular.flatsharing.add_group;

import android.provider.ContactsContract;

import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.util.AndroidImageFile;
import com.costular.flatsharing.util.ImageFile;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by diego on 8/12/15.
 */
public class AddGroupPresenterTest {

    @Mock
    private AddGroupContract.View view;
    @Mock
    private ImageFile imageFile;
    private AddGroupPresenter presenter;

    @Before
    public void setupAddGroupPresenter() {
        MockitoAnnotations.initMocks(this);
        presenter = new AddGroupPresenter(view, imageFile);
    }

    @Test
    public void testSaveGroup() {
        presenter.saveGroup(any(Group.class));
        //verify(view.)
    }

    @Test
    public void testTakePicture() throws IOException {
        presenter.takePicture();
        verify(imageFile).create(anyString(), anyString());
        verify(imageFile).getPath();
        verify(view).openCamera(anyString());
    }

    @Test
    public void testSelectPictureFromGallery() {
        // ???
    }

    @Test
    public void testWrongImage() {
    }

    @Test
    public void testDeletePicture() {

    }
}
