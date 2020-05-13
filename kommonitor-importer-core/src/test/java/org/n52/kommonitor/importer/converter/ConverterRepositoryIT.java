package org.n52.kommonitor.importer.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConverterRepository.class, AbstractConverter.class})
public class ConverterRepositoryIT {

    private static final String CONVERTER_NAME = "testConverter";

    @MockBean
    private AbstractConverter converter;

    @Autowired
    private ConverterRepository repo;

    @Test
    @DisplayName("test get all Converters")
    void testGetAllConverters() {
        Mockito.when(converter.getName()).thenReturn(CONVERTER_NAME);

        List<AbstractConverter> converterList = repo.getAll();

        Assertions.assertEquals(1, converterList.size());
    }

    @Test
    @DisplayName("test get Converter for name is present")
    void testGetConverterIsPresent() {
        Mockito.when(converter.getName()).thenReturn(CONVERTER_NAME);

        Optional<AbstractConverter> converterOpt = repo.getConverter(CONVERTER_NAME);

        Assertions.assertTrue(converterOpt.isPresent());
    }

    @Test
    @DisplayName("test get Converter for name is not present")
    void testGetConverterIsNotPresent() {
        Mockito.when(converter.getName()).thenReturn(CONVERTER_NAME);

        Optional<AbstractConverter> converterOpt = repo.getConverter("anotherConverter");

        Assertions.assertFalse(converterOpt.isPresent());
    }
}
