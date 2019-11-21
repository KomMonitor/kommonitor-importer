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
 * DefaultClassificationMappingItemType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T17:13:28.580+01:00")

public class DefaultClassificationMappingItemType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("defaultColorAsHex")
  private String defaultColorAsHex = null;

  @JsonProperty("defaultCustomRating")
  private String defaultCustomRating = null;

  public DefaultClassificationMappingItemType defaultColorAsHex(String defaultColorAsHex) {
    this.defaultColorAsHex = defaultColorAsHex;
    return this;
  }

  /**
   * the default color for the specified value interval as hex string inclusive leading #, i.e. '#ffffff'
   * @return defaultColorAsHex
  **/
  @ApiModelProperty(required = true, value = "the default color for the specified value interval as hex string inclusive leading #, i.e. '#ffffff'")
  @NotNull


  public String getDefaultColorAsHex() {
    return defaultColorAsHex;
  }

  public void setDefaultColorAsHex(String defaultColorAsHex) {
    this.defaultColorAsHex = defaultColorAsHex;
  }

  public DefaultClassificationMappingItemType defaultCustomRating(String defaultCustomRating) {
    this.defaultCustomRating = defaultCustomRating;
    return this;
  }

  /**
   * the default custom rating string for the specified value interval, i.e. 'very high'/'very low' or 'good'/'bad'
   * @return defaultCustomRating
  **/
  @ApiModelProperty(required = true, value = "the default custom rating string for the specified value interval, i.e. 'very high'/'very low' or 'good'/'bad'")
  @NotNull


  public String getDefaultCustomRating() {
    return defaultCustomRating;
  }

  public void setDefaultCustomRating(String defaultCustomRating) {
    this.defaultCustomRating = defaultCustomRating;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultClassificationMappingItemType defaultClassificationMappingItemType = (DefaultClassificationMappingItemType) o;
    return Objects.equals(this.defaultColorAsHex, defaultClassificationMappingItemType.defaultColorAsHex) &&
        Objects.equals(this.defaultCustomRating, defaultClassificationMappingItemType.defaultCustomRating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultColorAsHex, defaultCustomRating);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DefaultClassificationMappingItemType {\n");
    
    sb.append("    defaultColorAsHex: ").append(toIndentedString(defaultColorAsHex)).append("\n");
    sb.append("    defaultCustomRating: ").append(toIndentedString(defaultCustomRating)).append("\n");
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

