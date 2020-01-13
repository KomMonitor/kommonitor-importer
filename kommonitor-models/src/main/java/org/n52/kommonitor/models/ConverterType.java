package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Conerverter that enables the converting of a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators
 */
@ApiModel(description = "Conerverter that enables the converting of a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-13T17:03:29.024+01:00")

public class ConverterType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("mimeTypes")
  @Valid
  private List<String> mimeTypes = new ArrayList<>();

  @JsonProperty("schemas")
  @Valid
  private List<String> schemas = null;

  @JsonProperty("encodings")
  @Valid
  private List<String> encodings = null;

  @JsonProperty("parameters")
  @Valid
  private List<ParameterType> parameters = null;

  public ConverterType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * unique name of the converter
   * @return name
  **/
  @ApiModelProperty(required = true, value = "unique name of the converter")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ConverterType mimeTypes(List<String> mimeTypes) {
    this.mimeTypes = mimeTypes;
    return this;
  }

  public ConverterType addMimeTypesItem(String mimeTypesItem) {
    this.mimeTypes.add(mimeTypesItem);
    return this;
  }

  /**
   * list of MIME-types of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml that are supported by the converter
   * @return mimeTypes
  **/
  @ApiModelProperty(required = true, value = "list of MIME-types of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml that are supported by the converter")
  @NotNull


  public List<String> getMimeTypes() {
    return mimeTypes;
  }

  public void setMimeTypes(List<String> mimeTypes) {
    this.mimeTypes = mimeTypes;
  }

  public ConverterType schemas(List<String> schemas) {
    this.schemas = schemas;
    return this;
  }

  public ConverterType addSchemasItem(String schemasItem) {
    if (this.schemas == null) {
      this.schemas = new ArrayList<>();
    }
    this.schemas.add(schemasItem);
    return this;
  }

  /**
   * list of schemas of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml) that are supported by the converter
   * @return schemas
  **/
  @ApiModelProperty(value = "list of schemas of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml) that are supported by the converter")


  public List<String> getSchemas() {
    return schemas;
  }

  public void setSchemas(List<String> schemas) {
    this.schemas = schemas;
  }

  public ConverterType encodings(List<String> encodings) {
    this.encodings = encodings;
    return this;
  }

  public ConverterType addEncodingsItem(String encodingsItem) {
    if (this.encodings == null) {
      this.encodings = new ArrayList<>();
    }
    this.encodings.add(encodingsItem);
    return this;
  }

  /**
   * list of encodings that are supported by the converter
   * @return encodings
  **/
  @ApiModelProperty(value = "list of encodings that are supported by the converter")


  public List<String> getEncodings() {
    return encodings;
  }

  public void setEncodings(List<String> encodings) {
    this.encodings = encodings;
  }

  public ConverterType parameters(List<ParameterType> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ConverterType addParametersItem(ParameterType parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

  /**
   * list with descriptions of additional parameters that are required for decoding a certain dataset format
   * @return parameters
  **/
  @ApiModelProperty(value = "list with descriptions of additional parameters that are required for decoding a certain dataset format")

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
    ConverterType converterType = (ConverterType) o;
    return Objects.equals(this.name, converterType.name) &&
        Objects.equals(this.mimeTypes, converterType.mimeTypes) &&
        Objects.equals(this.schemas, converterType.schemas) &&
        Objects.equals(this.encodings, converterType.encodings) &&
        Objects.equals(this.parameters, converterType.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mimeTypes, schemas, encodings, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConverterType {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mimeTypes: ").append(toIndentedString(mimeTypes)).append("\n");
    sb.append("    schemas: ").append(toIndentedString(schemas)).append("\n");
    sb.append("    encodings: ").append(toIndentedString(encodings)).append("\n");
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

