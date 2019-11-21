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
 * FormatType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T17:13:28.580+01:00")

public class FormatType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("mimeType")
  private String mimeType = null;

  @JsonProperty("schema")
  private String schema = null;

  @JsonProperty("encoding")
  private String encoding = null;

  public FormatType mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  /**
   * The MIME-type of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml
   * @return mimeType
  **/
  @ApiModelProperty(required = true, value = "The MIME-type of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml")
  @NotNull


  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public FormatType schema(String schema) {
    this.schema = schema;
    return this;
  }

  /**
   * The schema of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml)
   * @return schema
  **/
  @ApiModelProperty(value = "The schema of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml)")


  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public FormatType encoding(String encoding) {
    this.encoding = encoding;
    return this;
  }

  /**
   * Encoding procedure or character set used (e.g. raw, base64, or UTF-8)
   * @return encoding
  **/
  @ApiModelProperty(value = "Encoding procedure or character set used (e.g. raw, base64, or UTF-8)")


  public String getEncoding() {
    return encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormatType formatType = (FormatType) o;
    return Objects.equals(this.mimeType, formatType.mimeType) &&
        Objects.equals(this.schema, formatType.schema) &&
        Objects.equals(this.encoding, formatType.encoding);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mimeType, schema, encoding);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormatType {\n");
    
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
    sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
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

