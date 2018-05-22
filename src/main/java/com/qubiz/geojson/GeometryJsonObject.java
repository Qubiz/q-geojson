package com.qubiz.geojson;

import com.qubiz.geojson.writer.ContentWriter;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;

public abstract class GeometryJsonObject extends AbstractGeoJsonObject implements ContentWriter {

    public GeometryJsonObject(GeoJsonObjectType type) {
        super(type);
    }

    @Override
    public void writeJsonObject(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("type").value(getType().toString());
        if (getType().equals(GeoJsonObjectType.GeometryCollection)) {
            jsonWriter.name("geometries");
        } else {
            jsonWriter.name("coordinates");
        }
        writeContent(jsonWriter);
        jsonWriter.endObject();
    }
}
