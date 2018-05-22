package com.qubiz.geojson.geometry;

import com.qubiz.geojson.writer.ContentWriter;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;

public class Position implements ContentWriter {

    private final double latitude;
    private final double longitude;
    private final double altitude;

    public Position(double longitude, double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = Double.NaN;
    }

    public Position(double longitude, double latitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public void writeContent(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginArray();
        jsonWriter.value(longitude);
        jsonWriter.value(latitude);
        if (altitude != Double.NaN) {
            jsonWriter.value(altitude);
        }
        jsonWriter.endArray();
    }
}
