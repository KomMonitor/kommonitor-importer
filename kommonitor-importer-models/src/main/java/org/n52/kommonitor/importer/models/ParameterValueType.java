package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Additional parameter as key-value-pair that is either required for retrieving a dataset from a certain datsource | or for converting the dataset in a certain format (e.g. separator for CSV-based datasets)
 */
@ApiModel(description = "Additional parameter as key-value-pair that is either required for retrieving a dataset from a certain datsource | or for converting the dataset in a certain format (e.g. separator for CSV-based datasets)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-10T12:37:10.215+01:00")

public class ParameterValueType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private String value = null;

  public ParameterValueType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the parameter
   * @return name
  **/
  @ApiModelProperty(required = true, value = "name of the parameter")
  @NotNull


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
  **/
  @ApiModelProperty(required = true, value = "value of the parameter")
  @NotNull


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

