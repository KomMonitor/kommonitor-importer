package org.n52.kommonitor.importer.decoder;

import org.n52.kommonitor.models.ClassificationTypeEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestScope
public class DecoderConfig {

    private ClassificationTypeEnum classificationType;

    public DecoderConfig() {
        this.classificationType = ClassificationTypeEnum.QUANTITATIVE;
    }

    public DecoderConfig(ClassificationTypeEnum classificationType) {
        this.classificationType = classificationType;
    }

    public ClassificationTypeEnum getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(ClassificationTypeEnum classificationType) {
        this.classificationType = classificationType;
    }

}
