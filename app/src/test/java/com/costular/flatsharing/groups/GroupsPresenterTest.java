package com.costular.flatsharing.groups;

import com.costular.flatsharing.data.FakeApiService;
import com.costular.flatsharing.data.GroupDataCached;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dalvik.annotation.TestTargetClass;

import static org.mockito.Matchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by diego on 8/12/15.
 */
public class GroupsPresenterTest {

    @Mock
    private GroupsContract.MyView view;
    private GroupsPresenter groupPresenter;
    private FakeApiService fakeApiService;
    private GroupDataCached cachedSystem;

    @Before
    public void setupAddNotesPresenter() {
        MockitoAnnotations.initMocks(this);
        fakeApiService = new FakeApiService(10);
        cachedSystem = new GroupDataCached(fakeApiService);
        groupPresenter = new GroupsPresenter(view, cachedSystem);
    }

    @Test
    public void testAddGroupButton() {
        groupPresenter.addNewGroup();
        verify(view).showAddGroup();
    }

    @Test
    public void testFakeGroupsListSize() {
        groupPresenter.loadGroups(false);
        verify(view).setProgressIndicator(false);
        assertEquals("La lista no coincide en tamaño", fakeApiService.getList().size(), 10);
    }

    @Test
    public void testSingleFakeGroupIntoList() {
        groupPresenter.loadGroups(false);
        verify(view).setProgressIndicator(false);
        assertEquals("No coincide el título con la posición", fakeApiService.getList().get(0).getId(), 1);
    }


}
