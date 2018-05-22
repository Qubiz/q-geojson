package com.qubiz.geojson.geometry;

import com.qubiz.geojson.feature.Feature;
import com.qubiz.geojson.GeometryJsonObject;
import com.qubiz.geojson.geometry.exceptions.InvalidGeometryException;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LineString extends GeometryJsonObject {

    private List<Point> points;

    public LineString(List<Point> points) throws InvalidGeometryException {
        super(GeoJsonObjectType.LineString);

        if (points.size() < 2) {
            throw new InvalidGeometryException(this, "A LineString should have at least two Point elements (Currently " + points.size() + ").");
        }

        this.points = points;
    }

    public LineString(Point ... points) throws InvalidGeometryException {
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

    public boolean isClosed() {
        return points.size() >= 4 && points.get(0).getPosition().equals(points.get(points.size() - 1).getPosition());
    }

    public Feature<LineString> createFeature(HashMap<String, String> properties) {
        return new Feature<>(this, properties);
    }
}
