package com.qubiz.geojson.geometry;

import com.qubiz.geojson.feature.Feature;
import com.qubiz.geojson.GeometryJsonObject;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MultiPoint extends GeometryJsonObject {

    private final List<Point> points;

    public MultiPoint(List<Point> points) {
        super(GeoJsonObjectType.MultiPoint);
        this.points = points;
    }

    public MultiPoint(Point ... points) {
        this(Arrays.asList(points));
    }

    public List<Point> getImmutablePoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginArray();
        for (Point point : points) {
            point.writeContent(jsonWriter);
        }
        jsonWriter.endArray();
    }

    public Feature<MultiPoint> createFeature(HashMap<String, String> properties) {
        return new Feature<>(this, properties);
    }
}
