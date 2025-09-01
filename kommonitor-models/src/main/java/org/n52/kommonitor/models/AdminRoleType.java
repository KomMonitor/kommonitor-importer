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
 * Permissions for administrative tasks regarding resources, themes and users
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T12:23:47.117824300+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public enum AdminRoleType implements Serializable {
  
  CLIENT_USERS_CREATOR("client-users-creator"),
  
  UNIT_USERS_CREATOR("unit-users-creator"),
  
  CLIENT_RESOURCES_CREATOR("client-resources-creator"),
  
  UNIT_RESOURCES_CREATOR("unit-resources-creator"),
  
  CLIENT_THEMES_CREATOR("client-themes-creator"),
  
  UNIT_THEMES_CREATOR("unit-themes-creator");

  private final String value;

  AdminRoleType(String value) {
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
  public static AdminRoleType fromValue(String value) {
    for (AdminRoleType b : AdminRoleType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

