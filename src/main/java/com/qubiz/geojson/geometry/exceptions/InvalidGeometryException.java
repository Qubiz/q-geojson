package com.qubiz.geojson.geometry.exceptions;

import com.qubiz.geojson.GeometryJsonObject;

public class InvalidGeometryException extends Exception {

    public InvalidGeometryException(GeometryJsonObject geometryJsonObject, String message) {
        super("\n\nInvalid " + geometryJsonObject.getType() + ":\n" + message + "\n");
    }

}
