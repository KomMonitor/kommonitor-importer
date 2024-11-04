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
 * the poi marker type, either text or symbol
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-04T15:30:32.738846500+01:00[Europe/Berlin]")
public enum PoiMarkerStyleEnum {
  
  TEXT("text"),
  
  SYMBOL("symbol");

  private String value;

  PoiMarkerStyleEnum(String value) {
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
  public static PoiMarkerStyleEnum fromValue(String value) {
    for (PoiMarkerStyleEnum b : PoiMarkerStyleEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

