package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Additional parameter as key-value-pair that is either required for retrieving a dataset from a certain datsource | or for converting the dataset in a certain format (e.g. separator for CSV-based datasets)
 */

@Schema(name = "ParameterValueType", description = "Additional parameter as key-value-pair that is either required for retrieving a dataset from a certain datsource | or for converting the dataset in a certain format (e.g. separator for CSV-based datasets)")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-23T17:54:29.191576230+02:00[Europe/Berlin]")
public class ParameterValueType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String value;

  /**
   * Default constructor
   * @deprecated Use {@link ParameterValueType#ParameterValueType(String, String)}
   */
  @Deprecated
  public ParameterValueType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ParameterValueType(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public ParameterValueType name(String name) {
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

  public ParameterValueType value(String value) {
    this.value = value;
    return this;
  }

  /**
   * value of the parameter
   * @return value
  */
  @NotNull 
  @Schema(name = "value", description = "value of the parameter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParameterValueType parameterValueType = (ParameterValueType) o;
    return Objects.equals(this.name, parameterValueType.name) &&
        Objects.equals(this.value, parameterValueType.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParameterValueType {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

