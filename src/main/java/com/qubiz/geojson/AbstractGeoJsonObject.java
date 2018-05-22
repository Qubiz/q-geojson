package com.qubiz.geojson;

import com.squareup.moshi.JsonWriter;

import java.io.IOException;

public abstract class AbstractGeoJsonObject {

    public enum GeoJsonObjectType {
        Feature,
        FeatureCollection,
        GeometryCollection,
        Point,
        MultiPoint,
        LineString,
        MultiLineString,
        Polygon,
        MultiPolygon
    }

    private final GeoJsonObjectType type;

    public AbstractGeoJsonObject(GeoJsonObjectType type) {
        this.type = type;
    }

    public GeoJsonObjectType getType() {
        return type;
    }

    public abstract void writeJsonObject(JsonWriter jsonWriter) throws IOException;
}

