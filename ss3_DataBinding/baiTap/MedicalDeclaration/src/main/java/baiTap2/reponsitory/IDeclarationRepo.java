package baiTap2.reponsitory;

import baiTap2.model.MedicalDeclaration;

public interface IDeclarationRepo {

     MedicalDeclaration show();

     void update(MedicalDeclaration medicalDeclaration);

}
