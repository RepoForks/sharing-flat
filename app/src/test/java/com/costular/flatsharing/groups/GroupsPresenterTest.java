package com.costular.flatsharing.groups;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by diego on 8/12/15.
 */
public class GroupsPresenterTest {

    @Mock
    private GroupsContract.MyView view;
    private GroupsPresenter groupPresenter;

    @Before
    public void setupAddNotesPresenter() {
        MockitoAnnotations.initMocks(this);
        groupPresenter = new GroupsPresenter(view);
    }

    @Test
    public void testAddGroupButton() {
        groupPresenter.addNewGroup();
        verify(view).showAddGroup();
    }
}
