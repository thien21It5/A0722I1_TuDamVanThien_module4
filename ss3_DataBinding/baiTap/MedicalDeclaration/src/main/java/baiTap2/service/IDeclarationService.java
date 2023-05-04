package baiTap2.service;

import baiTap2.model.MedicalDeclaration;

public interface IDeclarationService {
    MedicalDeclaration show();

    void update(MedicalDeclaration medicalDeclaration);
}
