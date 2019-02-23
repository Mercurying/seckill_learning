package com.mercury.review.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Main instance = new Main();
        instance.ObjectListToJson();
    }

    private void objectToJson() throws IOException {
        JsonUtil jsonUtil = new JsonUtil();
        Company companyData = initData();
        //  formatter List to json formatter:["100","200"]
        //  List<String> stringList = new ArrayList<String>() {{
        //  add("100");
        //  add("200");
        //  }};
        //  logger.info("List to json formatter:{}", jsonUtil.toJson(stringList));
        String companyStr = jsonUtil.toJson(companyData);
        logger.info("companyData-->companyStr:{}", companyStr);
        Company fromJsonData = jsonUtil.fromJson(companyStr, Company.class);
        logger.info("fromJsonData:{}", fromJsonData.toString());
    }

    private void ObjectListToJson() throws IOException {
        JsonUtil jsonUtil = new JsonUtil();
        List<Company> companyList = new ArrayList<>();
        Company company1 = initData();
        Company company2 = initData();
        Company company3 = initData();
        companyList.add(company1);
        companyList.add(company2);
        companyList.add(company3);
        String companyString = jsonUtil.toJson(companyList);
        logger.info("companyList to json:{}", companyString);
        // json转list
        List<Company> listDecode = jsonUtil.fromJson(companyString, new TypeReference<List<Company>>() {
        });
        logger.info("listDecode:{}", listDecode);
    }


    private static Company initData() {

        Company company = new Company();
        company.setName("www.mercury.com.cn");
        company.setAddress("上海市张江高科技术产业园区");
        List<Department> departmentList = new ArrayList<>();
        Department productD = new Department();
        productD.setName("产品研发中心");
        productD.setEmployeeCount(100);
        Department technologyD = new Department();
        technologyD.setName("信息技术部");
        technologyD.setEmployeeCount(200);
        departmentList.add(productD);
        departmentList.add(technologyD);
        company.setDepartmentList(departmentList);
        company.setEmployeeCount(400);
        return company;
    }
}
