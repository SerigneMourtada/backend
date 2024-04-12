package com.example.gestionvaccinationtestfirst.service.ParentService;

import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CentreNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;

import java.util.List;

public interface ParentService {

    public List<ParentDTO> getAllParents();

    public ParentDTO getParent(Long parentId) throws ParentNotFoundException;

    public void  deleteParent(Long parentId);

    public ParentDTO saveParent(ParentDTO parentDTO,String email);

    public ParentDTO updateParent(ParentDTO parentDTO);

    public ParentDTO saveParent(ParentDTO parentDTO,Long centreId) throws CentreNotFoundException;
}
