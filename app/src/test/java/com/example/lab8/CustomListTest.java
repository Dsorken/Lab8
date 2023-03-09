package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();
        City city = new City("Edmonton", "Alberta");
        boolean result = cityList.hasCity(city);
        assertTrue(result);
    }

    @Test
    void testDelete() {
        CustomList cityList = MockCityList();
        City city = mockCity();
        cityList.addCity(city);
        cityList.delete(city);
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void testDeleteException() {
        CustomList cityList = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        assertThrows( IllegalArgumentException.class, () -> {
            cityList.delete(city); });
    }

    @Test
    void testCountCities() {
        CustomList cityList = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
    }

}
