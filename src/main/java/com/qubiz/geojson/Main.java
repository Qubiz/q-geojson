package com.qubiz.geojson;

import com.qubiz.geojson.geometry.*;
import com.qubiz.geojson.geometry.exceptions.InvalidGeometryException;
import com.squareup.moshi.JsonWriter;
import okio.Buffer;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException, InvalidGeometryException {
        HashMap<String, String> properties = new HashMap<>();
        properties.put("date", "");
        properties.put("vehicle", "");
        properties.put("temperature", "");
        properties.put("id", "");


    }

}
