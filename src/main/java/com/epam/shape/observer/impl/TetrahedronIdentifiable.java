package com.epam.shape.observer.impl;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.Observable;
import com.epam.shape.observer.Observer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronIdentifiable extends Tetrahedron implements Observable {
    private static final Logger LOGGER = Logger.getLogger(TetrahedronStore.class);

    private final Integer id;
    private final List<Observer> observers = new ArrayList<>();

    public TetrahedronIdentifiable(Integer id, Point pointA, Point pointB, Point pointC, Point pointD) {
        super(pointA, pointB, pointC, pointD);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void attach(Observer observer) throws TetrahedronException {
        observers.add(observer);
        notifyObservers();

        LOGGER.log(Level.INFO, String.format("Observer have been attached to tetrahedron id = %d", getId()));
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);

        LOGGER.log(Level.INFO, String.format("Observer have been detached to tetrahedron id = %d", getId()));
    }

    @Override
    public void notifyObservers() throws TetrahedronException {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void setPointA(Point pointA) throws TetrahedronException {
        super.setPointA(pointA);
        notifyObservers();
    }

    @Override
    public void setPointB(Point pointB) throws TetrahedronException {
        super.setPointB(pointB);
        notifyObservers();
    }

    @Override
    public void setPointC(Point pointC) throws TetrahedronException {
        super.setPointC(pointC);
        notifyObservers();
    }

    @Override
    public void setPointD(Point pointD) throws TetrahedronException {
        super.setPointD(pointD);
        notifyObservers();
    }
}
