package org.n52.kommonitor.importer.converter;

import org.springframework.beans.factory.InitializingBean;

import java.util.Collections;
import java.util.Set;

/**
 * An abstract converter that defines methods for converting a dataset that comes in a certain format
 * into the internal KomMonitor models for spatial resources and indicator values.
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
        return Collections.unmodifiableSet(supportedSchemas);
    }

    public Set<String> getSupportedEncodings() {
        return Collections.unmodifiableSet(supportedEncodings);
    }

    public Set<ConverterParameters> getConverterParameters() {
        return Collections.unmodifiableSet(converterParameters);
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
