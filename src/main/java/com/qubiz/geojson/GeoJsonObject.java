package com.qubiz.geojson;

import com.qubiz.geojson.writer.ContentWriter;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;

public abstract class GeoJsonObject extends AbstractGeoJsonObject implements ContentWriter {

    public GeoJsonObject(GeoJsonObjectType type) {
        super(type);
    }

    public void writeJsonObject(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("type").value(getType().toString());
        writeContent(jsonWriter);
        jsonWriter.endObject();
    }

}
