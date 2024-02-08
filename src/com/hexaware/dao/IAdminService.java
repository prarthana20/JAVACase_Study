package com.hexaware.dao;

import com.hexaware.entity.Admin;
import com.hexaware.exception.*;

public interface IAdminService {

	boolean updateAdmin(Admin admin) throws AdminNotFoundException;

	boolean registerAdmin(Admin admin);

	Admin getAdminByUsername(String adminUsername)throws AdminNotFoundException;

	Admin getAdminById(int adminId) throws AdminNotFoundException;

	boolean deleteAdmin(int adminId) throws AdminNotFoundException ;
    
}
