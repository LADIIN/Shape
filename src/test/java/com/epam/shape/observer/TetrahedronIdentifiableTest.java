package com.epam.shape.observer;

import com.epam.shape.entity.Point;
import com.epam.shape.exception.TetrahedronException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

public class TetrahedronIdentifiableTest {
    private static final int Id = 1;

    @Test
    public void testAttachShouldAddObserverWhenIsValid() throws TetrahedronException {
        //given
        Observer observer = Mockito.mock(Observer.class);

        Point pointA = Mockito.mock(Point.class);
        Point pointB = Mockito.mock(Point.class);
        Point pointC = Mockito.mock(Point.class);
        Point pointD = Mockito.mock(Point.class);
        Integer id = 1;

        TetrahedronIdentifiable tetrahedron = new TetrahedronIdentifiable(id, pointA, pointB, pointC, pointD);

        //when
        tetrahedron.attach(observer);

        //then
        Assert.assertEquals(1, tetrahedron.getObservers().size());

    }

    @Test
    public void testDetachShouldRemoveObserverWhenIsValid() throws TetrahedronException {
        //given
        Observer observer = Mockito.mock(Observer.class);

        Point pointA = Mockito.mock(Point.class);
        Point pointB = Mockito.mock(Point.class);
        Point pointC = Mockito.mock(Point.class);
        Point pointD = Mockito.mock(Point.class);
        Integer id = 1;

        TetrahedronIdentifiable tetrahedron = new TetrahedronIdentifiable(id, pointA, pointB, pointC, pointD);

        //when
        tetrahedron.attach(observer);
        tetrahedron.detach(observer);

        //then
        Assert.assertEquals(0, tetrahedron.getObservers().size());
    }

    //TODO: Check how to test notifyObservers()

    @Test
    public void testNotifyShouldUpdateWhenIsValid() throws TetrahedronException {
        //given
        TetrahedronStore tetrahedronStore = Mockito.mock(TetrahedronStore.class);

        Point pointA = Mockito.mock(Point.class);
        Point pointB = Mockito.mock(Point.class);
        Point pointC = Mockito.mock(Point.class);
        Point pointD = Mockito.mock(Point.class);
        Integer id = 1;

        TetrahedronIdentifiable tetrahedron = new TetrahedronIdentifiable(id, pointA, pointB, pointC, pointD);

        //when
        tetrahedron.attach(tetrahedronStore);

        tetrahedron.notifyObservers();

        //then
        Map<Integer, TetrahedronParameters> parameters = tetrahedronStore.getParameters();

        TetrahedronParameters tetrahedronParameters = parameters.get(tetrahedron.getId());

        Assert.assertEquals(1,parameters.size());


    }


}
