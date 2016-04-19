package com.epicodus.madlibs;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Guest on 4/19/16.
 */
public class MainActivityInstrumentationTest {

    public static Matcher<View> withHint(final String expectedHint) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View view) {
                if(!(view instanceof EditText)) {
                    return false;
                }
                String hint = ((EditText) view).getHint().toString();

                return expectedHint.equals(hint);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateBoringStory() {
        onView(withId(R.id.storyTypeSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Boring"))).perform(click());
        onView(withId(R.id.submitEntriesButton)).perform(click());
        onView(withId(R.id.workplaceEditText)).check(matches(withHint("Enter a workplace")));
    }
}
