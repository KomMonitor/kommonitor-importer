package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.models.AttributeMappingType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for mapping datasource properties to required properties for spatial units and georesources
 */
@ApiModel(description = "Definitions for mapping datasource properties to required properties for spatial units and georesources")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-29T12:47:29.312+02:00")

public class SpatialResourcePropertyMappingType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("identifierProperty")
  private String identifierProperty = null;

  @JsonProperty("nameProperty")
  private String nameProperty = null;

  @JsonProperty("validStartDateProperty")
  private String validStartDateProperty = null;

  @JsonProperty("validEndDateProperty")
  private String validEndDateProperty = null;

  @JsonProperty("arisenFromProperty")
  private String arisenFromProperty = null;

  @JsonProperty("keepAttributes")
  private Boolean keepAttributes = null;

  @JsonProperty("keepMissingOrNullValueAttributes")
  private Boolean keepMissingOrNullValueAttributes = null;

  @JsonProperty("attributes")
  @Valid
  private List<AttributeMappingType> attributes = null;

  public SpatialResourcePropertyMappingType identifierProperty(String identifierProperty) {
    this.identifierProperty = identifierProperty;
    return this;
  }

  /**
   * the property that contains each feature's unique identifier
   * @return identifierProperty
  **/
  @ApiModelProperty(value = "the property that contains each feature's unique identifier")


  public String getIdentifierProperty() {
    return identifierProperty;
  }

  public void setIdentifierProperty(String identifierProperty) {
    this.identifierProperty = identifierProperty;
  }

  public SpatialResourcePropertyMappingType nameProperty(String nameProperty) {
    this.nameProperty = nameProperty;
    return this;
  }

  /**
   * the property that contains each feature's unique name
   * @return nameProperty
  **/
  @ApiModelProperty(required = true, value = "the property that contains each feature's unique name")
  @NotNull


  public String getNameProperty() {
    return nameProperty;
  }

  public void setNameProperty(String nameProperty) {
    this.nameProperty = nameProperty;
  }

  public SpatialResourcePropertyMappingType validStartDateProperty(String validStartDateProperty) {
    this.validStartDateProperty = validStartDateProperty;
    return this;
  }

  /**
   * the property that contains information about each feature's period of validity start date (optional, can also be configured globally for all features in POST and PUT requests)
   * @return validStartDateProperty
  **/
  @ApiModelProperty(value = "the property that contains information about each feature's period of validity start date (optional, can also be configured globally for all features in POST and PUT requests)")


  public String getValidStartDateProperty() {
    return validStartDateProperty;
  }

  public void setValidStartDateProperty(String validStartDateProperty) {
    this.validStartDateProperty = validStartDateProperty;
  }

  public SpatialResourcePropertyMappingType validEndDateProperty(String validEndDateProperty) {
    this.validEndDateProperty = validEndDateProperty;
    return this;
  }

  /**
   * the property that contains information about each feature's period of validity end date - might be null to indicator that feature is most current feature (optional, can also be configured globally for all features in POST and PUT requests)
   * @return validEndDateProperty
  **/
  @ApiModelProperty(value = "the property that contains information about each feature's period of validity end date - might be null to indicator that feature is most current feature (optional, can also be configured globally for all features in POST and PUT requests)")


  public String getValidEndDateProperty() {
    return validEndDateProperty;
  }

  public void setValidEndDateProperty(String validEndDateProperty) {
    this.validEndDateProperty = validEndDateProperty;
  }

  public SpatialResourcePropertyMappingType arisenFromProperty(String arisenFromProperty) {
    this.arisenFromProperty = arisenFromProperty;
    return this;
  }

  /**
   * the property that contains an ID that references a former spatial feature that over time evolved into the respective feature
   * @return arisenFromProperty
  **/
  @ApiModelProperty(value = "the property that contains an ID that references a former spatial feature that over time evolved into the respective feature")


  public String getArisenFromProperty() {
    return arisenFromProperty;
  }

  public void setArisenFromProperty(String arisenFromProperty) {
    this.arisenFromProperty = arisenFromProperty;
  }

  public SpatialResourcePropertyMappingType keepAttributes(Boolean keepAttributes) {
    this.keepAttributes = keepAttributes;
    return this;
  }

  /**
   * indicates if all attributes of the feature should be kept (note, if true, you can't specify an alias for the attributes, like you would do for the attribute mappings)
   * @return keepAttributes
  **/
  @ApiModelProperty(required = true, value = "indicates if all attributes of the feature should be kept (note, if true, you can't specify an alias for the attributes, like you would do for the attribute mappings)")
  @NotNull


  public Boolean getKeepAttributes() {
    return keepAttributes;
  }

  public void setKeepAttributes(Boolean keepAttributes) {
    this.keepAttributes = keepAttributes;
  }

  public SpatialResourcePropertyMappingType keepMissingOrNullValueAttributes(Boolean keepMissingOrNullValueAttributes) {
    this.keepMissingOrNullValueAttributes = keepMissingOrNullValueAttributes;
    return this;
  }

  /**
   * Indicates if missing attributes or attributes with a null value should be kept. If true, missing attributes will be added with a null value and attributes that hold a null value will be kept. Will be ignored if `keepAttributes` is true, since alle values would be kept anyway.
   * @return keepMissingOrNullValueAttributes
  **/
  @ApiModelProperty(required = true, value = "Indicates if missing attributes or attributes with a null value should be kept. If true, missing attributes will be added with a null value and attributes that hold a null value will be kept. Will be ignored if `keepAttributes` is true, since alle values would be kept anyway.")
  @NotNull


  public Boolean getKeepMissingOrNullValueAttributes() {
    return keepMissingOrNullValueAttributes;
  }

  public void setKeepMissingOrNullValueAttributes(Boolean keepMissingOrNullValueAttributes) {
    this.keepMissingOrNullValueAttributes = keepMissingOrNullValueAttributes;
  }

  public SpatialResourcePropertyMappingType attributes(List<AttributeMappingType> attributes) {
    this.attributes = attributes;
    return this;
  }

  public SpatialResourcePropertyMappingType addAttributesItem(AttributeMappingType attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

  /**
   * list of additional attribute mappings (will be skipped, if `keepAttributes` is true)
   * @return attributes
  **/
  @ApiModelProperty(value = "list of additional attribute mappings (will be skipped, if `keepAttributes` is true)")

  @Valid

  public List<AttributeMappingType> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<AttributeMappingType> attributes) {
    this.attributes = attributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpatialResourcePropertyMappingType spatialResourcePropertyMappingType = (SpatialResourcePropertyMappingType) o;
    return Objects.equals(this.identifierProperty, spatialResourcePropertyMappingType.identifierProperty) &&
        Objects.equals(this.nameProperty, spatialResourcePropertyMappingType.nameProperty) &&
        Objects.equals(this.validStartDateProperty, spatialResourcePropertyMappingType.validStartDateProperty) &&
        Objects.equals(this.validEndDateProperty, spatialResourcePropertyMappingType.validEndDateProperty) &&
        Objects.equals(this.arisenFromProperty, spatialResourcePropertyMappingType.arisenFromProperty) &&
        Objects.equals(this.keepAttributes, spatialResourcePropertyMappingType.keepAttributes) &&
        Objects.equals(this.keepMissingOrNullValueAttributes, spatialResourcePropertyMappingType.keepMissingOrNullValueAttributes) &&
        Objects.equals(this.attributes, spatialResourcePropertyMappingType.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierProperty, nameProperty, validStartDateProperty, validEndDateProperty, arisenFromProperty, keepAttributes, keepMissingOrNullValueAttributes, attributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpatialResourcePropertyMappingType {\n");
    
    sb.append("    identifierProperty: ").append(toIndentedString(identifierProperty)).append("\n");
    sb.append("    nameProperty: ").append(toIndentedString(nameProperty)).append("\n");
    sb.append("    validStartDateProperty: ").append(toIndentedString(validStartDateProperty)).append("\n");
    sb.append("    validEndDateProperty: ").append(toIndentedString(validEndDateProperty)).append("\n");
    sb.append("    arisenFromProperty: ").append(toIndentedString(arisenFromProperty)).append("\n");
    sb.append("    keepAttributes: ").append(toIndentedString(keepAttributes)).append("\n");
    sb.append("    keepMissingOrNullValueAttributes: ").append(toIndentedString(keepMissingOrNullValueAttributes)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
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

