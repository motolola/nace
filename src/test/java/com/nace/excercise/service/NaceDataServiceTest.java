package com.nace.excercise.service;

import com.nace.excercise.entity.NaceData;
import com.nace.excercise.repository.NaceDataRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NaceDataServiceTest {

    @Autowired
    private NaceDataService naceDataService;

    @Autowired
    private NaceDataRepository naceDataRepository;

    @BeforeEach
    void setUp() {
        naceDataRepository.deleteAll();
    }

    @Test
    void testInsert() {
        NaceData naceData = getNaceData();

        NaceData result = naceDataService.create(naceData);
        Assertions.assertThat(result.getId()).isNotNull();
    }

    @Test
    void testGetAll() {
        int insertedCount = 10;
        for (int i = 0; i < insertedCount; i++) {

            NaceData naceData = getNaceData();
            naceData.setOrderNumber((long) i);
            naceDataService.create(naceData);
        }

        List<NaceData> result =  naceDataService.retrieveAll();
        Assertions.assertThat(result.size()).isEqualTo(insertedCount);
    }

    @Test
    void findByOrderNumberTest() {
        long orderNumber = 45678L;
        NaceData result = naceDataService.create(getNaceData());
        result.setOrderNumber(orderNumber);

    }

    private NaceData getNaceData() {
        NaceData naceData = new NaceData();

        naceData.setCode("647687");
        naceData.setRulings("Rulings");
        naceData.setLevel("Level");
        naceData.setParent("Parent");
        naceData.setOrderNumber(2435678L);
        naceData.setThisItemAlsoIncludes("This also include");
        naceData.setThisItemExcludes("This Exclude ...");
        naceData.setThisItemIncludes("This Include ...");
        naceData.setDescription("Description");
        naceData.setReferenceTpIsicRev4("RefeToIsic");

        return naceData;
    }
}
