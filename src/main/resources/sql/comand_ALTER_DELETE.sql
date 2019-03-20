
ALTER TABLE `task_02`.`address`
  ADD COLUMN `address` VARCHAR(45) NOT NULL AFTER `id_address`;

# ====================================================================

delete from company_address;
alter table company_address auto_increment = 1;

delete from company_employee;
alter table company_employee auto_increment = 1;

delete from employee;
alter table employee auto_increment = 1;

delete from address;
alter table address auto_increment = 1;

delete from company;
alter table company auto_increment = 1;

delete from city;
alter table city auto_increment = 1;

delete from country;
alter table country auto_increment = 1;

# =====================================================================

