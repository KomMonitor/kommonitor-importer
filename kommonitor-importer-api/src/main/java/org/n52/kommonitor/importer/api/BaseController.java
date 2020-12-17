package org.n52.kommonitor.importer.api;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping("/importer")
public @interface BaseController {
}
