package com.example.assignment11;
//create generic Repository<T> class that can manage collections of any entity type
import java.util.*;
import java.util.function.Predicate;


public class Repository<T> {
    //implement methods for adding, retrieving, and filtering items
    //use proper bounded type parameters where appropriate
    //include error handling for invalid data operations
    private List<T> items;

    //constructor
    public Repository() {
        this.items = new ArrayList<>();
    }

    //create empty class to handle empty value errors
    public static class EmptyException extends RuntimeException {
        public EmptyException() {
            super();
        }

        public EmptyException(String error) {
            super(error);
        }
    }


    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public void add(T item) {
        //no empty items can be added
        if (item == null) {
            throw new EmptyException("Item cannot be empty");
        }
        items.add(item);
    }

    public List<T> filter(Predicate<T> predicate) {
        //no empty items can be filtered
        if (predicate == null) {
            throw new EmptyException("Filter predicate cannot be empty");
        }

        List<T> newList = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                newList.add(item);
            }
        }
        return newList;
    }
}
