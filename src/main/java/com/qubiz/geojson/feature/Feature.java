package com.qubiz.geojson.feature;

import com.qubiz.geojson.GeoJsonObject;
import com.qubiz.geojson.GeometryJsonObject;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.Map;

public class Feature<T extends GeometryJsonObject> extends GeoJsonObject {

    private final T geometry;
    private final Map<String, String> properties;

    public Feature(T geometry, Map<String, String> properties) {
        super(GeoJsonObjectType.Feature);
        this.geometry = geometry;
        this.properties = properties;
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("geometry");
        geometry.writeJsonObject(jsonWriter);
        jsonWriter.name("properties");
        jsonWriter.beginObject();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            jsonWriter.name(entry.getKey()).value(entry.getValue());
        }
        jsonWriter.endObject();
    }

}
