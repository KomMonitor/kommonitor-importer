package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.AttributeMappingType;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Definitions for mapping datasource properties to required properties for spatial units and georesources
 */

@Schema(name = "SpatialResourcePropertyMappingType", description = "Definitions for mapping datasource properties to required properties for spatial units and georesources")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T12:23:45.798187400+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class SpatialResourcePropertyMappingType implements Serializable {

  private static final long serialVersionUID = 1L;

  private @Nullable String identifierProperty;

  private String nameProperty;

  private @Nullable String validStartDateProperty;

  private @Nullable String validEndDateProperty;

  private @Nullable String arisenFromProperty;

  private Boolean keepAttributes;

  private Boolean keepMissingOrNullValueAttributes;

  @Valid
  private List<@Valid AttributeMappingType> attributes = new ArrayList<>();

  public SpatialResourcePropertyMappingType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SpatialResourcePropertyMappingType(String nameProperty, Boolean keepAttributes, Boolean keepMissingOrNullValueAttributes) {
    this.nameProperty = nameProperty;
    this.keepAttributes = keepAttributes;
    this.keepMissingOrNullValueAttributes = keepMissingOrNullValueAttributes;
  }

  public SpatialResourcePropertyMappingType identifierProperty(@Nullable String identifierProperty) {
    this.identifierProperty = identifierProperty;
    return this;
  }

  /**
   * the property that contains each feature's unique identifier
   * @return identifierProperty
   */
  
  @Schema(name = "identifierProperty", description = "the property that contains each feature's unique identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("identifierProperty")
  public @Nullable String getIdentifierProperty() {
    return identifierProperty;
  }

  public void setIdentifierProperty(@Nullable String identifierProperty) {
    this.identifierProperty = identifierProperty;
  }

  public SpatialResourcePropertyMappingType nameProperty(String nameProperty) {
    this.nameProperty = nameProperty;
    return this;
  }

  /**
   * the property that contains each feature's unique name
   * @return nameProperty
   */
  @NotNull 
  @Schema(name = "nameProperty", description = "the property that contains each feature's unique name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nameProperty")
  public String getNameProperty() {
    return nameProperty;
  }

  public void setNameProperty(String nameProperty) {
    this.nameProperty = nameProperty;
  }

  public SpatialResourcePropertyMappingType validStartDateProperty(@Nullable String validStartDateProperty) {
    this.validStartDateProperty = validStartDateProperty;
    return this;
  }

  /**
   * the property that contains information about each feature's period of validity start date (optional, can also be configured globally for all features in POST and PUT requests)
   * @return validStartDateProperty
   */
  
  @Schema(name = "validStartDateProperty", description = "the property that contains information about each feature's period of validity start date (optional, can also be configured globally for all features in POST and PUT requests)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("validStartDateProperty")
  public @Nullable String getValidStartDateProperty() {
    return validStartDateProperty;
  }

  public void setValidStartDateProperty(@Nullable String validStartDateProperty) {
    this.validStartDateProperty = validStartDateProperty;
  }

  public SpatialResourcePropertyMappingType validEndDateProperty(@Nullable String validEndDateProperty) {
    this.validEndDateProperty = validEndDateProperty;
    return this;
  }

  /**
   * the property that contains information about each feature's period of validity end date - might be null to indicator that feature is most current feature (optional, can also be configured globally for all features in POST and PUT requests)
   * @return validEndDateProperty
   */
  
  @Schema(name = "validEndDateProperty", description = "the property that contains information about each feature's period of validity end date - might be null to indicator that feature is most current feature (optional, can also be configured globally for all features in POST and PUT requests)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("validEndDateProperty")
  public @Nullable String getValidEndDateProperty() {
    return validEndDateProperty;
  }

  public void setValidEndDateProperty(@Nullable String validEndDateProperty) {
    this.validEndDateProperty = validEndDateProperty;
  }

  public SpatialResourcePropertyMappingType arisenFromProperty(@Nullable String arisenFromProperty) {
    this.arisenFromProperty = arisenFromProperty;
    return this;
  }

  /**
   * the property that contains an ID that references a former spatial feature that over time evolved into the respective feature
   * @return arisenFromProperty
   */
  
  @Schema(name = "arisenFromProperty", description = "the property that contains an ID that references a former spatial feature that over time evolved into the respective feature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("arisenFromProperty")
  public @Nullable String getArisenFromProperty() {
    return arisenFromProperty;
  }

  public void setArisenFromProperty(@Nullable String arisenFromProperty) {
    this.arisenFromProperty = arisenFromProperty;
  }

  public SpatialResourcePropertyMappingType keepAttributes(Boolean keepAttributes) {
    this.keepAttributes = keepAttributes;
    return this;
  }

  /**
   * indicates if all attributes of the feature should be kept (note, if true, you can't specify an alias for the attributes, like you would do for the attribute mappings)
   * @return keepAttributes
   */
  @NotNull 
  @Schema(name = "keepAttributes", description = "indicates if all attributes of the feature should be kept (note, if true, you can't specify an alias for the attributes, like you would do for the attribute mappings)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("keepAttributes")
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
   */
  @NotNull 
  @Schema(name = "keepMissingOrNullValueAttributes", description = "Indicates if missing attributes or attributes with a null value should be kept. If true, missing attributes will be added with a null value and attributes that hold a null value will be kept. Will be ignored if `keepAttributes` is true, since alle values would be kept anyway.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("keepMissingOrNullValueAttributes")
  public Boolean getKeepMissingOrNullValueAttributes() {
    return keepMissingOrNullValueAttributes;
  }

  public void setKeepMissingOrNullValueAttributes(Boolean keepMissingOrNullValueAttributes) {
    this.keepMissingOrNullValueAttributes = keepMissingOrNullValueAttributes;
  }

  public SpatialResourcePropertyMappingType attributes(List<@Valid AttributeMappingType> attributes) {
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
   */
  @Valid 
  @Schema(name = "attributes", description = "list of additional attribute mappings (will be skipped, if `keepAttributes` is true)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attributes")
  public List<@Valid AttributeMappingType> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<@Valid AttributeMappingType> attributes) {
    this.attributes = attributes;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

