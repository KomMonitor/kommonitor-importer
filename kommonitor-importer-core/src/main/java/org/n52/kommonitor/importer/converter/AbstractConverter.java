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

    private Set<ConverterParameters> converterParameters;


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

    public Set<ConverterParameters> getConverterParameters() {
        return converterParameters != null ? Collections.unmodifiableSet(converterParameters) : null;
    }

    /**
     * Initializes the unique name for the converter
     */
    public abstract void initName();

    /**
     * Initializes the supported MIME-type for the converter
     */
    public abstract void initSupportedMimeType();

    /**
     * Initializes a set of supported schemas for the converter
     */
    public abstract void initSupportedSchemas();

    /**
     * Initializes a set of supported encodings for the converter
     */
    public abstract void initSupportedEncoding();

    /**
     * Initializes the set of additional parameters for the converter
     */
    public abstract void initConverterParameters();

    @Override
    public void afterPropertiesSet() throws Exception {
        initName();
        initSupportedMimeType();
        initSupportedSchemas();
        initSupportedEncoding();
        initConverterParameters();
    }
}
