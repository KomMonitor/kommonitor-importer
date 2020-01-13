package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Holds various information about the datasource for importing new resources
 */
@ApiModel(description = "Holds various information about the datasource for importing new resources")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-13T17:03:29.024+01:00")

public class DataSourceType  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * the type of datasource from which geodata or indicator data should be retrieved
   */
  public enum TypeEnum {
    DB("DB"),
    
    FILE("FILE"),
    
    FTP("FTP"),
    
    HTTP("HTTP"),
    
    INLINE("INLINE");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("parameters")
  @Valid
  private List<ParameterType> parameters = null;

  public DataSourceType type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * the type of datasource from which geodata or indicator data should be retrieved
   * @return type
  **/
  @ApiModelProperty(required = true, value = "the type of datasource from which geodata or indicator data should be retrieved")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public DataSourceType parameters(List<ParameterType> parameters) {
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
  **/
  @ApiModelProperty(value = "list with descriptions of additional parameters that are required for retrieving datasets from a datasource")

  @Valid

  public List<ParameterType> getParameters() {
    return parameters;
  }

  public void setParameters(List<ParameterType> parameters) {
    this.parameters = parameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

