package com.example.java8feature.innercollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

public class FilterInnerList {

    public static void main(String[] args) {
        filetrInnerListElements();
    }

    /**
     * Below logic will filter out the outer list(Customer) if any of the inner filter matches
     */
    private static List<Customer> filetrOuterListBasedOnInnerList() {
        List<Customer> customerList = getCustomerList();
        System.out.println("Before Customer Count>>>>>>>>> " + customerList.size());
        for (Customer customer3 : customerList) {
            System.out.println("Before Items count >>>>>>>>> " + customer3.getObjectName() + " >>>>>>> "
                    + CollectionUtils.size(customer3.getOrders()));
        }
        List<Customer> newCustomerList = getCustomerList()
                .stream()
                .filter(cust -> CollectionUtils.size(cust.getOrders().stream()
                        .filter(itm -> Objects.isNull(itm.getOrderCompletionDate())).collect(Collectors.toList())) > 0)
                .collect(Collectors.toList());
        System.out.println("After >>>>>>>>> " + newCustomerList.size());
        for (Customer customer3 : newCustomerList) {
            System.out.println("Before Items count >>>>>>>>> " + customer3.getObjectName() + " >>>>>>> "
                    + CollectionUtils.size(customer3.getOrders()));
        }
        return newCustomerList;

        // Console Output :
        /*
         * Before Customer Count>>>>>>>>> 3 Before Items count >>>>>>>>> customer >>>>>>> 1 Before Items count >>>>>>>>>
         * customer1 >>>>>>> 3 Before Items count >>>>>>>>> customer2 >>>>>>> 1 After >>>>>>>>> 2 Before Items count
         * >>>>>>>>> customer1 >>>>>>> 3 Before Items count >>>>>>>>> customer2 >>>>>>> 1
         */
    }

    /**
     *  This method will filter inner list(Orders), all those order which are completed will be filtered out 
     *  and open orders will be returned and then outer list(customer) will be filtered if it doesn't have any open order. 
     */
    private static List<Customer> filetrInnerListElements() {
        List<Customer> customerList = getCustomerList();
        System.out.println("Before Customer Count>>>>>>>>> " + customerList.size());
        for (Customer customer3 : customerList) {
            System.out.println("Before Items count >>>>>>>>> " + customer3.getObjectName() + " >>>>>>> "
                    + CollectionUtils.size(customer3.getOrders()));
        }

        List<Customer> newCustomerList = customerList
                .stream()
                .map(cust -> {
                    List<Order> orders = cust.getOrders().stream()
                            .filter(ordr -> Objects.isNull(ordr.getOrderCompletionDate())).collect(Collectors.toList());
                    cust.setOrders(orders);
                    return cust;
                }).filter(cust -> CollectionUtils.size(cust.getOrders()) > 0).collect(Collectors.toList());

        System.out.println("After >>>>>>>>> " + newCustomerList.size());
        for (Customer customer3 : newCustomerList) {
            System.out.println("Before Items count >>>>>>>>> " + customer3.getObjectName() + " >>>>>>> "
                    + CollectionUtils.size(customer3.getOrders()));
        }
        return newCustomerList;
        // Console Output :
        /*
         * Before Customer Count>>>>>>>>> 3 Before Items count >>>>>>>>> customer >>>>>>> 1 Before Items count >>>>>>>>>
         * customer1 >>>>>>> 3 Before Items count >>>>>>>>> customer2 >>>>>>> 1 After >>>>>>>>> 2 Before Items count
         * >>>>>>>>> customer1 >>>>>>> 1 Before Items count >>>>>>>>> customer2 >>>>>>> 1
         */
    }

    private static List<Customer> getCustomerList() {
        Order order = new Order();
        order.setObjectName("order");
        order.setOrderCompletionDate(new Date());
        Customer customer = new Customer();
        customer.setObjectName("customer");
        customer.setOrders(Arrays.asList(order));

        Order order11 = new Order();
        order11.setObjectName("order11");
        order11.setOrderCompletionDate(new Date());

        Order order12 = new Order();
        order12.setObjectName("order12");
        order12.setOrderCompletionDate(new Date());

        Order order13 = new Order();
        order13.setObjectName("order13");

        Customer customer1 = new Customer();
        customer1.setObjectName("customer1");
        customer1.setOrders(Arrays.asList(order11, order12, order13));

        Order order2 = new Order();
        Customer customer2 = new Customer();
        customer2.setObjectName("customer2");
        customer2.setOrders(Arrays.asList(order2));

        return Arrays.asList(customer, customer1, customer2);
    }

    public static class Customer {
        String objectName;
        List<Order> orders = new ArrayList<>();

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }
    }

    public static class Order {
        String objectName;
        public Date orderCompletionDate;

        public Date getOrderCompletionDate() {
            return orderCompletionDate;
        }

        public void setOrderCompletionDate(Date orderCompletionDate) {
            this.orderCompletionDate = orderCompletionDate;
        }

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

    }
}
