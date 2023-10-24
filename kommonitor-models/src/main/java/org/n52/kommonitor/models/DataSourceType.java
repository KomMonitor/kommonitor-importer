package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.models.ParameterType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Holds various information about the datasource for importing new resources
 */

@Schema(name = "DataSourceType", description = "Holds various information about the datasource for importing new resources")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-23T17:54:29.191576230+02:00[Europe/Berlin]")
public class DataSourceType implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * the type of datasource from which geodata or indicator data should be retrieved
   */
  public enum TypeEnum {
    DB("DB"),
    
    FILE("FILE"),
    
    FTP("FTP"),
    
    HTTP("HTTP"),
    
    INLINE("INLINE"),
    
    OGCAPI_FEATURES("OGCAPI_FEATURES");

    private String value;

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

  @Valid
  private List<@Valid ParameterType> parameters;

  /**
   * Default constructor
   * @deprecated Use {@link DataSourceType#DataSourceType(TypeEnum)}
   */
  @Deprecated
  public DataSourceType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DataSourceType(TypeEnum type) {
    this.type = type;
  }

  public DataSourceType type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * the type of datasource from which geodata or indicator data should be retrieved
   * @return type
  */
  @NotNull 
  @Schema(name = "type", description = "the type of datasource from which geodata or indicator data should be retrieved", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public DataSourceType parameters(List<@Valid ParameterType> parameters) {
    this.parameters = parameters;
    return this;
  }

  public DataSourceType addParametersItem(ParameterType parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

  /**
   * list with descriptions of additional parameters that are required for retrieving datasets from a datasource
   * @return parameters
  */
  @Valid 
  @Schema(name = "parameters", description = "list with descriptions of additional parameters that are required for retrieving datasets from a datasource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parameters")
  public List<@Valid ParameterType> getParameters() {
    return parameters;
  }

  public void setParameters(List<@Valid ParameterType> parameters) {
    this.parameters = parameters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataSourceType dataSourceType = (DataSourceType) o;
    return Objects.equals(this.type, dataSourceType.type) &&
        Objects.equals(this.parameters, dataSourceType.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataSourceType {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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

