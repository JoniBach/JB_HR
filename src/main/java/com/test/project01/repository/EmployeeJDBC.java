package com.test.project01.repository;

import com.test.project01.module.EmployeeModule;

public interface EmployeeJDBC {

    Iterable<EmployeeModule> findAll();

}
