package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.models.TopicOverviewType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TopicOverviewType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-26T14:06:30.854+01:00")

public class TopicOverviewType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("topicId")
  private String topicId = null;

  @JsonProperty("topicName")
  private String topicName = null;

  @JsonProperty("topicDescription")
  private String topicDescription = null;

  /**
   * topic type indicating if the topic object is a subtopic or a main topic - only topics of type 'sub' shall be subTopics of topics with type 'main'
   */
  public enum TopicTypeEnum {
    MAIN("main"),
    
    SUB("sub");

    private String value;

    TopicTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TopicTypeEnum fromValue(String text) {
      for (TopicTypeEnum b : TopicTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("topicType")
  private TopicTypeEnum topicType = null;

  /**
   * topic resource indicating if the topic object corresponds to an indicator or to a georesource
   */
  public enum TopicResourceEnum {
    INDICATOR("indicator"),
    
    GEORESOURCE("georesource");

    private String value;

    TopicResourceEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TopicResourceEnum fromValue(String text) {
      for (TopicResourceEnum b : TopicResourceEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("topicResource")
  private TopicResourceEnum topicResource = null;

  @JsonProperty("subTopics")
  @Valid
  private List<TopicOverviewType> subTopics = null;

  public TopicOverviewType topicId(String topicId) {
    this.topicId = topicId;
    return this;
  }

  /**
   * the identifier of the topic
   * @return topicId
  **/
  @ApiModelProperty(required = true, value = "the identifier of the topic")
  @NotNull


  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public TopicOverviewType topicName(String topicName) {
    this.topicName = topicName;
    return this;
  }

  /**
   * the topic name
   * @return topicName
  **/
  @ApiModelProperty(required = true, value = "the topic name")
  @NotNull


  public String getTopicName() {
    return topicName;
  }

  public void setTopicName(String topicName) {
    this.topicName = topicName;
  }

  public TopicOverviewType topicDescription(String topicDescription) {
    this.topicDescription = topicDescription;
    return this;
  }

  /**
   * short description of the topic
   * @return topicDescription
  **/
  @ApiModelProperty(required = true, value = "short description of the topic")
  @NotNull


  public String getTopicDescription() {
    return topicDescription;
  }

  public void setTopicDescription(String topicDescription) {
    this.topicDescription = topicDescription;
  }

  public TopicOverviewType topicType(TopicTypeEnum topicType) {
    this.topicType = topicType;
    return this;
  }

  /**
   * topic type indicating if the topic object is a subtopic or a main topic - only topics of type 'sub' shall be subTopics of topics with type 'main'
   * @return topicType
  **/
  @ApiModelProperty(required = true, value = "topic type indicating if the topic object is a subtopic or a main topic - only topics of type 'sub' shall be subTopics of topics with type 'main'")
  @NotNull


  public TopicTypeEnum getTopicType() {
    return topicType;
  }

  public void setTopicType(TopicTypeEnum topicType) {
    this.topicType = topicType;
  }

  public TopicOverviewType topicResource(TopicResourceEnum topicResource) {
    this.topicResource = topicResource;
    return this;
  }

  /**
   * topic resource indicating if the topic object corresponds to an indicator or to a georesource
   * @return topicResource
  **/
  @ApiModelProperty(value = "topic resource indicating if the topic object corresponds to an indicator or to a georesource")


  public TopicResourceEnum getTopicResource() {
    return topicResource;
  }

  public void setTopicResource(TopicResourceEnum topicResource) {
    this.topicResource = topicResource;
  }

  public TopicOverviewType subTopics(List<TopicOverviewType> subTopics) {
    this.subTopics = subTopics;
    return this;
  }

  public TopicOverviewType addSubTopicsItem(TopicOverviewType subTopicsItem) {
    if (this.subTopics == null) {
      this.subTopics = new ArrayList<>();
    }
    this.subTopics.add(subTopicsItem);
    return this;
  }

  /**
   * optional list of subTopics
   * @return subTopics
  **/
  @ApiModelProperty(value = "optional list of subTopics")

  @Valid

  public List<TopicOverviewType> getSubTopics() {
    return subTopics;
  }

  public void setSubTopics(List<TopicOverviewType> subTopics) {
    this.subTopics = subTopics;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopicOverviewType topicOverviewType = (TopicOverviewType) o;
    return Objects.equals(this.topicId, topicOverviewType.topicId) &&
        Objects.equals(this.topicName, topicOverviewType.topicName) &&
        Objects.equals(this.topicDescription, topicOverviewType.topicDescription) &&
        Objects.equals(this.topicType, topicOverviewType.topicType) &&
        Objects.equals(this.topicResource, topicOverviewType.topicResource) &&
        Objects.equals(this.subTopics, topicOverviewType.subTopics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topicId, topicName, topicDescription, topicType, topicResource, subTopics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopicOverviewType {\n");
    
    sb.append("    topicId: ").append(toIndentedString(topicId)).append("\n");
    sb.append("    topicName: ").append(toIndentedString(topicName)).append("\n");
    sb.append("    topicDescription: ").append(toIndentedString(topicDescription)).append("\n");
    sb.append("    topicType: ").append(toIndentedString(topicType)).append("\n");
    sb.append("    topicResource: ").append(toIndentedString(topicResource)).append("\n");
    sb.append("    subTopics: ").append(toIndentedString(subTopics)).append("\n");
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

