package com.epam.shape.observer;

import com.epam.shape.entity.Tetrahedron;

public interface Observer {
    void update(Tetrahedron tetrahedron);
}
