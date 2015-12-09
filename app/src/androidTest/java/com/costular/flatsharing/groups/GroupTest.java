package com.costular.flatsharing.groups;

import android.support.test.espresso.Espresso;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.costular.flatsharing.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by diego on 7/12/15.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class GroupTest {

    @Test
    public void testAddGroupFabButton() throws Exception{
        onView(withId(R.id.fab_add_group)).perform(click());
        onView(withId(R.id.add_group_title)).check(matches(isDisplayed()));
    }

    @Test
    public void testAddGroupAndSave() throws Exception {
        String title = "Test title";
        String description = "Esto es una prueba";

        onView(withId(R.id.fab_add_group)).perform(click());

        onView(withId(R.id.add_group_title)).perform(typeText(title));
        onView(withId(R.id.add_group_description)).perform(typeText(description), closeSoftKeyboard());

        onView(withId(R.id.action_done)).perform(click());
        //Aquí hacemos scroll
    }
}
