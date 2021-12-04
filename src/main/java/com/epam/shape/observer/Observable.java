package com.epam.shape.observer;

import com.epam.shape.exception.TetrahedronException;

public interface Observable {
    void attach(Observer observer) throws TetrahedronException;

    void detach(Observer observer);

    void notifyObservers() throws TetrahedronException;
}

