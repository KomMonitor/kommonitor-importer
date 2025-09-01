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
 * Definition of an additional parameter that is either required for retrieving a dataset from a certain datsource | or for converting the dataset in a certain format (e.g. separator for CSV-based datasets)
 */

@Schema(name = "ParameterType", description = "Definition of an additional parameter that is either required for retrieving a dataset from a certain datsource | or for converting the dataset in a certain format (e.g. separator for CSV-based datasets)")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T12:23:45.798187400+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class ParameterType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private @Nullable String description;

  private @Nullable Boolean mandatory;

  /**
   * type of the parameter
   */
  public enum TypeEnum {
    STRING("string"),
    
    NUMBER("number"),
    
    BOOLEAN("boolean"),
    
    ARRAY("array");

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

  private @Nullable TypeEnum type;

  public ParameterType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ParameterType(String name) {
    this.name = name;
  }

  public ParameterType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the parameter
   * @return name
   */
  @NotNull 
  @Schema(name = "name", description = "name of the parameter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ParameterType description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * description of the parameter
   * @return description
   */
  
  @Schema(name = "description", description = "description of the parameter", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public ParameterType mandatory(@Nullable Boolean mandatory) {
    this.mandatory = mandatory;
    return this;
  }

  /**
   * indicates wether the parameter is mandatory or optional
   * @return mandatory
   */
  
  @Schema(name = "mandatory", description = "indicates wether the parameter is mandatory or optional", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mandatory")
  public @Nullable Boolean getMandatory() {
    return mandatory;
  }

  public void setMandatory(@Nullable Boolean mandatory) {
    this.mandatory = mandatory;
  }

  public ParameterType type(@Nullable TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * type of the parameter
   * @return type
   */
  
  @Schema(name = "type", description = "type of the parameter", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public @Nullable TypeEnum getType() {
    return type;
  }

  public void setType(@Nullable TypeEnum type) {
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
    ParameterType parameterType = (ParameterType) o;
    return Objects.equals(this.name, parameterType.name) &&
        Objects.equals(this.description, parameterType.description) &&
        Objects.equals(this.mandatory, parameterType.mandatory) &&
        Objects.equals(this.type, parameterType.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, mandatory, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParameterType {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    mandatory: ").append(toIndentedString(mandatory)).append("\n");
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

