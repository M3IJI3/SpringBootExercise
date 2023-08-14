package com.csis3275.finalexam.repository.Item;

import java.util.List;

public interface ItemDAOInterface<T> {
    List<T> getAllItems();
}
