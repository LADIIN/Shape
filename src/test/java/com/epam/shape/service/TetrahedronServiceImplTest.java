package com.epam.shape.service;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.service.impl.TetrahedronServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class TetrahedronServiceImplTest {
    @Test
    public void testAddShouldCalculateAreaWhenCorrectPoints() throws TetrahedronException {
        //given
        Point pointA = new Point(-2, -1, 1);
        Point pointB = new Point(5, 5, 4);
        Point pointC = new Point(3, 2, -1);
        Point pointD = new Point(4, 1, 5);

        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        TetrahedronServiceImpl tetrahedronService = new TetrahedronServiceImpl();

        //when
        double area = tetrahedronService.calculateArea(tetrahedron);

        //then
        Assert.assertEquals(64.134, area, 0.001);
    }

    @Test
    public void testAddShouldCalculateVolumeWhenCorrectPoints() throws TetrahedronException {
        //given
        Point pointA = new Point(14, 4, 5);
        Point pointB = new Point(-5, -3, 2);
        Point pointC = new Point(-2, -6, -3);
        Point pointD = new Point(-2, 2, -1);

        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        TetrahedronServiceImpl tetrahedronService = new TetrahedronServiceImpl();

        //when
        double volume = tetrahedronService.calculateVolume(tetrahedron);

        //then
        Assert.assertEquals(112.67, volume, 0.01);
    }

    @Test
    public void testAddShouldCalculateRationWhenCorrectIntersectionPoints() throws TetrahedronException {
        //given
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(0, 1, 0);
        Point pointD = new Point(0, 0, 1);

        Point intersectionA = new Point(0.5, 0, 0);
        Point intersectionB = new Point(0, 0.5, 0);
        Point intersectionC = new Point(0, 0, 0.5);

        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        TetrahedronServiceImpl tetrahedronService = new TetrahedronServiceImpl();

        //when
        double ratio = tetrahedronService.calculateVolumeRation(tetrahedron, intersectionA, intersectionB, intersectionC);

        //then
        Assert.assertEquals(0.142, ratio, 0.001);

    }
}
