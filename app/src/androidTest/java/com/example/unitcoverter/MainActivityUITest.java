package com.example.unitcoverter;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
    }

    /*@Test
    public void can_enter_pounds() {
        onView(withId(R.id.converter_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("20.41 kg")));
    }

    @Test
    public void should_not_enter_empty_lbs() {
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("kg")));
    }*/

    @Test
    public void can_select_fahrenheit_to_celsius(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("fahrenheit to celsius")).perform(click());
    }

    @Test
    public void can_enter_fahrenheit(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("fahrenheit to celsius")).perform(click());
        onView(withId(R.id.converter_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("7.22 ºC")));
    }

    @Test
    public void should_not_enter_empty_fahrenheit(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("fahrenheit to celsius")).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("")));
    }
    @Test
    public void can_select_pounds_to_kilograms(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("pounds to kilograms")).perform(click());
    }
    @Test
    public void can_enter_pounds(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("pounds to kilograms")).perform(click());
        onView(withId(R.id.converter_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("20.41 kg")));
    }

    @Test
    public void should_not_enter_empty_pounds() {
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("pounds to kilograms")).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("")));
    }
    @Test
    public void can_select_miles_to_kilometers(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("miles to kilometers")).perform(click());
    }
    @Test
    public void can_enter_miles(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("miles to kilometers")).perform(click());
        onView(withId(R.id.converter_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("72.42 km")));
    }

    @Test
    public void should_not_enter_empty_miles() {
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("miles to kilometers")).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("")));
    }
    @Test
    public void can_select_feet_to_meters(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("feet to meters")).perform(click());
    }
    @Test
    public void can_enter_feet(){
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("feet to meters")).perform(click());
        onView(withId(R.id.converter_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("13.72 m")));
    }

    @Test
    public void should_not_enter_empty_feet() {
        onView(withId(R.id.conversion_select)).perform(click());
        onView(withText("feet to meters")).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_text)).check(matches(withText("")));
    }


}