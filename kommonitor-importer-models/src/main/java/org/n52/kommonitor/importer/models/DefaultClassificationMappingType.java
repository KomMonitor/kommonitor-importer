package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.importer.models.DefaultClassificationMappingItemType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definition of a default classification mapping for indicator values
 */
@ApiModel(description = "Definition of a default classification mapping for indicator values")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-28T19:57:45.678+01:00")

public class DefaultClassificationMappingType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("colorBrewerSchemeName")
  private String colorBrewerSchemeName = null;

  @JsonProperty("items")
  @Valid
  private List<DefaultClassificationMappingItemType> items = new ArrayList<DefaultClassificationMappingItemType>();

  public DefaultClassificationMappingType colorBrewerSchemeName(String colorBrewerSchemeName) {
    this.colorBrewerSchemeName = colorBrewerSchemeName;
    return this;
  }

  /**
   * the name of the colorBrewer color scheme jused to define the colors for classification (see project http://colorbrewer2.org/#type=sequential&scheme=BuGn&n=3 for colorSchemes). Set to 'INDIVIDUAL' if colors are set arbitrarily.
   * @return colorBrewerSchemeName
  **/
  @ApiModelProperty(required = true, value = "the name of the colorBrewer color scheme jused to define the colors for classification (see project http://colorbrewer2.org/#type=sequential&scheme=BuGn&n=3 for colorSchemes). Set to 'INDIVIDUAL' if colors are set arbitrarily.")
  @NotNull


  public String getColorBrewerSchemeName() {
    return colorBrewerSchemeName;
  }

  public void setColorBrewerSchemeName(String colorBrewerSchemeName) {
    this.colorBrewerSchemeName = colorBrewerSchemeName;
  }

  public DefaultClassificationMappingType items(List<DefaultClassificationMappingItemType> items) {
    this.items = items;
    return this;
  }

  public DefaultClassificationMappingType addItemsItem(DefaultClassificationMappingItemType itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

  /**
   * array of classification mapping items. The order of the items corresponds to indicator value intervals from low to high. The number of items represents the number of classes. In combination they represent the default classification and mapping to custom rating of the indicator values
   * @return items
  **/
  @ApiModelProperty(required = true, value = "array of classification mapping items. The order of the items corresponds to indicator value intervals from low to high. The number of items represents the number of classes. In combination they represent the default classification and mapping to custom rating of the indicator values")
  @NotNull

  @Valid

  public List<DefaultClassificationMappingItemType> getItems() {
    return items;
  }

  public void setItems(List<DefaultClassificationMappingItemType> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultClassificationMappingType defaultClassificationMappingType = (DefaultClassificationMappingType) o;
    return Objects.equals(this.colorBrewerSchemeName, defaultClassificationMappingType.colorBrewerSchemeName) &&
        Objects.equals(this.items, defaultClassificationMappingType.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(colorBrewerSchemeName, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DefaultClassificationMappingType {\n");
    
    sb.append("    colorBrewerSchemeName: ").append(toIndentedString(colorBrewerSchemeName)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

