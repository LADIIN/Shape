package com.epam.shape.service;


import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;

public class TetrahedronServiceImpl implements TetrahedronService {

    @Override
    public double calculateArea(Tetrahedron tetrahedron) {

//        if(tetrahedron == null){
//            throw new TetrahedronException("Object must be no-null.");
//        }

        Point vectorAB = calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointB());
        Point vectorAC = calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointC());
        Point vectorAD = calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointD());
        Point vectorBC = calculateCoordinates(tetrahedron.getPointB(), tetrahedron.getPointC());
        Point vectorBD = calculateCoordinates(tetrahedron.getPointB(), tetrahedron.getPointD());

        double sideABC = calculateSideArea(vectorAB, vectorAC);
        double sideABD = calculateSideArea(vectorAB, vectorAD);
        double sideACD = calculateSideArea(vectorAC, vectorAD);
        double sideBCD = calculateSideArea(vectorBC, vectorBD);

        return sideABC + sideABD + sideACD + sideBCD;
    }

    @Override
    public double calculateVolume(Tetrahedron tetrahedron) {
        Point vectorAB = calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointB());
        Point vectorAC = calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointC());
        Point vectorAD = calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointD());

        double determinant = calculateDeterminantForVectors(vectorAB, vectorAC, vectorAD);

        return determinant / 6;
    }

    //TODO: Add enum "Axis" to vary axis in function parameters

    public double calculateVolumeRation(Tetrahedron tetrahedron, Point intersectionA,
                                        Point intersectionB, Point intersectionC) {
        Tetrahedron smallTetrahedron = new Tetrahedron(intersectionA,
                intersectionB, intersectionC, tetrahedron.getPointD());

        double firstPartVolume = calculateVolume(smallTetrahedron);
        double secondPartVolume = calculateVolume(tetrahedron) - firstPartVolume;

        return firstPartVolume / secondPartVolume;
    }

    private double calculateDeterminantForVectors(Point vectorA, Point vectorB, Point vectorC) {

        return vectorA.getX() * (vectorB.getY() * vectorC.getZ() - vectorC.getY() * vectorB.getZ())
                - vectorB.getX() * (vectorA.getY() * vectorC.getZ() - vectorC.getY() * vectorA.getZ())
                + vectorC.getX() * (vectorA.getY() * vectorB.getZ() - vectorB.getY() * vectorA.getZ());
    }

    private double calculateSideArea(Point vectorA, Point vectorB) {
        double sideA = Math.sqrt(Math.pow(vectorA.getX(), 2) + Math.pow(vectorA.getY(), 2)
                + Math.pow(vectorA.getZ(), 2));

        double sideB = Math.sqrt(Math.pow(vectorB.getX(), 2) + Math.pow(vectorB.getY(), 2)
                + Math.pow(vectorB.getZ(), 2));

        double cosine = (vectorA.getX() * vectorB.getX() + vectorA.getY() * vectorB.getY()
                + vectorA.getZ() * vectorB.getZ()) / (sideA * sideB);

        double sinus = Math.sqrt(1 - Math.pow(cosine, 2));

        return sideA * sideB * sinus / 2;
    }

    private Point calculateCoordinates(Point pointA, Point pointB) {
        double x = pointA.getX() - pointB.getX();
        double y = pointA.getY() - pointB.getY();
        double z = pointA.getZ() - pointB.getZ();

        return new Point(x, y, z);
    }
}
