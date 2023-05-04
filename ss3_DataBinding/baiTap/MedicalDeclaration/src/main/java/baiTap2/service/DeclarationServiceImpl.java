package baiTap2.service;

import baiTap2.model.MedicalDeclaration;
import baiTap2.reponsitory.DeclarationRepo;
import baiTap2.reponsitory.IDeclarationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationServiceImpl implements IDeclarationService{

    @Autowired
    private IDeclarationRepo declarationRepository;
    @Override

    public MedicalDeclaration show() {
        return declarationRepository.show();
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration) {
        declarationRepository.update(medicalDeclaration);
    }
}
