package com.costular.flatsharing.groups;

import com.costular.flatsharing.add_group.AddGroupContract;
import com.costular.flatsharing.add_group.AddGroupPresenter;
import com.costular.flatsharing.groups.GroupsContract;
import com.costular.flatsharing.groups.GroupsPresenter;

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
    private GroupsContract.View view;
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
