package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines assignable colors for different feature styles, such as POI, LOI and AOI colors.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T16:25:00.685068500+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public enum ColorType implements Serializable {
  
  WHITE("white"),
  
  RED("red"),
  
  ORANGE("orange"),
  
  BEIGE("beige"),
  
  GREEN("green"),
  
  BLUE("blue"),
  
  PURPLE("purple"),
  
  PINK("pink"),
  
  GRAY("gray"),
  
  BLACK("black");

  private final String value;

  ColorType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ColorType fromValue(String value) {
    for (ColorType b : ColorType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

