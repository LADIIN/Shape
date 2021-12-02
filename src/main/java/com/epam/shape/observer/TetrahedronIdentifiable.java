package com.epam.shape.observer;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronIdentifiable extends Tetrahedron implements Observable {
    private final Integer id;
    private final List<Observer> observers = new ArrayList<>();

    public TetrahedronIdentifiable(Integer id, Point pointA, Point pointB, Point pointC, Point pointD) {
        super(pointA, pointB, pointC, pointD);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setPointA(Point pointA) {
        super.setPointA(pointA);
        notifyObservers();
    }

    @Override
    public void setPointB(Point pointB) {
        super.setPointB(pointB);
        notifyObservers();
    }

    @Override
    public void setPointC(Point pointC) {
        super.setPointC(pointC);
        notifyObservers();
    }

    @Override
    public void setPointD(Point pointD) {
        super.setPointD(pointD);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
