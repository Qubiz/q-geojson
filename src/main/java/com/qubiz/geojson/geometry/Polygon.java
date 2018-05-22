package com.qubiz.geojson.geometry;

import com.qubiz.geojson.feature.Feature;
import com.qubiz.geojson.GeometryJsonObject;
import com.qubiz.geojson.geometry.exceptions.InvalidGeometryException;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.HashMap;

public class Polygon extends GeometryJsonObject {

    private final MultiLineString multiLineString;

    public Polygon(MultiLineString multiLineString) throws InvalidGeometryException {
        super(GeoJsonObjectType.Polygon);

        checkGeometry(multiLineString);

        this.multiLineString = multiLineString;
    }

    public MultiLineString getMultiLineString() {
        return multiLineString;
    }

    private void checkGeometry(MultiLineString multiLineString) throws InvalidGeometryException {
        for (LineString lineString : multiLineString.getImmutableLineStrings()) {
            if (!lineString.isClosed()) {
                if (lineString.getImmutablePoints().size() >= 4) {
                    throw new InvalidGeometryException(this, "The given LineString(s) should contain at least four " +
                            "Point elements (Currently only" + lineString.getImmutablePoints().size() + ").");
                } else {
                    throw new InvalidGeometryException(this, "The first and last Position of the given LineString(s) " +
                            "should be equivalent, they must contain identical values.");
                }
            }

            //TODO: Create a warning for when the exterior ring does not follow the LHR and for when the holes don't follow the RHR.
        }
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        multiLineString.writeContent(jsonWriter);
    }

    public Feature<Polygon> createFeature(HashMap<String, String> properties) {
        return new Feature<>(this, properties);
    }

}
