package org.n52.kommonitor.importer.api;

import jakarta.annotation.Generated;

@Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-18T13:37:04.985+01:00")

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
