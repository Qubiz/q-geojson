package com.qubiz.geojson.geometry;

import com.qubiz.geojson.feature.Feature;
import com.qubiz.geojson.GeometryJsonObject;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MultiPolygon extends GeometryJsonObject {

    private final List<Polygon> polygons;

    public MultiPolygon(List<Polygon> polygons) {
        super(GeoJsonObjectType.MultiPolygon);

        this.polygons = polygons;
    }

    public List<Polygon> getPolygons() {
        return Collections.unmodifiableList(polygons);
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginArray();
        for(Polygon polygon : polygons) {
            polygon.writeContent(jsonWriter);
        }
        jsonWriter.endArray();
    }

    public Feature<MultiPolygon> createFeature(HashMap<String, String> properties) {
        return new Feature<>(this, properties);
    }
}
