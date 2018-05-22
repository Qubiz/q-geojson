package com.qubiz.geojson.geometry;

import com.qubiz.geojson.feature.Feature;
import com.qubiz.geojson.GeometryJsonObject;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MultiLineString extends GeometryJsonObject {

    private final List<LineString> lineStrings;

    public MultiLineString(List<LineString> lineStrings) {
        super(GeoJsonObjectType.MultiLineString);

        this.lineStrings = lineStrings;
    }

    public MultiLineString(LineString ... lineStrings) {
        this(Arrays.asList(lineStrings));
    }

    public List<LineString> getImmutableLineStrings() {
        return Collections.unmodifiableList(lineStrings);
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginArray();
        for (LineString lineString : lineStrings) {
            lineString.writeContent(jsonWriter);
        }
        jsonWriter.endArray();
    }

    public Feature<MultiLineString> createFeature(HashMap<String, String> properties) {
        return new Feature<>(this, properties);
    }
}
