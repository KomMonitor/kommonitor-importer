package org.n52.kommonitor.importer.models;

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
 * DatasetReferenceType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T17:13:28.580+01:00")

public class DatasetReferenceType  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Type of the dataset reference. Can be an attribute for tabular data or FeatureType if the underlying datasource is Feature like.
   */
  public enum TypeEnum {
    ATTRIBUTE("ATTRIBUTE"),
    
    FEATURE_TYPE("FEATURE_TYPE");

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

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private String value = null;

  public DatasetReferenceType type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the dataset reference. Can be an attribute for tabular data or FeatureType if the underlying datasource is Feature like.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Type of the dataset reference. Can be an attribute for tabular data or FeatureType if the underlying datasource is Feature like.")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public DatasetReferenceType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the attribute that contains a certain value for referencing the target dataset.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the attribute that contains a certain value for referencing the target dataset.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DatasetReferenceType value(String value) {
    this.value = value;
    return this;
  }

  /**
   * The value that specifies the target dataset to be referenced.
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The value that specifies the target dataset to be referenced.")
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
    DatasetReferenceType datasetReferenceType = (DatasetReferenceType) o;
    return Objects.equals(this.type, datasetReferenceType.type) &&
        Objects.equals(this.name, datasetReferenceType.name) &&
        Objects.equals(this.value, datasetReferenceType.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DatasetReferenceType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

