package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestOption {
    private Option<SomeClass> defaultOption;

    @Before
    public void setUp() throws Exception {
        defaultOption = new Option<SomeClass>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Empty_Option_Has_No_Value() {
        Assert.assertFalse(Option.<SomeClass> createEmptyOption()
                .hasValue());
    }

    @Test
    public void Default_Option_IsEmpty() {
        Assert.assertEquals(Option.<SomeClass> createEmptyOption(),
                defaultOption);
    }

    @Test
    public void Non_Empty_Option_Has_Value() {
        Assert.assertTrue(new Option<SomeClass>(true, new SomeClass())
                .hasValue());
    }

    @Test
    public void Empty_Option_Value_Throws() {
        try {
            Option.<SomeClass> createEmptyOption().getValue();
            fail();
        } catch (IllegalAccessError e) {
            // nothing
        }
    }

    @Test
    public void Non_Empty_Option_Returns_Its_Value() {
        SomeClass value = new SomeClass();
        Assert.assertTrue(value == new Option<SomeClass>(true, value)
                .getValue());
    }

    @Test
    public void From_Value_Returns_Empty_For_Null() {
        Assert.assertEquals(Option.<SomeClass> createEmptyOption(),
                Option.<SomeClass> fromValue(null));
    }

    @Test
    public void From_Value_Return_Its_Value() {
        SomeClass value = new SomeClass();
        Assert.assertTrue(value == Option.<SomeClass> fromValue(value)
                .getValue());
    }

    @Test
    public void Empty_Option_ValueOrElse_Evaluates_Else_Branch() {
        final SomeClass expected = new SomeClass();
        Assert.assertTrue(expected == Option
                .<SomeClass> createEmptyOption().valueOrElse(
                        new IValueProvider<SomeClass>() {
                            @Override
                            public SomeClass getValue() {
                                return expected;
                            }
                        }));
    }

    @Test
    public void Empty_Option_ValueOrElse_Does_Not_Evaluates_Else_Branch() {
        SomeClass expected = new SomeClass();
        final SomeClass notExpected = new SomeClass();
        Assert.assertTrue(expected == new Option<SomeClass>(true, expected)
                .valueOrElse(new IValueProvider<SomeClass>() {
                    @Override
                    public SomeClass getValue() {
                        return notExpected;
                    }
                }));
    }
}
