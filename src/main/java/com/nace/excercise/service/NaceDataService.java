package com.nace.excercise.service;

import com.nace.excercise.dto.NaceDataDto;
import com.nace.excercise.entity.NaceData;
import com.nace.excercise.handlers.exception.NaceDataAlreadyExistException;
import com.nace.excercise.handlers.exception.NaceNotFoundException;
import com.nace.excercise.repository.NaceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaceDataService {

    @Autowired
    private NaceDataRepository naceDataRepository;

    public NaceData create(NaceData naceData) {
        if (naceDataRepository.findByOrderNumber(naceData.getOrderNumber()).isPresent()) {
            throw new NaceDataAlreadyExistException("NACE data with id Exist: " + naceData.getOrderNumber());
        }

        return naceDataRepository.save(naceData);
    }

    public List<NaceData> retrieveAll() {
        return naceDataRepository.findAll();
    }

    public NaceData findByOrderNumber(Long otherNumber) {

        return naceDataRepository.findByOrderNumber(otherNumber)
                .orElseThrow(() -> new NaceNotFoundException("Record not found"));
    }

    public NaceData convertFromDto(NaceDataDto dto) {
        NaceData naceData = new NaceData();
        naceData.setCode(dto.getCode());
        naceData.setDescription(dto.getDescription());
        naceData.setLevel(dto.getLevel());
        naceData.setParent(dto.getParent());
        naceData.setOrderNumber(dto.getOrderNumber());
        naceData.setRulings(dto.getRulings());
        naceData.setReferenceTpIsicRev4(dto.getReferenceTpIsicRev4());
        naceData.setThisItemAlsoIncludes(dto.getThisItemAlsoIncludes());
        naceData.setThisItemExcludes(dto.getThisItemExcludes());
        naceData.setThisItemAlsoIncludes(dto.getThisItemAlsoIncludes());

        return naceData;
    }
}
