package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.importer.models.ParameterValueType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definition of an conveter that should be used for decoding a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators and importing it
 */
@ApiModel(description = "Definition of an conveter that should be used for decoding a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators and importing it")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T18:54:04.581+01:00")

public class ConverterDefinitionType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("mimeType")
  private String mimeType = null;

  @JsonProperty("schema")
  private String schema = null;

  @JsonProperty("encoding")
  private String encoding = null;

  @JsonProperty("parameters")
  @Valid
  private List<ParameterValueType> parameters = null;

  public ConverterDefinitionType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * unique name of the conveter
   * @return name
  **/
  @ApiModelProperty(required = true, value = "unique name of the conveter")
  @NotNull


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
  **/
  @ApiModelProperty(required = true, value = "the MIME-type of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml")
  @NotNull


  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public ConverterDefinitionType schema(String schema) {
    this.schema = schema;
    return this;
  }

  /**
   * the schema of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml)
   * @return schema
  **/
  @ApiModelProperty(value = "the schema of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml)")


  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public ConverterDefinitionType encoding(String encoding) {
    this.encoding = encoding;
    return this;
  }

  /**
   * encoding procedure or character set used (e.g. raw, base64, or UTF-8)
   * @return encoding
  **/
  @ApiModelProperty(value = "encoding procedure or character set used (e.g. raw, base64, or UTF-8)")


  public String getEncoding() {
    return encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }

  public ConverterDefinitionType parameters(List<ParameterValueType> parameters) {
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
  **/
  @ApiModelProperty(value = "list of additional format related parameters as key-value-pairs that are required for decoding")

  @Valid

  public List<ParameterValueType> getParameters() {
    return parameters;
  }

  public void setParameters(List<ParameterValueType> parameters) {
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
    ConverterDefinitionType converterDefinitionType = (ConverterDefinitionType) o;
    return Objects.equals(this.name, converterDefinitionType.name) &&
        Objects.equals(this.mimeType, converterDefinitionType.mimeType) &&
        Objects.equals(this.schema, converterDefinitionType.schema) &&
        Objects.equals(this.encoding, converterDefinitionType.encoding) &&
        Objects.equals(this.parameters, converterDefinitionType.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mimeType, schema, encoding, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConverterDefinitionType {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
    sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
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

