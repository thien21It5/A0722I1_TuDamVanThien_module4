package baiTap2.reponsitory;

import baiTap2.model.MedicalDeclaration;
import org.springframework.stereotype.Repository;

@Repository
public class DeclarationRepo implements IDeclarationRepo{
    MedicalDeclaration medicalDeclarationRepo = new MedicalDeclaration();

    @Override
    public MedicalDeclaration show() {
        return medicalDeclarationRepo;
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepo = medicalDeclaration;
    }
}
