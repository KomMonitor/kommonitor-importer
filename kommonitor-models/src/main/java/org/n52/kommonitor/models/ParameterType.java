package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definition of an additional parameter that is either required for retrieving a dataset from a certain datsource | or for converting the dataset in a certain format (e.g. separator for CSV-based datasets)
 */
@ApiModel(description = "Definition of an additional parameter that is either required for retrieving a dataset from a certain datsource | or for converting the dataset in a certain format (e.g. separator for CSV-based datasets)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-01T15:35:10.522+02:00")

public class ParameterType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("mandatory")
  private Boolean mandatory = null;

  /**
   * type of the parameter
   */
  public enum TypeEnum {
    STRING("string"),
    
    NUMBER("number"),
    
    BOOLEAN("boolean"),
    
    ARRAY("array");

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

  public ParameterType name(String name) {
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

  public ParameterType description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description of the parameter
   * @return description
  **/
  @ApiModelProperty(value = "description of the parameter")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ParameterType mandatory(Boolean mandatory) {
    this.mandatory = mandatory;
    return this;
  }

  /**
   * indicates wether the parameter is mandatory or optional
   * @return mandatory
  **/
  @ApiModelProperty(value = "indicates wether the parameter is mandatory or optional")


  public Boolean isMandatory() {
    return mandatory;
  }

  public void setMandatory(Boolean mandatory) {
    this.mandatory = mandatory;
  }

  public ParameterType type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * type of the parameter
   * @return type
  **/
  @ApiModelProperty(value = "type of the parameter")


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

