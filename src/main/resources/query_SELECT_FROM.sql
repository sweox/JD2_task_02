# ========================================================================================

SELECT CONCAT_WS('    ',
                 employee.first_name,
                 employee.last_name)        AS 'Name',
       CONCAT_WS(', ',
                 address.street,
                 city.city,
                 country.country)           AS 'Address',
       CONCAT_WS(', ',
                 company.name_company,
                 companyCity.city,
                 companyCountry.country,
                 companyAddress.street,
                 count(company_employee.fid_company),
                 company_employee.position) AS 'Offices'
FROM employee
       JOIN address ON employee.fid_address = address.id_address
       JOIN company_employee ON employee.id_employee = company_employee.fid_employee
       JOIN company ON company_employee.fid_company = company.id_company
       JOIN city ON address.fid_city = city.id_city
       JOIN country ON city.fid_country = country.id_country
       JOIN company_address ON company.id_company = company_address.fid_company
       JOIN address companyAddress ON company_address.fid_address = companyAddress.id_address
       JOIN city companyCity ON companyAddress.fid_city = companyCity.id_city
       JOIN country companyCountry ON companyCity.fid_country = companyCountry.id_country

GROUP BY employee.first_name
ORDER BY employee.id_employee
LIMIT 100
;