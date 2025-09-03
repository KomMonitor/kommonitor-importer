package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.ParameterValueType;
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
 * Definition of an converter that should be used for decoding a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators and importing it
 */

@Schema(name = "ConverterDefinitionType", description = "Definition of an converter that should be used for decoding a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators and importing it")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T16:24:59.129000700+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class ConverterDefinitionType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String mimeType;

  private @Nullable String schema;

  private @Nullable String encoding;

  /**
   * Mechanism, which should be used to determine the encoding of the dataset. Supported values are `manual` | (encoding has to be defined manually by setting the `encoding` parameter) and `auto` (the converter will | apply an automatically encoding detection strategy; which strategy will be used depends on the converter).| If no or an unsupported encoding method will be provided, the converter will decide on its own, which strategy | will be applied.
   */
  public enum EncodingMethodEnum {
    MANUAL("manual"),
    
    AUTO("auto");

    private final String value;

    EncodingMethodEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EncodingMethodEnum fromValue(String value) {
      for (EncodingMethodEnum b : EncodingMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable EncodingMethodEnum encodingMethod;

  @Valid
  private @Nullable List<@Valid ParameterValueType> parameters;

  public ConverterDefinitionType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ConverterDefinitionType(String name, String mimeType) {
    this.name = name;
    this.mimeType = mimeType;
  }

  public ConverterDefinitionType name(String name) {
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

  public ConverterDefinitionType mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  /**
   * the MIME-type of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml
   * @return mimeType
   */
  @NotNull 
  @Schema(name = "mimeType", description = "the MIME-type of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mimeType")
  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public ConverterDefinitionType schema(@Nullable String schema) {
    this.schema = schema;
    return this;
  }

  /**
   * the schema of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml)
   * @return schema
   */
  
  @Schema(name = "schema", description = "the schema of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("schema")
  public @Nullable String getSchema() {
    return schema;
  }

  public void setSchema(@Nullable String schema) {
    this.schema = schema;
  }

  public ConverterDefinitionType encoding(@Nullable String encoding) {
    this.encoding = encoding;
    return this;
  }

  /**
   * encoding procedure or character set used (e.g. raw, base64, or UTF-8)
   * @return encoding
   */
  
  @Schema(name = "encoding", description = "encoding procedure or character set used (e.g. raw, base64, or UTF-8)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("encoding")
  public @Nullable String getEncoding() {
    return encoding;
  }

  public void setEncoding(@Nullable String encoding) {
    this.encoding = encoding;
  }

  public ConverterDefinitionType encodingMethod(@Nullable EncodingMethodEnum encodingMethod) {
    this.encodingMethod = encodingMethod;
    return this;
  }

  /**
   * Mechanism, which should be used to determine the encoding of the dataset. Supported values are `manual` | (encoding has to be defined manually by setting the `encoding` parameter) and `auto` (the converter will | apply an automatically encoding detection strategy; which strategy will be used depends on the converter).| If no or an unsupported encoding method will be provided, the converter will decide on its own, which strategy | will be applied.
   * @return encodingMethod
   */
  
  @Schema(name = "encodingMethod", description = "Mechanism, which should be used to determine the encoding of the dataset. Supported values are `manual` | (encoding has to be defined manually by setting the `encoding` parameter) and `auto` (the converter will | apply an automatically encoding detection strategy; which strategy will be used depends on the converter).| If no or an unsupported encoding method will be provided, the converter will decide on its own, which strategy | will be applied.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("encodingMethod")
  public @Nullable EncodingMethodEnum getEncodingMethod() {
    return encodingMethod;
  }

  public void setEncodingMethod(@Nullable EncodingMethodEnum encodingMethod) {
    this.encodingMethod = encodingMethod;
  }

  public ConverterDefinitionType parameters(@Nullable List<@Valid ParameterValueType> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ConverterDefinitionType addParametersItem(ParameterValueType parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

  /**
   * list of additional format related parameters as key-value-pairs that are required for decoding
   * @return parameters
   */
  @Valid 
  @Schema(name = "parameters", description = "list of additional format related parameters as key-value-pairs that are required for decoding", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parameters")
  public @Nullable List<@Valid ParameterValueType> getParameters() {
    return parameters;
  }

  public void setParameters(@Nullable List<@Valid ParameterValueType> parameters) {
    this.parameters = parameters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConverterDefinitionType converterDefinitionType = (ConverterDefinitionType) o;
    return Objects.equals(this.name, converterDefinitionType.name) &&
        Objects.equals(this.mimeType, converterDefinitionType.mimeType) &&
        Objects.equals(this.schema, converterDefinitionType.schema) &&
        Objects.equals(this.encoding, converterDefinitionType.encoding) &&
        Objects.equals(this.encodingMethod, converterDefinitionType.encodingMethod) &&
        Objects.equals(this.parameters, converterDefinitionType.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mimeType, schema, encoding, encodingMethod, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConverterDefinitionType {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
    sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
    sb.append("    encodingMethod: ").append(toIndentedString(encodingMethod)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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

