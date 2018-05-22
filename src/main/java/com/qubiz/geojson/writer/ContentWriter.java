package com.qubiz.geojson.writer;

import com.squareup.moshi.JsonWriter;

import java.io.IOException;

public interface ContentWriter {
    void writeContent(JsonWriter jsonWriter) throws IOException;
}
