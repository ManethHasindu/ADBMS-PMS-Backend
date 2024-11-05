package com.pms.PharmacyMS.medicine.service;


import com.pms.PharmacyMS.medicine.dto.MedicineDTO;
import com.pms.PharmacyMS.medicine.entity.MedicineEntity;
import com.pms.PharmacyMS.medicine.repository.MedicineRepo;
import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.entity.Supplier;
import com.pms.PharmacyMS.suppliers.repository.SupplierRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;
    @Autowired
    private ModelMapper modelMapper;


    // get all medicines
    public List<MedicineDTO> getAllMedicines() {
        return medicineRepo.findAll().stream()
                .map(medicine -> modelMapper.map(medicine, MedicineDTO.class))
                .collect(Collectors.toList());
    }

    // add medicine
    public MedicineDTO addMedicine(MedicineDTO medicineDTO) {
        medicineRepo.save(modelMapper.map( medicineDTO, MedicineEntity.class));
        return  medicineDTO;
    }

}
