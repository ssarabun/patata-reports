
INSERT INTO b4r_account_info (account_info_id, version, account_status_id, login, password, registration_date) VALUES (1000, 0, 1, 'testoperator1', 'testoperator1', now());
INSERT INTO b4r_accoun_info_account_role(account_info_id, account_role_id) VALUES (1000, 5);
INSERT INTO b4r_abstract_personal_info (personal_info_id, version, first_name, last_name, account_info_id) VALUES (1000, 0, 'Operator #1', 'Operator #1', 1000);
INSERT INTO b4r_operator_personal_info (personal_info_id) VALUES (1000);
INSERT INTO b4r_account_role (account_role_id, version, account_role, role_label, is_business_role) VALUES (1000, 0, 'test_agency_name_#1_role', 'Role for: "test agency name #1"', false);
INSERT INTO b4r_location_info (location_info_id, version) VALUES (1000, 0);
INSERT INTO b4r_agency (agency_id, version, agency_name, location_info_id, account_role_id) VALUES (1000, 0, 'test agency name #1', 1000, 1000);

INSERT INTO b4r_account_info (account_info_id, version, account_status_id, login, password, registration_date) VALUES (1001, 0, 1, 'testoperator2', 'testoperator2', now());
INSERT INTO b4r_accoun_info_account_role(account_info_id, account_role_id) VALUES (1001, 5);
INSERT INTO b4r_abstract_personal_info (personal_info_id, version, first_name, last_name, account_info_id) VALUES (1001, 0, 'Operator #2', 'Operator #2', 1001);
INSERT INTO b4r_operator_personal_info (personal_info_id) VALUES (1001);
INSERT INTO b4r_account_role (account_role_id, version, account_role, role_label, is_business_role) VALUES (1001, 0, 'test_agency_name_#2_role', 'Role for: "test agency name #2"', false);
INSERT INTO b4r_location_info (location_info_id, version) VALUES (1001, 0);
INSERT INTO b4r_agency (agency_id, version, agency_name, location_info_id, account_role_id) VALUES (1001, 0, 'test agency name #1', 1001, 1001);

