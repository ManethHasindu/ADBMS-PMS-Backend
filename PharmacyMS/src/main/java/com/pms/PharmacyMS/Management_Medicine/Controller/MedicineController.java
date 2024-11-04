package com.pms.PharmacyMS.Management_Medicine.Controller;


import com.pms.PharmacyMS.Management_Medicine.DTO.ResponseDTO;
import com.pms.PharmacyMS.Management_Medicine.Util.VarList;
import com.pms.PharmacyMS.Management_Medicine.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;


    @GetMapping("getallmedicines")
    public ResponseEntity<ResponseDTO> getAllMedicines(){
        ResponseDTO allMedicines = medicineService.getAllMedicines();
        if (allMedicines.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity<>(allMedicines, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(allMedicines,HttpStatus.NOT_FOUND);
        }
    }

}
