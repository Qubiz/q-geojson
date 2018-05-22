package com.qubiz.geojson.geometry;

import com.qubiz.geojson.feature.Feature;
import com.qubiz.geojson.GeometryJsonObject;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GeometryCollection extends GeometryJsonObject {

    private final List<GeometryJsonObject> geometries;

    public GeometryCollection(List<GeometryJsonObject> geometries) {
        super(GeoJsonObjectType.GeometryCollection);

        this.geometries = geometries;
    }

    public GeometryCollection(GeometryJsonObject ... geometries) {
        this(Arrays.asList(geometries));
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginArray();
        for (GeometryJsonObject geometryJsonObject : geometries) {
            geometryJsonObject.writeJsonObject(jsonWriter);
        }
        jsonWriter.endArray();
    }

    public Feature<GeometryCollection> createFeature(HashMap<String, String> properties) {
        return new Feature<>(this, properties);
    }
}
