package com.example.java8feature;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.example.java8feature.dto.Customer;

public class CustomerTest {

    @Test
    public void test() {
        fail("Not yet implemented");
    }

    @Test
    public void testCustmer() {
        Customer cust = new Customer(1L, "test");
        Assert.assertEquals("test", cust.getFirstname());
    }
}
