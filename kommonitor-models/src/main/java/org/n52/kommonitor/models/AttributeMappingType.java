package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Definitions for mapping of additional attributes of datasets from a data source
 */

@Schema(name = "AttributeMappingType", description = "Definitions for mapping of additional attributes of datasets from a data source")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T16:24:59.129000700+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class AttributeMappingType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private @Nullable String mappingName;

  /**
   * data type of the parameter
   */
  public enum TypeEnum {
    STRING("string"),
    
    INTEGER("integer"),
    
    FLOAT("float"),
    
    DATE("date");

    private final String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  public AttributeMappingType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributeMappingType(String name, TypeEnum type) {
    this.name = name;
    this.type = type;
  }

  public AttributeMappingType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the attribute from the origin dataset
   * @return name
   */
  @NotNull 
  @Schema(name = "name", description = "name of the attribute from the origin dataset", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AttributeMappingType mappingName(@Nullable String mappingName) {
    this.mappingName = mappingName;
    return this;
  }

  /**
   * name that should be used for importing the attribute into KomMonitor
   * @return mappingName
   */
  
  @Schema(name = "mappingName", description = "name that should be used for importing the attribute into KomMonitor", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mappingName")
  public @Nullable String getMappingName() {
    return mappingName;
  }

  public void setMappingName(@Nullable String mappingName) {
    this.mappingName = mappingName;
  }

  public AttributeMappingType type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * data type of the parameter
   * @return type
   */
  @NotNull 
  @Schema(name = "type", description = "data type of the parameter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttributeMappingType attributeMappingType = (AttributeMappingType) o;
    return Objects.equals(this.name, attributeMappingType.name) &&
        Objects.equals(this.mappingName, attributeMappingType.mappingName) &&
        Objects.equals(this.type, attributeMappingType.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mappingName, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeMappingType {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mappingName: ").append(toIndentedString(mappingName)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

