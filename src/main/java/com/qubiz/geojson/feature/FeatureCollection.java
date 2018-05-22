package com.qubiz.geojson.feature;

import com.qubiz.geojson.GeoJsonObject;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FeatureCollection extends GeoJsonObject {

    private final List<Feature> features;

    public FeatureCollection(List<Feature> features) {
        super(GeoJsonObjectType.FeatureCollection);
        this.features = features;
    }

    public FeatureCollection(Feature ... features) {
        this(Arrays.asList(features));
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("feature");
        jsonWriter.beginArray();
        for (Feature feature : features) {
            feature.writeJsonObject(jsonWriter);
        }
        jsonWriter.endArray();
    }
}
