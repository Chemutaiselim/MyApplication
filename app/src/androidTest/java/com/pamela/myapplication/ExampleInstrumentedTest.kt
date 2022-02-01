package com.pamela.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString

import org.junit.Test
import org.junit.runner.RunWith


import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
/*@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.pamela.myapplication", appContext.packageName)
    }
}*/
@RunWith(AndroidJUnit4::class)
class CalculatorTests{
    // Tells the device to launch an activity specified
    @get:Rule()
    val activity= ActivityScenarioRule(MainActivity::class.java)

    //Test Logic
    @Test
    fun calculate_20_percent_tip(){

        //To get the editText and type 50.00 on the EditText View
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("56.00"))

            //To click the buttonView
        onView(withId(R.id.calculate_button))
            .perform(click())

        //To compare the result with 10.00

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("12.00"))))

        onView(withId(R.id.round_up_switch))
            .perform(click())

        //To click the buttonView
        onView(withId(R.id.calculate_button))
            .perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("11.20"))))



    }

    @Test
    fun calculate_18_percent_tip(){

        //To get the editText and type 50.00 on the EditText View
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        //press 18%
        onView(withId(R.id.option_eighteen_percent)).perform(click())

        //To click the buttonView
        onView(withId(R.id.calculate_button))
            .perform(click())

        //To compare the result with 10.00

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("9.00"))))

    }

    @Test
    fun calculate_15_percent_tip(){

        //To get the editText and type 50.00 on the EditText View
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        //press 15%
        onView(withId(R.id.option_fifteen_percent)).perform(click())

        //To click the buttonView
        onView(withId(R.id.calculate_button))
            .perform(click())

        //To compare the result with 10.00

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("8.00"))))


    }


}