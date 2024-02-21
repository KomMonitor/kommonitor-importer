package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.ParameterType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Converter that enables the converting of a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators
 */

@Schema(name = "ConverterType", description = "Converter that enables the converting of a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-21T12:40:27.304865200+01:00[Europe/Berlin]")
public class ConverterType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  @Valid
  private List<String> mimeTypes = new ArrayList<>();

  @Valid
  private List<String> schemas;

  @Valid
  private List<String> encodings;

  private String defaultEncoding;

  @Valid
  private List<@Valid ParameterType> parameters;

  @Valid
  private List<String> datasources;

  public ConverterType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ConverterType(String name, List<String> mimeTypes) {
    this.name = name;
    this.mimeTypes = mimeTypes;
  }

  public ConverterType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * unique name of the converter
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "unique name of the converter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
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
    if (this.mimeTypes == null) {
      this.mimeTypes = new ArrayList<>();
    }
    this.mimeTypes.add(mimeTypesItem);
    return this;
  }

  /**
   * list of MIME-types of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml that are supported by the converter
   * @return mimeTypes
  */
  @NotNull 
  @Schema(name = "mimeTypes", description = "list of MIME-types of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml that are supported by the converter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mimeTypes")
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
  */
  
  @Schema(name = "schemas", description = "list of schemas of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml) that are supported by the converter", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("schemas")
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
  */
  
  @Schema(name = "encodings", description = "list of encodings that are supported by the converter", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("encodings")
  public List<String> getEncodings() {
    return encodings;
  }

  public void setEncodings(List<String> encodings) {
    this.encodings = encodings;
  }

  public ConverterType defaultEncoding(String defaultEncoding) {
    this.defaultEncoding = defaultEncoding;
    return this;
  }

  /**
   * Default encoding that will be expected by converter.
   * @return defaultEncoding
  */
  
  @Schema(name = "defaultEncoding", description = "Default encoding that will be expected by converter.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("defaultEncoding")
  public String getDefaultEncoding() {
    return defaultEncoding;
  }

  public void setDefaultEncoding(String defaultEncoding) {
    this.defaultEncoding = defaultEncoding;
  }

  public ConverterType parameters(List<@Valid ParameterType> parameters) {
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
  */
  @Valid 
  @Schema(name = "parameters", description = "list with descriptions of additional parameters that are required for decoding a certain dataset format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parameters")
  public List<@Valid ParameterType> getParameters() {
    return parameters;
  }

  public void setParameters(List<@Valid ParameterType> parameters) {
    this.parameters = parameters;
  }

  public ConverterType datasources(List<String> datasources) {
    this.datasources = datasources;
    return this;
  }

  public ConverterType addDatasourcesItem(String datasourcesItem) {
    if (this.datasources == null) {
      this.datasources = new ArrayList<>();
    }
    this.datasources.add(datasourcesItem);
    return this;
  }

  /**
   * list of supported datasources
   * @return datasources
  */
  
  @Schema(name = "datasources", description = "list of supported datasources", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("datasources")
  public List<String> getDatasources() {
    return datasources;
  }

  public void setDatasources(List<String> datasources) {
    this.datasources = datasources;
  }

  @Override
  public boolean equals(Object o) {
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
        Objects.equals(this.defaultEncoding, converterType.defaultEncoding) &&
        Objects.equals(this.parameters, converterType.parameters) &&
        Objects.equals(this.datasources, converterType.datasources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mimeTypes, schemas, encodings, defaultEncoding, parameters, datasources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConverterType {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mimeTypes: ").append(toIndentedString(mimeTypes)).append("\n");
    sb.append("    schemas: ").append(toIndentedString(schemas)).append("\n");
    sb.append("    encodings: ").append(toIndentedString(encodings)).append("\n");
    sb.append("    defaultEncoding: ").append(toIndentedString(defaultEncoding)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    datasources: ").append(toIndentedString(datasources)).append("\n");
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

