package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;

/**
 * The payload of the dataset that should we imported. Might be either provided inline or as a reference on a remote dataset.
 */
@ApiModel(description = "The payload of the dataset that should we imported. Might be either provided inline or as a reference on a remote dataset.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-28T19:57:45.678+01:00")

public class PayloadType  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * specifies the the way the payload content will be provided. Possible values are 'DATA' for providing data inline or 'REFERENCE' to specifiy an URL that references some remote data.
   */
  public enum InputTypeEnum {
    DATA("DATA"),
    
    REFERENCE("REFERENCE");

    private String value;

    InputTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static InputTypeEnum fromValue(String text) {
      for (InputTypeEnum b : InputTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("inputType")
  private InputTypeEnum inputType = null;

  @JsonProperty("content")
  private String content = null;

  public PayloadType inputType(InputTypeEnum inputType) {
    this.inputType = inputType;
    return this;
  }

  /**
   * specifies the the way the payload content will be provided. Possible values are 'DATA' for providing data inline or 'REFERENCE' to specifiy an URL that references some remote data.
   * @return inputType
  **/
  @ApiModelProperty(value = "specifies the the way the payload content will be provided. Possible values are 'DATA' for providing data inline or 'REFERENCE' to specifiy an URL that references some remote data.")


  public InputTypeEnum getInputType() {
    return inputType;
  }

  public void setInputType(InputTypeEnum inputType) {
    this.inputType = inputType;
  }

  public PayloadType content(String content) {
    this.content = content;
    return this;
  }

  /**
   * the content according to the selected sourceFormat (i.e. an URL to a WFS, or Base64 encoded String of a zipped ShapeFile or GeoJSON)
   * @return content
  **/
  @ApiModelProperty(value = "the content according to the selected sourceFormat (i.e. an URL to a WFS, or Base64 encoded String of a zipped ShapeFile or GeoJSON)")


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayloadType payloadType = (PayloadType) o;
    return Objects.equals(this.inputType, payloadType.inputType) &&
        Objects.equals(this.content, payloadType.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputType, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayloadType {\n");
    
    sb.append("    inputType: ").append(toIndentedString(inputType)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

