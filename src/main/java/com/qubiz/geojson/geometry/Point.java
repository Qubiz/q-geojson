package com.qubiz.geojson.geometry;

import com.qubiz.geojson.feature.Feature;
import com.qubiz.geojson.GeometryJsonObject;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.HashMap;

public class Point extends GeometryJsonObject {

    private final Position position;

    public Point(Position position) {
        super(GeoJsonObjectType.Point);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        position.writeContent(jsonWriter);
    }

    public Feature<Point> createFeature(HashMap<String, String> properties) {
        return new Feature<>(this, properties);
    }
}
