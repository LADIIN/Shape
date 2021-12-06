package com.epam.shape.observer;

import com.epam.shape.calculator.TetrahedronCalculator;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;
import com.epam.shape.observer.impl.TetrahedronParameters;
import com.epam.shape.observer.impl.TetrahedronStore;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;


public class TetrahedronStoreTest {
    private static final double AREA = 1;
    private static final double VOLUME = 1;
    private static final double DELTA = 0.01;
    private static final int AMOUNT = 1;

    @Test
    public void testUpdateShouldUpdateObjectWhenFieldIsUpdated() throws TetrahedronException {
        //given
        TetrahedronIdentifiable tetrahedron = Mockito.mock(TetrahedronIdentifiable.class);
        Mockito.when(tetrahedron.getId()).thenReturn(1);

        TetrahedronCalculator tetrahedronCalculator = Mockito.mock(TetrahedronCalculator.class);
        Mockito.when(tetrahedronCalculator.calculateArea(tetrahedron)).thenReturn(AREA);
        Mockito.when(tetrahedronCalculator.calculateVolume(tetrahedron)).thenReturn(VOLUME);

        TetrahedronStore tetrahedronStore = TetrahedronStore.getInstance();
        tetrahedronStore.setTetrahedronCalculator(tetrahedronCalculator);

        //when
        tetrahedronStore.update(tetrahedron);

        //then
        Map<Integer, TetrahedronParameters> parameters = tetrahedronStore.getParameters();

        Assert.assertEquals(AMOUNT, parameters.size());

        TetrahedronParameters tetrahedronParameters = parameters.get(tetrahedron.getId());

        Assert.assertEquals(AREA, tetrahedronParameters.getSurfaceArea(), DELTA);
        Assert.assertEquals(VOLUME, tetrahedronParameters.getVolume(), DELTA);

    }
}
