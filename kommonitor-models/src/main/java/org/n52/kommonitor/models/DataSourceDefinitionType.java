package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.ParameterValueType;
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

@Schema(name = "DataSourceDefinitionType", description = "Holds various information about the datasource for importing new resources")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-18T08:37:30.174370900+01:00[Europe/Berlin]")
public class DataSourceDefinitionType implements Serializable {

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
  private List<@Valid ParameterValueType> parameters;

  public DataSourceDefinitionType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DataSourceDefinitionType(TypeEnum type) {
    this.type = type;
  }

  public DataSourceDefinitionType type(TypeEnum type) {
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

  public DataSourceDefinitionType parameters(List<@Valid ParameterValueType> parameters) {
    this.parameters = parameters;
    return this;
  }

  public DataSourceDefinitionType addParametersItem(ParameterValueType parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

  /**
   * list of additional parameters as key-value-pairs that are required for retrieving datasets from a datasource
   * @return parameters
  */
  @Valid 
  @Schema(name = "parameters", description = "list of additional parameters as key-value-pairs that are required for retrieving datasets from a datasource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parameters")
  public List<@Valid ParameterValueType> getParameters() {
    return parameters;
  }

  public void setParameters(List<@Valid ParameterValueType> parameters) {
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
    DataSourceDefinitionType dataSourceDefinitionType = (DataSourceDefinitionType) o;
    return Objects.equals(this.type, dataSourceDefinitionType.type) &&
        Objects.equals(this.parameters, dataSourceDefinitionType.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataSourceDefinitionType {\n");
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

