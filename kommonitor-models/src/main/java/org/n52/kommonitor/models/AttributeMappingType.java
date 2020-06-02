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
 * Definitions for mapping of additional attributes of datasets from a data source
 */
@ApiModel(description = "Definitions for mapping of additional attributes of datasets from a data source")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-26T14:06:29.866+01:00")

public class AttributeMappingType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("mappingName")
  private String mappingName = null;

  /**
   * data type of the parameter
   */
  public enum TypeEnum {
    STRING("string"),
    
    INTEGER("integer"),
    
    FLOAT("float"),
    
    DATE("date");

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

  public AttributeMappingType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the attribute from the origin dataset
   * @return name
  **/
  @ApiModelProperty(required = true, value = "name of the attribute from the origin dataset")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AttributeMappingType mappingName(String mappingName) {
    this.mappingName = mappingName;
    return this;
  }

  /**
   * name that should be used for importing the attribute into KomMonitor
   * @return mappingName
  **/
  @ApiModelProperty(value = "name that should be used for importing the attribute into KomMonitor")


  public String getMappingName() {
    return mappingName;
  }

  public void setMappingName(String mappingName) {
    this.mappingName = mappingName;
  }

  public AttributeMappingType type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * data type of the parameter
   * @return type
  **/
  @ApiModelProperty(required = true, value = "data type of the parameter")
  @NotNull


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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

