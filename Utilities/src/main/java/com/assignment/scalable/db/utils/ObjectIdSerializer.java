package com.assignment.scalable.db.utils;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ObjectIdSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
		gen.writeEmbeddedObject(new ObjectId(value.toString()));
	}

}
