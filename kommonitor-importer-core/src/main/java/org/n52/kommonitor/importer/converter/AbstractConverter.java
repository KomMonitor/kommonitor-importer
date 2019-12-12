package org.n52.kommonitor.importer.converter;

import org.springframework.beans.factory.InitializingBean;

import java.util.Collections;
import java.util.Set;

/**
 * An abstract converter that encapsulates definitions of supported format types for a converter
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractConverter implements InitializingBean, Converter {

    private String name;

    private String supportedMimeType;

    private Set<String> supportedSchemas;

    private Set<String> supportedEncodings;

    private Set<ConverterParameter> converterParameters;


    @Override
    public String getName() {
        return name;
    }

    public String getSupportedMimeType() {
        return supportedMimeType;
    }

    public Set<String> getSupportedSchemas() {
        return supportedSchemas != null ? Collections.unmodifiableSet(supportedSchemas) : null;
    }

    public Set<String> getSupportedEncodings() {
        return supportedEncodings != null ? Collections.unmodifiableSet(supportedEncodings) : null;
    }

    public Set<ConverterParameter> getConverterParameters() {
        return converterParameters != null ? Collections.unmodifiableSet(converterParameters) : null;
    }

    /**
     * Initializes the unique name for the converter
     */
    public abstract String initName();

    /**
     * Initializes the supported MIME-type for the converter
     */
    public abstract String initSupportedMimeType();

    /**
     * Initializes a set of supported schemas for the converter
     */
    public abstract Set<String> initSupportedSchemas();

    /**
     * Initializes a set of supported encodings for the converter
     */
    public abstract Set<String> initSupportedEncoding();

    /**
     * Initializes the set of additional parameters for the converter
     */
    public abstract Set<ConverterParameter> initConverterParameters();

    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = initName();
        this.supportedMimeType = initSupportedMimeType();
        this.supportedSchemas = initSupportedSchemas();
        this.supportedEncodings = initSupportedEncoding();
        this.converterParameters = initConverterParameters();
    }
}
